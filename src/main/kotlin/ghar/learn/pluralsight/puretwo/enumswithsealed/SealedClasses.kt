package ghar.learn.pluralsight.puretwo.enumswithsealed

import kotlin.Error

fun main(){
    println("Sealed classes intro")
    println("-------------------------------")
    println("sealed classes are abstract classes, are 'closed-set' of classes,\ni.e: need to be defined at compile time," +
            " cannot be instantiated directly,\nNow sub-classes within Sealed Class can be classes, data-classes or could be objects\n" +
            "however, within 'same compilation-Unit', means: all code needs to be available within same module and\n" +
            "should not be called (for example) in another library at a later-time. Hence in 'same-compilation-Unit " +
            "(bascially in the same project)', and compiled at the same time\n\n")

    var error:Errors = Errors.NetworkError(23)
    error = RuntimeError()                             // do not need access using a '.'
    println("runtime error: ${error.errorCode}")

    val isSafeToContinue: Boolean = when(error) {
        is Errors.NetworkError -> error.isSafeToContinue()      // error here depicts of 'type' NetworkError: a great flexibility of Sealed-classes
        is Errors.DatabaseError -> error.errorCode > 10          // error here depicts of 'type' DatabaseError
        is RuntimeError -> false
    }
}

sealed class Errors(val errorCode: Int) {

    abstract fun getErrorMessage() : String

    // below two classes are part of the 'closed-set'
    class NetworkError(errorCode: Int) : Errors(errorCode) {
        override fun getErrorMessage()  = "error message code: $errorCode "

        fun isSafeToContinue(): Boolean {
            return errorCode < 100
        }
    }

    class DatabaseError(errorCode: Int, val errorMsg: String) : Errors(errorCode) {
        override fun getErrorMessage(): String {
            return "Error message: $errorMsg with $errorCode "
        }
    }
}

class RuntimeError() : Errors(-1) {
    override fun getErrorMessage(): String = "Runtime Error: $errorCode"
}
