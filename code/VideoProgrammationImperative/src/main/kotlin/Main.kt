package org.gagneleroux


fun main(args: Array<String>) {
    // Programmation impérative : montre à l'ordinateur comment faire une tâche étape par étape. Elle modifie souvent la mémoire.

    // Revenir sur la différence entre val et var
    if (args.isEmpty()) {
        println("You must provide a number of arguments.")
    } else {

        for (arg in args) {
            try {
                afficherPyramide(arg.toInt())
            } catch (e: Exception) {
                println("Cet argument n'est pas une hauteur valide : $arg")
            }
        }
    }



}

fun afficherPyramide(hauteur: Int) {

    var nbEtoiles: Int = 1
    var nbEspaces: Int = hauteur - 1
    var ligne: String = ""

    for (i: Int in 1..hauteur) {
        ligne = " ".repeat(nbEspaces) + "*".repeat(nbEtoiles)
        println(ligne)
        nbEtoiles += 2
        nbEspaces -= 1
    }
}