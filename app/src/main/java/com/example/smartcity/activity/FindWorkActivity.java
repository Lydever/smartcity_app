package com.example.smartcity.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.smartcity.R;
import com.example.smartcity.fragment.SFindWorkFragment;
import com.example.smartcity.fragment.SJianLiRecordFrament;
import com.example.smartcity.fragment.SUserJianlIFragment;
import com.google.android.material.tabs.TabLayout;

public class FindWorkActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private WebView webView;
    private String title;
    private TextView service_name;
    private int[] unSele = new int[]{R.mipmap.main_home, R.mipmap.main_type, R.mipmap.main_user};
    private int[] onSele = new int[]{R.mipmap.main_home_press, R.mipmap.main_type_press, R.mipmap.main_user_press};
    private String[] name = {"找工作", "投递记录", "个人简历"};
    private ViewPager viewpager;
    private TabLayout tab_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_work);
        initView();
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        service_name = findViewById(R.id.service_name);
        webView = (WebView) findViewById(R.id.webView);
        initData();
    }

    private void initData() {
        toolbar.setNavigationIcon(R.mipmap.top_bar_left_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

/*        Bundle bundle = new Bundle();
        bundle = getIntent().getExtras();
        String url = bundle.getString("url");
        title = bundle.getString("title");
        service_name.setText(title);
        webView.loadUrl(url);
        webView.requestFocusFromTouch();
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setSupportZoom(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });*/
    }


    private void initView() {
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        tab_layout = (TabLayout) findViewById(R.id.tab_layout);
        MyFragmentAdapter adapter = new MyFragmentAdapter(getSupportFragmentManager());
        viewpager.setAdapter(adapter);
        tab_layout.setupWithViewPager(viewpager);

        for (int i=0;i<tab_layout.getTabCount();i++){
            TabLayout .Tab tab = tab_layout.getTabAt(i);
            tab.setCustomView(adapter.getView(i));
        }

    }
    public class MyFragmentAdapter extends FragmentPagerAdapter {
        public MyFragmentAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            if (position==0) {
                return new SFindWorkFragment();
            } else if (position==1) {
                return new SJianLiRecordFrament();
            } else if (position==3) {
                return new SUserJianlIFragment();
            }
            return new SFindWorkFragment();
        }

        @Override
        public int getCount() {
            return name.length;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return name[position];
        }

        public View getView(int position) {
            View view = LayoutInflater.from(FindWorkActivity.this).inflate(R.layout.tab_item,null);
            ImageView img = view.findViewById(R.id.imgView);
            TextView tv = view.findViewById(R.id.tv);
            if (tab_layout.getTabAt(position).isSelected()) {
                img.setImageResource(onSele[position]);
            } else {
                img.setImageResource(unSele[position]);
            }
            tv.setText(name[position]);
            tv.setTextColor(tab_layout.getTabTextColors());
            return view;
        }


    }



}