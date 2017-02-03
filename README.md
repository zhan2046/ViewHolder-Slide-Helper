
RecyclerView Animation
===============

A grace let recycleriew holder add animation.


-----


![](https://github.com/ruzhan123/RecyclerViewItemAnimation/raw/master/gif/item01.gif)
![](https://github.com/ruzhan123/RecyclerViewItemAnimation/raw/master/gif/item01.gif)




RecyclerView Animation use **Animation** **onAnimationUpdate** let recyclerview holder do animation, use **SlideAnimationHelper** control open animation and close animation.



Usage
-----

1. create holder add to holder list 

```java

	private List<OneSlideViewHolder> mOneSlideViewHolders = new ArrayList<>();
	
	@Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
	
	OneSlideViewHolder oneSlideViewHolder = new OneSlideViewHolder(
	    LayoutInflater.from(parent.getContext()).inflate(R.layout.one_item, parent, false));
	
	//add holder to list
	mOneSlideViewHolders.add(oneSlideViewHolder);
	
	return oneSlideViewHolder;
	}
```

2. call open or close animation

```java

	public void openItemAnimation() {
	for (OneSlideViewHolder holder : mOneSlideViewHolders) {
	  holder.openItemAnimation();
	}
	}
	
	public void closeItemAnimation() {
	for (OneSlideViewHolder holder : mOneSlideViewHolders) {
	  holder.closeItemAnimation();
	}
	}
```


3. in holder

```java

	public void openItemAnimation() {
	if (mOpenUpdateListener == null) {
	  mOpenUpdateListener = new OpenUpdateListener();
	}
	mSlideAnimationHelper.openAnimation(DURATION_OPEN, mOpenUpdateListener);
	}
	
	public void closeItemAnimation() {
	if (mCloseUpdateListener == null) {
	  mCloseUpdateListener = new CloseUpdateListener();
	}
	mSlideAnimationHelper.closeAnimation(DURATION_CLOSE, mCloseUpdateListener);
	}
	
	public void bind() {
	//keep refresh one_item is change state
	switch (mSlideAnimationHelper.getState()) {
	  case SlideAnimationHelper.STATE_CLOSE:
	    mContentRl.scrollTo(0, 0);
	    break;
	
	  case SlideAnimationHelper.STATE_OPEN:
	    mContentRl.scrollTo(-mOffset, 0);
	    break;
	}
	}
	
	private void doAnimationSet(int x, float fraction) {
	mContentRl.scrollTo(x, 0);
	mCheckBox.setScaleX(fraction);
	mCheckBox.setScaleY(fraction);
	mCheckBox.setAlpha(fraction * 255);
	}
	
	private class OpenUpdateListener implements ValueAnimator.AnimatorUpdateListener {
	
	@Override public void onAnimationUpdate(ValueAnimator animation) {
	  float fraction = animation.getAnimatedFraction();
	  int endX = (int) (-mOffset * fraction);
	  doAnimationSet(endX, fraction);
	}
	}
	
	private class CloseUpdateListener implements ValueAnimator.AnimatorUpdateListener {
	
	@Override public void onAnimationUpdate(ValueAnimator animation) {
	  float fraction = animation.getAnimatedFraction();
	  int endX = (int) (-mOffset * (1 - fraction));
	  doAnimationSet(endX, (1 - fraction));
	}
	}
```



License
-------

    Copyright 2017 ruzhan

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
