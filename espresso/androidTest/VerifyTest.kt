@RunWith(AndroidJUnit4::class)
class VerifyTest {

    @get:Rule
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)
    
    @Test
    fun verifyHideTextViewWhenHideTextTyped() {
        //actions
        onView(withId(R.id.editTextName)).perform(typeText("hide"))
        onView(withId(R.id.buttonAction)).perform(click())

        //verify
        onView(withId(R.id.textViewName)).check(matches(not(isDisplayed())))
    }
}