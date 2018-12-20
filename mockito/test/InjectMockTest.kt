@RunWith(MockitoJUnitRunner::class)
class InjectMockTest {

    @Mock
    var mock: Data? = null

    //constructor requires Data arg
    @InjectMocks
    var manager1: Manager? = null

    @Test
    fun checkIsManager1Initialized() {
        assertNotNull(mock)
        assertNotNull(manager1)
    }

    //equivalent
    @Test
    fun checkIsManager2Initialized() {
        var manager2 = Manager(mock)  
        assertNotNull(mock)
        assertNotNull(manager2)
    }
}