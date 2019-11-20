package com.ruzhan.recyclerviewitemanimation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.ruzhan.recyclerviewitemanimation.R
import com.ruzhan.recyclerviewitemanimation.holder.OneSlideViewHolder

import zhan.library.slide.ISlideHelper


class OneSlideAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mData: List<String>? = null

    private val mISlideHelper = ISlideHelper()

    fun setData(data: List<String>) {
        mData = data
        notifyDataSetChanged()
    }

    fun slideOpen() {
        mISlideHelper.slideOpen()
    }

    fun slideClose() {
        mISlideHelper.slideClose()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val oneSlideViewHolder = OneSlideViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.one_item, parent, false))

        //add holder
        mISlideHelper.add(oneSlideViewHolder)

        return oneSlideViewHolder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as OneSlideViewHolder).bind()
    }

    override fun getItemCount(): Int {
        return if (mData == null) 0 else mData!!.size
    }
}
