package ghar.learn.pluralsight.puretwo

import java.awt.image.SampleModel

fun main(){
    println("singletons here")
    println("--------------------")
//    LoggerImpl.warn()

    warningMessage(SimpleLogger())  // can take both Singleton as well as Object-of-a-class

}

interface Logger {
    fun warn()
}

fun warningMessage(logger: Logger) {
    logger.warn()
}

/** Singleton approach using 'object' keyword */
object LoggerImpl : Logger {
    override fun warn() {
        println("warning message...")
    }
}

/**
 * an object-instantiated based - approach
 */
class SimpleLogger : Logger {
    override fun warn() {
        println("a different warning message...")
    }
}