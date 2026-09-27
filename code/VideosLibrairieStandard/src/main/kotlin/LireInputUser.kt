package org.gagneleroux

fun main(){
    // Objectif : Lire l'input d'un utilisateur dans la console
    val question: String = "Quel est votre langage de programmation préféré ?"

    while(true){
        println(question)

        val reponse : String = readln()
        if(reponse == "Kotlin"){
            println("Merci, votre langage de programmation préféré est : $reponse !")
            return
        }else{
            println("Mauvaise réponse...")
        }

    }


}