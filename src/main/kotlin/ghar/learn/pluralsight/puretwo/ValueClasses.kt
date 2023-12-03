package ghar.learn.pluralsight.puretwo

import java.lang.IllegalArgumentException

fun main(){
    println("Value class demo")
    val p0 = Person(Id("223-aba"), GivenName("Hamza"))
}

class Person(val id: Id, val givenName: GivenName) {
    fun provideIds(){
        println("Id: ${id.id}")
    }

    /** accessing properties in the given (value) classes */
    fun getLength(){
        givenName.length
    }
}

/**
 * 'value' keyword
 */
@JvmInline
//value class GivenName(var givenName: String, val lastName: String) {   // Limitations of Value-class: no 'var', only One property
value class GivenName(val givenName: String) {
    val length : Int
        get() = givenName.length
    init {
        if (givenName.isEmpty()) throw IllegalArgumentException()
        if (givenName.contains(" ")) throw IllegalArgumentException()
    }
}
class Student(id: Id){  }

@JvmInline
value class Id(val id: String){
    init {
        //111-abc
        if(id.isEmpty()) throw IllegalArgumentException()
        if(!id.matches(Regex("^\\d{3}-[a-zA-Z]{3}\$"))) throw IllegalArgumentException()
    }
}