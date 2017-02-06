
ViewHolder-Slide-Helper
===============

A grace recycleriew holder animation library for Android, expend recyclerview holder


-----


![](https://github.com/ruzhan123/RecyclerViewItemAnimation/raw/master/gif/slide01.gif) 
![](https://github.com/ruzhan123/RecyclerViewItemAnimation/raw/master/gif/slide02.gif)




ViewHolder-Slide-Helper use **Animation** and **Scroller** let holder layout slide, expend recyclerview holder

[![](https://jitpack.io/v/ruzhan123/ViewHolder-Slide-Helper.svg)](https://jitpack.io/#ruzhan123/ViewHolder-Slide-Helper)

Gradle
------

Add it in your root build.gradle at the end of repositories:


```java

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

Add the dependency:


```java

	dependencies {
	        compile 'com.github.ruzhan123:ViewHolder-Slide-Helper:v1.0'
	}
```

Usage
-----

1, recyclerview adapter create ISlideHelper instance

```java

	public class SlideAdapter extends RecyclerView.Adapter {
	
	private ISlideHelper mISlideHelper = new ISlideHelper();
```

2, in onCreateViewHolder, use ISlideHelper add new create holder

```java

	@Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
	
	OneSlideViewHolder oneSlideViewHolder = new OneSlideViewHolder(
	    LayoutInflater.from(parent.getContext()).inflate(R.layout.one_item, parent, false));
	
	//add holder
	mISlideHelper.add(oneSlideViewHolder);
	
	return oneSlideViewHolder;
	}
```


3, recyclerview holder need extends SlideViewHolder, in dapter onBindViewHolder call holder onBindSlide method

```java

	@Override public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
	((SlideViewHolder) holder).bind();
	}

	public class OneSlideViewHolder extends SlideViewHolder {
	
	public void bind() {
	//slide offset
	setOffset(50);
	
	//slide must call,param is slide view
	onBindSlide(mContentRl);
	}
	}
```

4, expend recyclerview holder, you can add animation set

```java

	@Override public void doAnimationSet(int offset, float fraction) {
	mContentRl.scrollTo(offset, 0);
	
	itemTv.setScaleX(fraction);
	itemTv.setScaleY(fraction);
	itemTv.setAlpha(fraction * 255);
	
	titleLl.scrollTo(offset, 0);
	}
	
	//static bind anmation state
	@Override public void onBindSlideClose(int state) {
	titleLl.scrollTo(0, 0);
	}
	
	//static bind anmation state
	@Override public void doAnimationSetOpen(int state) {
	titleLl.scrollTo(-mOffset, 0);
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
