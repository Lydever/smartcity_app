package com.example.smartcity.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @ProjectName: MyApp
 * @Package: com.example.myapp.adapter
 * @ClassName: NewTabAdapter
 * @Description:
 * @Author: liyingxia
 * @CreateDate: 2021/04/23 10:11
 */
public class NewTabAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList;
    private String[] titles;

    public NewTabAdapter(@NonNull FragmentManager fm,List<Fragment> fragmentList,String[] titles) {
        super(fm);
        this.fragmentList = fragmentList;
        this.titles = titles;
    }


    /**
     * 返回当前的fragment
     * @param position: 当前页面的位置
     * @return
     */
    @NonNull
    @Override
    public Fragment getItem(int position) {
        /*if (position == 0) {
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
        return new HomeFragment();//首页*/
        return fragmentList.get(position);
    }

    /**
     * fragment中的个数
     */
    @Override
    public int getCount() {
        return fragmentList.size();
    }

    /**
     * 返回当前的标题
     */
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
