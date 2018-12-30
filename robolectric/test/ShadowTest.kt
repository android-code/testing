@RunWith(RobolectricTestRunner::class)
@Config(shadows=arrayOf(CustomShadowTextView::class))
class ShadowTest {

    @Test
    fun shadowCustomClassImplicit() {
        val activity = Robolectric.setupActivity(MainActivity::class.java)
        val view = activity.textViewTitle //TextView instance
        view.setEnabled(false) 
        assertEquals(0.5f, view.getAlpha())
    }

    @Test
    fun shadowCustomClassExplicit() {
        val activity = Robolectric.setupActivity(MainActivity::class.java)
        val view = extract(activity.textViewTitle) as CustomShadowTextView
        view.setEnabled(false)
        assertEquals(0.5f, view.getAlpha())
    }
}