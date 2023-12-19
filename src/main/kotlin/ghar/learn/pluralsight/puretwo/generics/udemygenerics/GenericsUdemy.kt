package ghar.learn.pluralsight.puretwo.generics.udemygenerics

import java.math.BigDecimal

fun main(){
    println("Udemy Generics provide examples with Generics-implementations")

    val bList = mutableListOf(
        BigDecimal(33.2566),
        BigDecimal(-23.2888)
    )

    listOf<Int>(26, 28, 30, 32, 34).printCollections(Int.javaClass.typeName)
    bList.printCollections(bList.javaClass.typeName)            // printCollections is defined as 'extension-fun' to List<>

    /** STAR Projection */
    println("2. using Star to prevent compile time-error:")
    val listAny : List<Any> = listOf("Any1", "Any2")
    if(listAny is List<*>){                         // avoid compile time error, so compiler ascertains type of 'listAny'
        println("Yes, It is a list. Thank you STAR Projection")
    }

}

// A generic Extension.function (to List<> Interface
fun <T> List<T>.printCollections(typeOfCollection : String){
    for (items in this){                // 'this' due to extension-fun approach
        println(items)
    }
    println("collection-tye: $typeOfCollection")
    println("------------------------------------")
}