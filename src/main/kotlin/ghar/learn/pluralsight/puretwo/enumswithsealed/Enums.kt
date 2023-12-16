package ghar.learn.pluralsight.puretwo.enumswithsealed

fun main(){
    println("Enums and Sealed aspects in Kotlin")
    println("----------------------------------")
    val season: Season = Season.Autumn          // type of enumeration is type of the 'class' itself (here: Season)

//    for(s in Season.values()){
    for(s in Season.entries){        // same, and preferred way, gives same result as above line since Kotlin-version: 1.9
        println("Season ${s.name} has ordinal: ${s.ordinal}")
    }

    // As state machine (where 'next-value' matters) using 'when'
    val nextSeason: Season = when(season) {
        Season.Spring -> Season.Summer
        Season.Summer -> Season.Autumn
        Season.Autumn -> Season.Winter
        Season.Winter -> Season.Spring
    }
    println("----------------------------------")
    println("Enum can act as a state-machine using 'when-statement'")
    println("Next season is: $nextSeason")
    // As state machine (where 'next-value' matters) using 'when'

    // Using values instead of Names using constructor
    val httpCodes = HttpStatusCodes.Success
    println("----------------------------------")
    println("Using constructor-provided-property to retrieve assigned-values to Enum-entries, instead of default ordinals ")
    println("http status-code-Ordinal: ${httpCodes.ordinal}")       // default ordinal
    println("http success status-code: ${httpCodes.statusCode}")    // here construct

    // Enumerations with methods-calls (call-backs)
    println("----------------------------------")
    println("Enums with powerful methods")
    var shift  = Shift.General
    shift = shift.nextShift()           // notice, same variable type can be re-assigned, that makes this call powerful
    println("next shift: $shift")
}

enum class Season {
    Spring,                 // enumerations have a value and name as well as 'ordinals' associated
    Summer,
    Autumn,
    Winter
}

/** Enum class example where values can be used to assign-specific numerical-meaningful  */
enum class HttpStatusCodes(val statusCode: String) {
//    Complete List of HTTP Status Codes
    Informational("1xx"),
    Success("2xx"),
    Redirection("3xx"),
    ClientErrors("4xx"),
    ServerErrors("5xx"),
    GlobalErrors("6xx")
}

/** Enumerations with methods calls */
enum class Shift{
    General {
        override fun nextShift(): Shift {
            return Evening
        }
    },
    Evening {
        override fun nextShift(): Shift {
            return Graveyard
        }
    },
    Graveyard {
        override fun nextShift(): Shift {
           return General
        }
    };

    abstract fun nextShift() : Shift
}