package com.example.smartcity.demo;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.smartcity.R;
import com.example.smartcity.bean.CityBean;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class GetAssetsActivity extends AppCompatActivity {

    private TextView msg;
    private ScrollView scroll;
    private CityBean cityBean;
    private List<CityBean> cityBeans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_assets);
        msg = (TextView) findViewById(R.id.msg);
        scroll = (ScrollView) findViewById(R.id.scroll);
        getdate();
    }

    public void getdate(){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                String re = getJson(getApplicationContext(), "province.txt");
                JsonParser parser = new JsonParser();
                JsonArray jsonArray = parser.parse(re).getAsJsonArray();
                Gson gson = new Gson();
                for (JsonElement obj:jsonArray) {
                    CityBean cityBean = gson.fromJson(obj,CityBean.class);
                    msg.append(cityBean.getProvinceName());
                }

            }
        });
    }

    // --------获取本地的json文件
    public static String getJson(Context context, String fileName) {
        // 将json数据转换为字符串
        StringBuilder s = new StringBuilder();
        // 获取assets 资源管理器
        AssetManager am = context.getAssets();
        // 使用io流读取json 文件内容
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(am.open(fileName), "utf-8"));
            String line;
            while ((line = br.readLine()) != null) {
                s.append(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s.toString();
    }

    /**
     * 解析 json数据的方式
     */
    // 1. android 自带
/*    String s = "";
    List<CityBean> list = new ArrayList<>();
    JSONArray obj  = new JSONArray(s);
    for(int i=0;i<obj.length();i++){
        JSONObject jsonObject = obj.get(i);
        CityBean cityBean1 = new CityBean();
        cityBean1.setMallCityList(jsonObject.getString("mallCityList"));
        cityBean1.setProvinceCode(jsonObject.getString("provinceCode"));
        cityBean1.setProvinceName(jsonObject.getString("proviceName"));
        cityBean1.setProvinceName(jsonObject.getJSONObject(""));
        cityBean1.setMallCityList(jsonObject.getString(""));
      //  msg.setText(cityBean1.toString());
        msg.append(cityBean1.toString());


        // 使用gson 解析
    String re = getJson(getApplicationContext(), "province.txt");
    JsonParser parser = new JsonParser();
    JsonArray jsonArray = parser.parse(re).getAsJsonArray();
    Gson gson = new Gson();
    for (JsonElement obj:jsonArray) {
        CityBean cityBean = gson.fromJson(obj,CityBean.class);
        msg.append(cityBean.getProvinceName());*/


}