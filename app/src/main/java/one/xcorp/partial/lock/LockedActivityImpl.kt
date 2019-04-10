package one.xcorp.partial.lock

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.util.Log
import one.xcorp.partial.BasePartialActivity
import one.xcorp.sample.SecondActivity

/**
 * Demonstrates how to use delegation of method calls from main activity.
 */
class LockedActivityImpl : LockedActivity, BasePartialActivity() {

    override val lockedActivity = this

    private var isLocked = true

    override fun isLocked() = isLocked

    override fun setLock(isLocked: Boolean) {
        if (isLocked) {
            this.isLocked = isLocked
            Log.i("TEST_TAG", "LockedActivity: isLocked = $isLocked")
        } else {
            val intent = Intent(getContext(), SecondActivity::class.java)
            startActivityForResult(intent, REQUEST_LOCK_ACTIVITY)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        Log.i("TEST_TAG", "LockedActivity: onActivityResult")
        if (requestCode == REQUEST_LOCK_ACTIVITY && resultCode == RESULT_OK) {
            this.isLocked = false
            Log.i("TEST_TAG", "LockedActivity: isLocked = $isLocked")
        }
    }

    companion object {

        const val REQUEST_LOCK_ACTIVITY = 100
    }
}
