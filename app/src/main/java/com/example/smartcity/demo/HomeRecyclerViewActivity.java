package com.example.smartcity.demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.smartcity.R;
import com.example.smartcity.bean.BannerBean;
import com.example.smartcity.bean.NewsBean;
import com.example.smartcity.bean.RecommendBean;
import com.example.smartcity.bean.ServiceBean;

import java.util.ArrayList;
import java.util.List;

public class HomeRecyclerViewActivity extends AppCompatActivity {
private RecyclerView home_recyclerview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_recycler_view);
        home_recyclerview = findViewById(R.id.home_recyclerview);
    }





public class HomeRecycleViewAdapter extends RecyclerView.Adapter{
        private static final int Banner = 0;
        private static final int Service = 1;
        private static final int Theme = 2;
        private static final int News = 3;

        public int currentType = Banner;

        private final Context context;
        private List list = new ArrayList<>();
        private List<BannerBean.RowsDTO> bannerList;
        private List<NewsBean.RowsBean> newsList;
        private List<RecommendBean.RowsDTO> reList;
        private List<ServiceBean.RowsBean> serviceList;
        private  LayoutInflater layoutInflater;

    public HomeRecycleViewAdapter(Context context, List list) {
        this.context = context;
        this.list = list;
        layoutInflater = LayoutInflater.from(context);
    }






    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType==Banner) {
          //  return new BannerViewHolder(context,layoutInflater.inflate(R.layout.banner,null));
        } else if (viewType==Service){
          //  return new ServiceViewHolder(context,layoutInflater.inflate(R.layout.service_item,null));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class BannerViewHolder extends RecyclerView.ViewHolder{
        private Context context;
        private com.youth.banner.Banner banner;

        public BannerViewHolder(@NonNull View itemView) {
            super(itemView);
            this.context = context;
            banner = itemView.findViewById(R.id.banner);
        }
    }

    class ServiceViewHolder extends RecyclerView.ViewHolder{
        private Context context;
        private GridView gridView;
        public ServiceViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }


}







}