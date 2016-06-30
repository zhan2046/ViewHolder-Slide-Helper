<!--lang: java-->
####效果如图：

![](https://github.com/ruzhan123/RecyclerViewItemAnimation/raw/master/gif/item_animation.gif)

</br>

我的博客：[详解](https://ruzhan123.github.io/2016/07/01/2016-07-01-01-%E5%AF%B9RecyclerViewItem%E5%81%9A%E5%8A%A8%E7%94%BB/)



RecyclerView Item Animation --- 为Item添加动态位移，静态位移，缩放等动画，保证了动画状态的平滑衔接。

---

RecyclerView，ListView这些具有Item复用性的View，想要对其Item做动画，需要注意以下几点：



1，如果要一点击，让所有Item做动画的效果。例如，上图的编辑和取消，这样的动态动画。

可以对所有ViewHolder中的View直接做动画。但是需要在onBindViewHolder方法中对复用的item做静态动画，保证动画状态的平滑衔接。



2，处理每一个Item的特有属性，例如，上图checkbox的选中状态，都需要把状态字段放到对应的Java bean中，
并在onBindViewHolder方法从java bean取出状态值，设置到view里。

</br>

部分参考代码：

```java

	//对所有ViewHolder中的View直接做动画
    public static final int NORMAL = 1000;
    public static final int SLIDE = 2000;
    private int mState = NORMAL;
	private List<SlideViewHolder> mSlideViewHolders = new ArrayList<>();

	public void openItemAnimation() {
       mState = SLIDE;
       for (SlideViewHolder holder : mSlideViewHolders) {
           holder.openItemAnimation();
       }
    }

    public void closeItemAnimation() {
        mState = NORMAL;
        for (SlideViewHolder holder : mSlideViewHolders) {
            holder.closeItemAnimation();
        }
    }



	//需要在onBindViewHolder方法中对复用的item做静态动画，保证动画状态的平滑衔接
    public void bind(ItemBean itemBean) {
   	    mItemBean = itemBean;

       //在onBindViewHolder方法从java bean取出状态值，设置到view里
        mCheckBox.setChecked(itemBean.isChecked());

        switch (mState) {
          case NORMAL:
             mSlideRelativeLayout.close();
             break;

          case SLIDE:
             mSlideRelativeLayout.open();
             break;
    }
     }


```




