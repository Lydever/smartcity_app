package com.example.smartcity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.smartcity.R;
import com.example.smartcity.bean.WeiZhangBean;
import com.example.smartcity.utils.APIConfig;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class WZRecordActivity extends AppCompatActivity {
    private WeiZhangBean weiZhangBean;
    private  WeiZhangAdapter zhangAdapter;

    private Toolbar toolbar;
    private TextView serviceName;
    private ListView listView;
    private TextView tvMore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wzrecord);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        serviceName = (TextView) findViewById(R.id.service_name);
        listView = (ListView) findViewById(R.id.listView);
        tvMore = (TextView) findViewById(R.id.tv_more);

        toolbar.setNavigationIcon(R.mipmap.top_bar_left_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        getData();
    }

     public void getData(){
                /*        pageNum 当前页
        catType 汽车类型
        engineNumber 发动机型号
        licencePlate 车牌号
        pageSize 页面大小
        参考示例 /userinfo/illegal/list?pageNum=1&pageSize=10&catType=小型汽车
                &engineNumber=1234&licencePlate=京123*/
        Bundle bundle = getIntent().getExtras();
        String type = bundle.getString("type");
        String num = bundle.getString("num");

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()   // /userinfo/illegal/list?pageNum=1&pageSize=10&catType=小型汽车&engineNumber=1234&licencePlate=京123
                .url(APIConfig.BASE_URL+"/userinfo/illegal/list?pageNum=1&pageSize=10&catType=小型汽车&engineNumber=1234&licencePlate=京123")
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("请求失败：",e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String result = response.body().string();
                    System.out.println(result);
                    Gson gson = new Gson();
                    weiZhangBean = gson.fromJson(result,WeiZhangBean.class);
                    int code = weiZhangBean.getCode();
                    Log.i("请求",String.valueOf(code));
                    if (code==200){
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                zhangAdapter = new WeiZhangAdapter();
                                listView.setAdapter(zhangAdapter);
                                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                        String money = weiZhangBean.getRows().get(i).getMoney();
                                        String date = weiZhangBean.getRows().get(i).getBadTime();
                                        String didian = weiZhangBean.getRows().get(i).getIllegalSites();
                                        String no = weiZhangBean.getRows().get(i).getNoticeNo();
                                        String type = weiZhangBean.getRows().get(i).getTrafficOffence();
                                        String mark = weiZhangBean.getRows().get(i).getDeductMarks();
                                        Intent intent = new Intent(WZRecordActivity.this,WeiZhangInfoActivity.class);
                                        Bundle bundle =  new Bundle();
                                        bundle.putString("money",money);
                                        bundle.putString("date",date);
                                        bundle.putString("didian",didian);
                                        bundle.putString("no",no);
                                        bundle.putString("type",type);
                                        bundle.putString("mark",mark);
                                        intent.putExtras(bundle);
                                        startActivity(intent);
                                    }
                                });
                            }
                        });
                    }
                }
            }
        });
    }



    /**
     * 适配器
     */
    public class WeiZhangAdapter extends BaseAdapter {
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
                convertView = View.inflate(getApplicationContext(),R.layout.weizhang_item,null);
                viewHolder = new ViewHolder();
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




}