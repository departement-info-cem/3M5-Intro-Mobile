package org.gagneleroux

// Créer une classe avec un constructeur et surcharger la méthode toString

class Etoile (var nom:String, var age:Int) {

    override fun toString(): String {
        return "Etoile(nom : $nom, âge (années) : $age)"
    }
}