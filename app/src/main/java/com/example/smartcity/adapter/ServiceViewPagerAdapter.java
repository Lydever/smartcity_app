package com.example.smartcity.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @ProjectName: smartcity
 * @Package: com.example.smartcity.adapter
 * @ClassName: ServiceViewPagerAdapter
 * @Description:
 * @Author: liyingxia
 * @CreateDate: 2021/4/5 22:11
 */
public class ServiceViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> list;
    public ServiceViewPagerAdapter(@NonNull FragmentManager fm,List<Fragment> list) {
        super(fm);
        this.list=list;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

}
