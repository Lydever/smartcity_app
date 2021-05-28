package com.example.smartcity.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.smartcity.R;

import okhttp3.OkHttpClient;

public class OkhttpActivity extends AppCompatActivity implements View.OnClickListener {
private Button bt_get;
private Button bt_post;
private TextView tv_show;
private EditText et_name;
final OkHttpClient client = new OkHttpClient();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);



        bt_get = findViewById(R.id.bt_get);
        bt_post = findViewById(R.id.bt_post);
        tv_show = findViewById(R.id.tv_show);
        bt_get.setOnClickListener(this);
        bt_post.setOnClickListener(this);
        et_name = findViewById(R.id.et_name);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_get:
              //  getRequest();
                break;
            case R.id.bt_post:
              //  postRequest();
                break;
        }
    }

/*
    //-------------post请求-----------------
    private void postRequest() {
        RequestBody formBody = new FormBody.Builder().add("name",et_name.getText().toString()).build();
        final Request request = new Request.Builder()
                .url("")
                .post(formBody)
                .build();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response response = client.newCall(request).execute();
                    if (response.isSuccessful()){
                        //tv_show.setText(response.body().toString());
                        Log.i("post",response.body().toString());
                    } else {
                        throw new IOException("请求失败："+response);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    //----------------OkHttp get请求-----------------------
    private void getRequest() {
        final Request request = new Request.Builder().get().tag(this).url("https://www.baidu.com").build();
        new Thread(new Runnable() {
            @Override
            public void run() {
                Response response = null;
                try {
                    response = client.newCall(request).execute();
                    if (response.isSuccessful()) {
                       // tv_show.setText(response.body().toString());
                        Log.i("get","get请求打印的数据："+response.body().toString());
                    } else {
                        throw new IOException("请求失败："+response);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
*/


}