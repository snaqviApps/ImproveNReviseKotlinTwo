package ghar.learn.pluralsight.puretwo

import java.lang.IllegalArgumentException

fun main(){
    println("Value class demo")
    val p0 = Person("223-abc", "Hamza")
}

class Person(id: String, givenName: String){

    init {
        if(id.isEmpty()) throw IllegalArgumentException()
        // 111-ddd
        if(!id.matches(Regex("^\\d{3}-[a-zA-Z]{3}\$"))) throw IllegalArgumentException()
        if (givenName.isEmpty()) throw IllegalArgumentException()
        if (givenName.contains(" ")) throw IllegalArgumentException()
    }
}

class Student(id: String){
    init {
        if(id.isEmpty()) throw IllegalArgumentException()
        // 111-ddd
        if(!id.matches(Regex("^\\d{3}-[a-zA-Z]{3}\$"))) throw IllegalArgumentException()
    }
}
