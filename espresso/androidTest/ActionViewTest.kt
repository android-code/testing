@RunWith(AndroidJUnit4::class)
class ActionViewTest {

    @get:Rule
    var intentsRule: IntentsTestRule<MainActivity> = IntentsTestRule(MainActivity::class.java)
    
    @Test
    fun verifyNavigateToSecondActivityWithMessage() {
        onView(withId(R.id.editTextName)).perform(typeText("value")) 
        onView(withId(R.id.buttonNavigate)).perform(closeSoftKeyboard(), click())

        intended(allOf(
                hasComponent(hasShortClassName(".SecondActivity")),
                toPackage("pl.androidcode.espresso"),
                hasExtra(MainActivity.NAME, "value")))
    }
}