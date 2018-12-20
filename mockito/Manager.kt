class Manager(val data: Data) {

    fun fetchData(): String {
        return data.getInfo()
    }

    fun fetchDataWithMessage(message: String): String {
        return data.getInfo(message)
    }
}