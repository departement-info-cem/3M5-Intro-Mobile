package org.gagneleroux

fun main(){

    val nom = "Kotlin" // ou val nom : String =  "Kotlin"
    val nbPatates = 3 // Le type est inféré.
    val n : Int // Le type est requis lorsque la variable est déclarée, mais non initialisée avec une valeur.

    println("Bonjour $nom ! J'ai $nbPatates patates dans mon jardin")

    // nbPatates = 10 ==> provoque une erreur parce que nbPatates est déclaré avec val (read-only variable)

    n = 11

    println("J'ai maintenant ${nbPatates+n} patates dans mon jardin")


    // Boucle for : Pour itérer à travers une plage de valeurs et effectuer une action
    // La boucle inclue la dernière valeur !
    for(i: Int in 0..10) {
        println("i = $i")
        bidon()
    }


    // Tableaux (Ressource : https://kotlinlang.org/docs/arrays.html)

    val tableau : Array<String> = arrayOf("Bonjour", "Salut", "Hola")
    for(s: String in tableau){
        println(s)
    }


}

fun bidon(){
    val j: Int = 1
    val k: Float = 3.4F
    val l: String = "Bonjour"
}

