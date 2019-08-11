package zhan.library.slide.helper;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;

public class SlideAnimationHelper {

    public static final int STATE_CLOSE = 20000;
    public static final int STATE_OPEN = 30000;

    private static int mCurrentState = STATE_CLOSE;

    private ValueAnimator mValueAnimator;

    public SlideAnimationHelper() {
        mValueAnimator = new ValueAnimator();
        mValueAnimator.setFloatValues(0.0f, 1.0f);
    }

    public ValueAnimator getValueAnimator() {
        return mValueAnimator;
    }

    public void addAnimatorUpdateListener(AnimatorUpdateListener animatorUpdateListener) {
        mValueAnimator.addUpdateListener(animatorUpdateListener);
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        mValueAnimator.addListener(animatorListener);
    }

    public int getState() {
        return mCurrentState;
    }

    public boolean isOpenStatus() {
        return mCurrentState == STATE_OPEN;
    }

    public boolean isCloseStatus() {
        return mCurrentState == STATE_CLOSE;
    }

    public void openAnimation(long duration, float... values) {
        mCurrentState = STATE_OPEN;
        setValueAnimator(duration, values);
    }

    public void closeAnimation(long duration, float... values) {
        mCurrentState = STATE_CLOSE;
        setValueAnimator(duration, values);
    }

    public void openAnimation(long duration) {
        mCurrentState = STATE_OPEN;
        setValueAnimator(duration);
    }

    public void closeAnimation(long duration) {
        mCurrentState = STATE_CLOSE;
        setValueAnimator(duration);
    }

    private void setValueAnimator(long duration) {
        mValueAnimator.setDuration(duration);
        start();
    }

    private void setValueAnimator(long duration, float... values) {
        mValueAnimator.setDuration(duration);
        mValueAnimator.setFloatValues(values);
        start();
    }

    private void start() {
        if (mValueAnimator != null && !mValueAnimator.isRunning()) {
            mValueAnimator.start();
        }
    }

    public void cancel() {
        if (mValueAnimator != null) {
            mValueAnimator.cancel();
        }
    }

    public static int getOffset(Context context, int offset) {
        return (int) (context.getResources().getDisplayMetrics().density * offset + 0.5f);
    }
}
