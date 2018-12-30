@RunWith(RobolectricTestRunner::class)
@Config(minSdk = LOLLIPOP)
class ConfigurationTest {

    lateinit var activity: MainActivity

    @Before
    fun init() {
    	//this method provides that activity goes throw all create lifecycle
        activity = Robolectric.setupActivity(MainActivity::class.java)
    }

    @Test
    fun checkViewsValueOnLollipopAndAbove() {
        assertEquals("title", activity.textViewTitle.text)
        assertEquals("action", activity.buttonAction.text)
    }

    @Config(minSdk = KITKAT, maxSdk = LOLLIPOP)
    @Test
    fun checkViewsValueOnMinKitkatMaxLollipop() {
        assertEquals("title", activity.textViewTitle.text)
        assertEquals("action", activity.buttonAction.text)
    }

    @Config(sdk = intArrayOf(O, O_MR1, P))
    @Test
    fun checkViewsValueOnlyOnOreoAndPie() {
        assertEquals("title", activity.textViewTitle.text)
        assertEquals("action", activity.buttonAction.text)
    }

    @Config(qualifiers = "pl")
    @Test
    fun checkViewsValueInPolish() {
        assertEquals("tytuł", activity.textViewTitle.text)
        assertEquals("akcja", activity.buttonAction.text)
    }

    @Config(qualifiers = "xhdpi")
    @Test
    fun checkViewsValueOnXhdpi() {
        assertEquals(32, activity.buttonAction.paddingTop)
    }
}