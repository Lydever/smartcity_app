package com.example.smartcity.activity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.smartcity.R;
import com.example.smartcity.utils.APIConfig;

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

public class AdviseActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton btn_back;
    private EditText content;
    private Button btn_send;

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what==1) {
                String re = msg.obj.toString();
                Toast.makeText(getApplicationContext(),"反馈成功："+re,Toast.LENGTH_LONG).show();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advise);
        initView();
    }

    private void initView() {
        btn_back = (ImageButton) findViewById(R.id.btn_back);
        content = (EditText) findViewById(R.id.content);
        btn_send = (Button) findViewById(R.id.btn_send);

        btn_back.setOnClickListener(this);
        btn_send.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back:
                finish();
                break;
            case R.id.btn_send:
                SendAdavice();
                break;
        }
    }

    private void SendAdavice() {
        String contentString = content.getText().toString().trim();
        if (TextUtils.isEmpty(contentString)) {
            Toast.makeText(this, "内容不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        SharedPreferences sp = this.getSharedPreferences("token_data",MODE_PRIVATE);
        String token = sp.getString("token","");

        OkHttpClient client = new OkHttpClient();
        JSONObject object = new JSONObject();
        try {
            object.put("content",contentString);
            object.put("userid",8888);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        MediaType mediaType = MediaType.parse("application/json;charset=utf-8");
        RequestBody requestBody = RequestBody.create(mediaType,object.toString());
        Request request = new Request.Builder()
                .post(requestBody)
                .url(APIConfig.BASE_URL+"/userinfo/feedback")
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
                    Message msg = new Message();
                    msg.what=1;
                    msg.obj=result;
                    handler.sendMessage(msg);
                }
            }
        });
    }
}