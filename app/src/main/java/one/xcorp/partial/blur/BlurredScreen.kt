package one.xcorp.partial.blur

import one.xcorp.partial.PartialScreen

interface BlurredScreen : PartialScreen {

    val blurredScreen: BlurredScreen

    fun isBlurred(): Boolean

    fun setBlur(isBlurred: Boolean)
}
