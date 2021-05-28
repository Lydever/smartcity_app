package com.example.smartcity.activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.smartcity.R;
import com.example.smartcity.fragment.HomeFragment;
import com.example.smartcity.fragment.JianDangFragment;
import com.example.smartcity.fragment.NewsFragment;
import com.example.smartcity.fragment.ServiceFragment;
import com.example.smartcity.fragment.UserFragment;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {


    private MyFragmentPagerAdapter adapter;
    //未选中的Tab图片
    private int[] unSelectTabRes = new int[]{R.mipmap.main_home,R.mipmap.main_community,R.mipmap.main_cart,R.mipmap.main_user,R.mipmap.main_type};
    //选中的Tab图片
    private int[] selectTabRes = new int[]{R.mipmap.main_home_press,R.mipmap.main_community_press, R.mipmap.main_cart_press,R.mipmap.main_user_press,R.mipmap.main_type_press};
    //Tab标题
    private   String[] title = {"首页","全部服务","发布","新闻","用户中心"};
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        //使用适配器将ViewPager与Fragment绑定在一起
        adapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        //将TabLayout与ViewPager绑定
        tabLayout.setupWithViewPager(viewPager);

        for (int i=0;i<tabLayout.getTabCount();i++){
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setCustomView(adapter.getView(i));
        }

    }


    private void initListener() {
        //TabLayout切换时导航栏图片处理
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //选中图片操作
                View view = tab.getCustomView();
                ImageView imageView = view.findViewById(R.id.imgView);
                TextView tv = view.findViewById(R.id.tv);
                String title = tv.getText().toString();
                if (title.equals("首页")){
                    imageView.setImageResource(selectTabRes[0]);
                } else if (title.equals("全部服务")) {
                    imageView.setImageResource(selectTabRes[1]);
                } else if (title.equals("发布")) {
                    imageView.setImageResource(selectTabRes[2]);
                } else if (title.equals("新闻")) {
                    imageView.setImageResource(selectTabRes[3]);
                } else if (title.equals("用户中心")) {
                    imageView.setImageResource(selectTabRes[4]);
                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {//未选中图片操作
                //未选中图片操作
                View view = tab.getCustomView();
                ImageView imageView = view.findViewById(R.id.imgView);
                TextView tv = view.findViewById(R.id.tv);
                String title = tv.getText().toString();
                if (title.equals("首页")){
                    imageView.setImageResource(unSelectTabRes[0]);
                } else if (title.equals("全部服务")) {
                    imageView.setImageResource(unSelectTabRes[1]);
                } else if (title.equals("发布")) {
                    imageView.setImageResource(unSelectTabRes[2]);
                } else if (title.equals("新闻")) {
                    imageView.setImageResource(unSelectTabRes[3]);
                } else if (title.equals("用户中心")) {
                    imageView.setImageResource(unSelectTabRes[4]);
                }
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }



    //自定义适配器
    public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return new HomeFragment();
            } else if (position == 1) {
                return new ServiceFragment();
            } else if (position == 2) {
                return new JianDangFragment();
            }else if (position == 3) {
                return new NewsFragment();
            }else if (position == 4) {
                return new UserFragment();
            }
            return new HomeFragment();//首页
        }

        @Override
        public int getCount() {
            return title.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }

        public View getView(int position) {
            View view =View.inflate(MainActivity.this,R.layout.tab_item,null);
            ImageView imageView = view.findViewById(R.id.imgView);
            TextView tv = view.findViewById(R.id.tv);
            if (tabLayout.getTabAt(position).isSelected()) {
                imageView.setImageResource(selectTabRes[position]);
            } else {
                imageView.setImageResource(unSelectTabRes[position]);
            }
            tv.setText(title[position]);
            tv.setTextColor(tabLayout.getTabTextColors());
            return view;
        }
    }


}

