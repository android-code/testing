@Implements(TextView::class)
class CustomShadowTextView : ShadowView() {

    @Implementation
    fun setEnabled(enable: Boolean) {
        directlyOn(realView, View::class.java).setEnabled(enable)
        if(enable)
            directlyOn(realView, View::class.java).setAlpha(1.0f)
        else
            directlyOn(realView, View::class.java).setAlpha(0.5f)
    }

    fun getAlpha() : Float {
        return realView.alpha
    }
}