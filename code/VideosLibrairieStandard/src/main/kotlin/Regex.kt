package org.gagneleroux

fun main(){

    val text: String = "zzzzzzzallozzzzzzzzzzzaozzzzzzzzzalozzzzzzzzalllllozzzz"

    // Regex permet de chercher des patterns précis dans une chaîne de caractères
    val regex: Regex = "a[lk]+o".toRegex() // a[lk]+o : au moins une instance de l/k entre a et o. Si on remplace + par *, permet 0 instance de l/k entre a et o
    val occurrences = regex.findAll(text).map{it.value}.toList() // trouver les occurences et mettre leur valeur dans une liste

    println(occurrences)
}