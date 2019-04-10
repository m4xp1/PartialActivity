package one.xcorp.partial.lock

import android.content.Intent
import one.xcorp.partial.Delegated
import one.xcorp.partial.PartialScreen

interface LockableScreen : PartialScreen {

    val lockableScreen: LockableScreen

    fun isLocked(): Boolean

    fun setLock(isLocked: Boolean)

    @Delegated
    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
}
