package ghar.learn.pluralsight.puretwo.generics

import ghar.learn.pluralsight.puretwo.Person
import java.time.LocalDate
import java.time.LocalDateTime

fun main(args: Array<String>) {
    println("about Generics")

    val env: Envelope<GenPerson> = Envelope(GenPerson(), null)

    val names : List<String> = listOf("Zem", "Mashto")
    val namesEnv: Envelope<List<String>> = Envelope(names, null)    // 'nested' generic-type (List<String>)

    val sqlEnvelope: SqlEnvelope<List<String>> = SqlEnvelope(100, names)
    println(sqlEnvelope.data)


}

class Envelope<T> (val result: T?, val message: String?) {
    val timeGenerated: LocalDateTime
    init {
        timeGenerated = LocalDateTime.now()
    }
}

class GenPerson

//class SqlEnvelope<T>(val count: Int, val data: T) where T:List<Any>  // limit the generic-type to 'list'
class SqlEnvelope<T:List<Any> >(val count: Int, val data: T)    // (2nd param) same as 'above', but now generic-type is limited, unlike 'where' that can put multiple types as generic



