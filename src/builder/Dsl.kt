package builder

enum class BoardColors {
    Blue,
    Red,
    Yellow,
    White
}

class Board {
    var title = ""
    var count = 0
    var taskList = mutableListOf<Task>()


    fun task(mInit : Task.() -> Unit) {
        val t = Task()
        t.mInit()
        taskList.add(t)
    }
}

class Task {
    var ind = 0
    var name = ""
}

fun board(mInit : Board.() -> Unit) : Board {
    val b = Board()
    b.mInit()
    return b
}



fun main() {
    val dsl = board {
        title = "siva"
        count = 100

        task {
            ind = 0
            name = "first"
        }

        task {
            ind = 1
            name = "second"
        }

        task {
            ind = 2
            name = "second"
        }
    }

    println("title -> " + dsl.title + dsl.taskList.map {it.name})
}