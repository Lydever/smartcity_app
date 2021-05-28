package com.example.smartcity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.smartcity.R;
import com.example.smartcity.adapter.RecycleServiceAdapter;
import com.example.smartcity.bean.ServiceBean;

import java.util.List;

public class ServiceActivity extends AppCompatActivity {

    private RecyclerView service_reView;
    private RecycleServiceAdapter adapter;
    private List<ServiceBean.RowsBean> rowsBeanList;


/*    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what==0) {
                ServiceBean serviceBean = (ServiceBean) msg.obj;
                rowsBeanList = serviceBean.getRows();
                adapter = new RecycleServiceAdapter(ServiceActivity.this, rowsBeanList);
                service_reView.setLayoutManager(new GridLayoutManager(ServiceActivity.this,5));
                service_reView.setAdapter(adapter);
                adapter.setItemClickListener(new RecycleServiceAdapter.MyItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Toast.makeText(ServiceActivity.this, rowsBeanList.get(position).getImgUrl(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }
    };*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        service_reView = findViewById(R.id.service_reView);
       // getServiceData();
    }



/*
    public void getServiceData(){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(APIConfig.BASE_URL+"/service/service/list")
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
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Gson gson = new Gson();
                            ServiceBean serviceBean = gson.fromJson(result,ServiceBean.class);
                            Message msg = new Message();
                            msg.what  = 0;
                            msg.obj = serviceBean;
                            handler.sendMessage(msg);
                        }
                    });
                }
            }
        });
    }
*/


}