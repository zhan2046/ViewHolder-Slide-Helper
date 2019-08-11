package zhan.library.slide;

import android.animation.Animator;

public abstract class SlideAnimatorListener implements Animator.AnimatorListener {

    @Override
    public void onAnimationStart(Animator animation) {

    }

    @Override
    public void onAnimationEnd(Animator animation) {

    }

    @Override
    public void onAnimationCancel(Animator animation) {

    }

    @Override
    public void onAnimationRepeat(Animator animation) {

    }

    public abstract void onSlideAnimationStart(Animator animation, int currentStatus);

    public abstract void onSlideAnimationEnd(Animator animation, int currentStatus);
}
