package zhan.library.slide

import android.animation.ValueAnimator

abstract class SlideAnimatorUpdateListener : ValueAnimator.AnimatorUpdateListener {

    override fun onAnimationUpdate(animation: ValueAnimator) {

    }

    abstract fun onSlideAnimationUpdate(animation: ValueAnimator, currentStatus: Int)
}
