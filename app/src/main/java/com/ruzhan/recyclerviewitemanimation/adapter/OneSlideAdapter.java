package com.ruzhan.recyclerviewitemanimation.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.ruzhan.recyclerviewitemanimation.R;
import com.ruzhan.recyclerviewitemanimation.holder.OneSlideViewHolder;
import zhan.library.slide.ISlideHelper;
import java.util.List;

/**
 * Created by ruzhan on 16/6/30.
 */
public class OneSlideAdapter extends RecyclerView.Adapter {

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

    OneSlideViewHolder oneSlideViewHolder = new OneSlideViewHolder(
        LayoutInflater.from(parent.getContext()).inflate(R.layout.one_item, parent, false));

    //add holder
    mISlideHelper.add(oneSlideViewHolder);

    return oneSlideViewHolder;
  }

  @Override public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    ((OneSlideViewHolder) holder).bind();
  }

  @Override public int getItemCount() {
    return mData == null ? 0 : mData.size();
  }
}
