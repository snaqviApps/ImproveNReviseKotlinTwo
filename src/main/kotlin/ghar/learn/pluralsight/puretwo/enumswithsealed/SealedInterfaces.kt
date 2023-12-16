
package ghar.learn.pluralsight.puretwo.enumswithsealed

fun main(){
    println("Sealed Interface intro")
    println("-------------------------------")
    println("sealed Interfaces, sealed classes have advantage that they could have\ndefault-constructor" +
            "that sealed-interfaces couldn't.\nOn the other hand, we could have multiple\nsealed-interfaces")


    var errorsInterface: ErrorsInterface = ErrorsInterface.NwInterface(41)
    errorsInterface = RuntimeErrorInterface
    println("runtime error: ${errorsInterface.getErrorMessageInterface()}")
    val hasProcessedMsg : Boolean = when(errorsInterface) {
        is ErrorsInterface.DBErrorInterface -> errorsInterface.errorCode == 0
        is ErrorsInterface.NwInterface -> errorsInterface.errorCode == -1
        is AppExceptionInterface -> true
        is RuntimeErrorInterface -> false
        is DBError -> TODO()
        is UserError -> TODO()
    }
}

sealed interface RemoteError  {
    fun getRemoteErrorMsg() : String
}

sealed interface ErrorsInterface {

    fun getErrorMessageInterface(): String

    // below two classes are part of the 'closed-set'
    data class NwInterface(val errorCode: Int) : ErrorsInterface, RemoteError {
        override fun getErrorMessageInterface(): String = "error message code: $errorCode "
        override fun getRemoteErrorMsg(): String = "remote error-msg"
    }

    data class DBErrorInterface(val errorCode: Int, val errorMsg: String) : ErrorsInterface {
        override fun getErrorMessageInterface(): String = "Error message: $errorMsg with $errorCode "
    }
}

data class AppExceptionInterface(val e: Exception) : ErrorsInterface {
    override fun getErrorMessageInterface(): String = e.message ?: ""
}

object RuntimeErrorInterface : ErrorsInterface {
    override fun getErrorMessageInterface(): String = "Runtime Error"
}

/** below two interfaces allow to 'External users' to utilize the abstract methods
 * provided by the 'ErrorsInterface'
 * */
interface UserError: ErrorsInterface
interface DBError : ErrorsInterface