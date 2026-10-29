package com.caldairou.composescaffold

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EcranB(
    navController: NavHostController,
    fromClick : Boolean = false
){
    // On crée un état pour le SnackbarHost afin de gérer l'affichage des Snackbars
    val snackbarHostState = remember { SnackbarHostState() }

    // Si l'utilisateur est arrivé depuis le lien du bouton "Navigue vers l'écran B avec snackbar", on affiche un Snackbar pour l'informer
    if (fromClick) {
        LaunchedEffect(Unit) {
            snackbarHostState.showSnackbar(
                message = "Vous êtes arrivé depuis le lien du bouton \"Navigue vers l'écran B avec snackbar\"!"
            )
        }
    }

    // On utilise un Scaffold pour structurer l'écran avec un TopAppBar et un SnackbarHost
    // Le TopAppBar affiche le titre de l'écran et le SnackbarHost permet d'afficher les Snackbars au-dessus du contenu principal
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = { Text(text = "Ecran B") }
            )
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ){
            Text(text = "Ceci est l'écran B")
            Button(
                onClick = { navController.navigate("ecran_principal") }
            ){
                Text(text = "Navigue vers l'écran Principal")
            }
        }
    }
}
