package org.gagneleroux

// https://kotlinlang.org/docs/collections-overview.html
// Voir les exercices sur : https://kotlinlang.org/docs/kotlin-tour-collections.html

// Les collections permettent de regrouper des données.

// List : Collection ordonnée d'items (dans l'ordre dans lequel ils sont ajoutés). Les duplicatas sont permis.
// .first(), .last(), .count(), .add(), .remove(), ... in ...

// Set : Ensemble d'items uniques et sans ordre précis. **Les doublons ne sont pas permis** : voir exemple : https://kotlinlang.org/docs/kotlin-tour-collections.html#set
// Les items ne peuvent être accédés à l'aide d'index

// Map : Ensembles de paires clé-valeur dont les clés sont uniques et correspondent à une seule valeur.
// On accède à la valeur à l'aide de la clé.
// Les clés sont uniques, mais les valeurs peuvent être dupliquées
// .remove(), .count(), .containsKey(), .keys(), .values()

// Chaque type de collection peut être modifiable ou en lecture seule.
// (ex: listOf() vs mutableListOf(), setOf() vs mutableSetOf(), mapOf() vs mutableMapOf())

fun main(){


    // Liste
    val liste:List<String> = listOf("HAL10", "HAL30", "HAL00", "HAL20")
    for(item in liste){
        println(item)
    }
    println(liste.count())
    // Trier une liste par ordre alphanumérique
    val listeTriee: List<String> = liste.sorted()
    println(listeTriee)

    // Inverser une liste
    val listeInversee: List<String> = liste.reversed()
    println(listeInversee)

    // Trier selon la longueur des chaînes de caractères
    val liste2: List<String> = listOf("a", "zzz", "cc", "aa", "bb", "zzzzz", "ddddd")
    val listeTrieeLongueur : List<String> = liste2.sortedWith(compareBy({it.length}))
    println(listeTrieeLongueur)

    // Trier selon la longueur des chaînes de caractères ET par ordre alphabétique
    val liste3: List<String> = listOf("a", "zzz", "cc", "aa", "bb", "zzzzz", "ddddd")
    val listeTrieeLongueurAlpha : List<String> = liste3.sortedWith(compareBy({it.length}, {it}))
    println(listeTrieeLongueurAlpha)

    // Vérifier si un élément est dans une liste
    println(liste3.contains("aa"))
    println("zzz" in liste3)

    // Compter l'occurence d'un item
    println(liste3.count({it=="a"}))


    // Liste mutable ==> MODIFIABLE
    val liste3Mutable: MutableList<String> = mutableListOf("a", "zzz", "cc", "aa", "bb", "zzzzz", "ddddd")
    liste3Mutable.add("ff") // insérer un élément à la fin
    liste3Mutable.add(3, "IIIIIIIIIII") // Insérer un élément à l'index donné
    println(liste3Mutable)

    liste3Mutable.remove("IIIIIIIIIII")
    liste3Mutable.removeAt(5)
    println(liste3Mutable)

    //==================================================================================================================

    // Passer d'une liste à un set
    var set1: Set<String> = liste3Mutable.toSet()
    println(set1)


    // Que se produit-il si un Set est initialisé avec un duplicata ?
    val readOnlyFruit = setOf("apple", "banana", "cherry", "cherry")
    println(readOnlyFruit)
    // [apple, banana, cherry]

    // est-il possible d'accéder à un élément du set ? Non, provoque une erreur du compilateur


    // Vérifier si un élément est dans l'ensemble :
    println("zzz" in set1)


    // Qu'arrive-t-il si je tente d'ajouter un doublon à un MutableSet
    var setMutable: MutableSet<String> = liste3Mutable.toMutableSet()

    setMutable.add("a") // cet ajout n'est pas effectué
    setMutable.add("AAA")
    println(setMutable)



    //==================================================================================================================

    // Map : CLÉ = VALEUR
    val map1: Map<String, Int> = mapOf("a" to 1, "b" to 2, "c" to 3)

    // Parcourir une map
    for ((key, value) in map1){
        println("$key : $value")
    }

    for (key in map1.keys){
        println("$key : ${map1[key]}")
    }

    // Présence d'une clé
    println("a" in map1 )

    // Si un Map contient une clé dupliquée vs une valeur dupliquée ?
    val readOnlyJuiceMenuDuplicateKey = mapOf("apple" to 100, "apple" to 190, "orange" to 100)
    val readOnlyJuiceMenuDuplicateValue = mapOf("apple" to 100, "kiwi" to 190, "orange" to 100)
    println(readOnlyJuiceMenuDuplicateKey)
    // {apple=190, orange=100}
    println(readOnlyJuiceMenuDuplicateValue)
    // {apple=100, kiwi=190, orange=100}

    // Qu'arrive-t-il si vous essayez d'accéder à une paire clé-valeur dont la clé n'existe pas dans une table ? Vous obtenez une valeur nulle !
    // Read-only map
    val readOnlyJuiceMenu = mapOf("apple" to 100, "kiwi" to 190, "orange" to 100)
    println("The value of pineapple juice is: ${readOnlyJuiceMenu["pineapple"]}")
    // The value of pineapple juice is: null



    // Map MODIFIABLE
    var map2: MutableMap<String, Int> = mutableMapOf("a" to 1, "b" to 2, "c" to 3)

    map2["a"] = 2
    println(map2)

    map2["allo"] = 900
    println(map2)

    map2.remove("allo")
    println(map2)

}