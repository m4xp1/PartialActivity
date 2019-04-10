package one.xcorp.partial

import android.arch.lifecycle.LifecycleObserver
import android.content.Context
import android.support.v4.app.FragmentActivity

interface PartialActivity : LifecycleObserver {

    fun getContext(): Context

    fun attachToActivity(activity: FragmentActivity)
}
