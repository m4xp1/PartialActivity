package one.xcorp.partial

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.FragmentActivity

abstract class BasePartialScreen : PartialScreen {

    private lateinit var activity: FragmentActivity

    protected val baseActivity: FragmentActivity
        get() = activity

    override fun getContext() = activity

    override fun attachToActivity(activity: FragmentActivity) {
        this.activity = activity
        activity.lifecycle.addObserver(this)
    }

    protected fun startActivity(intent: Intent, options: Bundle? = null) {
        activity.startActivity(intent, options)
    }

    protected fun startActivityForResult(intent: Intent, requestCode: Int, options: Bundle? = null) {
        activity.startActivityForResult(intent, requestCode, options)
    }
}
