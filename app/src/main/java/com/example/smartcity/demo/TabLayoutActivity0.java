package com.example.smartcity.demo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.smartcity.R;
import com.example.smartcity.fragment.HomeFragment;
import com.example.smartcity.fragment.NewsFragment;
import com.example.smartcity.fragment.ServiceFragment;
import com.example.smartcity.fragment.UserFragment;
import com.example.smartcity.fragment.JianDangFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class TabLayoutActivity0 extends AppCompatActivity {

    int i;
    private ViewPager view_pager;
    private TabLayout tab_layout;
    //未选中的Tab图片
    private int[] unSelectTabRes = new int[]{R.mipmap.main_home,R.mipmap.main_community,R.mipmap.main_cart,R.mipmap.main_user,R.mipmap.main_type};
    //选中的Tab图片
    private int[] selectTabRes = new int[]{R.mipmap.main_home_press,R.mipmap.main_community_press, R.mipmap.main_cart_press,R.mipmap.main_user_press,R.mipmap.main_type_press};
    //Tab标题
    private   String[] title = {"首页","全部服务","智慧环保","新闻","用户中心"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view_pager = (ViewPager) findViewById(R.id.view_pager);
        tab_layout = (TabLayout) findViewById(R.id.tab_layout);
        // 获取初始化的适配器
        MyTabPagerAdapter myTabPagerAdapter = initTabPager();
        view_pager.setAdapter(myTabPagerAdapter);
        tab_layout.setupWithViewPager(view_pager);
        initListener();

        for (int i = 0; i < title.length; i++) {
            if (i == 0) {
                tab_layout.getTabAt(0).setIcon(selectTabRes[0]);
            } else {
                tab_layout.getTabAt(i).setIcon(unSelectTabRes[i]);
            }
        }//----for----

    }

    //TabLayout切换时导航栏图片处理
    private void initListener() {
        tab_layout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //选中图片操作
                for (int i = 0; i < title.length; i++) {
                    if (tab == tab_layout.getTabAt(i)) {
                        tab_layout.getTabAt(i).setIcon(selectTabRes[i]);
                        view_pager.setCurrentItem(i);
                    }
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //未选中图片操作
                for (int i = 0; i < title.length; i++) {
                    if (tab == tab_layout.getTabAt(i)) {
                        tab_layout.getTabAt(i).setIcon(unSelectTabRes[i]);
                    }
                }

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }



    /**
     * 初始化适配器
     */
    private MyTabPagerAdapter initTabPager() {
       // 导航菜单
        String[] title = {"首页","全部服务","智慧环保","新闻","用户中心"};
        List<Fragment> fragmentList;
        // 初始化列表，并创建五个Fragment页面添加到列表中
        fragmentList = new ArrayList<>();
        fragmentList.add(new HomeFragment());
        fragmentList.add(new ServiceFragment());
        fragmentList.add(new JianDangFragment());
        fragmentList.add(new NewsFragment());
        fragmentList.add(new UserFragment());
        // 创建Fragment适配器
        MyTabPagerAdapter myTabPagerAdapter = new MyTabPagerAdapter(getSupportFragmentManager(),fragmentList,title);
        return  myTabPagerAdapter;
    }

    // 适配器
    public class MyTabPagerAdapter extends FragmentPagerAdapter{
        private List<Fragment> list;
        private String[] title;

        /**
         * 构造方法
         * @param fm
         * @param list
         * @param title
         */
        public MyTabPagerAdapter(@NonNull FragmentManager fm,List<Fragment> list,String[] title) {
            super(fm);
            this.list = list;
            this.title = title;
        }

        /**
         * 返回当前位置的fragment
         * @param position 当前页面的位置
         */
        @NonNull
        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        // 获取list中fragment的个数
        @Override
        public int getCount() {
            return list.size();
        }

        // 返回当前的标题
        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }

        public View getView(int position) {
            View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.tab_item,null);
            ImageView imageView = view.findViewById(R.id.imgView);
            TextView tv = view.findViewById(R.id.tv);
            imageView.setImageResource(unSelectTabRes[position]);
            tv.setText(title[position]);
            tv.setTextColor(tab_layout.getTabTextColors());
            return view;
        }
    }




}