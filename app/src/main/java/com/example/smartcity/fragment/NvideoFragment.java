package com.example.smartcity.fragment;

import android.util.Log;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.viewpager.widget.ViewPager;

import com.example.smartcity.R;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

// 新闻类别：时政，电视，旅游，视频，广播，基层

/**
 * @ProjectName: smartcity
 * @Package: com.example.smartcity.fragment
 * @ClassName: NewsFragment
 * @Description:  新闻中心模块
 * @Author: liyingxia
 * @CreateDate: 2021/3/10 16:12
 */
public class NvideoFragment extends BaseFragment {
    private static final String TAG = NvideoFragment.class.getSimpleName();
    private Banner banner; //banner组件
    private ArrayList imgList;  //图片资源
    private ArrayList titleList; //轮播标题
    private List<View> mListview = new ArrayList<>();
    private ViewPager new_viewpager;
    // private List<NewsBean.RowsBean> list;
    private ListView listView;
    private ListAdapter newsAdapter;

    @Override
    public View initView() {
        Log.i(TAG, "视频的视图被实例化了");
        View view = View.inflate(getContext(), R.layout.news_video, null);

        findView(view);

        return view;
    }

    private void findView(View view) {

        banner = view.findViewById(R.id.banner);
        listView = (ListView) view.findViewById(R.id.new_listView);
        TextView tv2 = view.findViewById(R.id.tv2);
    }


    @Override
    public void initData() {
        super.initData();
        Log.e(TAG, "视频的Fragment的数据被初始化了");




    }








}
