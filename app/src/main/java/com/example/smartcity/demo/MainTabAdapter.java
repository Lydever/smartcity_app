package com.example.smartcity.demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.smartcity.R;
import com.example.smartcity.fragment.HomeFragment;
import com.example.smartcity.fragment.JianDangFragment;
import com.example.smartcity.fragment.NewsFragment;
import com.example.smartcity.fragment.ServiceFragment;
import com.example.smartcity.fragment.UserFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.List;


/**
 * @ProjectName: MyApp4
 * @Package: com.example.myapp4.adapter
 * @ClassName: MainTabAdapter
 * @Description:  TabLayout 标题栏切换
 * @Author: liyingxia
 * @CreateDate: 2021/3/30 17:47
 */
public class MainTabAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList;
    private String[] titles;
    private Context context;
    private TabLayout tabLayout;
    public MainTabAdapter(@NonNull FragmentManager fm, List<Fragment> fragmentList, String[] titles) {
        super(fm);
        this.fragmentList = fragmentList;
        this.titles = titles;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position==0) {
            return new HomeFragment();
        } else if (position==1) {
            return new ServiceFragment();
        } else if (position==2) {
            return new JianDangFragment();
        } else if (position==3) {
            return new NewsFragment();
        } else if (position==4) {
            return new UserFragment();
        }
        return new HomeFragment();
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    public View getView(int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.tab_item,null);
        ImageView img = view.findViewById(R.id.imgView);
        TextView tv = view.findViewById(R.id.tv);
       /* if (tabLayout.getTabAt(position).isSelected()) {
            img.setImageResource(selectTabIcon[position]);
        } else {
            img.setImageResource(unSelectIcon[position]);
        }*/
        tv.setText(titles[position]);
        tv.setTextColor(tabLayout.getTabTextColors());
        return view;
    }
}
