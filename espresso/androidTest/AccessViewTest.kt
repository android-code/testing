@RunWith(AndroidJUnit4::class)
class AccessViewTest {

    @get:Rule
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)
    
    @Test
    fun changeTextFromViewAccess() {
        onView(allOf(withId(R.id.editTextName), instanceOf(EditText::class.java))) //combine id with type
            .perform(typeText("value")) //do action

        onView(withText("action")) //only one matcher
            .perform(click())

        onView(withId(R.id.textViewName)) //only one matcher
            .check(matches(withText("value")))
    }

    @Test
    fun changeTextFromAdapterViewAccess() {
        onData(anything())
            .inAdapterView(withId(R.id.listViewNames))
            .atPosition(0)
            .perform(click())

        onView(withId(R.id.textViewName))
            .check(matches(withText("name1")))
    }
}