package com.example.smartcity.fragment;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.smartcity.R;


// 新闻类别：时政，电视，旅游，视频，广播，基层

/**
 * @ProjectName: smartcity
 * @Package: com.example.smartcity.fragment
 * @ClassName: NewsFragment
 * @Description:  新闻中心模块
 * @Author: liyingxia
 * @CreateDate: 2021/3/13 23:23
 */
public class NJicengFragment extends BaseFragment{
    private static final String TAG = NJicengFragment.class.getSimpleName();

    @Override
    public View initView() {
        Log.i(TAG, "基层的视图被实例化了");
        View view = View.inflate(getContext(), R.layout.news_jiceng, null);

        findView(view);

        return view;
    }

    private void findView(View view) {
        TextView tv2 = view.findViewById(R.id.tv2);

    }


    @Override
    public void initData() {
        super.initData();
        Log.e(TAG, "基层的Fragment的数据被初始化了");

    }



}
