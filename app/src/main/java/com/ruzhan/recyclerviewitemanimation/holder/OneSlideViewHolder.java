package com.ruzhan.recyclerviewitemanimation.holder;

import android.animation.Animator;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.ruzhan.recyclerviewitemanimation.R;

import zhan.library.slide.SlideAnimatorListener;
import zhan.library.slide.helper.SlideAnimationHelper;
import zhan.library.slide.holder.SlideViewHolder;


public class OneSlideViewHolder extends SlideViewHolder {

    private static final String TAG = OneSlideViewHolder.class.getSimpleName();

    private View mContentRl;
    private TextView itemTv;

    private View itemIconV;
    private View titleLl;
    private TextView itemTitleTv;
    private TextView itemSubtitleTv;

    public OneSlideViewHolder(View itemView) {
        super(itemView);

        mContentRl = itemView.findViewById(R.id.item_content_rl);
        itemTv = (TextView) itemView.findViewById(R.id.item_tv);
        itemIconV = itemView.findViewById(R.id.item_icon_v);
        titleLl = itemView.findViewById(R.id.title_ll);
        itemTitleTv = (TextView) itemView.findViewById(R.id.item_title_tv);
        itemSubtitleTv = (TextView) itemView.findViewById(R.id.item_subtitle_tv);

        setSlideAnimatorListener(new SlideAnimatorListener() {
            @Override
            public void onSlideAnimationStart(Animator animation, int currentStatus) {
                Log.i(TAG, "setSlideAnimatorListener: onSlideAnimationStart: "
                        + (currentStatus == SlideAnimationHelper.STATE_OPEN ? "open" : "close"));
            }

            @Override
            public void onSlideAnimationEnd(Animator animation, int currentStatus) {
                Log.i(TAG, "setSlideAnimatorListener: onSlideAnimationEnd: "
                        + (currentStatus == SlideAnimationHelper.STATE_OPEN ? "open" : "close"));
            }
        });
    }

    @Override
    public void doAnimationSet(int offset, float fraction) {
        mContentRl.scrollTo(offset, 0);

        itemTv.setScaleX(fraction);
        itemTv.setScaleY(fraction);
        itemTv.setAlpha(fraction * 255);

        titleLl.scrollTo(offset, 0);
    }

    @Override
    public void onBindSlideClose(int state) {
        titleLl.scrollTo(0, 0);
    }

    @Override
    public void doAnimationSetOpen(int state) {
        titleLl.scrollTo(-mOffset, 0);
    }

    public void bind() {
        setOffset(50);

        //slide must call
        onBindSlide(mContentRl);
    }
}
