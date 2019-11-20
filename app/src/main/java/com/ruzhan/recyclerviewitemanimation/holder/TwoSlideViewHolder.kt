package com.ruzhan.recyclerviewitemanimation.holder

import android.graphics.Color
import android.view.View
import kotlinx.android.synthetic.main.two_item.view.*
import zhan.library.slide.holder.SlideViewHolder

class TwoSlideViewHolder(itemView: View) : SlideViewHolder(itemView) {

    companion object {
        private var mCurrentColor = 0
        private const val DEFAULT_OFFSET = 150
    }

    private var mFraction: Float = 0.toFloat()

    override fun doAnimationSet(offset: Int, fraction: Float) {
        itemView.content_ll.scrollTo(-offset, 0)
        mFraction = 1 - fraction

        itemView.item_red_tv.scaleX = mFraction
        itemView.item_red_tv.scaleY = mFraction

        itemView.item_blue_tv.scaleX = mFraction
        itemView.item_blue_tv.scaleY = mFraction

        itemView.hello_tv.scaleX = mFraction
        itemView.hello_tv.scaleY = mFraction
        itemView.hello_tv.alpha = mFraction * 255

        val blue = 233 * mFraction
        mCurrentColor = Color.argb(233, 233 / 2, 233, blue.toInt())
        itemView.item_root.setBackgroundColor(mCurrentColor)
    }

    override fun onBindSlideClose(state: Int) {
        itemView.item_root.setBackgroundColor(mCurrentColor)
    }

    override fun doAnimationSetOpen(state: Int) {
        itemView.item_root.setBackgroundColor(mCurrentColor)

        itemView.hello_tv.scaleX = mFraction
        itemView.hello_tv.scaleY = mFraction
        itemView.hello_tv.alpha = mFraction * 255
    }

    fun bind() {
        offset = DEFAULT_OFFSET
        //slide must call
        onBindSlide(itemView.content_ll)
    }
}
