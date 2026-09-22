# Évaluation formative A26 - Partie machine

## Utiliser une bibliothèque


1. **1 point** Créer un programme lisant la page web suivante : https://info.cegepmontpetit.ca/3M5-Intro-Mobile/testbot/lotr.html
2. Extraire les attributs src et alt de chaque `<img>`. 
3. **2 points** Afficher dans la console les informations sous la forme "urlDeImage >> contenuDuAlt" pour chaque élément trouvé

Par exemple : 
```
https://upload.wikimedia.org/wikipedia/commons/f/f6/Frodo_CSC_pic.jpg?20080822163340  >>  Froddo Baggins
...
```

## Débugger un programme

Le stagiaire récemment embauché par l'entreprise s'est vu confier une mission simple : créer une fonction de lecture d'un nombre. 

Cette fonction doit avoir les caractéristiques suivantes : 
 - Le nombre doit être lu au clavier
 - Si l'entrée au clavier n'est pas un nombre, alors on force l'utilisateur à faire une nouvelle entrée
 - Une fois qu'on a validé qu'on avait bien un nombre, alors la fonction renvoie ce nombre. 

 Voici sa solution : 

 ```kotlin
 fun main(args: Array<String>) {
    var nombre:Int = lireNombre()
}

fun lireNombre() : Int{
    var nombre = 0
    while(true){
        println("Veuillez entrer votre nombre entier : ")
        var lecture:String = readln()
        nombre = lecture.toInt()
    }
    return nombre
}
 ```
**1 point** Quel est le problème de son code ? 
```




```


**2 points** Fournis un projet avec le code corrigé.


## La somme des nombres dans un fichier

Crée un projet kotlin qui :
1. prend un argument en ligne de commandes
2. cet argument sera la chemin vers un fichier texte
3. lis chaque ligne du fichier texte
4. affiche le contenu de chaque ligne en console
5. essaie d'interpréter si le contenu est un nombre entier
6. si c'est un nombre il l'ajoute à la somme, sinon on ne fait rien
7. affiche en console la somme de toutes les lignes qui contenaient un nombre

Pointage :
- **2 points** si l'affichage des lignes fonctionne
- **2 points** si l'affichage de la somme fonctionne

Le nom du fichier avec ton **main** doit s'appeler **FichierNombreDupont.kt** en remplaçant Dupont pas ton nom (-1 point si non respecté)


