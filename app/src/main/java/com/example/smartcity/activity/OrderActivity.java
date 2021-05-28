package com.example.smartcity.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import com.example.smartcity.R;
import com.example.smartcity.bean.OrderBean;
import com.example.smartcity.utils.APIConfig;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OrderActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView order_listView;
    private OrderBean orderBean;
/*    private Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what==1) {
                String result = msg.obj.toString();
                Gson gson = new Gson();
                orderBean = gson.fromJson(result,OrderBean.class);
                OrderAdapter orderAdapter = new OrderAdapter();
                order_listView.setAdapter(orderAdapter);
                order_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Toast.makeText(getApplication(),"你点击了："+i,Toast.LENGTH_LONG).show();
                    }
                });
            }
        }
    };*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        toolbar = findViewById(R.id.toolbar);
        order_listView = findViewById(R.id.order_listView);

        getHttp();

    }

    private void getHttp() {
        int pageNum = 1;
        int pageSize = 10;
        int userId = 1;
        OkHttpClient client = new OkHttpClient();
        SharedPreferences sp = getSharedPreferences("token_data",MODE_PRIVATE);
        String token  =sp.getString("token","");
        JSONObject object = new JSONObject();
        try {
            object.put("pageNum",1);
            object.put("pageSize",10);
            object.put("userId",1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        MediaType mediaType = MediaType.parse("application/json;charset=utf-8");
        RequestBody requestBody = RequestBody.create(mediaType,object.toString());
        String url = APIConfig.BASE_URL+"/userinfo/orders/list"+"?"+pageNum+"&"+pageSize+"&"+userId;
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Authorization",token)
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
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Gson gson = new Gson();
                            orderBean = gson.fromJson(result,OrderBean.class);
                            OrderAdapter orderAdapter = new OrderAdapter();
                            order_listView.setAdapter(orderAdapter);
                            order_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                    Toast.makeText(getApplication(),"你点击了"+i,Toast.LENGTH_LONG).show();
                                }
                            });
                        }
                    });
                }
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        toolbar.setTitle("订单列表");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.top_bar_left_back);
        toolbar.setTitleMarginEnd(200);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public class OrderAdapter extends BaseAdapter {

        /**
         * 返回数目
         * @return
         */
        @Override
        public int getCount() {
            return orderBean.getData().size();
        }

        /**
         * 返回当前的item
         * @param i
         * @return
         */
        @Override
        public Object getItem(int i) {
            return orderBean.getData().get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            HolderView holderView;
            if (view==null) {
                view = View.inflate(getApplicationContext(),R.layout.order_item,null);
                holderView = new HolderView();
                holderView.tv_ordernum  = view.findViewById(R.id.tv_ordernum);
                holderView.order_date  = view.findViewById(R.id.order_date);
                holderView.order_type = view.findViewById(R.id.order_type);
                view.setTag(holderView);
            } else {
                holderView = (HolderView) view.getTag();
            }
            holderView.order_date.setText(orderBean.getData().get(i).getCreateTime());
            holderView.tv_ordernum.setText(orderBean.getData().get(i).getOrderNum());
            holderView.order_type.setText("地铁");
            return view;
        }

        class HolderView{
            TextView tv_ordernum;
            TextView order_date;
            TextView order_type;
        }
    }


}