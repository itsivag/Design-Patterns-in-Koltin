package structural

/**
 * The adapter pattern acts as a bridge b/w two incompatible classes to make them work together.
 * we have 3 components:
 * 1) Client - the class which wants to use the incompatible class ~ interface
 * 2) Adaptee - the incompatible class which has the functionality required by client
 * 3) Adapter - returns intended interface for the client and delegates call to the adaptee
 * */

interface Athlete {
    fun compete(action: String)
}

interface Chef {
    fun cook()
}

class ChefImp : Chef {
    override fun cook() {
        println("cooking .....")
    }
}

class ProChefImp : Chef {
    override fun cook() {
        println("pro cooking .....")
    }
}

class AthleteAdapter() : Athlete {
    override fun compete(action: String) {
        val chef: Chef? = when (action) {
            "cook" -> ChefImp()
            "pro cook" -> ProChefImp()
            else -> null
        }
        chef?.cook() ?: println("Unknown action: $action")
    }
}

class AthleteImp : Athlete {
    val athleteAdapter = AthleteAdapter()
    override fun compete(action: String) {
        athleteAdapter.compete(action)
    }
}

fun main() {
    val athlete = AthleteImp()
    athlete.compete("cook")
    athlete.compete("pro cook")
    athlete.compete("")
}
