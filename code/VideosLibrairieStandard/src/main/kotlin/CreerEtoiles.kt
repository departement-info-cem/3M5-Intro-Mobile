package org.gagneleroux

fun main(){
    for(i in 0..9){
        var etoile = Etoile("HAL90$i", 42000000)
        println(etoile)
    }
}