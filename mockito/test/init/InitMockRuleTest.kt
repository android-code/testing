//or use Mockito rule
class InitMockRuleTest {

    @Mock
    var obj: Data? = null

    @get:Rule
    var mockitoRule = MockitoJUnit.rule()

    @Test
    fun checkIsObjectInitialized() {
        assertNotNull(obj)
    }
}