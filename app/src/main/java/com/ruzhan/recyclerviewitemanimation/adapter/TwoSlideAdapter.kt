package com.ruzhan.recyclerviewitemanimation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.ruzhan.recyclerviewitemanimation.R
import com.ruzhan.recyclerviewitemanimation.holder.TwoSlideViewHolder

import zhan.library.slide.ISlideHelper


class TwoSlideAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val MAX_INDEX = 77
    }

    private var dataList = ArrayList<String>()
    private val iSlideHelper = ISlideHelper()

    init {
        for (x in 0..MAX_INDEX) {
            dataList.add(x.toString())
        }
    }

    fun slideOpen() {
        iSlideHelper.slideOpen()
    }

    fun slideClose() {
        iSlideHelper.slideClose()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val twoSlideViewHolder = TwoSlideViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.two_item, parent, false))
        //add holder
        iSlideHelper.add(twoSlideViewHolder)
        return twoSlideViewHolder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as TwoSlideViewHolder).bind()
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}
