@RunWith(RobolectricTestRunner::class)
class LifecycleTest {

    @Test
    fun checkMainActivityHasWorkingLifecycle() {
        val controller = Robolectric.buildActivity(MainActivity::class.java)
        val activity = controller.create().get()

        assertEquals(Lifecycle.State.CREATED, activity.lifecycle.currentState)
        //do more assertion for this state
        
        controller.start()
        assertEquals(Lifecycle.State.STARTED, activity.lifecycle.currentState)
        //do more assertion for this state
        
        controller.resume()
        assertEquals(Lifecycle.State.RESUMED, activity.lifecycle.currentState)
        //do more assertion for this state
        
        controller.pause().stop().destroy()
        assertEquals(Lifecycle.State.DESTROYED, activity.lifecycle.currentState)
    }

    @Test
    fun checkMainActivityHasWorkingFinishLifecycle() {
        //this activity goes throw all create lifecycle
        val controller = Robolectric.buildActivity(MainActivity::class.java)
        val activity = controller.create().start().resume().visible().get()
        //equivalent of val activity = Robolectric.setupActivity(MainActivity::class.java)
        //visible methods assures that activity view's is attached

        assertFalse(activity.isFinishing)
        activity.finish()
        assertTrue(activity.isFinishing)
    }

    @Test
    fun checkMainActivityHasWorkingRestoringState() {
        val savedInstanceState = Bundle()
        savedInstanceState.putString(TITLE_KEY, "value restored")
        val activity = Robolectric.buildActivity(MainActivity::class.java)
            .create().restoreInstanceState(savedInstanceState).get()

        assertEquals("value restored", activity.textViewTitle.text)
    }
}