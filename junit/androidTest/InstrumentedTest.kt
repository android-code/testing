@RunWith(AndroidJUnit4::class)
class InstrumentedTest {

    @Rule @JvmField
    val activityRule = ActivityTestRule(GameActivity::class.java)

    //use only context
    @Test
    fun checkStringResourceFromContext() {
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("Game", appContext.getString(R.string.app_name))
    }

    //use activity from rule
    @Test
    fun startAndStopGameFromActivity() {
        activityRule.activity.initDefaultGame()
        activityRule.activity.startGame()
        assertTrue(activityRule.activity.isGameRunning())
        activityRule.activity.stopGame()
        assertFalse(activityRule.activity.isGameRunning())
    }
}