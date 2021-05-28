package com.example.smartcity.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.smartcity.R;
import com.example.smartcity.adapter.NewTabAdapter;
import com.example.smartcity.fragment.NJicengFragment;
import com.example.smartcity.fragment.NShizhengFragment;
import com.example.smartcity.fragment.NTVFragment;
import com.example.smartcity.fragment.NTravelFragment;
import com.example.smartcity.fragment.NbrodcastFragment;
import com.example.smartcity.fragment.NvideoFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class TabLayoutActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private NewTabAdapter adapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        initData();
    }

    public void initData(){
        // 新闻分类标题导航栏
        String[] titles = {"时政","电视","旅游","视频","广播","基层"};
        //创建装载Fragment的列表
        List<Fragment> fragmentlist;
        // 初始化列表，并把创建的6个Fragment页面添加到列表中
        fragmentlist = new ArrayList<>();
        fragmentlist.add(new NShizhengFragment());
        fragmentlist.add(new NTVFragment());
        fragmentlist.add(new NTravelFragment());
        fragmentlist.add(new NvideoFragment());
        fragmentlist.add(new NbrodcastFragment());
        fragmentlist.add(new NJicengFragment());

        adapter = new NewTabAdapter(getSupportFragmentManager(),fragmentlist,titles);
        // ViewPager与Adapter绑定
        viewPager.setAdapter(adapter);
        // TabLayout与ViewPager绑定
        tabLayout.setupWithViewPager(viewPager);
    }



}