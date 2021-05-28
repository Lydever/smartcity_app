package com.example.smartcity.adapter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.viewpager.widget.ViewPager;

/**
 * @ProjectName: smartcity
 * @Package: com.example.smartcity.adapter
 * @ClassName: NoScrollViewPager
 * @Description: 禁止ViewPager 滑动跳转效果
 * @Author: liyingxia
 * @CreateDate: 2021/3/23 13:16
 */
public class NoScrollViewPager extends ViewPager {
    public boolean canScroll = false;

    public NoScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NoScrollViewPager(Context context) {
        super(context);
    }


    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return canScroll && super.onTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return canScroll && super.onInterceptTouchEvent(ev);
    }

    @Override
    public void setCurrentItem(int item) {
        setCurrentItem(item, false);
    }


}
