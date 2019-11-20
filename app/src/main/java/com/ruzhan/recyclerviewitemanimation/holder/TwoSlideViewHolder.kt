package com.ruzhan.recyclerviewitemanimation.holder

import android.graphics.Color
import android.view.View
import android.widget.TextView

import com.ruzhan.recyclerviewitemanimation.R

import zhan.library.slide.holder.SlideViewHolder

class TwoSlideViewHolder(itemView: View) : SlideViewHolder(itemView) {

    private val itemRoot: View
    private val mContentLl: View
    private val itemRedTv: TextView
    private val itemBlueTv: TextView
    private val helloTv: TextView
    private var mFraction: Float = 0.toFloat()

    init {

        itemRoot = itemView.findViewById(R.id.item_root)
        mContentLl = itemView.findViewById(R.id.content_ll)
        itemRedTv = itemView.findViewById<View>(R.id.item_red_tv) as TextView
        itemBlueTv = itemView.findViewById<View>(R.id.item_blue_tv) as TextView
        helloTv = itemView.findViewById<View>(R.id.hello_tv) as TextView
    }

    override fun doAnimationSet(offset: Int, fraction: Float) {
        mContentLl.scrollTo(-offset, 0)

        mFraction = 1 - fraction

        itemRedTv.scaleX = mFraction
        itemRedTv.scaleY = mFraction

        itemBlueTv.scaleX = mFraction
        itemBlueTv.scaleY = mFraction

        helloTv.scaleX = mFraction
        helloTv.scaleY = mFraction
        helloTv.alpha = mFraction * 255

        val blue = 233 * mFraction
        mCurrentColor = Color.argb(233, 233 / 2, 233, blue.toInt())
        itemRoot.setBackgroundColor(mCurrentColor)
    }

    override fun onBindSlideClose(state: Int) {
        itemRoot.setBackgroundColor(mCurrentColor)

    }

    override fun doAnimationSetOpen(state: Int) {
        itemRoot.setBackgroundColor(mCurrentColor)

        helloTv.scaleX = mFraction
        helloTv.scaleY = mFraction
        helloTv.alpha = mFraction * 255
    }

    fun bind() {
        offset = 150

        //slide must call
        onBindSlide(mContentLl)
    }

    companion object {

        private var mCurrentColor: Int = 0
    }
}
