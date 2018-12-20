@RunWith(MockitoJUnitRunner::class)
class AnswerTest {

    @Test
    fun checkFetchDataWithObjectChangedAndReturnsItsValue() {
        val spy = spy(Data::class.java)
        val manager = Manager(mock)

        assertEquals(" 0", manager.fetchData())
        assertEquals("message 0", manager.fetchDataWithMessage("message"))

        doAnswer(Answer {
            spy.number++
            spy.text = it.arguments[0] as String
            return@Answer spy.getInfo()
        }).`when`(spy).getInfo(anyString())

        assertEquals("message 1", manager.fetchDataWithMessage("message"))
        assertEquals("message 1", manager.fetchData())
    }
}