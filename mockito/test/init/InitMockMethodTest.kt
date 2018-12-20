//or use static mock method
class InitMockMethodTest {

    @Test
    fun checkIsObjectInitialized() {
        val obj = mock(Data::class.java)
        assertNotNull(obj)
    }
}