@RunWith(AndroidJUnit4::class)
class EspressoTest {

    @get:Rule
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)
    
    @Test
    fun changeTextInTextViewFromEditText() {
        onView(withId(R.id.editTextName)) //find UI component
            .perform(typeText("value")) //do action

        onView(withId(R.id.buttonAction)) //find UI component
            .perform(click()) //do action

        onView(withId(R.id.textViewName)) //find UI component
            .check(matches(withText("value"))) //verify
    }
}