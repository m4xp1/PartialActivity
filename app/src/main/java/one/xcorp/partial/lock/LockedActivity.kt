package one.xcorp.partial.lock

import android.content.Intent
import one.xcorp.partial.Delegated
import one.xcorp.partial.PartialActivity

interface LockedActivity : PartialActivity {

    val lockedActivity: LockedActivity

    fun isLocked(): Boolean

    fun setLock(isLocked: Boolean)

    @Delegated
    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
}
