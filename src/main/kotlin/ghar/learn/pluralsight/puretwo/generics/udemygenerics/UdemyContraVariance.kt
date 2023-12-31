package ghar.learn.pluralsight.puretwo.generics.udemygenerics

fun main() {
    println("now Contra-Variance..,")
    println("We're going in the opposite direction to Covariance" +
            "\nso we're starting at a subclass and we wind to accept instance" +
            "\nof that subclass or any of its superclasses, so going up the inheritance-stream\n" +
            "rather than going down, while going down the point (of Inheritance-tree) is Covariance\n" +
            "Limitations: Write-able instances Only, cannot read-from.\n" +
            "This type of class-statement is called 'Declaration-site' Variants (same for Covariance'")

    // instantiate an interface, being done, using an 'object' type (anonymous instance)

    val flowerTender = object : FlowerCare<ContraFlower> {
        override fun prune(contraFlower: ContraFlower) = println("I'm pruning a ${contraFlower.name}")
    }

    /** Not required anymore due to the utilization of Generalized approach using 'Contravariance' */
//    val roseTender = object : FlowerCare<ContraRose> {
//        override fun prune(contraFlower: ContraRose) = println("I'm pruning a rose!")
//    }
//    val daffodilTender = object : FlowerCare<ContraDaffodil> {
//        override fun prune(contraFlower: ContraDaffodil) {
//            println("I'm pruning a daffodil!")
//        }
//    }

    val roseContraGarden = ContraGarden<ContraRose>(listOf(ContraRose(), ContraRose()), flowerTender)
    roseContraGarden.tendFlower(0)

    val daffodilContraGarden = ContraGarden<ContraDaffodil>(listOf(ContraDaffodil(), ContraDaffodil(),
        ContraDaffodil()), flowerTender)
    daffodilContraGarden.tendFlower(2)
}


class ContraGarden<T: ContraFlower>(val contraFlowers: List<T>, val flowerCare: FlowerCare<T>) {
    fun pickFlower(i: Int) = contraFlowers[i]
    fun tendFlower(i: Int) {
        flowerCare.prune(contraFlowers[i])
    }
}

open class ContraFlower(val name: String){  }

class ContraRose: ContraFlower("Rose") {  }
class ContraDaffodil: ContraFlower("Daffodil") {  }

/** using 'in' with T makes the interface
 * able to accept the Type 'T' and it's Super-types
 * */
interface FlowerCare<in T> {
    fun prune(contraFlower: T)
}
