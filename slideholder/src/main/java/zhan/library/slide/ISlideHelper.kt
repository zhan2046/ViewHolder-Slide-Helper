package zhan.library.slide

import java.util.ArrayList

class ISlideHelper {

    private val mISlides = ArrayList<ISlide>()

    val iSlideList: List<ISlide>
        get() = mISlides

    fun add(iSlide: ISlide) {
        mISlides.add(iSlide)
    }

    fun remove(iSlide: ISlide) {
        mISlides.remove(iSlide)
    }

    fun clear() {
        mISlides.clear()
    }

    fun slideOpen() {
        for (slide in mISlides) {
            slide.slideOpen()
        }
    }

    fun slideClose() {
        for (slide in mISlides) {
            slide.slideClose()
        }
    }
}
