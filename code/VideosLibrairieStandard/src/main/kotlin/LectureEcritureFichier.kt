package org.gagneleroux

import java.io.File

fun main(args: Array<String>) {
    // Premier argument : fichier à lire
    // Second argument : fichier à écrire


    // On assume qu'il y a deux arguments

    val nomFichier1: String = args[0]
    val nomFichier2: String = args[1]

    // Créer un objet de type File
    val fichier1: File = File(nomFichier1) // Si le chemin vers le fichier n'est pas spécifié, le fichier doit être à la racine

    // Vérifier si le fichier existe
    if (fichier1.exists()) {

        try {
            // Lire un fichier
            val txt1: String = fichier1.readText() // retourne une string qui représente tout le contenu du fichier
            println(txt1)

            val liste1: List<String> = txt1.split("\r\n") // sépare le contenu d'une string selon le délimiteur donné
            println(liste1)

            // ou readLines() à la place de readText() + split()
            val liste2: List<String> = fichier1.readLines()
            println(liste2)

            val txt2: String = liste1.joinToString("\r\n---------------------------\r\n") // regroupe le contenu d'une liste avec le séparateur donné
            println(txt2)

            // Écrire dans un fichier
            val fichier2: File = File(nomFichier2)
            fichier2.writeText(txt2) // Écrase le contenu précédent

        } catch (e: Exception) {
            println(e.message)
        }
    }else{
        println("$nomFichier1 n'existe pas...")
    }

}