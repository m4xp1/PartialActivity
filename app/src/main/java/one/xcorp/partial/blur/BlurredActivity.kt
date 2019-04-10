package one.xcorp.partial.blur

import one.xcorp.partial.PartialActivity

interface BlurredActivity : PartialActivity {

    val blurredActivity: BlurredActivity

    fun isBlurred(): Boolean

    fun setBlur(isBlurred: Boolean)
}
