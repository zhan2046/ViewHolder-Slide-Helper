package com.ruzhan.recyclerviewitemanimation.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.ruzhan.recyclerviewitemanimation.R;
import com.ruzhan.recyclerviewitemanimation.holder.OneSlideViewHolder;
import com.ruzhan.recyclerviewitemanimation.holder.TwoSlideViewHolder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ruzhan on 16/6/30.
 */
public class TwoSlideAdapter extends RecyclerView.Adapter {

  private List<String> mData;
  private List<TwoSlideViewHolder> mTwoSlideViewHolders = new ArrayList<>();

  public void setData(List<String> data) {
    mData = data;
    notifyDataSetChanged();
  }

  public void openItemAnimation() {
    for (TwoSlideViewHolder holder : mTwoSlideViewHolders) {
      holder.openItemAnimation();
    }
  }

  public void closeItemAnimation() {
    for (TwoSlideViewHolder holder : mTwoSlideViewHolders) {
      holder.closeItemAnimation();
    }
  }

  @Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

    TwoSlideViewHolder twoSlideViewHolder = new TwoSlideViewHolder(
        LayoutInflater.from(parent.getContext()).inflate(R.layout.two_item, parent, false));

    //add holder to list
    mTwoSlideViewHolders.add(twoSlideViewHolder);

    return twoSlideViewHolder;
  }

  @Override public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    ((TwoSlideViewHolder) holder).bind();
  }

  @Override public int getItemCount() {
    return mData == null ? 0 : mData.size();
  }
}
