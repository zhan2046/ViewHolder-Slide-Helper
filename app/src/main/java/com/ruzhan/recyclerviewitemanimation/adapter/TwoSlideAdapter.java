package com.ruzhan.recyclerviewitemanimation.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.ruzhan.recyclerviewitemanimation.R;
import com.ruzhan.recyclerviewitemanimation.holder.TwoSlideViewHolder;
import zhan.library.slide.ISlideHelper;
import java.util.List;

/**
 * Created by ruzhan on 16/6/30.
 */
public class TwoSlideAdapter extends RecyclerView.Adapter {

  private List<String> mData;

  private ISlideHelper mISlideHelper = new ISlideHelper();

  public void setData(List<String> data) {
    mData = data;
    notifyDataSetChanged();
  }

  public void slideOpen() {
    mISlideHelper.slideOpen();
  }

  public void slideClose() {
    mISlideHelper.slideClose();
  }

  @Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

    TwoSlideViewHolder twoSlideViewHolder = new TwoSlideViewHolder(
        LayoutInflater.from(parent.getContext()).inflate(R.layout.two_item, parent, false));

    //add holder
    mISlideHelper.add(twoSlideViewHolder);

    return twoSlideViewHolder;
  }

  @Override public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    ((TwoSlideViewHolder) holder).bind();
  }

  @Override public int getItemCount() {
    return mData == null ? 0 : mData.size();
  }
}
