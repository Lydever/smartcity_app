package com.example.smartcity.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.example.smartcity.R;

/**
 * @ProjectName: smartcity
 * @Package: com.example.smartcity.fragment
 * @ClassName: SFindWorkFragment
 * @Description:
 * @Author: liyingxia
 * @CreateDate: 2021/4/6 11:15
 */
public class SJianLiRecordFrament extends BaseFragment {
    private Toolbar toolbar;
    private TextView tv_title;


    @Override
    public View initView() {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.service_jianli_record, null);
        toolbar = view.findViewById(R.id.toolbar);
        tv_title = view.findViewById(R.id.tv_title);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
    }

    public class JianLiRecordAdapter extends BaseAdapter{

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
                convertView = View.inflate(getActivity(),R.layout.jianlirecord_item,null);
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


}
