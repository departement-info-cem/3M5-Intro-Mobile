package com.caldairou.composescaffold

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation(
    modifier : Modifier = Modifier,
    navController : NavHostController = rememberNavController()
){
    NavHost(
        navController = navController,
        startDestination = "ecran_principal",
        modifier = modifier
    ){
        // Définition de la route vers l'écran principal
        // On définit également la route vers l'écran B avec un paramètre optionnel "fromClick" pour indiquer si l'utilisateur est arrivé depuis le lien du bouton
        // La route "ecran_b?fromClick={fromClick}" permet de passer le paramètre optionnel "fromClick" à l'écran B
        // La valeur par défaut de "fromClick" est false si le paramètre n'est pas fourni
        composable("ecran_principal"){
            EcranPrincipal(
                navController,
                onLinkClicked = {
                    // On passe le paramètre optionnel suite au clic
                    navController.navigate("ecran_b?fromClick=true")
                },
                onNormalNavigation = {
                    // Navigation standard : pas besoin de spécifier le paramètre
                    navController.navigate("ecran_b")
                }
            )
        }

        // Définition de la route vers l'écran B avec le paramètre optionnel "fromClick"
        // On récupère la valeur du paramètre "fromClick" depuis les arguments de la backStackEntry
        // Si le paramètre n'est pas fourni, on utilise la valeur par défaut false
        composable("ecran_b?fromClick={fromClick}"){ backStackEntry ->
            val fromClick = backStackEntry.arguments?.getString("fromClick")?.toBooleanStrict() ?: false
            EcranB(navController, fromClick)
        }
    }
}
