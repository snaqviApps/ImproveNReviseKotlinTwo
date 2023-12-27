package ghar.learn.pluralsight.puretwo.generics.udemygenerics

fun main(args: Array<String>) {

    val shortList: List<Short> = listOf(1, 2, 3, 4, 5)
    convertToInt(shortList)
}

fun convertToInt(collection: List<Number>) {
    for (num in collection) {
        println("${num.toInt()}")
    }
    //collection.add(25.3)
}

fun tendGarden(roseGarden: Garden<Rose>) {
    waterGarden(roseGarden)
}

fun waterGarden(garden: Garden<Flower>) {

}

open class Flower {

}

class Rose: Flower() {  }

/** Covariant (read-Only)
 * is a constructor parameter.
 * Except,
 * for Constructors...
 * And that's because constructors are called when an instance is created.
 * So you know there's no danger of using a constructor to do something that's going
 * to lead to this type
 * */
//class Garden<out T: Flower>(private var something: T) {   // below works if it is not 'private'
                                                            // but 'val' type, so it is cannot be changed
                                                            // except at 'instantiation' (as 'Variance' would mean)

class Garden<out T: Flower>(val something: T) {             // Garden is 'typed' as 'Covariant' after using 'out'

    val flowers: List<T> = listOf()

    fun pickFlower(i: Int): T = flowers[i]
//    fun plantFlower(flower: T) { }            // Wrong as T is declared as 'out' but  here occurs in 'in' position

}