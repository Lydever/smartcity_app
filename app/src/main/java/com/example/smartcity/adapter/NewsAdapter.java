package com.example.smartcity.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.smartcity.R;
import com.example.smartcity.bean.NewsBean;
import com.example.smartcity.utils.APIConfig;

import java.util.List;

/**
 * @ProjectName: smartcity
 * @Package: com.example.smartcity.adapter
 * @ClassName: NewsAdapter
 * @Description:，
 * @Author: liyingxia
 * @CreateDate: 2021/3/31 9:20
 */
public class NewsAdapter extends BaseAdapter {
    private NewsBean newsBean;
    private Context context;
    private List<Fragment> fragmentList;

    public NewsAdapter(NewsBean newsBean,List<Fragment> fragmentList) {
        this.newsBean = newsBean;
        this.fragmentList = fragmentList;
    }

    @Override
    public int getCount() {
       // return newsBean!=null ? newsBean.getRows().size() : 0;
        return newsBean.getRows().size();
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
            view = View.inflate(context, R.layout.news_item,null);
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
        holder.likeNumber.setText(newsBean.getRows().get(i).getLikeNumber());
        holder.viewsNumber.setText(newsBean.getRows().get(i).getViewsNumber());
        holder.new_create.setText(newsBean.getRows().get(i).getCreateTime());
        holder.new_context.setText(newsBean.getRows().get(i).getContent());
        holder.new_title.setText(newsBean.getRows().get(i).getTitle());
        String url = APIConfig.BASE_URL+newsBean.getRows().get(i).getImgUrl();
        Glide.with(context).load(url).into(holder.new_img);
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
