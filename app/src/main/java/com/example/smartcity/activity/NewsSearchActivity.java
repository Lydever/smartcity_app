package com.example.smartcity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smartcity.R;
import com.example.smartcity.adapter.NewsAdapter;
import com.example.smartcity.bean.NewsBean;
import com.example.smartcity.utils.APIConfig;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NewsSearchActivity extends AppCompatActivity {

    private TextView tv_new;
    private ListView listView;
    private List<NewsBean.RowsBean> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_search);
        tv_new = findViewById(R.id.tv_new);
        listView = findViewById(R.id.listview_search);
        Intent intent = getIntent();
        final String serach_txt = intent.getStringExtra("search");
        System.out.println(serach_txt);

        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json;charset=utf-8");

        Request request = new Request.Builder()
                .url(APIConfig.BASE_URL+"/press/press/list")
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("","请求失败："+e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                int position = 0;
                String result = response.body().string();
                if (response.isSuccessful()) {
                    Gson gson = new Gson();
                    NewsBean list = (NewsBean) gson.fromJson(result,NewsBean.class).getRows();
                    int code = list.getCode();
                    if (code==200){
                        String title = list.getRows().get(position).getPressCategory();
                        if (title == serach_txt) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    NewsAdapter newsAdapter = new NewsAdapter(list, (List<Fragment>) getApplicationContext());
                                    listView.setAdapter(newsAdapter);
                                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                        @Override
                                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                            Toast.makeText(getApplicationContext(),"点击："+position,Toast.LENGTH_LONG).show();
                                        }
                                    });
                                }
                            });
                        }
                    }
                }
            }
        });



    }

}