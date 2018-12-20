//or use manual init method
class InitMockAnnotationTest {

    @Mock
    var obj: Data? = null

    @Test
    fun checkIsObjectInitialized() {
        MockitoAnnotations.initMocks(this)
        assertNotNull(obj)
    }
}