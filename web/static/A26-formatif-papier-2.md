## Compose vers dessin (5 points)

À partir du code fourni, dessinez l'interface graphique de l'activité en mode portrait.

Votre dessin doit représenter fidèlement la disposition des éléments graphiques. Identifiez clairement :
- la couleur des *backgrounds* ;
- le *padding* appliqué aux éléments, en indiquant les valeurs correspondantes ;
- le ratio de l'espace attribué à chaque élément, lorsque celui-ci est défini dans le code.

**3 points** Les couleurs, les ratios et les valeurs de *padding* sont correctement représentés.

**2 points** Les éléments graphiques sont correctement représentés et disposés dans l'interface.

```kotlin
@Composable
fun AllEyesOnMe(

){
    Column(
        modifier = Modifier.fillMaxSize()
    ){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(color = Color.Black),
            contentAlignment = Alignment.Center
        ){
            Text(
                "Me vois-tu ?"
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Button(
                onClick = {},
                modifier = Modifier
                    .weight(1f)
                    .padding(10.dp)
            ){
                Text("Oui")
            }
            Button(
                onClick = {},
                modifier = Modifier
                    .weight(1f)
                    .padding(10.dp)
            ){
                Text("Non")
            }
        }
    }
}
```

```






























```

## Types et valeurs (4 points)

Soit le code Kotlin suivant :

```kotlin
val a = 3f
val b = a + 1.0
var c by remember{ mutableIntStateOf(0) }
val d = '\n'
```

Pour chaque variable, indiquez la valeur obtenue et le type inféré par Kotlin.

```
a valeur :                     type :
b valeur :                     type :
c valeur :                     type :
d valeur :                     type :
```


## Activités et Navigation (3 points)

Schématisez la navigation entre les différentes activités de l'application.
- Utilisez des **rectangles** pour représenter les activités;
- Utilisez des **flèches** pour représenter les navigations possibles d'une activité à une autre.

Chaque flèche doit partir de l'activité d'origine et pointer vers l'activité de destination.

**1 point** Toutes les activités sont correctement identifiées.

**2 points** Les navigations des activités sont bien représentées (1 point / activité).

```kotlin
@Composable
fun Navigation(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
){
    NavHost(
        navController = navController,
        startDestination = "ecran_principal",
        modifier = modifier
            .padding(top = 24.dp)
    ) {
        composable(route = "ecran_principal") { EcranPrincipal(navController) }
        composable(route = "article") { Article() }
    }

}
@Composable
fun EcranPrincipal(
    navController: NavHostController,
){
    Button(
        onClick = { navController.navigate("ecran_principal") }
    ) {
        Text("ARTICLE", fontSize = 40.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun Article(){
    Text(
        "Argent comptant seulement"
    )
}
```

```






























```