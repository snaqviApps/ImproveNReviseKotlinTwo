package ghar.learn.pluralsight.puretwo.generics.udemygenerics

import java.math.BigDecimal

fun main() {
    println("'Reified' overview:")
    println(
        "'Reification' is a Koplin feature that prevents the type from being\n" + "erased at runtime..."
    )
    println(
        "If you declare a function as in line and a type parameter as a reified\n" + "then you can check the generic type at runtime."
    )

    val mixedList = listOf<Any>(
        "Hi String",
        BigDecimal(15.323423),
        14,
        BigDecimal(23.43433),
        "Bye String"
    )
    val bigDecimalOnly = getElementsOfType<String>(mixedList)
    bigDecimalOnly.forEach {
        println("List members: $it")
    }
}

/** by 'reifie-ing' the function's 'T-Parameter', lets keep compiler's memory
 * that T's type is not 'erased' at run-time
 *
 * So only reason to use 'reification' when 'type-check' of 'T' is needed inside the 'function'
 * more, it works only with 'inline-functions'
 *
 * */
inline fun <reified T> getElementsOfType(list: List<Any>): List<T> {
    val newList: MutableList<T> = mutableListOf()
    for (item in list) {
        if (item is T) {
            with(newList) { add(item) }
        }
    }
    return newList
}