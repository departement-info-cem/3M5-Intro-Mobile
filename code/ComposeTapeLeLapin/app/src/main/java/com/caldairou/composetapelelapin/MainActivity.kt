package com.caldairou.composetapelelapin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.caldairou.composetapelelapin.ui.theme.ComposeTapeLeLapinTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        println("Entrée dans onCreate")
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeTapeLeLapinTheme {
                    EcranPrincipal()
            }
        }
        println("Sortir de onCreate")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EcranPrincipal(modifier: Modifier = Modifier) {

    println("Entrée dans EcranPrincipal")
    var nbPafs by remember { mutableIntStateOf(0) }
    var nbFlops by remember { mutableIntStateOf(0) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {Text(text = "Tape le lapin")},
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier.padding(innerPadding).fillMaxSize()
        ) {
            AffichageScores(
                nbPafs = nbPafs,
                nbFlops = nbFlops,
                modifier = Modifier.fillMaxWidth().weight(1f)
            )
            TitreApplication(
                modifier = Modifier.fillMaxWidth().weight(1f)
            )
            GrilleTuiles(
                incrementePafs = { nbPafs++ },
                incrementeFlops = { nbFlops++ },
                modifier = Modifier.fillMaxSize().weight(5f)
            )
        }
    }
    println("Sortir de EcranPrincipal")
}

@Composable
private fun TitreApplication(
    modifier : Modifier = Modifier
) {
    println("Entrée dans TitreApplication")
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ){
        Text(
            text = "Tape le lapin",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold
        )
    }
    println("Sortir de TitreApplication")
}

@Composable
private fun AffichageScores(
    nbPafs : Int,
    nbFlops : Int,
    modifier : Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier.fillMaxWidth().weight(1f),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = "$nbPafs Pafs",
                color = Color.Green,
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Box(
            modifier = Modifier.fillMaxWidth().weight(1f),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = "$nbFlops Flops",
                color = Color.Red,
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )
        }

    }
}

@Composable
private fun GrilleTuiles(
    incrementePafs : () -> Unit,
    incrementeFlops : () -> Unit,
    modifier: Modifier
) {

    var positionLapin by remember{mutableIntStateOf(Random.nextInt(9))}

    Column(
        modifier = modifier
    ) {
        for (i in 0..2) {
            Row(
                modifier = Modifier.fillMaxSize().weight(1f)
            ) {
                for (j in 0..2) {
                    var indexTuile = i*3 + j
                    Tuile(
                        estLapin = positionLapin == indexTuile,
                        quandOnCliqueSurBouton = { estLapin ->
                            effetCliqueTuile(
                                estLapin = estLapin,
                                incrementePafs = incrementePafs,
                                incrementeFlops = incrementeFlops,
                                reInitPositionLapin = {positionLapin = Random.nextInt(9)}
                        )
                                                 },
                        modifier = Modifier.padding(6.dp).fillMaxSize().weight(1f)
                    )
                }
            }

        }
    }
}

@Composable
private fun Tuile(
    estLapin : Boolean,
    quandOnCliqueSurBouton : (Boolean) -> Unit,
    modifier: Modifier
) {
    Button(
        onClick = {
            quandOnCliqueSurBouton(estLapin)
        },
        modifier = modifier
    ) {
        Text(
            text = if(estLapin) "Lapin" else "Taupe",
            fontSize = 25.sp
        )
    }
}

fun effetCliqueTuile(
    estLapin : Boolean,
    incrementePafs : () -> Unit,
    incrementeFlops : () -> Unit,
    reInitPositionLapin : () -> Unit
){
    if(estLapin) {
        incrementePafs()
        reInitPositionLapin()
    }
    else{
        incrementeFlops()
    }
}