package ghar.learn.pluralsight.puretwo.generics.udemygenerics

import java.math.BigDecimal
import kotlin.text.StringBuilder

fun main(){
    println("Udemy Generics ... Covariance, ContraVariance, and \n\n")

    val bList = mutableListOf(
        BigDecimal(33.2566), BigDecimal(-23.2888)
    )
    val shorts = listOf<Short?>(2, 3, 5, 9)

    // call with one upper-Bound
    toInt(bList)
    toInt(shorts)

    // using two upper-bounds with 'where-clause'
    append(StringBuilder("String 1"), StringBuilder("String 2"))

    //Non-nullable upper-bound:
    printCollectionsNonNullable(bList)
//    printCollectionsNonNullable(shorts)     // error: can't take nullable

}


// more than one Upper-boun using 'where-clause'
fun <T> append(item1: T, item2: T) where T: CharSequence, T: Appendable {
    println("appending two strings result as: ${item1.append(item2)}\n")
}

// A generic 'Upper-bound' (here Number
fun <T: Number?> toInt(collection : List<T>){
    for (item in collection){
        println(item)
    }
    println("-------------")
}

// A generic Extension.function (to List<> Interface
fun <T:Any> printCollectionsNonNullable(typeOfCollection: List<T>){
    for (items in typeOfCollection){
        println(items)
    }
    println("collection-tye: $typeOfCollection")
    println("-------------")
}