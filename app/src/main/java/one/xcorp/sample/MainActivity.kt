package one.xcorp.sample

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.blurButton
import kotlinx.android.synthetic.main.activity_main.lockButton
import one.xcorp.partial.R
import one.xcorp.partial.blur.BlurredActivity
import one.xcorp.partial.blur.BlurredActivityImpl
import one.xcorp.partial.lock.LockedActivity
import one.xcorp.partial.lock.LockedActivityImpl

class MainActivity : AppCompatActivity(),
        BlurredActivity by BlurredActivityImpl(), // TODO first step
        LockedActivity by LockedActivityImpl() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        attachToActivity(this) // All parts must pass the base activity // TODO second step
        setContentView(R.layout.activity_main)

        // How to get context from partial activity
        val appName = getContext().getString(R.string.app_name)
        Log.i("TEST_TAG", "MainActivity: appName = $appName")

        blurButton.setOnClickListener {
            setBlur(true) // Blur activity
            startActivity(Intent(this, SecondActivity::class.java))
        }

        lockButton.setOnClickListener {
            setLock(true) // Enable lock screen
            setLock(false) // Unlock screen via launch activity
        }
    }

    // TODO third step
    override fun getContext() = this

    // TODO fourth step
    override fun attachToActivity(activity: FragmentActivity) {
        blurredActivity.attachToActivity(activity)
        lockedActivity.attachToActivity(activity)
    }

    override fun onResume() {
        super.onResume()
        Log.i("TEST_TAG", "MainActivity: onResume")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // You must delegate all annotated methods
        Log.i("TEST_TAG", "MainActivity: onActivityResult")
        lockedActivity.onActivityResult(requestCode, resultCode, data)
    }
}
