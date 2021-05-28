package com.example.smartcity.adapter;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.smartcity.bean.BannerBean;
import com.youth.banner.adapter.BannerAdapter;
import java.util.List;
import static com.bumptech.glide.request.RequestOptions.bitmapTransform;

/**
 * @ProjectName: smartcity
 * @Package: com.example.smartcity.adapter
 * @ClassName: MyBannerAdapter
 * @Description:
 * @Author: liyingxia
 * @CreateDate:  2021/3/24 12:51
 */
public class MyBannerAdapter extends BannerAdapter<BannerBean,MyBannerAdapter.BannerViewHolder> {
    public MyBannerAdapter(List<BannerBean> datas) {
        super(datas);
    }
private BannerViewHolder holder;
    @Override
    public BannerViewHolder onCreateHolder(ViewGroup viewGroup, int i) {
        ImageView imageView = new ImageView(viewGroup.getContext());
        // 必需设置match_parent
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        imageView.setLayoutParams(params);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return new BannerViewHolder(imageView);
    }

    @Override
    public void onBindView(BannerViewHolder bannerViewHolder, final BannerBean bannerData, final int i, int i1) {
        RoundedCorners roundedCorners = new RoundedCorners(10);
        String  url = "http://124.93.196.45:10002"+bannerData.getRows().get(i).getImgUrl();
        Glide.with(holder.itemView).load(url).apply(bitmapTransform(roundedCorners)).into(holder.imageView);
        holder.imageView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Log.e("11111",bannerData.getRows().get(i).getImgUrl());
            }
        });

    }

    public class BannerViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public BannerViewHolder(@NonNull ImageView view) {
            super(view);
            this.imageView = view;
        }
    }


}
