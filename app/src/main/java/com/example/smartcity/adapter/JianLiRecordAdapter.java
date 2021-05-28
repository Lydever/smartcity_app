package com.example.smartcity.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.smartcity.R;


/**
 * @ProjectName: smartcity
 * @Package: com.example.smartcity.adapter
 * @ClassName: JianLiRecordAdapter
 * @Description:
 * @Author: liyingxia
 * @CreateDate: 2021/4/7 0:11
 */
public class JianLiRecordAdapter extends BaseAdapter {
private Context context;
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (convertView==null) {
            convertView = View.inflate(context, R.layout.jianlirecord_item,null);
            viewHolder = new ViewHolder();
            viewHolder.tvWork = (TextView) convertView.findViewById(R.id.tv_work);
            viewHolder.tvCom = (TextView) convertView.findViewById(R.id.tv_com);
            viewHolder.tvSalery = (TextView) convertView.findViewById(R.id.tv_salery);
            viewHolder.tvTime = (TextView) convertView.findViewById(R.id.tv_time);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //  viewHolder.tvCom.setText();


        return convertView;
    }

    class ViewHolder{
        TextView tvWork;
        TextView tvCom;
        TextView tvSalery;
        TextView tvTime;
    }
}

