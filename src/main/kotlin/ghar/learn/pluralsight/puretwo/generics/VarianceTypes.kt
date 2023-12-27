package ghar.learn.pluralsight.puretwo.generics

fun main(){
    println("-----------------------------")
    println("Now about Generics-Types, called Variances, it has three of those with one Default")
    println("- Invariant (default)\n- Covariant\n- ContraVariant")
    println("-----------")
    println("Covariant: certain rules apply on it, it 'varies' along-with the generic-type ")
    println("while Contravariant: it 'varies' in Opposite-direction to the generic-type ")

}

//interface Producer<T> {               // this is missing 'type'
interface Producer<out T> {
    fun next() : T
}

fun produce(producer: Producer<Student>): Person {
    val personProducer : Producer<Person> = producer
                                                        // line# 13, with error --> Required:Producer<Person>, Found: Producer<Student>
    return personProducer.next()                        // corrected 'interface is on line# 14 with 'out' to mention 'Covarance' usint 'out'
                                                        // that tells Compiler that interface can only 'Produce (one-way), and cannot take 'in'
}


open class Person

class Developer : Person()

class Student : Person() {

}