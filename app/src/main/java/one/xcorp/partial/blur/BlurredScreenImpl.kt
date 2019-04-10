package one.xcorp.partial.blur

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.OnLifecycleEvent
import android.util.Log
import one.xcorp.partial.BasePartialScreen

/**
 * Demonstrates how to use bind to the activity life cycle.
 */
class BlurredScreenImpl : BlurredScreen, BasePartialScreen() {

    override val blurredScreen = this

    private var isBlurred = false

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        setBlur(false)
    }

    override fun isBlurred() = isBlurred

    override fun setBlur(isBlurred: Boolean) {
        this.isBlurred = isBlurred
        Log.i("TEST_TAG", "BlurredScreen: isBlurred = $isBlurred")
    }
}
