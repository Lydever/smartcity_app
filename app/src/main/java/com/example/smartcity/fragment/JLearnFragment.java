package com.example.smartcity.fragment;

import android.util.Log;
import android.view.View;

import com.example.smartcity.R;

/**
 * @ProjectName: smartcity
 * @Package: com.example.smartcity.fragment
 * @ClassName: JLearnFragment
 * @Description:
 * @Author: liyingxia
 * @CreateDate: 2021/4/4 12:13
 */
public class JLearnFragment extends BaseFragment {
    private static final String TAG = JLearnFragment.class.getSimpleName();
    @Override
    public View initView() {
        Log.i(TAG,"建党学习");
        View view = View.inflate(getActivity(), R.layout.jd_learn,null);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
    }
}
