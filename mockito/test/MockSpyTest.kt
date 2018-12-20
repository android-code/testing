@RunWith(MockitoJUnitRunner::class)
class MockSpyTest {

    @Mock
    var mock: Data? = null

    @Spy
    var spy: Data? = null

    @Test
    fun checkIsObjectInitialized() {
        assertNotNull(mock)
        assertNotNull(spy)
        mock?.text = "mock"
        spy?.text = "spy"
        assertEquals("mock", mock?.text) //fails mock.text is null
        assertEquals("spy", spy?.text)
    }
}