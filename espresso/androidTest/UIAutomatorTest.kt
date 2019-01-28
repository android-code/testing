@RunWith(AndroidJUnit4::class)
class UIAutomatorTest {

    private val APP_PACKAGE = "pl.androidcode.espresso"
    private val SMS_APP_PACKAGE = "com.google.android.apps.messaging"

    private lateinit var device: UiDevice

    @Before
    fun startMainActivityFromHomeScreen() {
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation()) //initialize
        device.pressHome() //start every test from home screen
        deviceWait(device.launcherPackageName) //wait for launcher

        //start the app
        val context = ApplicationProvider.getApplicationContext<Context>()
        val intent = context.packageManager.getLaunchIntentForPackage(APP_PACKAGE)
            .apply { addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK) }
        context.startActivity(intent)
        deviceWait(APP_PACKAGE) //wait for app
    }

    private fun deviceWait(pkg: String) {
        device.wait(Until.hasObject(By.pkg(pkg).depth(0)), 5000L)
    }

    @Test
    fun verifyTypedMessageFromEditText() {
        //find views by some selectors (known from you app code)
        val editText = device.findObject(UiSelector().resourceId("${APP_PACKAGE}:id/editTextName"))
        val buttonAction = device.findObject(UiSelector().text("ACTION").className("android.widget.Button"))
        val buttonSms = device.findObject(UiSelector().text("SMS").className("android.widget.Button"))

        if(editText.exists() && buttonAction.exists() && buttonSms.exists()) {
            //do actions
            editText.setText("message")
            buttonAction.click()
            buttonSms.click()
            deviceWait(SMS_APP_PACKAGE) //wait for expected sms app

            //find view by some selectors (known from UiAutomator Viewer)
            val messageField = device.findObject(UiSelector().resourceId("${SMS_APP_PACKAGE}:id/compose_message_text"))
            Assert.assertEquals("message", messageField.text)
        }
        else throw UiObjectNotFoundException("Throw when no matching UI element is found")
    }

    /*instead of findObject on UiDevice like below UiCollection and UiScrollable can be used
    val listViewItem: UiObject = device.findObject(UiSelector().className("android.widget.ListView")
    .instance(0).childSelector(UiSelector().text("name1")))*/

    @Test
    fun verifyPassedMessageFromCollection() {
        val buttonSms = device.findObject(UiSelector().text("SMS").className("android.widget.Button"))
        val collection: UiCollection = UiCollection(UiSelector().className("android.widget.ListView"))
        val listViewItem: UiObject = collection.getChild(UiSelector().text("name1"))

        if(listViewItem.exists() && buttonSms.exists()) {
            listViewItem.click()
            buttonSms.click()
            deviceWait(SMS_APP_PACKAGE) //wait for expected sms app

            val messageField = device.findObject(UiSelector().resourceId("${SMS_APP_PACKAGE}:id/compose_message_text"))
            Assert.assertEquals("name1", messageField.text)
        }
        else throw UiObjectNotFoundException("Throw when no matching UI element is found")
    }

    @Test
    fun verifyPassedMessageFromScrollable() {
        val buttonSms = device.findObject(UiSelector().text("SMS").className("android.widget.Button"))
        val scrollable = UiScrollable(UiSelector().className("android.widget.ListView"))

        if(buttonSms.exists()) {
            scrollable.getChildByText(UiSelector().className("android.widget.TextView"), "name1")
            buttonSms.click()
            deviceWait(SMS_APP_PACKAGE) //wait for expected sms app

            val messageField = device.findObject(UiSelector().resourceId("${SMS_APP_PACKAGE}:id/compose_message_text"))
            Assert.assertEquals("name1", messageField.text)
        }
        else throw UiObjectNotFoundException("Throw when no matching UI element is found")
    }
}