@RunWith(RobolectricTestRunner::class)
class ServiceTest {

    @Test
    fun checkSomeServiceProperlyBindAndUnbind() {
        val service = Robolectric.buildService(SomeService::class.java).bind().get()
        assertTrue(service.bound)
        service.onUnbind(null)
        assertFalse(service.bound)
    }
}