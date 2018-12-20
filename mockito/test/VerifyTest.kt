class VerifyTest {

    lateinit var mock: Data
    lateinit var manager: Manager

    @Before
    fun init() {
        mock = mock(Data::class.java)
        manager = Manager(mock)
    }

    @Test
    fun checkHowManyTimesGetInfoCalled() {
        verifyZeroInteractions(mock) //any methods called on the mock
        verify(mock, never()).getInfo()

        manager.fetchData()

        verify(mock, times(1)).getInfo()
        verify(mock, atLeast(1)).getInfo()
        verify(mock, atMost(3)).getInfo()
        verifyNoMoreInteractions(mock) //no others method called
    }


    @Test
    fun checkArgsOfGetInfo() {
        val captor = forClass(String::class.java)
        manager.fetchDataWithMessage("message")

        //verify args passed into getInfo method
        verify(mock).getInfo(captor.capture())
        assertEquals("message", captor.value)
    }
}