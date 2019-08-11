package com.ruzhan.recyclerviewitemanimation.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ruzhan.recyclerviewitemanimation.R;
import com.ruzhan.recyclerviewitemanimation.holder.TwoSlideViewHolder;

import java.util.List;

import zhan.library.slide.ISlideHelper;


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

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TwoSlideViewHolder twoSlideViewHolder = new TwoSlideViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.two_item, parent, false));

        //add holder
        mISlideHelper.add(twoSlideViewHolder);

        return twoSlideViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((TwoSlideViewHolder) holder).bind();
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }
}
