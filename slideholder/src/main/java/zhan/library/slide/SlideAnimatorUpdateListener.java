package zhan.library.slide;

import android.animation.ValueAnimator;

public abstract class SlideAnimatorUpdateListener implements ValueAnimator.AnimatorUpdateListener {

    @Override
    public void onAnimationUpdate(ValueAnimator animation) {

    }

    public abstract void onSlideAnimationUpdate(ValueAnimator animation, int currentStatus);
}
