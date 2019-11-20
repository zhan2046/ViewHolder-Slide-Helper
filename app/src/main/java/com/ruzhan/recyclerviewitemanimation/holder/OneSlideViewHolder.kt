package com.ruzhan.recyclerviewitemanimation.holder

import android.animation.Animator
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.one_item.view.*
import zhan.library.slide.SlideAnimatorListener
import zhan.library.slide.helper.SlideAnimationHelper
import zhan.library.slide.holder.SlideViewHolder


class OneSlideViewHolder(itemView: View) : SlideViewHolder(itemView) {

    companion object {
        private const val TAG = "OneSlideViewHolder"
        private const val DEFAULT_OFFSET = 50
    }

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
        itemView.item_content_rl.scrollTo(offset, 0)

        itemView.item_tv.scaleX = fraction
        itemView.item_tv.scaleY = fraction
        itemView.item_tv.alpha = fraction * 255
        itemView.title_ll.scrollTo(offset, 0)
    }

    override fun onBindSlideClose(state: Int) {
        itemView.title_ll.scrollTo(0, 0)
    }

    override fun doAnimationSetOpen(state: Int) {
        itemView.title_ll.scrollTo(-mOffset, 0)
    }

    fun bind() {
        offset = DEFAULT_OFFSET
        //slide must call
        onBindSlide(itemView.item_content_rl)
    }
}
