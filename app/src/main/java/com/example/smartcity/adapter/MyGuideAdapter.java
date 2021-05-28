package com.example.smartcity.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

/**
 * @ProjectName: smartcity
 * @Package: com.example.smartcity.adapter
 * @ClassName: MyGuideAdapter
 * @Description:
 * @Author: liyingxia
 * @CreateDate: 2021/4/7 0:06
 */
public class MyGuideAdapter extends PagerAdapter {
    private List<ImageView> imageViews;

    @Override
    public int getCount() {
        return imageViews.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        container.addView(imageViews.get(position));
        return imageViews.get(position);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(imageViews.get(position));
    }
}

