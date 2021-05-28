package com.example.smartcity.fragment;


import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.smartcity.R;


// 新闻类别：时政，电视，旅游，视频，广播，基层

/**
 * @ProjectName: smartcity
 * @Package: com.example.smartcity.fragment
 * @ClassName: NewsFragment
 * @Description:  新闻中心模块
 * @Author: liyingxia
 * @CreateDate: 2021/3/13 23:12
 */
public class NShizhengFragment extends BaseFragment  {
    private static final String TAG = NShizhengFragment.class.getSimpleName();

    private ListView listView;



    @Override
    public View initView() {
        Log.i(TAG, "时政的视图被实例化了");
        View view = View.inflate(getActivity(), R.layout.news_shizheng, null);

        findView(view);
        return view;
    }

    private void findView(View view) {
        listView = view.findViewById(R.id.new_listView);
        TextView tv2 = view.findViewById(R.id.tv2);

    }

    @Override
    public void initData() {
        super.initData();
        Log.e(TAG, "时政的Fragment的数据被初始化了");


    }


}
