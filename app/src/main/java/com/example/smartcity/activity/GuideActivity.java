package com.example.smartcity.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.smartcity.R;

import java.util.ArrayList;
import java.util.List;

public class
GuideActivity extends AppCompatActivity {

    private int[] images = {R.mipmap.y1, R.mipmap.y2, R.mipmap.y3, R.mipmap.y4};
    private List<ImageView> imageViews;
    private ImageView[] dotViews;
    private GuideAdapter guideAdapter;
    private ViewPager guide_vp;
    private LinearLayout guide_ll;
    private Button guide_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initView();
        // 初始化图片
        initImgs();
        initDots();

        guideAdapter = new GuideAdapter();
        guide_vp.setAdapter(guideAdapter);
        // 页面滑动式,指示器在动
        guide_vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                for (int i=0;i<dotViews.length;i++){
                    if (position==i) {
                        dotViews[i].setImageResource(R.drawable.guide_red_circle);
                    } else {
                        dotViews[i].setImageResource(R.drawable.guide_gray_circle);
                    }
                    if (position==dotViews.length-1) {
                        guide_btn.setVisibility(View.VISIBLE);
                    } else {
                        guide_btn.setVisibility(View.GONE);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        guide_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = getSharedPreferences("start_app",MODE_PRIVATE).edit();
                editor.putString("isFirst","1");
                editor.commit();
                Intent intent = new Intent(GuideActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void initView() {
        guide_vp = (ViewPager) findViewById(R.id.guide_vp);
        guide_ll = (LinearLayout) findViewById(R.id.guide_ll);
        guide_btn = (Button) findViewById(R.id.guide_btn);
        guide_vp = (ViewPager) findViewById(R.id.guide_vp);
        guide_ll = (LinearLayout) findViewById(R.id.guide_ll);
        guide_btn = (Button) findViewById(R.id.guide_btn);
    }

    public void initImgs() {
        ViewPager.LayoutParams params = new ViewPager.LayoutParams();
        imageViews = new ArrayList<ImageView>();
        for (int i = 0; i < images.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(params);
            imageView.setImageResource(images[i]);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageViews.add(imageView);
        }
    }

    public void initDots() {
        LinearLayout guide_ll = findViewById(R.id.guide_ll);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(20,20);
        params.setMargins(10,0,10,0);
        dotViews = new ImageView[images.length];
        for (int i=0;i<imageViews.size();i++){
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(params);
            if (i==0) {
                imageView.setImageResource(R.drawable.guide_red_circle);
            } else {
                imageView.setImageResource(R.drawable.guide_gray_circle);
            }
            dotViews[i] = imageView;
            final int current = i;
            dotViews[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    guide_vp.setCurrentItem(current);
                }
            });
            guide_ll.addView(imageView);
        }

    }

    /**
     * 引导页适配器
     */
    public class GuideAdapter extends PagerAdapter {

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


}