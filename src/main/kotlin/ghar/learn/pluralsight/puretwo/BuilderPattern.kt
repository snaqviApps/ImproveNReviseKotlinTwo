package ghar.learn.pluralsight.puretwo

fun main(){
    println("Builder pattern explained...")

//    val user = User("test-name")        // Error: Cannot access '<init>': it is private in 'User'

//    val user = User.Builder.build("Terry", "Johns")    // User.Build.build(): less-cleaner access towards using build-pattern
    val user= User.build("Cleaner", "Approach")   // User.build(): cleaner access towards using build-pattern
    println("clearer-builder-pattern:  ")

}

class User private constructor(name: String) {      // can't access private constructor

//    object Builder {                                // less-cleaner access
    companion object Builder {                        // cleaner access
        fun build(firstName : String, lastName: String) : User {
            return User("$firstName $lastName")
        }
    }
}