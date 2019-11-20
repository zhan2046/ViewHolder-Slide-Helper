package zhan.library.slide.holder

import android.animation.Animator
import android.animation.ValueAnimator
import android.view.View

import androidx.recyclerview.widget.RecyclerView

import zhan.library.slide.ISlide
import zhan.library.slide.SlideAnimatorListener
import zhan.library.slide.SlideAnimatorUpdateListener
import zhan.library.slide.helper.SlideAnimationHelper


abstract class SlideViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), ISlide {

    private val mSlideAnimationHelper = SlideAnimationHelper()

    private var slideAnimatorListener: SlideAnimatorListener? = null
    private var slideAnimatorUpdateListener: SlideAnimatorUpdateListener? = null

    protected var mOffset: Int = 0
    private var openDuration = DURATION_OPEN
    private var closeDuration = DURATION_CLOSE

    var offset: Int
        get() = mOffset
        set(offset) {
            mOffset = SlideAnimationHelper.getOffset(itemView.context, offset)
        }

    val state: Int
        get() = mSlideAnimationHelper.state

    init {
        mOffset = SlideAnimationHelper.getOffset(itemView.context, NORMAL_OFFSET)
        mSlideAnimationHelper.addAnimatorListener(InAnimatorListener())
        mSlideAnimationHelper.addAnimatorUpdateListener(InUpdateListener())
    }

    fun setSlideAnimatorListener(listener: SlideAnimatorListener) {
        this.slideAnimatorListener = listener
    }

    fun setSlideAnimatorUpdateListener(listener: SlideAnimatorUpdateListener) {
        this.slideAnimatorUpdateListener = listener
    }

    fun getmSlideAnimationHelper(): SlideAnimationHelper {
        return mSlideAnimationHelper
    }

    //keep change state
    fun onBindSlide(targetView: View) {
        when (mSlideAnimationHelper.state) {
            SlideAnimationHelper.STATE_CLOSE -> {
                targetView.scrollTo(0, 0)
                onBindSlideClose(SlideAnimationHelper.STATE_CLOSE)
            }

            SlideAnimationHelper.STATE_OPEN -> {
                targetView.scrollTo(-mOffset, 0)
                doAnimationSetOpen(SlideAnimationHelper.STATE_OPEN)
            }
        }
    }

    override fun slideOpen() {
        mSlideAnimationHelper.openAnimation(openDuration.toLong())
    }

    override fun slideClose() {
        mSlideAnimationHelper.closeAnimation(closeDuration.toLong())
    }

    open fun doAnimationSet(offset: Int, fraction: Float) {
        //empty
    }

    open fun onBindSlideClose(state: Int) {
        //empty
    }

    open fun doAnimationSetOpen(state: Int) {
        //empty
    }

    fun cancel() {
        mSlideAnimationHelper.cancel()
    }

    protected fun handlerOpenAnimationUpdate(animation: ValueAnimator) {
        val fraction = animation.animatedFraction
        val endX = (-mOffset * fraction).toInt()
        doAnimationSet(endX, fraction)
    }

    protected fun handlerCloseAnimationUpdate(animation: ValueAnimator) {
        var fraction = animation.animatedFraction
        fraction = 1.0f - fraction
        val endX = (-mOffset * fraction).toInt()
        doAnimationSet(endX, fraction)
    }

    private inner class InUpdateListener : ValueAnimator.AnimatorUpdateListener {

        override fun onAnimationUpdate(animation: ValueAnimator) {
            if (mSlideAnimationHelper.isOpenStatus) {
                handlerOpenAnimationUpdate(animation)

            } else {
                handlerCloseAnimationUpdate(animation)
            }

            if (slideAnimatorUpdateListener != null) {
                slideAnimatorUpdateListener!!.onAnimationUpdate(animation)
                slideAnimatorUpdateListener!!.onSlideAnimationUpdate(animation,
                        mSlideAnimationHelper.state)
            }
        }
    }

    private inner class InAnimatorListener : Animator.AnimatorListener {

        override fun onAnimationStart(animation: Animator) {
            if (slideAnimatorListener != null) {
                slideAnimatorListener!!.onAnimationStart(animation)
                slideAnimatorListener!!.onSlideAnimationStart(animation,
                        mSlideAnimationHelper.state)
            }
        }

        override fun onAnimationEnd(animation: Animator) {
            if (slideAnimatorListener != null) {
                slideAnimatorListener!!.onAnimationEnd(animation)
                slideAnimatorListener!!.onSlideAnimationEnd(animation,
                        mSlideAnimationHelper.state)
            }
        }

        override fun onAnimationCancel(animation: Animator) {
            if (slideAnimatorListener != null) {
                slideAnimatorListener!!.onAnimationCancel(animation)
            }
        }

        override fun onAnimationRepeat(animation: Animator) {
            if (slideAnimatorListener != null) {
                slideAnimatorListener!!.onAnimationRepeat(animation)
            }
        }
    }

    companion object {

        private const val DURATION_OPEN = 300
        private const val DURATION_CLOSE = 150
        private const val NORMAL_OFFSET = 50
    }
}
