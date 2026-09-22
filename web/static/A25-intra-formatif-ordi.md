# Examen intra A25 : partie ordinateur

## Utiliser une librairie

1. **1 point** Créer un programme lisant la page web suivante : https://info.cegepmontpetit.ca/3M5-Intro-Mobile/testbot/courrielsDansA.html
2. Extraire l'ensemble des adresses courriels incluses dans une balise `<a>`. 
3. **2 points** Afficher dans la console les informations sous la forme "Prénom nom a pour courriel prenom.nom@cegepmontpetit.ca" pour chaque élément trouvé

Par exemple : 
```
Benoit Caldairou a pour courriel benoit.caldairou@cegepmontpetit.ca
...
```


## Déboguer un programme ?

- Dans le programme suivant, la fonction sommeCumulative est sensée retourner un tableau d'entiers représentant la somme cumulative d'un autre tableau passé en paramètre.
- Par exemple, à partir d'un tableau représentant les points marqués par un pilote de chaque course d'un championnat, on veut montrer la progression de son nombre de points total au fur et à mesure des épreuves ([10, 25, 20, 2] -> [10, 35, 55, 57]).
- Le chef de projet a confié la programmation de cette fonction à un stagiaire, mais ce dernier ne parvient pas au résultat attendu.
- Sa fonction retourne systématiquement un tableau composé de zéros.


**2 points** Corriger le programme pour qu'il atteigne le résultat demandé ?

**1 point** Explique quel est est le problème du code actuel:
```




```

```kotlin
fun main(args: Array<String>) {
    var tabTest:Array<Int> = arrayOf(1, 2, 3, 4, 5, 6, 7, 8)
    var tabResultat = sommeCumulative(tabTest)

    afficheTableau(tabResultat)
}

fun sommeCumulative(tabEntiers: Array<Int>):Array<Int> {
    for(i in 0 .. tabEntiers.size-1) {
        tabEntiers[i] = 0
        for(j in 0..i){
            tabEntiers[i] += tabEntiers[j]
        }
    }

    return tabEntiers
}

fun afficheTableau(tabEntiers: Array<Int>){
    for(i in 0 .. tabEntiers.size-1) {
        println(tabEntiers[i])
    }
}
```


## Listes

Dans le fichier ExoListe.kt, vous devez programmer les méthodes :
- **2 points** joursParMois qui renvoie une liste contenant le nombre de jours par mois jusqu’à n mois. Par exemple :
  - pour n qui vaut 1 renvoie la liste [31]
  - pour n qui vaut 3 renvoie la liste [31, 28, 31]
  - si n est supérieur à 12, la méthode doit lancer une exception
-	**1 point** tri qui renvoie la liste de double passée en paramètre en la triant par ordre croissant. Par exemple :
  - si on passe la liste [2.5, 1, 3] 
  - on veut le résultat [1, 2.5, 3] pour trier la liste dans l’ordre croissant de la valeur

**1 point** Vous validerez le bon fonctionnement de votre code en programmant un main qui 
- appelle **joursParMois de 1, 7, 12
- appelle **tri** pour la liste [5.5, 9, 2.1, 1.2]
- appelle **joursParMois de 13


