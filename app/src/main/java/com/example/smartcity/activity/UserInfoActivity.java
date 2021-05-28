package com.example.smartcity.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.smartcity.R;
import com.example.smartcity.bean.ResponseBean;
import com.example.smartcity.utils.APIConfig;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class UserInfoActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton btn_back;
    private ImageView ib_img;
    private EditText et_nicke;
    private EditText et_phone;
    private EditText et_email;
    private EditText et_idetity;
    private RadioButton rb_man;
    private RadioButton rb_woman;
    private RadioGroup rg_sex;
    private Button btn_update;
    private Button btn_clear;
    private String sex = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        initView();
    }

    private void initView() {
        btn_back = (ImageButton) findViewById(R.id.btn_back);
        ib_img = (ImageView) findViewById(R.id.ib_img);
        et_nicke = (EditText) findViewById(R.id.et_nicke);
        et_phone = (EditText) findViewById(R.id.et_phone);
        et_email = (EditText) findViewById(R.id.et_email);
        et_idetity = (EditText) findViewById(R.id.et_idetity);
        rb_man = (RadioButton) findViewById(R.id.rb_man);
        rb_woman = (RadioButton) findViewById(R.id.rb_woman);
        rg_sex = (RadioGroup) findViewById(R.id.rg_sex);
        btn_update = (Button) findViewById(R.id.btn_update);
        btn_clear = (Button) findViewById(R.id.btn_clear);

        btn_back.setOnClickListener(this);
        btn_update.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
        rg_sex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (rb_man.isChecked()) {
                    sex = "1";
                } else {
                    sex = "0";
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back:
                finish();
                break;
            case R.id.btn_update:
                UpdateInfo();
                break;
            case R.id.btn_clear:
                et_nicke.setText("");
                et_phone.setText("");
                et_phone.setText("");
                et_idetity.setText("");
                et_email.setText("");
                sex = "";
                break;
        }
    }

    private void UpdateInfo() {
        String nicke = et_nicke.getText().toString().trim();
        if (TextUtils.isEmpty(nicke)) {
            Toast.makeText(this, "请输入昵称", Toast.LENGTH_SHORT).show();
            return;
        }
        String phone = et_phone.getText().toString().trim();
        if (TextUtils.isEmpty(phone)) {
            Toast.makeText(this, "请输入你的手机号码", Toast.LENGTH_SHORT).show();
            return;
        }
        String email = et_email.getText().toString().trim();
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "请输入你的邮箱地址", Toast.LENGTH_SHORT).show();
            return;
        }
        String idetity = et_idetity.getText().toString().trim();
        if (TextUtils.isEmpty(idetity)) {
            Toast.makeText(this, "4405281999121411040640", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(sex)){
            Toast.makeText(this, "请选择你的性别", Toast.LENGTH_SHORT).show();
            return;
        }
        SharedPreferences sp = this.getSharedPreferences("token_data",MODE_PRIVATE);
        String token = sp.getString("token","");
        String username = sp.getString("username","");
        OkHttpClient client = new OkHttpClient();
        JSONObject object = new JSONObject();
        try {
            object.put("userId",111);
            object.put("idCard",idetity);
            object.put("userName",username);
            object.put("nickName",nicke);
            object.put("phonenumber",phone);
            object.put("email",email);
            object.put("sex",sex);
            object.put("file","");
            object.put("remark","");
        } catch (Exception e) {
            e.printStackTrace();
        }
        MediaType mediaType = MediaType.parse("application/json;charset=utf-8");
        RequestBody requestBody = RequestBody.create(mediaType,object.toString());
        Request request = new Request.Builder()
                .url(APIConfig.BASE_URL+"/system/user/updata")
                .post(requestBody)
                .addHeader("Authorization",token)
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
                    Gson gson = new Gson();
                    String result = response.body().string();
                    ResponseBean responseBean = gson.fromJson(result,ResponseBean.class);
                    String code = responseBean.getCode();
                    if (code=="200") {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext(),"用户信息修改成功："+result,Toast.LENGTH_LONG).show();;

                            }
                        });
                    }
                }
            }
        });

    }
}