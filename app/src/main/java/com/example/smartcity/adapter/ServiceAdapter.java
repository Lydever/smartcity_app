package com.example.smartcity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.smartcity.R;
import com.example.smartcity.bean.ServiceBean;

import java.net.URL;
import java.util.List;

/**
 * @ProjectName: smartcity
 * @Package: com.example.smartcity.adapter
 * @ClassName: ServiceAdapter
 * @Description:
 * @Author: liyingxia
 * @CreateDate: 2021/3/24 14:10
 */
public class ServiceAdapter extends BaseAdapter {
    private Context context;
    private List<ServiceBean.RowsBean> serviceBean;
    private LayoutInflater layoutInflater;

    public ServiceAdapter(Context context,  List<ServiceBean.RowsBean> serviceBean) {
        this.context = context;
        this.serviceBean = serviceBean;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return serviceBean.size()>0 ? serviceBean.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return serviceBean.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
         ViewHolder holder = null;
        if (view==null) {
            view = View.inflate(context, R.layout.service_item,null);
            holder = new ViewHolder();
            holder.service_img = view.findViewById(R.id.service_img);
            holder.service_name = view.findViewById(R.id.service_name);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.service_name.setText(serviceBean.get(i).getServiceName());
        URL url = null;
        try {
            url = new URL("http://124.93.196.45:1002"+serviceBean.get(i).getImgUrl());
            Glide.with(context).load(url).into(holder.service_img);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return view;
    }

    class ViewHolder {
        TextView service_name;
        ImageView service_img;
    }
}
