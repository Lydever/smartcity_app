package com.example.smartcity.fragment;

import android.util.Log;
import android.view.View;

import com.example.smartcity.R;

/**
 * @ProjectName: smartcity
 * @Package: com.example.smartcity.fragment
 * @ClassName: JActivityFragment
 * @Description:
 * @Author: liyingxia
 * @CreateDate: 2021/4/4 12:10
 */
public class JActivityFragment extends BaseFragment {
    private static final String TAG = JActivityFragment.class.getSimpleName();
    @Override
    public View initView() {
        Log.i(TAG,"建党活动");
        View view = View.inflate(getActivity(),R.layout.jd_activity,null);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
    }
}
