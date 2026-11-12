# Les fonctions lambdas

En Kotlin, les fonctions lambdas sont des fonctions **anonymes** pouvant être **manipulées comme des valeurs**, c'est-à-dire qu'elles peuvent être :

- passées en argument à d’autres fonctions;
- assignées à des variables;
- retournées par des fonctions.

Dans cette recette, nous nous concentrerons davantage sur une lambda **passée en argument** à une autre fonction. Vous trouverez les deux autres cas à la fin de la recette dans la section "Pour aller plus loin".

## Passer une lambda en argument à une fonction

Prenons par exemple une fonction nommée `appliquerOperation()` ayant comme paramètres un nombre et une opération à effectuer sur ce nombre :

```kotlin
fun appliquerOperation(nombre: Int, operation: (Int) -> Int): Int {
    return operation(nombre)
}
```
Remarquez qu'`operation` est en fait une lambda passée en argument à la fonction `appliquerOperation`. Maintenant, regardez comment cette fonction est appelée dans un `main` :

```kotlin
fun main() {
    val resultat = appliquerOperation(5, { n -> n * 2 })

    println(resultat) // 10
}
```

Décortiquons la syntaxe de notre lambda :

* `{ n -> n * 2 }` : notre expression lambda, entre les accolades
* `n` : le paramètre d'entrée de notre lambda
* `->` : la flèche permet de séparer les paramètres d'entrée du corps de la lambda
* `n * 2` : le corps de la lambda qui, dans ce cas-ci, retourne le double de `n`.


:::note IMPORTANT
Remarquez l'absence du mot-clé `return`. En effet, lorsque la valeur de retour n'est pas `Unit` (qui agit comme un `void` en C#),**la dernière expression** dans le corps de la lambda sera automatiquement considérée comme la valeur de retour. Nul besoin d'utiliser le mot-clé `return`.
:::

### Le mot-clé ``it``

Lorsqu’une lambda n’a qu’un seul paramètre, Kotlin permet d’y accéder sans avoir à le déclarer explicitement, à l’aide du mot-clé `it`. Cela rend la lambda plus concise et plus lisible.

Voici la même expression lambda que présentée plus haut, mais utilisant le mot-clé ``it`` à la place de `n -> ...` :

```kotlin
fun main() {
    val resultat = appliquerOperation(5, { it * 2 })

    println(resultat) // 10
}
```

### Différentes signatures possibles

Le type d'une lambda décrit ses paramètres et sa valeur de retour. Il existe plusieurs variétés de signatures possibles :

```kotlin
// Avec paramètres et valeur de retour
(Int, Int) -> Int       // ex. : { a, b -> a + b }

// Avec paramètres, sans valeur de retour
(Int, Int) -> Unit      // ex. : { a, b -> println(a + b) }

// Sans paramètre, avec valeur de retour
() -> String            // ex. : { "Bonjour" }

// Sans paramètre ni valeur de retour
() -> Unit              // ex. : { println("Salut !") }
```

### Exemple avec `() -> Unit`

```kotlin
fun repeter(fois: Int, action: () -> Unit) {
    for (i in 1..fois) {
        action()
    }
}

fun main() {
    repeter(3, { println("Salut !") }) // Affichera 3x "Salut !" dans la console
}
```

:::tip Mise en pratique

Osbervez les fonctions suivantes :

```kotlin
fun filtrerPairs(l: List<Int>): List<Int> { /* boucle + if (n % 2 == 0) */ }
fun filtrerPositifs(l: List<Int>): List<Int> { /* boucle + if (n > 0) */ }
fun filtrerPlusGrandsQueCent(l: List<Int>): List<Int> { /* boucle + if (n > 100) */ }
```

**Consigne :**

1. Identifiez ce qui est identique dans les trois fonctions, et ce qui change.
2. Écrivez une seule fonction `filtrer` qui remplace les trois. **Requis :** `filtrer` devra prendre une lambda en paramètre !
3. Écrivez les trois appels correspondants dans le ``main``. Utilisez cette liste : `val liste = listOf(-3, 4, 150, 7)`.


**Solution:**

```kotlin
fun main() {
    val liste = listOf(-3, 4, 150, 7)

    filtrer(liste, { it % 2 == 0 })
    filtrer(liste, { it > 0 })
    filtrer(liste, { it > 100 })
}

fun filtrer(l: List<Int>, condition: (Int) -> Boolean): List<Int> {
    val resultat = mutableListOf<Int>()
    for (n in l) {
        if (condition(n)) {
            resultat.add(n)
        }
    }
    return resultat
}
```

:::

### La *trailing* lambda

Lorsque le dernier paramètre d'une fonction est une lambda, on peut écrire cette lambda **après** les parenthèses. On appelle cela une *trailing* lambda. C'est seulement une alternative syntaxique : la lambda conserve le même comportement.

**Lambda à l'intérieur des parenthèses**
```kotlin
val resultat = appliquerOperation(5, { it * 2 })

println(resultat) // 10
```

**Lambda après les parenthèses**
```kotlin
val resultat = appliquerOperation(5) { it * 2 }

println(resultat) // 10
```

Une lambda peut être déportée seulement si elle est le **dernier paramètre** d'une fonction. Si une fonction possède deux lambdas, la première doit être définie dans les parenthèses, alors que la seconde peut être déportée. Nous verrons un exemple avec `Button` plus bas.

:::tip Suite du défi

4. Réécrivez les trois appels de `filtrer` avec une trailing lambda.

**Solution**

```kotlin
filtrer(liste) { it % 2 == 0 }
filtrer(liste) { it > 0 }
filtrer(liste) { it > 100 }
```
:::

## Où trouvons-nous des lambdas avec Compose ?

Regardons la signature de notre fonction composable préférée. Combien de paramètres de `Button` sont des lambdas ?

```kotlin
@Composable
fun Button(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = ButtonDefaults.shape,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    elevation: ButtonElevation? = ButtonDefaults.buttonElevation(),
    border: BorderStroke? = null,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    interactionSource: MutableInteractionSource? = null,
    content: @Composable RowScope.() -> Unit
)
```

Deux ! `onClick` et `content`.

Puisque `content` est une lambda, et qu'elle est le dernier paramètre de `Button`, elle peut être déportée :

```kotlin
// Appel sans trailing lambda
Button(
    onClick = { println("Clic !") },
    content = { Text("Cliquez-moi") }
)

// Appel avec trailing lambda
Button(
    onClick = { println("Clic !") }
    ) 
{
    Text("Cliquez-moi")
}
```

Les deux appels sont équivalents.

### Information additionnelle

`RowScope` fournit des modificateurs qui n'ont de sens que dans une `Row`, comme `Modifier.weight()` et `Modifier.align()` :

```kotlin
Row {
    Text("A", modifier = Modifier.weight(1f))   // OK : on est dans un RowScope
    Text("B", modifier = Modifier.weight(2f))
}

Text("C", modifier = Modifier.weight(1f))       // Erreur : pas de RowScope ici
```

## Pour aller plus loin

### Exemple : Assigner une lambda à une variable

Une lambda peut être assignée à une variable. Il suffit de placer directement la lambda dans une variable, puis on utilise cette variable pour l'appeler.

```kotlin
fun main() {
    val somme: (Int, Int) -> Int = { n, m -> n + m }

    val resultat = somme(5, 4)

    println(resultat) // 9
}
```

### Exemple : retourner une lambda à partir d’une fonction

Une lambda peut également être une valeur de retour. Prenons une fonction nommée `creerOperation()` qui retourne une opération que l’on pourra exécuter plus tard. Quelle serait la signature de cette fonction ?

```kotlin
fun creerOperation(): (Int) -> Int {
    return { n -> n * 2 }
}
```

Comment faire appel à cette fonction dans un `main()` ?

```kotlin
fun main() {
    val operation = creerOperation()

    val resultat = operation(5)

    println(resultat) // 10
}
```
