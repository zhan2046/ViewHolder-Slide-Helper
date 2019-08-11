package zhan.library.slide.holder;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import zhan.library.slide.ISlide;
import zhan.library.slide.SlideAnimatorListener;
import zhan.library.slide.SlideAnimatorUpdateListener;
import zhan.library.slide.helper.SlideAnimationHelper;


public abstract class SlideViewHolder extends RecyclerView.ViewHolder implements ISlide {

    private static final int DURATION_OPEN = 300;
    private static final int DURATION_CLOSE = 150;
    private static final int NORMAL_OFFSET = 50;

    private SlideAnimationHelper mSlideAnimationHelper = new SlideAnimationHelper();

    private SlideAnimatorListener slideAnimatorListener;
    private SlideAnimatorUpdateListener slideAnimatorUpdateListener;

    protected int mOffset;
    private int openDuration = DURATION_OPEN;
    private int closeDuration = DURATION_CLOSE;

    public SlideViewHolder(View itemView) {
        super(itemView);
        mOffset = SlideAnimationHelper.getOffset(itemView.getContext(), NORMAL_OFFSET);
        mSlideAnimationHelper.addAnimatorListener(new InAnimatorListener());
        mSlideAnimationHelper.addAnimatorUpdateListener(new InUpdateListener());
    }

    public void setSlideAnimatorListener(SlideAnimatorListener listener) {
        this.slideAnimatorListener = listener;
    }

    public void setSlideAnimatorUpdateListener(SlideAnimatorUpdateListener listener) {
        this.slideAnimatorUpdateListener = listener;
    }

    public void setOffset(int offset) {
        mOffset = SlideAnimationHelper.getOffset(itemView.getContext(), offset);
    }

    public int getOffset() {
        return mOffset;
    }

    public int getState() {
        return mSlideAnimationHelper.getState();
    }

    public SlideAnimationHelper getmSlideAnimationHelper() {
        return mSlideAnimationHelper;
    }

    public int getOpenDuration() {
        return openDuration;
    }

    public void setOpenDuration(int openDuration) {
        this.openDuration = openDuration;
    }

    public int getCloseDuration() {
        return closeDuration;
    }

    public void setCloseDuration(int closeDuration) {
        this.closeDuration = closeDuration;
    }

    //keep change state
    public void onBindSlide(View targetView) {
        switch (mSlideAnimationHelper.getState()) {
            case SlideAnimationHelper.STATE_CLOSE:
                targetView.scrollTo(0, 0);
                onBindSlideClose(SlideAnimationHelper.STATE_CLOSE);
                break;

            case SlideAnimationHelper.STATE_OPEN:
                targetView.scrollTo(-mOffset, 0);
                doAnimationSetOpen(SlideAnimationHelper.STATE_OPEN);
                break;
        }
    }

    @Override
    public void slideOpen() {
        mSlideAnimationHelper.openAnimation(openDuration);
    }

    @Override
    public void slideClose() {
        mSlideAnimationHelper.closeAnimation(closeDuration);
    }

    public void doAnimationSet(int offset, float fraction) {
        //empty
    }

    public void onBindSlideClose(int state) {
        //empty
    }

    public void doAnimationSetOpen(int state) {
        //empty
    }

    public void cancel() {
        mSlideAnimationHelper.cancel();
    }

    protected void handlerOpenAnimationUpdate(ValueAnimator animation) {
        float fraction = animation.getAnimatedFraction();
        int endX = (int) (-mOffset * fraction);
        doAnimationSet(endX, fraction);
    }

    protected void handlerCloseAnimationUpdate(ValueAnimator animation) {
        float fraction = animation.getAnimatedFraction();
        fraction = 1.0f - fraction;
        int endX = (int) (-mOffset * fraction);
        doAnimationSet(endX, fraction);
    }

    private class InUpdateListener implements ValueAnimator.AnimatorUpdateListener {

        @Override
        public void onAnimationUpdate(ValueAnimator animation) {
            if (mSlideAnimationHelper.isOpenStatus()) {
                handlerOpenAnimationUpdate(animation);

            } else {
                handlerCloseAnimationUpdate(animation);
            }

            if (slideAnimatorUpdateListener != null) {
                slideAnimatorUpdateListener.onAnimationUpdate(animation);
                slideAnimatorUpdateListener.onSlideAnimationUpdate(animation,
                        mSlideAnimationHelper.getState());
            }
        }
    }

    private class InAnimatorListener implements Animator.AnimatorListener {

        @Override
        public void onAnimationStart(Animator animation) {
            if (slideAnimatorListener != null) {
                slideAnimatorListener.onAnimationStart(animation);
                slideAnimatorListener.onSlideAnimationStart(animation,
                        mSlideAnimationHelper.getState());
            }
        }

        @Override
        public void onAnimationEnd(Animator animation) {
            if (slideAnimatorListener != null) {
                slideAnimatorListener.onAnimationEnd(animation);
                slideAnimatorListener.onSlideAnimationEnd(animation,
                        mSlideAnimationHelper.getState());
            }
        }

        @Override
        public void onAnimationCancel(Animator animation) {
            if (slideAnimatorListener != null) {
                slideAnimatorListener.onAnimationCancel(animation);
            }
        }

        @Override
        public void onAnimationRepeat(Animator animation) {
            if (slideAnimatorListener != null) {
                slideAnimatorListener.onAnimationRepeat(animation);
            }
        }
    }
}
