package ghar.learn.pluralsight.puretwo

import java.lang.IllegalArgumentException

fun main(){
    println("Value class demo")
    val p0 = Person(Id("223-aba"), GivenName("Hamza"))
}

class Person(val id: Id, givenName: GivenName) {    // still not taking advantage of 'primitive' type, while creating 'Id'-class
    fun provideIds(){
        println("Id: $id")
    }
}

class GivenName(val givenName: String) {
    init {
        if (givenName.isEmpty()) throw IllegalArgumentException()
        if (givenName.contains(" ")) throw IllegalArgumentException()
    }
}

class Student(id: Id){  }

class Id(id: String){
    init {
        //111-abc
        if(id.isEmpty()) throw IllegalArgumentException()
        if(!id.matches(Regex("^\\d{3}-[a-zA-Z]{3}\$"))) throw IllegalArgumentException()
    }
}
