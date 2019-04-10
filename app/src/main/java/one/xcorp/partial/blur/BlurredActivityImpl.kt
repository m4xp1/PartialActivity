package one.xcorp.partial.blur

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.OnLifecycleEvent
import android.util.Log
import one.xcorp.partial.BasePartialActivity

/**
 * Demonstrates how to use bind to the activity life cycle.
 */
class BlurredActivityImpl : BlurredActivity, BasePartialActivity() {

    override val blurredActivity = this

    private var isBlurred = false

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        setBlur(false)
    }

    override fun isBlurred() = isBlurred

    override fun setBlur(isBlurred: Boolean) {
        this.isBlurred = isBlurred
        Log.i("TEST_TAG", "BlurredActivity: isBlurred = $isBlurred")
    }
}
