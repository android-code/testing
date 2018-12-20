@RunWith(MockitoJUnitRunner::class)
class ConfigurationTest {

    @Mock
    lateinit var mock: Data

    @Spy
    lateinit var spy: Data

    lateinit var manager: Manager

    @Before
    fun init() {
        manager = Manager(mock)
    }

    @Test
    fun checkFetchDataReturnsMockValue() {
        assertNull(manager.fetchData())
        `when`(mock.getInfo()).thenReturn("mock")
        assertNull(manager.fetchData()) //now it fails
        assertEquals("mock", manager.fetchData())
    }

    @Test
    fun checkFetchDataReturnsMultipleMockValue() {
        assertNull(manager.fetchData())
        `when`(mock.getInfo()).thenReturn("mock1", "mock2")
        assertNull(manager.fetchData()) //now it fails
        assertEquals("mock1", manager.fetchData())
        assertEquals("mock2", manager.fetchData())
        assertEquals("mock2", manager.fetchData())
    }

    @Test
    fun checkFetchDataTakesMultipleArgReturnsMockValue() {
        manager = Manager(spy)
        doReturn("spy with arg").`when`(spy).getInfo("arg1")
        doReturn("spy with arg").`when`(spy).getInfo("arg2")
        assertEquals("spy with arg", manager.fetchDataWithMessage("arg1"))
        assertEquals("spy with arg", manager.fetchDataWithMessage("arg2"))
        //not possible without reset using when.thenReturn
    }

    @Test
    fun checkGetInfoForWrappedReturnsWrapperValue() {
        val data = Data()
        val spyData = Mockito.spy(data)
        manager = Manager(spyData)
        doReturn("wrapper").`when`(spyData).getInfo()
        assertEquals("wrapper", manager.fetchData())
    }

    @Test
    fun checkFetchDataWithArgsReturnsMockValue() {
        Mockito.`when`(mock.getInfo("arg")).thenReturn("mock with arg")
        assertEquals("mock with arg", manager.fetchDataWithMessage("arg"))
        assertEquals("mock with arg", manager.fetchDataWithMessage("whatever")) //fails
        `when`(mock.getInfo(anyString())).thenReturn("mock with arg")
        assertEquals("mock with arg", manager.fetchDataWithMessage("whatever")) //now it pass
    }

    @Test(expected = IllegalArgumentException::class)
    fun checkFetchDataThrowsExceptionForSpecialCharactersArg() {
        `when`(mock.getInfo("@")).thenThrow(IllegalArgumentException())
        manager.fetchDataWithMessage("@")
    }
}