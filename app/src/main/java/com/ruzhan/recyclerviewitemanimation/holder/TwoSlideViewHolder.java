package com.ruzhan.recyclerviewitemanimation.holder;

import android.animation.ValueAnimator;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import com.ruzhan.recyclerviewitemanimation.R;
import com.ruzhan.recyclerviewitemanimation.helper.SlideAnimationHelper;

/**
 * Created by zhan on 2017/2/3.
 */

public class TwoSlideViewHolder extends RecyclerView.ViewHolder {

  private static final int DURATION_OPEN = 300;
  private static final int DURATION_CLOSE = 150;

  private static final int NORMAL_OFFSET = 100;

  private SlideAnimationHelper mSlideAnimationHelper;
  private OpenUpdateListener mOpenUpdateListener;
  private CloseUpdateListener mCloseUpdateListener;

  private int mOffset;
  private View mContentLl;

  public TwoSlideViewHolder(View itemView) {
    super(itemView);

    mContentLl = itemView.findViewById(R.id.content_ll);


    mOffset = SlideAnimationHelper.getOffset(itemView.getContext(), NORMAL_OFFSET);
    mSlideAnimationHelper = new SlideAnimationHelper(itemView);
  }

  public void bind() {

    //keep refresh one_item is change state
    switch (mSlideAnimationHelper.getState()) {
      case SlideAnimationHelper.STATE_CLOSE:
        mContentLl.scrollTo(0, 0);
        break;

      case SlideAnimationHelper.STATE_OPEN:
        mContentLl.scrollTo(mOffset, 0);
        break;
    }
  }

  public void openItemAnimation() {
    if (mOpenUpdateListener == null) {
      mOpenUpdateListener = new OpenUpdateListener();
    }
    mSlideAnimationHelper.openAnimation(DURATION_OPEN, mOpenUpdateListener);
  }

  public void closeItemAnimation() {
    if (mCloseUpdateListener == null) {
      mCloseUpdateListener = new CloseUpdateListener();
    }
    mSlideAnimationHelper.closeAnimation(DURATION_CLOSE, mCloseUpdateListener);
  }

  private void doAnimationSet(int x, float fraction) {
    mContentLl.scrollTo(-x, 0);
  }

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
      int endX = (int) (-mOffset * (1 - fraction));
      doAnimationSet(endX, (1 - fraction));
    }
  }
}
