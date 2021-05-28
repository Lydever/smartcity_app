package com.example.smartcity.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.smartcity.R;
import com.example.smartcity.bean.LoginBean;
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

public class UpdataPSWActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton btn_back;
    private EditText userId;
    private EditText et_old_psw;
    private EditText et_new_psw;
    private Button btn_update;
    private Button btn_clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updata_psw);
        initView();
    }

    private void initView() {
        btn_back = (ImageButton) findViewById(R.id.btn_back);
        userId = (EditText) findViewById(R.id.userId);
        et_old_psw = (EditText) findViewById(R.id.et_old_psw);
        et_new_psw = (EditText) findViewById(R.id.et_new_psw);
        btn_update = (Button) findViewById(R.id.btn_update);
        btn_clear = (Button) findViewById(R.id.btn_clear);

        btn_back.setOnClickListener(this);
        btn_update.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back:
                finish();
                break;
            case R.id.btn_update:
                Update();
                break;
            case R.id.btn_clear:
                userId.setText("");
                et_old_psw.setText("");
                et_new_psw.setText("");
                break;
        }
    }

    private void Update() {
        String userIdString = userId.getText().toString().trim();
        if (TextUtils.isEmpty(userIdString)) {
            Toast.makeText(this, "请输入你的用户编号", Toast.LENGTH_SHORT).show();
            return;
        }
        String old_password = et_old_psw.getText().toString().trim();
        if (TextUtils.isEmpty(old_password)) {
            Toast.makeText(this, "请输入你的原始密码", Toast.LENGTH_SHORT).show();
            return;
        }
        String password = et_new_psw.getText().toString().trim();
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "请输入你的新密码", Toast.LENGTH_SHORT).show();
            return;
        }

        SharedPreferences sp = getSharedPreferences("token_data",MODE_PRIVATE);
        String user_psw = sp.getString("password","");
        String token = sp.getString("token","");
        OkHttpClient client = new OkHttpClient();
        JSONObject json = new JSONObject();
        try {
            json.put("userId",userIdString);
            json.put("oldPwd",old_password);
            json.put("password",password);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        MediaType mediaType = MediaType.parse("application/json;charset=utf-8");
        RequestBody requestBody  = RequestBody.create(mediaType,json.toString());
        Request request = new Request.Builder()
                .url(APIConfig.BASE_URL+"/system/user/resetPwd")
                .addHeader("Authorization",token)
                .post(requestBody)
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("请求失败",e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String result = response.body().string();
                    Gson gson = new Gson();
                    LoginBean loginBean = gson.fromJson(result,LoginBean.class);
                    String code = loginBean.getCode();
                    if (code=="200") {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(UpdataPSWActivity.this,"密码更新成功："+result,Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                }
            }
        });


    }
}