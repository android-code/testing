//this is only dummy implementation
class SomeService : Service() {

    var bound = false

    override fun onBind(intent: Intent?): IBinder? {
        bound = true
        return null
    }

    override fun onUnbind(intent: Intent?): Boolean {
        bound = false
        return super.onUnbind(intent)
    }

    //more methods
}