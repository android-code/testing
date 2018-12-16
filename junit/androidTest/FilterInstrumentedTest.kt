@RunWith(AndroidJUnit4::class)
class FilterInstrumentedTest {

    @MediumTest @SdkSuppress(minSdkVersion = 21) @RequiresDevice
    @Test //runs only on devices with min 21 API
    fun checkAppTitle() { 
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("Game", appContext.getString(R.string.app_name))
    }

    @SmallTest @SdkSuppress(maxSdkVersion = 20)
    @Test //runs on devices and emulator with max 20 API
    fun checkOldAppTitle() {
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("Game Old", appContext.getString(R.string.app_name))
    }
}