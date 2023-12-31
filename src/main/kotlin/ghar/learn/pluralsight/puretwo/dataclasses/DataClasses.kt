package ghar.learn.pluralsight.puretwo.dataclasses

fun main(){

    val car = Car("Nissan", 2022)
    val car2 = Car("Nissan", 2022)
    println(car)    // print the data withIn the 'car' object
    println(car.hashCode())
    println(car2.hashCode())                    // same value as 'car'
    println(car.hashCode() == car2.hashCode())  // true

    // Override the default methods:
    println("--------------------------")
    println("\nOverriding default methods with Data classes")
    val pData = PersonnelData("Nam")
    println("$pData, hashCode is same: ${pData.hashCode()}")
}

/** compiler generates certain info / methods along-with the object:
 *  - toString()
 *  - hashCode
 *  - equals
 *  Note: the above calls only include the
 *
 * */
data class Car(val make: String, val year: Int)     // parameters used in Constructor, have to be properties (val / var)

/**
 * Override the default methods, example toString(), here additional property "canonicalName"
 * will not be part of default toString() call, so if needed, it needs to be added via
 * Overriding
 *
 */
data class PersonnelData(val name: String){

    val canonicalName: String

    init {
        canonicalName = name.uppercase()
    }

    override fun toString(): String {
        // return super.toString() ---> default
        return "Person(name: $name, canonicalName: $canonicalName)"
    }

    // below methods can be generated by  'pressing' two times 'shift-key' (on macBook)
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PersonnelData

        if (name != other.name) return false
        if (canonicalName != other.canonicalName) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + canonicalName.hashCode()
        return result
    }

}

