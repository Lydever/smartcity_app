package com.example.smartcity.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.smartcity.R;
import com.example.smartcity.bean.WeiZhangBean;

/**
 * @ProjectName: smartcity
 * @Package: com.example.smartcity.adapter
 * @ClassName: MyWZAdapter
 * @Description:
 * @Author: liyingxia
 * @CreateDate: 2021/4/7 0:08
 */
public class MyWZAdapter extends BaseAdapter{
    private Context context;
    private WeiZhangBean weiZhangBean;
        @Override
        public int getCount() {
            return weiZhangBean.getRows().size();
        }

        @Override
        public Object getItem(int i) {
            return weiZhangBean.getRows().get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup viewGroup) {
           ViewHolder viewHolder = null;
            if (convertView==null) {
                convertView = View.inflate(context, R.layout.weizhang_item,null);
                viewHolder =new  ViewHolder();
                viewHolder.wzDate = (TextView) convertView.findViewById(R.id.wz_date);
                viewHolder.wzMoney = (TextView) convertView.findViewById(R.id.wz_money);
                viewHolder.wzTrafficOffence = (TextView) convertView.findViewById(R.id.wz_trafficOffence);
                viewHolder.wzIllegalSites = (TextView) convertView.findViewById(R.id.wz_illegalSites);
                viewHolder.wzDeductMarks = (TextView) convertView.findViewById(R.id.wz_deductMarks);
                viewHolder.wzDisposeState = (TextView) convertView.findViewById(R.id.wz_disposeState);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.wzDate.setText(weiZhangBean.getRows().get(i).getBadTime());
            viewHolder.wzMoney.setText(weiZhangBean.getRows().get(i).getMoney());
            viewHolder.wzTrafficOffence.setText(weiZhangBean.getRows().get(i).getTrafficOffence());
            viewHolder.wzDeductMarks.setText(weiZhangBean.getRows().get(i).getDeductMarks());
            viewHolder.wzDisposeState.setText(weiZhangBean.getRows().get(i).getDisposeState());
            return convertView;
        }

        class ViewHolder{
            TextView wzDate;
            TextView wzMoney;
            TextView wzTrafficOffence;
            TextView wzIllegalSites;
            TextView wzDeductMarks;
            TextView wzDisposeState;
        }
    }



