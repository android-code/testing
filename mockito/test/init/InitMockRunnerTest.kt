//use Mockito runner
@RunWith(MockitoJUnitRunner::class)
class InitMockRunnerTest {

    @Mock
    var obj: Data? = null

    @Test
    fun checkIsObjectInitialized() {
        assertNotNull(obj)
    }
}