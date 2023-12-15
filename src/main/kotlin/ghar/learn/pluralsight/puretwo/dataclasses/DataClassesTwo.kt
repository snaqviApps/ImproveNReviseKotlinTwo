package ghar.learn.pluralsight.puretwo.dataclasses

fun main(){
    println("data-classes-section-Two:\nCopy-function in data classes and destructuring,\n" +
            "Copy() lets them change properties values (data), that is otherwise not recommended\n" +
            "as 'Data' classes are ideally immutablen\n")
    println("---------------------------------------------\n")

    val person = Person("Hamza Naqvi", url="abc.com")
    println("Person info: $person")

    /**
     * Object-instantiating using 'copy()-method', that uses properties ONLY from primary constructor
     * Data can be changed while copying
     * */
    val person2 = person.copy(url="msnbc.com")
    println("person1 copied as person2: $person2")

    /** Destructuring */
    val (name, urlInfo) = person2
    println("person2 de-structured, gives info, name: $name, and url: $urlInfo")


    /** Destructuring using 'Compunent()' call */
    println("person1 de-structured, getting properties using component(): ${person2.component1()}, ${person2.component2()}")

    val (_, url) = person2              //de-structuring with skipping a property using '_' instead.
    println("using '_' to exclude, unused-property, with only getting 'url' that is required: $url")
}

data class Person(var name: String, val url:String) {

    val parts = name.split(" ")
    val namePart1 = parts.component1()
    val namePart2 = parts.component2()

    val uppedNamePart1: String;
    val uppedNamePart2: String;

    init {
        uppedNamePart1 = namePart1.uppercase()
        uppedNamePart2 = namePart2.uppercase()
    }

    override fun toString(): String {
        return "Person(uppedNamePart1='$uppedNamePart1', uppedNamePart2='$uppedNamePart2')"
    }


}