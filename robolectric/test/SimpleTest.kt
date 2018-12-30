class SimpleTest {

    lateinit var activity: MainActivity

    @Before
    fun init() {
    	//this method provides that activity goes throw all create lifecycle
        activity = Robolectric.setupActivity(MainActivity::class.java)
    }

    @Test
    fun checkViewsValue() {
        assertEquals("title", activity.textViewTitle.text)
        assertEquals("action", activity.buttonAction.text)
    }

    @Test
    fun clickingTextViewChangeText() {
        activity.textViewTitle.performClick()
        assertEquals("clicked", activity.textViewTitle.text)
    }

    @Test
    fun clickingButtonNavigateToSecondActivity() {
        activity.buttonAction.performClick()
        val expectedIntent = Intent(activity, SecondActivity::class.java)
        val actual = shadowOf(getApplicationContext() as Application).nextStartedActivity
        assertNotNull(actual)
        assertEquals(expectedIntent.component, actual.component)
    }
}