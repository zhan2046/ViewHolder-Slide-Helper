package zhan.library.slide;

import java.util.ArrayList;
import java.util.List;

public class ISlideHelper {

    private List<ISlide> mISlides = new ArrayList<>();

    public void add(ISlide iSlide) {
        mISlides.add(iSlide);
    }

    public void remove(ISlide iSlide) {
        mISlides.remove(iSlide);
    }

    public void clear() {
        mISlides.clear();
    }

    public List<ISlide> getISlideList() {
        return mISlides;
    }

    public void slideOpen() {
        for (ISlide slide : mISlides) {
            slide.slideOpen();
        }
    }

    public void slideClose() {
        for (ISlide slide : mISlides) {
            slide.slideClose();
        }
    }
}
