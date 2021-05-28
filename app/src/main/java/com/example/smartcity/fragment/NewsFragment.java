package com.example.smartcity.fragment;


import android.content.Intent;
import android.util.Log;
import android.view.View;

import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.smartcity.R;
import com.example.smartcity.activity.NewsWebViewActivity;
import com.example.smartcity.adapter.NewTabAdapter;
import com.example.smartcity.bean.BannerBean;
import com.example.smartcity.bean.NewsBean;
import com.example.smartcity.utils.APIConfig;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.listener.OnBannerListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * @ProjectName: smartcity
 * @Package: com.example.myapp.fragment
 * @ClassName: NewsFragment
 * @Description:  新闻中心模块
 * @Author: liyingxia
 * @CreateDate: 2021/3/31 10:12
 */
public class NewsFragment extends BaseFragment{
    private static final String TAG = NewsFragment.class.getSimpleName();
    private Banner banner; //banner组件
    private NewsAdapter newsAdapter;
    private ViewPager new_viewpager;
    private ListView listView;
    private NewTabAdapter newTabAdapter;
    private TabLayout tabLayout;
    private NewsBean newBean;
    private List<BannerBean.RowsDTO> bannerList;
    @Override
    public View initView() {
        Log.i(TAG, "新闻的视图被实例化了");
        View view = View.inflate(getActivity(), R.layout.fragment_news, null);

        findView(view);
        return view;
    }

    private void findView(View view) {
        tabLayout = view.findViewById(R.id.tab_layout);
        new_viewpager = view.findViewById(R.id.view_pager);
        banner = view.findViewById(R.id.banner);
        listView = (ListView) view.findViewById(R.id.new_listView);

    }


    @Override
    public void initData() {
        super.initData();
        Log.e(TAG, "新闻中心的Fragment的数据被初始化了");

        initBannerData();
        initNewsData();

    }

    private void initBannerData() {
        // Banner轮播图
        bannerList = new ArrayList<BannerBean.RowsDTO>();
        bannerList.add(new BannerBean.RowsDTO("http://124.93.196.45:10002/profile/home1.png", null));
        bannerList.add(new BannerBean.RowsDTO("http://124.93.196.45:10002/profile/home2.png", null));
        bannerList.add(new BannerBean.RowsDTO("http://124.93.196.45:10002/profile/home3.png", null));
        bannerList.add(new BannerBean.RowsDTO("http://124.93.196.45:10002/profile/home4.png", null));
        banner.setAdapter(new BannerImageAdapter<BannerBean.RowsDTO>(bannerList) {
            @Override
            public void onBindView(BannerImageHolder bannerImageHolder, BannerBean.RowsDTO rowsDTO, int i, int i1) {
                //加载图片
                Glide.with(getActivity())
                        .load(rowsDTO.getImgUrl())
                        .apply(RequestOptions.bitmapTransform(new RoundedCorners(30)))
                        .into(bannerImageHolder.imageView);
            }

        })
                .addBannerLifecycleObserver(this)
                .setIndicator(new CircleIndicator(getActivity()))
                .setOnBannerListener(new OnBannerListener() {
                    @Override
                    public void OnBannerClick(Object o, int i) {
                        // getIntent(i);
                        Toast.makeText(getActivity(),"点击了"+i,Toast.LENGTH_LONG).show();
                    }
                });

    }

    private void initNewsData() {

        // 新闻分类标题导航栏
        String[] title = {"时政","电视","旅游","视频","广播","基层"};
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

        getHttpData();
        newTabAdapter = new NewTabAdapter(getChildFragmentManager(),fragmentlist,title);
        newsAdapter = new NewsAdapter();
        // ViewPager与Adapter绑定
        new_viewpager.setAdapter(newTabAdapter);
        // TabLayout与ViewPager绑定
        tabLayout.setupWithViewPager(new_viewpager);
    }

    public void getHttpData(){
            OkHttpClient client = new OkHttpClient();
            Request request  = new Request.Builder()
                    .url(APIConfig.BASE_URL+"/press/press/list")
                    .build();
            Call call = client.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    Log.i("onFailure",e.getMessage());
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    if (response.isSuccessful()) {
                        String result = response.body().string();
                     //   Log.i("请求成功",result);
                        Gson gson = new Gson();
                        newBean =  gson.fromJson(result,NewsBean.class);
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                listView.setAdapter(newsAdapter);
                                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                        Intent intent = new Intent(getActivity(), NewsWebViewActivity.class);
                                        ImageView new_img = view.findViewById(R.id.new_img);  // 通过发送图片
                                        new_img.setDrawingCacheEnabled(Boolean.TRUE);
                                        intent.putExtra("bitmap",new_img.getDrawingCache());
                                        intent.putExtra("title",newBean.getRows().get(i).getTitle());
                                        intent.putExtra("time",newBean.getRows().get(i).getCreateTime());
                                        intent.putExtra("content",newBean.getRows().get(i).getContent());
                                        startActivity(intent);
                                    }
                                });
                            }
                        });
                    }
                }
            });
        }


/**
 * 新闻适配器
 */
public class NewsAdapter extends BaseAdapter {

    @Override
    public int getCount() {
         return newBean!=null ? newBean.getRows().size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return newBean.getRows().get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view==null) {
            view = View.inflate(getContext(), R.layout.news_item,null);
            holder = new ViewHolder();
            holder.new_title = view.findViewById(R.id.new_title);
            holder.new_context = view.findViewById(R.id.new_context);
            holder.new_create = view.findViewById(R.id.new_date);
            holder.likeNumber = view.findViewById(R.id.likeNumber);
            holder.viewsNumber = view.findViewById(R.id.viewsNumber);
            holder.new_img = view.findViewById(R.id.new_img);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.likeNumber.setText(newBean.getRows().get(i).getLikeNumber()+"");
        holder.viewsNumber.setText(newBean.getRows().get(i).getViewsNumber()+"");
        holder.new_create.setText(newBean.getRows().get(i).getCreateTime());
        holder.new_context.setText(newBean.getRows().get(i).getContent());
        holder.new_title.setText(newBean.getRows().get(i).getTitle());
        String url = APIConfig.BASE_URL+newBean.getRows().get(i).getImgUrl();
        Glide.with(getActivity()).load(url).into(holder.new_img);
        return view;
    }

    // ListView优化类
    class ViewHolder{
        TextView new_title;
        TextView new_context;
        TextView new_create;
        ImageView new_img;
        TextView viewsNumber;
        TextView likeNumber;

    }
}



}
