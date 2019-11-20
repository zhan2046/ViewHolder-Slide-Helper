
ViewHolder-Slide-Helper
===============

A grace recycleriew holder animation library for Android


Screenshots
-----
<a href="gif/slide01.gif"><img src="gif/slide01.gif" width="40%"/></a>
<a href="gif/slide02.gif"><img src="gif/slide02.gif" width="40%"/></a>


ViewHolder-Slide-Helper use **Animation** and **Scroller**, expend recyclerview holder

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
	        compile 'com.github.ruzhan123:ViewHolder-Slide-Helper:v1.3'
	}
```

Usage
-----

1, recyclerview adapter create ISlideHelper

```java

public class SlideAdapter extends RecyclerView.Adapter {
private ISlideHelper mISlideHelper = new ISlideHelper();
```

2, use ISlideHelper add holder

```java

@Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

OneSlideViewHolder oneSlideViewHolder = new OneSlideViewHolder(
	LayoutInflater.from(parent.getContext()).inflate(R.layout.one_item, parent, false));
//add holder
mISlideHelper.add(oneSlideViewHolder);
return oneSlideViewHolder;
}
```

Developed by
-------

 ruzhan - <a href='javascript:'>dev19921116@gmail.com</a>


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
