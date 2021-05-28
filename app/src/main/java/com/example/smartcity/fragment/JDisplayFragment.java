package com.example.smartcity.fragment;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.smartcity.R;

import java.util.List;

/**
 * @ProjectName: smartcity
 * @Package: com.example.smartcity.fragment
 * @ClassName: JDisplayFragment
 * @Description:
 * @Author: liyingxia
 * @CreateDate: 2021/4/4 12:14
 */
public class JDisplayFragment extends BaseFragment {
    private List<String> list;
    private ListView jd_lv;
    private static final String TAG = JDisplayFragment.class.getSimpleName();

    @Override
    public View initView() {
        Log.i(TAG,"建党展示");
        View view = View.inflate(getContext(), R.layout.jd_display, null);
        jd_lv = view.findViewById(R.id.jd_lv);
        jd_lv.setAdapter(new JDisplayAdapter(getContext()));
        jd_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(),"你点击了"+(position+1),Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }

    @Override
    public void initData() {
        super.initData();

    }

    public static class JDisplayAdapter extends BaseAdapter {
        private Context context;
        private LayoutInflater layoutInflater;

        public JDisplayAdapter(Context context) {
            this.context = context;
            layoutInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return 10;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // 实例化ViewHolder
            ViewHolder viewHolder = null;
            if (convertView==null){
                convertView = layoutInflater.inflate(R.layout.jd_display_item,null);
                // 生成一个ViewHolder对象
                viewHolder = new ViewHolder();
                // 绑定控件一3以便赋值
                viewHolder.jd_content = convertView.findViewById(R.id.jd_context);
                viewHolder.jd_date = convertView.findViewById(R.id.jd_date);
                viewHolder.jd_img = convertView.findViewById(R.id.jd_img);
                viewHolder.jd_title = convertView.findViewById(R.id.jd_title);
                // 把viewHolder传递进去
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.jd_title.setText("标题");
            viewHolder.jd_content.setText("建党展示的新闻内容，，，，，");
            viewHolder.jd_date.setText("2021-03-19 10:43:56");
            String url =  "https://pics6.baidu.com/feed/6609c93d70cf3bc75e6733e6d30f88a9cd112a68.jpeg?token=dc7266deb0b0fd98b39e60f0b0542334";
            Glide.with(context).load(url).into(viewHolder.jd_img);
            return convertView;
        }

        //写一个静态的class, 把layout_list_item的控件转移过来使用
        static class ViewHolder{
            public TextView jd_title;
            public TextView jd_content;
            public TextView jd_date;
            public ImageView jd_img;
        }
    }

}
