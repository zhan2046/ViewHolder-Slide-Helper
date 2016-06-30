package com.pioneers.recyclerviewitemanimation.view;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.CheckBox;
import android.widget.RelativeLayout;

import com.pioneers.recyclerviewitemanimation.R;

/**
 * Created by Young Pioneers on 16/6/29.
 */
public class SlideRelativeLayout extends RelativeLayout {
    public static final String TAG = SlideRelativeLayout.class.getSimpleName();
    private CheckBox mCheckBox;
    private RelativeLayout mContentSlide;
    private int mOffset;

    public SlideRelativeLayout(Context context) {
        super(context);
    }

    public SlideRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SlideRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mCheckBox = (CheckBox) findViewById(R.id.item_checkbox);
        mContentSlide = (RelativeLayout) findViewById(R.id.item_content_rl);
        setOffset(35);
    }

    public void setOffset(int offset) {
        mOffset = (int) (getContext().getResources().getDisplayMetrics().density * offset + 0.5f);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public void openAnimation() {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(0, 1);
        valueAnimator.setDuration(300);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fraction = valueAnimator.getAnimatedFraction();
                int endX = (int) (-mOffset * fraction);
                doAnimationSet(endX, fraction);
            }
        });
        valueAnimator.start();
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public void closeAnimation() {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(0, 1);
        valueAnimator.setDuration(150);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fraction = valueAnimator.getAnimatedFraction();
                int endX = (int) (-mOffset * (1 - fraction));
                doAnimationSet(endX, (1 - fraction));
            }
        });
        valueAnimator.start();
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void doAnimationSet(int dx, float fraction) {
        mContentSlide.scrollTo(dx, 0);
        mCheckBox.setScaleX(fraction);
        mCheckBox.setScaleY(fraction);
        mCheckBox.setAlpha(fraction * 255);
    }

    public void open() {
        mContentSlide.scrollTo(-mOffset, 0);
    }

    public void close() {
        mContentSlide.scrollTo(0, 0);
    }
}
