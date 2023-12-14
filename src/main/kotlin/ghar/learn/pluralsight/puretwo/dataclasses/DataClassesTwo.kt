package ghar.learn.pluralsight.puretwo.dataclasses

fun main(){
    println("data-classes-section-Two:\nCopy-function in data classes and destructuring,\n" +
            "Copy() lets them change properties values (data), that is otherwise not recommended\n" +
            "as 'Data' classes are ideally immutablen\n")
    println("---------------------------------------------\n")
    val carTwo = CarTwo("Toyota", 2022)
    val car3 = carTwo.copy(make="Nissan", year = 2020)

    println("Car2: $carTwo")
    println("Car3 is car2's copy: $car3")

    println("\ndestructuring data-object to get original properties back: ")
    val (makeD, yearD) = car3
    println("post destructuring: $makeD, $yearD")
    val (_, yearD2) = car3
    println("put '_' for unused property in destructuring: , $yearD2")
    println("using component() call for the destructuring")
    println("component1: ${car3.component1()}")

    // more about destructing
    println("\n\n------------------------------------")
    println("more about destructing")
}

data class CarTwo (val make: String, val year: Int)

data class Person(var name: String) {

    val parts = name.split(" ")
    val namePart1 = parts.component1()
    val namePart2 = parts.component2()

}