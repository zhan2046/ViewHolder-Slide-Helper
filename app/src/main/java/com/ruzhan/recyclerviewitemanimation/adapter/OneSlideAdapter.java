package com.ruzhan.recyclerviewitemanimation.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ruzhan.recyclerviewitemanimation.R;
import com.ruzhan.recyclerviewitemanimation.holder.OneSlideViewHolder;

import java.util.List;

import zhan.library.slide.ISlideHelper;


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

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        OneSlideViewHolder oneSlideViewHolder = new OneSlideViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.one_item, parent, false));

        //add holder
        mISlideHelper.add(oneSlideViewHolder);

        return oneSlideViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((OneSlideViewHolder) holder).bind();
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }
}
