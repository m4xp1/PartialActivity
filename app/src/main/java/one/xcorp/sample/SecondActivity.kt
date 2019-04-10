package one.xcorp.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import one.xcorp.partial.R

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        setResult(RESULT_OK)
    }
}
