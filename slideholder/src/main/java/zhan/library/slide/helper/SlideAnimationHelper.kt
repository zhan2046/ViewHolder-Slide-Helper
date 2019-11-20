package zhan.library.slide.helper

import android.animation.Animator
import android.animation.ValueAnimator
import android.animation.ValueAnimator.AnimatorUpdateListener
import android.content.Context

class SlideAnimationHelper {

    private val valueAnimator: ValueAnimator?

    val state: Int
        get() = mCurrentState

    val isOpenStatus: Boolean
        get() = mCurrentState == STATE_OPEN

    val isCloseStatus: Boolean
        get() = mCurrentState == STATE_CLOSE

    init {
        valueAnimator = ValueAnimator()
        valueAnimator.setFloatValues(0.0f, 1.0f)
    }

    fun addAnimatorUpdateListener(animatorUpdateListener: AnimatorUpdateListener) {
        valueAnimator!!.addUpdateListener(animatorUpdateListener)
    }

    fun addAnimatorListener(animatorListener: Animator.AnimatorListener) {
        valueAnimator!!.addListener(animatorListener)
    }

    fun openAnimation(duration: Long, vararg values: Float) {
        mCurrentState = STATE_OPEN
        setValueAnimator(duration, *values)
    }

    fun closeAnimation(duration: Long, vararg values: Float) {
        mCurrentState = STATE_CLOSE
        setValueAnimator(duration, *values)
    }

    fun openAnimation(duration: Long) {
        mCurrentState = STATE_OPEN
        setValueAnimator(duration)
    }

    fun closeAnimation(duration: Long) {
        mCurrentState = STATE_CLOSE
        setValueAnimator(duration)
    }

    private fun setValueAnimator(duration: Long) {
        valueAnimator!!.duration = duration
        start()
    }

    private fun setValueAnimator(duration: Long, vararg values: Float) {
        valueAnimator!!.duration = duration
        valueAnimator.setFloatValues(*values)
        start()
    }

    private fun start() {
        if (valueAnimator != null && !valueAnimator.isRunning) {
            valueAnimator.start()
        }
    }

    fun cancel() {
        valueAnimator?.cancel()
    }

    companion object {

        const val STATE_CLOSE = 20000
        const val STATE_OPEN = 30000

        private var mCurrentState = STATE_CLOSE

        fun getOffset(context: Context, offset: Int): Int {
            return (context.resources.displayMetrics.density * offset + 0.5f).toInt()
        }
    }
}
