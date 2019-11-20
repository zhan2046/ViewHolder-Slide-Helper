package com.ruzhan.recyclerviewitemanimation.holder

import android.animation.Animator
import android.util.Log
import android.view.View
import android.widget.TextView

import com.ruzhan.recyclerviewitemanimation.R

import zhan.library.slide.SlideAnimatorListener
import zhan.library.slide.helper.SlideAnimationHelper
import zhan.library.slide.holder.SlideViewHolder


class OneSlideViewHolder(itemView: View) : SlideViewHolder(itemView) {

    private val mContentRl: View = itemView.findViewById(R.id.item_content_rl)
    private val itemTv: TextView = itemView.findViewById<View>(R.id.item_tv) as TextView

    private val itemIconV: View = itemView.findViewById(R.id.item_icon_v)
    private val titleLl: View = itemView.findViewById(R.id.title_ll)
    private val itemTitleTv: TextView = itemView.findViewById<View>(R.id.item_title_tv) as TextView
    private val itemSubtitleTv: TextView = itemView.findViewById<View>(R.id.item_subtitle_tv) as TextView

    init {

        setSlideAnimatorListener(object : SlideAnimatorListener() {
            override fun onSlideAnimationStart(animation: Animator, currentStatus: Int) {
                Log.i(TAG, "setSlideAnimatorListener: onSlideAnimationStart: " +
                        if (currentStatus == SlideAnimationHelper.STATE_OPEN) "open" else "close")
            }

            override fun onSlideAnimationEnd(animation: Animator, currentStatus: Int) {
                Log.i(TAG, "setSlideAnimatorListener: onSlideAnimationEnd: " +
                        if (currentStatus == SlideAnimationHelper.STATE_OPEN) "open" else "close")
            }
        })
    }

    override fun doAnimationSet(offset: Int, fraction: Float) {
        mContentRl.scrollTo(offset, 0)

        itemTv.scaleX = fraction
        itemTv.scaleY = fraction
        itemTv.alpha = fraction * 255

        titleLl.scrollTo(offset, 0)
    }

    override fun onBindSlideClose(state: Int) {
        titleLl.scrollTo(0, 0)
    }

    override fun doAnimationSetOpen(state: Int) {
        titleLl.scrollTo(-mOffset, 0)
    }

    fun bind() {
        offset = 50
        //slide must call
        onBindSlide(mContentRl)
    }

    companion object {

        private const val TAG = "OneSlideViewHolder"
    }
}
