package ghar.learn.pluralsight.puretwo

fun main(){

    println("Singleton approach")
    println("-----------------------")

    Logger.warn()
}



/**
 * Singleton approach (static in 'Java')
 *
 */
object Logger {
    fun warn(){
        println("warning using singleton...")
    }
}