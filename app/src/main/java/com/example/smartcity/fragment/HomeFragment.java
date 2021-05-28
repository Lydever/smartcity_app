package com.example.smartcity.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.smartcity.R;
import com.example.smartcity.activity.ApponitmentActivity;
import com.example.smartcity.activity.BannerWebView;
import com.example.smartcity.activity.BusActivity;
import com.example.smartcity.activity.CityStateActivity;
import com.example.smartcity.activity.LivingPayActivity;
import com.example.smartcity.activity.NewsActivity;
import com.example.smartcity.activity.NewsWebViewActivity;
import com.example.smartcity.activity.ParkActivity;
import com.example.smartcity.activity.RecommendWebView;
import com.example.smartcity.activity.ServiceActivity;
import com.example.smartcity.activity.WeiZhangActivity;
import com.example.smartcity.adapter.NewTabAdapter;
import com.example.smartcity.adapter.RecommendAdapter;
import com.example.smartcity.adapter.RecycleServiceAdapter;
import com.example.smartcity.bean.BannerBean;
import com.example.smartcity.bean.NewsBean;
import com.example.smartcity.bean.RecommendBean;
import com.example.smartcity.bean.ServiceBean;
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
 * @Package: com.example.smartcity.fragment
 * @ClassName: HomeFrament
 * @Description:
 * @Author: liyingxia
 * @CreateDate: 2021/3/22 22:47
 */
public class HomeFragment extends BaseFragment {
    private static final String TAG = HomeFragment.class.getSimpleName();
    private TextView tv_more,tv_theme,tv_theme_title;
    private EditText ed_search;
    private Banner banner;
    private RecyclerView home_recyclerview,home_recyclerview1;
    private RecycleServiceAdapter recycleServiceAdapter;
    private List<ServiceBean.RowsBean> rowsBeanList;
    private List<RecommendBean.RowsDTO> recommendList;
    private RecommendAdapter recommendAdapter;
    private NewsBean newsBean;
    private NewsAdapter newsAdapter;
    private NewTabAdapter newTabAdapter;
    private TabLayout tab_layout;
    private ListView home_listview;
    private ViewPager view_pager;
    private OkHttpClient client = new OkHttpClient();

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what==0) {
                ServiceBean serviceBean = (ServiceBean) msg.obj;
                rowsBeanList = serviceBean.getRows();
                recycleServiceAdapter= new RecycleServiceAdapter(getActivity(),rowsBeanList);
                home_recyclerview.setLayoutManager(new GridLayoutManager(getActivity(),5));
                home_recyclerview.setAdapter(recycleServiceAdapter);
                recycleServiceAdapter.setItemClickListener(new RecycleServiceAdapter.MyItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        String url = APIConfig.BASE_URL+"/"+rowsBeanList.get(position).getLink();
                        Intent intent = null;
                        if (position==0){
                            intent = new Intent(getActivity(), CityStateActivity.class);
                        } else if (position==1) {
                            intent = new Intent(getActivity(), BusActivity.class);
                        } else if (position==2) {
                            intent = new Intent(getActivity(), ApponitmentActivity.class);
                        } else if (position==3) {
                            intent = new Intent(getActivity(), LivingPayActivity.class);
                        } else if (position==4) {
                            intent = new Intent(getActivity(), WeiZhangActivity.class);
                        } else if (position==5) {
                            intent = new Intent(getActivity(), ParkActivity.class);
                        }
                        Bundle bundle = new Bundle();
                        bundle.putString("title",rowsBeanList.get(position).getServiceName());
                        bundle.putString("url",url);
                        intent.putExtras(bundle);
                        getActivity().startActivity(intent);
                    }
                });
            }
            if (msg.what==1) {
                RecommendBean recommendBean = (RecommendBean) msg.obj;
                recommendList = recommendBean.getRows();
                recommendAdapter = new RecommendAdapter(getActivity(),recommendList);
                home_recyclerview1.setLayoutManager(new GridLayoutManager(getActivity(),2));
                home_recyclerview1.setAdapter(recommendAdapter);
                recommendAdapter.setOnItemClickListener(new RecommendAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(int position, List<RecommendBean.RowsDTO> list) {
                        String url = APIConfig.BASE_URL+"/"+list.get(position).getLink();
                        Toast.makeText(getContext(),"url详情："+url,Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getActivity(), RecommendWebView.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("title",list.get(position).getServiceName());
                        bundle.putString("url",url);
                        intent.putExtras(bundle);
                        getActivity().startActivity(intent);
                    }
                });
            }
        }
    };

    @Override
    public View initView() {
        Log.i(TAG, "首页的视图被初始化了");
        View view = View.inflate(getContext(), R.layout.fragment_home, null);
        ed_search = view.findViewById(R.id.ed_search);
        banner = view.findViewById(R.id.banner);
        home_recyclerview = view.findViewById(R.id.home_recyclerview);
        home_recyclerview1 = view.findViewById(R.id.home_recyclerview1);
        home_listview = view.findViewById(R.id.home_listview);
        tab_layout = view.findViewById(R.id.tab_layout);
        view_pager = view.findViewById(R.id.view_pager);
        tv_more = view.findViewById(R.id.tv_more);
        tv_theme = view.findViewById(R.id.tv_theme);
        tv_theme_title = view.findViewById(R.id.tv_theme_title);

        return view;
    }

    /**
     * 解决ScrollView 导致ListView 只显示一项问题
     * @param listView
     */
    public static void setListViewHeightBasedOnChildren(ListView listView){
        NewsAdapter newsAdapter = (NewsAdapter) listView.getAdapter();
        if (newsAdapter==null){
            return;
        }
        int totalHeight=0;
        // newsAdapter.getCount() 获取返回数据项的数目
        for (int i=0;newsAdapter.getCount()>i;i++){
            View listItem = newsAdapter.getView(i,null,listView);
            // 计算子项View的宽高
            listItem.measure(0,0);
            // 统计所有子项的总高度
            totalHeight+=listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight+(listView.getDividerHeight()*(newsAdapter.getCount()-1));
        //getDividerHeight()：获取子项间分隔符占用的高度， params.height 得到整个ListView 完整显示需要的高度
        listView.setLayoutParams(params);
    }

    @Override
    public void initData() {
        super.initData();
        initSearch();
        initBanner();
        getServiceData();
        getRecommendData();
        initNews();
    }

    // 顶部搜索框
    public void initSearch(){
        ed_search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i== EditorInfo.IME_ACTION_SEARCH){
                    String search = ed_search.getText().toString();
                    Intent intent = new Intent(getActivity(), NewsActivity.class);
                    intent.putExtra("search",search);
                    startActivity(intent);
                    /*HomeFragment fragment = new HomeFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("search",search);
                    fragment.setArguments(bundle);
                    return fragment;*/
                }
                return false;
            }
        });
        tv_more.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), NewsActivity.class);
                startActivity(intent);
            }
        });
        tv_theme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ServiceActivity.class);
                startActivity(intent);
            }
        });
    }

    // Banner轮播图
    public void initBanner(){
        //网络加载图片
        List<BannerBean.RowsDTO> list = new ArrayList<>();
        list.add(new BannerBean.RowsDTO("http://124.93.196.45:10002/profile/home1.png", null));
        list.add(new BannerBean.RowsDTO("http://124.93.196.45:10002/profile/home2.png", null));
        list.add(new BannerBean.RowsDTO("http://124.93.196.45:10002/profile/home3.png", null));
        list.add(new BannerBean.RowsDTO("http://124.93.196.45:10002/profile/home4.png", null));
        banner.setAdapter(new BannerImageAdapter<BannerBean.RowsDTO>(list) {
            @Override
            public void onBindView(BannerImageHolder holder, BannerBean.RowsDTO data, int position, int size) {
                //BannerImageHolder 图片加载自己实现
                Glide.with(getActivity())
                        .load(data.getImgUrl())
                        .apply(RequestOptions.bitmapTransform(new RoundedCorners(30)))
                        .into(holder.imageView);
            }
        }).addBannerLifecycleObserver(this)//添加生命周期观察者
                .setIndicator(new CircleIndicator(getActivity()))
                .setOnBannerListener(new OnBannerListener() {
                    @Override
                    public void OnBannerClick(Object o, int position) {
                        //  getIntent(position);
                        Intent intent = new Intent(getActivity(), BannerWebView.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("url",list.get(position).getImgUrl());
                        intent.putExtras(bundle);
                        getActivity().startActivity(intent);
                    }
                });
    }

    // 请求全部服务
    private void getServiceData() {
        Request request = new Request.Builder()
                .url(APIConfig.BASE_URL+"/service/service/list")
                .build();
        try {
            Call call = client.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    Log.i("onFailure",e.getMessage());
                }
                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    if (response.isSuccessful()) {
                        final String result = response.body().string();
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Gson gson = new Gson();
                                ServiceBean serviceBean = gson.fromJson(result,ServiceBean.class);
                                Message msg = new Message();
                                msg.what=0;
                                msg.obj=serviceBean;
                                handler.sendMessage(msg);
                            }
                        });
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 主题推荐
    public void getRecommendData(){
        Request request = new Request.Builder()
                .url(APIConfig.BASE_URL+"/service/service/list?pageNum=1&pageSize=10")
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
                    final String recommend = response.body().string();
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Gson gson = new Gson();
                            RecommendBean recommendBean = gson.fromJson(recommend,RecommendBean.class);
                            Message msg = new Message();
                            msg.what=1;
                            msg.obj=recommendBean;
                            handler.sendMessage(msg);
                        }
                    });
                }
            }
        });
    }

    // 新闻数据
    public void initNews(){
        String[] title = {"时政","电视","旅游","视频","广播","基层"};
        List<Fragment> fragmentlist;
        fragmentlist = new ArrayList<>();
        fragmentlist.add(new NShizhengFragment());
        fragmentlist.add(new NTVFragment());
        fragmentlist.add(new NTravelFragment());
        fragmentlist.add(new NvideoFragment());
        fragmentlist.add(new NbrodcastFragment());
        fragmentlist.add(new NJicengFragment());
        getNewsData();
        newTabAdapter = new NewTabAdapter(getChildFragmentManager(),fragmentlist,title);
        newsAdapter = new NewsAdapter();
        view_pager.setAdapter(newTabAdapter);
        tab_layout.setupWithViewPager(view_pager);
    }

    // 新闻请求
    public void getNewsData(){
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
                    Log.i("请求成功",result);
                    Gson gson = new Gson();
                    newsBean =  gson.fromJson(result, NewsBean.class);
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            home_listview.setAdapter(newsAdapter);
                            setListViewHeightBasedOnChildren(home_listview);
                            home_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                    Intent intent = new Intent(getActivity(), NewsWebViewActivity.class);
                                    ImageView new_img = view.findViewById(R.id.new_img);
                                    new_img.setDrawingCacheEnabled(Boolean.TRUE);
                                    intent.putExtra("bitmap",new_img.getDrawingCache());
                                    intent.putExtra("title",newsBean.getRows().get(i).getTitle());
                                    intent.putExtra("time",newsBean.getRows().get(i).getCreateTime());
                                    intent.putExtra("content",newsBean.getRows().get(i).getContent());
                                   /* Bundle bundle = new Bundle();
                                    bundle.putString("img",newsBean.getRows().get(i).getImgUrl());
                                    bundle.putString("title",newsBean.getRows().get(i).getTitle());
                                    bundle.putString("content",newsBean.getRows().get(i).getContent());
                                    bundle.putString("time",newsBean.getRows().get(i).getContent());
                                    intent.putExtras(bundle);*/
                                    getActivity().startActivity(intent);
                                }
                            });

                        }
                    });
                }
            }
        });
    }

    // 新闻适配器
    public class NewsAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return newsBean!=null ? newsBean.getRows().size() : 0;
        }
        @Override
        public Object getItem(int i) {
            return newsBean.getRows().get(i);
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
            holder.likeNumber.setText(newsBean.getRows().get(i).getLikeNumber()+"");
            holder.viewsNumber.setText(newsBean.getRows().get(i).getViewsNumber()+"");
            holder.new_create.setText(newsBean.getRows().get(i).getCreateTime());
            holder.new_context.setText(newsBean.getRows().get(i).getContent());
            holder.new_title.setText(newsBean.getRows().get(i).getTitle());
            String url = APIConfig.BASE_URL+newsBean.getRows().get(i).getImgUrl();
            Glide.with(getActivity()).load(url).into(holder.new_img);
            return view;
        }
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
