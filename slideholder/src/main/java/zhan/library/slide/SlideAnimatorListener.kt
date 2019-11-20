package zhan.library.slide

import android.animation.Animator

abstract class SlideAnimatorListener : Animator.AnimatorListener {

    override fun onAnimationStart(animation: Animator) {

    }

    override fun onAnimationEnd(animation: Animator) {

    }

    override fun onAnimationCancel(animation: Animator) {

    }

    override fun onAnimationRepeat(animation: Animator) {

    }

    abstract fun onSlideAnimationStart(animation: Animator, currentStatus: Int)

    abstract fun onSlideAnimationEnd(animation: Animator, currentStatus: Int)
}
