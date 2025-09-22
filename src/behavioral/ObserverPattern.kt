package behavioral

/**
 * Observer Pattern is subscription mechanism that notifies multiple objects about any changes that happen to the observed object
 * */

/**
 * This interface will execute whenever a change happens to the object that is observed
 * **/
interface MyObserver {
    fun update()
}

/**
 * behavioral.Observable is responsible for managing all the observers
 * */
interface Observable {
    val myObservers: ArrayList<MyObserver>

    fun add(myObserver: MyObserver) {
        myObservers.add(myObserver)
    }

    fun remove(myObserver: MyObserver) {
        myObservers.remove(myObserver)
    }

    // notify all the listeners/observers
    fun sendNotificationEvent() {
        myObservers.forEach { it.update() }
    }
}

/**
 * Example Impl
 * */

class OutOfStockObservable() : Observable {
    override val myObservers: ArrayList<MyObserver> = arrayListOf()

    fun mNotify() {
        sendNotificationEvent()
    }
}

class OutOfStockObserver() : MyObserver {
    override fun update() {
        println("OOS notification ---- ")
    }
}

fun main() {
    val observable = OutOfStockObservable()
    val observer1 = object : MyObserver {
        override fun update() {
            println("Update from 1")
        }

    }

    val observer2 = object : MyObserver {
        override fun update() {
            println("Update from 2")
        }
    }

    val observer3 = object : MyObserver {
        override fun update() {
            println("Update from 3")
        }
    }

    observable.add(observer1)
    observable.add(observer2)
    observable.add(observer3)
    observable.mNotify()
}

interface ButtonClickListener {
    fun onClicked()
}

