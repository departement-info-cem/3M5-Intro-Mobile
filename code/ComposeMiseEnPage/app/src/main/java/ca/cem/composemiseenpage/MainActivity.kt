package ca.cem.composemiseenpage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ca.cem.composemiseenpage.ui.theme.ComposeMiseEnPageTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        println("Entrée dans onCreate")
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeMiseEnPageTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),
                    topBar = {
                        CenterAlignedTopAppBar(
                            title = { Text("Mise en page") }
                        )
                    }
                ) { innerPadding ->
                    // TODO décommenter une ligne, celle qu'on veut afficher
                    //mep_simple(modifier = Modifier.padding(innerPadding))
                    //mep_complexe(modifier = Modifier.padding(innerPadding))
                    mep_brisée(modifier = Modifier.padding(innerPadding))
                }
            }
        }
        println("Sortir de onCreate")
    }
}

@Composable
fun mep_simple(modifier: Modifier = Modifier) {
    println("Entrée dans mep_simple")
    Row(
        // comme c'est le plus haut niveau, on veut prendre tout l'espace disponible
        modifier = modifier.fillMaxWidth()
    ){
        // au niveau 2 on peut tracer un trait horizontal entre 2 sous-éléments donc c'est un Column
        Column(
            // on n'oublie pas de dimensionner les sous-éléments
            Modifier.weight(1f).fillMaxHeight()
        ){
            // Si on ne dimensionne pas un texte, il prend la place minimal du texte
            Text("Yo on ne devrait jamais utiliser un poids pour la hauteur d'un élément avec du texte")
            // Un Spacer crée un espace vide, un poids indique une proportion de l'espace disponible
            Spacer(Modifier.weight(1f))
            Button(
                // on dimensionne le bouton, ici on veut prendre toute la largeur
                modifier = Modifier.padding(10.dp).fillMaxWidth(),
                onClick = {}
            ) {
                Text(text = "Clique moi")
            }
        }
        // ici on a le 2ème sous-élément de la Row
        // Une Box permet de changer la couleur de fond etc.
        Box(
            // en lui donnant le même poids que le 1er, il prend la même place
            // 2 poids de 1f dans une Row, ça fait 50% chacun
            modifier = Modifier.weight(1f)
                .fillMaxHeight()
                .background(Color.Blue),
        ) {
            Text("Yo mama")
        }
    }
    println("Sortir de mep_simple")
}

@Composable
fun mep_complexe(modifier: Modifier = Modifier) {
    println("Entrée dans mep_complexe")
    // au niveau 1 on peut tracer un trait horizontal entre 2 sous-éléments Column
    Column(
        // si je mets un padding ici il entoure toute la colonne
        modifier.fillMaxWidth(1f).padding(10.dp)
    ){
        Text("Le texte qui est en haut de la page, on peut tracer en dessous")
        Spacer(Modifier.weight(2f)) // crée un espace vide de 2f en fonction de la somme des poids
        Button(
            modifier = Modifier.fillMaxWidth().padding(15.dp),
            onClick = {}
        ) {
            Text(text = "Clique moi")
        }
        Spacer(Modifier.height(20.dp)) // crée un espace vide de 20dp
        Row(
            modifier = Modifier.fillMaxSize(),
        ) {
            Column(
                Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                // la somme des weight se fait sur les enfants directs
            ){
                Text("Le texte du haut de la colonne de gauche")
                Spacer(Modifier.weight(30f))
                Button(
                    onClick = {}
                ) {
                    Text(text = "Bouton 2")
                }
                Spacer(Modifier.weight(30f))
                OutlinedButton(
                    modifier = Modifier.padding(10.dp),
                    onClick = { },
                ) {
                    Text("Délimité")
                }
            }
            Column(
                Modifier.width(240.dp),
            ) {
                Text(
                    modifier = Modifier
                        .background(Color.Green)
                        .fillMaxWidth()
                        .weight(1f),
                    text = ""
                )
                Row(
                    // si on ne donne pas de taille, il prend la place de son contenu
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(40.dp)
                            .clip(shape = androidx.compose.foundation.shape.CircleShape)
                            .background(Color.Gray)
                    ) {
                        Text(
                            text = "EM",
                            color = Color.White
                        )
                    }
                    Column(
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
                        verticalArrangement = Arrangement.spacedBy(0.dp)
                    ) {
                        Text("Un exemple d'élément de liste")
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            "sous-titre ici",
                            fontSize = 10.sp // on peut mettre un fontSize pour le texte
                        )
                    }
                }
                Text(
                    modifier = Modifier
                        .background(Color.Blue)
                        .fillMaxWidth()
                        .weight(1f),
                    text = ""
                )
            }
        }
    }
    println("Sortir de mep_complexe")
}

@Composable
fun mep_brisée(modifier: Modifier = Modifier) {
    println("Entrée dans mep_brisée")
    Row(
        modifier = modifier
    ){
        Column(Modifier.weight(1f)){
            Text("Les 2 problèmes, on ne voit pas la colonne de droite, et le texte trop petit ne s'affiche pas")
            Spacer(Modifier.weight(30f))
            Button(
                onClick = {}
            ) {
                Text(text = "Clique moi")
            }
            Spacer(Modifier.weight(30f))
            Box(Modifier
                .weight(30f)
                .fillMaxWidth()
                .background(Color.Red)) {

            }
            OutlinedButton(
                onClick = { },
                modifier = Modifier.weight(10f)
            ) {
                Text(
                    "trop petit"
                )
            }
            Spacer(Modifier.weight(30f))
        }
        Column(
            Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
            Text(
                "Yo on ne devrait jamais utiliser un poids pour la hauteur d'un élément avec du texte",
                //modifier = Modifier.weight(1f)
            )
            Spacer(Modifier.weight(30f))
            Button(
                onClick = {}
            ) {
                Text(text = "Clique moi")
            }
            Spacer(Modifier.weight(30f))
            Box(Modifier
                .weight(30f)
                .fillMaxWidth()
                .background(Color.Red)) {

            }
            OutlinedButton(
                onClick = { },
            ) {
                Text(
                    "trop petit"
                )
            }
            Spacer(Modifier.weight(30f))
        }
    }
    println("Sortir de mep_brisée")
}
