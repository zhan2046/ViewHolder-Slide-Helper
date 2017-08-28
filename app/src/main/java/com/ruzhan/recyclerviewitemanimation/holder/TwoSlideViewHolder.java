package com.ruzhan.recyclerviewitemanimation.holder;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.ruzhan.recyclerviewitemanimation.R;

import zhan.library.slide.holder.SlideViewHolder;

/**
 * Created by zhan on 2017/2/3.
 */

public class TwoSlideViewHolder extends SlideViewHolder {

    private View itemRoot;
    private View mContentLl;
    private TextView itemRedTv;
    private TextView itemBlueTv;
    private TextView helloTv;

    private static int mCurrentColor;
    private float mFraction;

    public TwoSlideViewHolder(View itemView) {
        super(itemView);

        itemRoot = itemView.findViewById(R.id.item_root);
        mContentLl = itemView.findViewById(R.id.content_ll);
        itemRedTv = (TextView) itemView.findViewById(R.id.item_red_tv);
        itemBlueTv = (TextView) itemView.findViewById(R.id.item_blue_tv);
        helloTv = (TextView) itemView.findViewById(R.id.hello_tv);
    }

    @Override
    public void doAnimationSet(int offset, float fraction) {
        mContentLl.scrollTo(-offset, 0);

        mFraction = 1 - fraction;

        itemRedTv.setScaleX(mFraction);
        itemRedTv.setScaleY(mFraction);

        itemBlueTv.setScaleX(mFraction);
        itemBlueTv.setScaleY(mFraction);

        helloTv.setScaleX(mFraction);
        helloTv.setScaleY(mFraction);
        helloTv.setAlpha(mFraction * 255);

        float blue = 233 * mFraction;
        mCurrentColor = Color.argb(233, 233 / 2, 233, (int) blue);
        itemRoot.setBackgroundColor(mCurrentColor);
    }

    @Override
    public void onBindSlideClose(int state) {
        itemRoot.setBackgroundColor(mCurrentColor);

    }

    @Override
    public void doAnimationSetOpen(int state) {
        itemRoot.setBackgroundColor(mCurrentColor);

        helloTv.setScaleX(mFraction);
        helloTv.setScaleY(mFraction);
        helloTv.setAlpha(mFraction * 255);
    }

    public void bind() {
        setOffset(150);

        //slide must call
        onBindSlide(mContentLl);
    }
}
