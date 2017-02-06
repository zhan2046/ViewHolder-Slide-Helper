package com.ruzhan.recyclerviewitemanimation.holder;

import android.view.View;
import android.widget.TextView;
import com.ruzhan.recyclerviewitemanimation.R;
import zhan.library.slide.holder.SlideViewHolder;

/**
 * Created by zhan on 2017/2/3.
 */

public class OneSlideViewHolder extends SlideViewHolder {

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
  }

  @Override public void doAnimationSet(int offset, float fraction) {
    mContentRl.scrollTo(offset, 0);

    itemTv.setScaleX(fraction);
    itemTv.setScaleY(fraction);
    itemTv.setAlpha(fraction * 255);

    titleLl.scrollTo(offset, 0);
  }

  @Override public void onBindSlideClose(int state) {
    titleLl.scrollTo(0, 0);
  }

  @Override public void doAnimationSetOpen(int state) {
    titleLl.scrollTo(-mOffset, 0);
  }

  public void bind() {
    setOffset(50);

    //slide must call
    onBindSlide(mContentRl);
  }
}
