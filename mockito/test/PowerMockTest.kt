@RunWith(PowerMockRunner::class)
@PrepareForTest(Data::class, System::class)
class PowerMockTest {

    @Test
    fun checkMockStaticMethod() {
        PowerMockito.mockStatic(System::class.java)
        PowerMockito`when`(System.currentTimeMillis()).thenReturn(100)
        assertEquals(100, System.currentTimeMillis())
    }

    @Test
    fun checkMockPrivateMethod() {
        val obj = Data()
        val spy: Data = PowerMockito.spy(obj)
        assertEquals("private returned from public", spy.publicMethod())
        PowerMockito.doReturn("private mocked").`when`(spy, "privateMethod")
        assertEquals("private mocked", spy.publicMethod())
        PowerMockito.verifyPrivate(spy, times(2)).invoke("privateMethod")
    }

    @Test
    fun checkMockConstructor() {
        val obj = Data()
        assertEquals(0, obj.number)
        assertEquals("", obj.text)
        obj.number = 1
        obj.text = "text"

        PowerMockito.whenNew(Data::class.java).withNoArguments().thenReturn(obj)
        val newObj = Data()
        assertEquals(1, newObj.number)
        assertEquals("text", newObj.text)
    }
}