package behavioral

interface MyListener {
    fun update()
}


class NotificationListener : MyListener {
    override fun update() {
        println("notification received!")
    }
}

class SendNotification(val notificationListener: NotificationListener) {
    fun invoke() {
        notificationListener.update()
    }
}

fun main() {
    val listener = NotificationListener()
    SendNotification(listener).invoke()
}