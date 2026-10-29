package com.caldairou.composescaffold

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import kotlinx.coroutines.launch

// Cette fonction définit le TopAppBar personnalisé pour l'écran principal
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar(title : String){
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        title = { Text(text = title) }
    )
}

// Cette fonction définit le BottomAppBar personnalisé pour l'écran principal
@Composable
fun MyBottomBar(){
    BottomAppBar(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.primary
    ){
        Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            text = "Ceci est la BottomAppBar",
        )
    }
}

// Cette fonction définit l'écran principal avec un Scaffold, un TopAppBar, un BottomAppBar, un FloatingActionButton et deux boutons pour naviguer vers l'écran B
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EcranPrincipal(
    navController: NavHostController,
    onLinkClicked: () -> Unit,
    onNormalNavigation: () -> Unit
) {
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        // Définition du topBar avec la fonction MyTopBar
        topBar = {
            MyTopBar("Ecran Principal")
        },
        // Définition du bottomBar avec la fonction MyBottomBar
        bottomBar = {
            MyBottomBar()
        },
        // Définition du FloatingActionButton avec un clic qui affiche un Snackbar
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar("Tu viens de cliquer sur le FloatingActionButton")
                    }
                }
            ) {
                Icon(Icons.Filled.Info, contentDescription = "Info")
            }
        },
        // Définition du SnackbarHost pour afficher les Snackbars
        // Le SnackbarHost est lié à l'état du snackbarHostState pour gérer l'affichage des Snackbars
        // Le SnackbarHost est défini dans le Scaffold pour permettre l'affichage des Snackbars au-dessus du contenu principal de l'écran
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) { innerPadding ->
        // Contenu principal de l'écran avec deux boutons pour naviguer vers l'écran B
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(text = "Ceci est l'écran Principal")
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = {
                    // Navigation standard vers l'écran B sans Snackbar
                    onNormalNavigation()
                }
            ){
                Text(text = "Navigue vers l'écran B sans Snackbar")
            }
            Button(
                onClick = {
                    // Navigation vers l'écran B avec Snackbar
                    onLinkClicked()
                }
            ){
                Text(text = "Navigue vers l'écran B avec Snackbar")
            }
        }
    }
}
