package zhan.library.slide.holder;

import android.animation.ValueAnimator;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import zhan.library.slide.helper.SlideAnimationHelper;
import zhan.library.slide.ISlide;

/**
 * Created by zhan on 2017/2/6.
 */

public abstract class SlideViewHolder extends RecyclerView.ViewHolder implements ISlide {

  private static final int DURATION_OPEN = 300;
  private static final int DURATION_CLOSE = 150;

  private static final int NORMAL_OFFSET = 50;

  private SlideAnimationHelper mSlideAnimationHelper;

  private OpenUpdateListener mOpenUpdateListener;
  private CloseUpdateListener mCloseUpdateListener;

  protected int mOffset;

  public SlideViewHolder(View itemView) {
    super(itemView);
    mOffset = SlideAnimationHelper.getOffset(itemView.getContext(), NORMAL_OFFSET);
    mSlideAnimationHelper = new SlideAnimationHelper();
  }

  public void setOffset(int offset) {
    mOffset = SlideAnimationHelper.getOffset(itemView.getContext(), offset);
  }

  public int getOffset() {
    return mOffset;
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

  @Override public void slideOpen() {
    if (mOpenUpdateListener == null) {
      mOpenUpdateListener = new OpenUpdateListener();
    }
    mSlideAnimationHelper.openAnimation(DURATION_OPEN, mOpenUpdateListener);
  }

  @Override public void slideClose() {
    if (mCloseUpdateListener == null) {
      mCloseUpdateListener = new CloseUpdateListener();
    }
    mSlideAnimationHelper.closeAnimation(DURATION_CLOSE, mCloseUpdateListener);
  }

  public abstract void doAnimationSet(int offset, float fraction);

  public abstract void onBindSlideClose(int state);

  public abstract void doAnimationSetOpen(int state);


  private class OpenUpdateListener implements ValueAnimator.AnimatorUpdateListener {

    @Override public void onAnimationUpdate(ValueAnimator animation) {
      float fraction = animation.getAnimatedFraction();
      int endX = (int) (-mOffset * fraction);

      doAnimationSet(endX, fraction);
    }
  }

  private class CloseUpdateListener implements ValueAnimator.AnimatorUpdateListener {

    @Override public void onAnimationUpdate(ValueAnimator animation) {
      float fraction = animation.getAnimatedFraction();
      fraction = 1.0f - fraction;
      int endX = (int) (-mOffset * fraction);

      doAnimationSet(endX, fraction);
    }
  }
}
