data class Data(var number: Int, var text: String) {

    constructor() : this(0, "")

    fun getInfo(): String {
        return "$text $number"
    }

    fun getInfo(message: String?): String {
        return "$message $number"
    }

    fun publicMethod(): String {
        return privateMethod()
    }

    private fun privateMethod(): String {
        return "private returned from public"
    }
}