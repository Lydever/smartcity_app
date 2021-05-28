package com.example.smartcity.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.smartcity.R;

public class WeiZhangActivity extends AppCompatActivity implements View.OnClickListener {
    private Toolbar toolbar;
    private WebView webView;
    private TextView service_name;
    private String title;
    private EditText edt_type;
    private Button btn_query;
    private EditText edt_unm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weizhang);
        initView();
        service_name = findViewById(R.id.service_name);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        webView = (WebView) findViewById(R.id.webView);
        toolbar.setNavigationIcon(R.mipmap.top_bar_left_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        // getSend();
    }

    private void getSend() {
        Bundle bundle = new Bundle();
        bundle = getIntent().getExtras();
        String url = bundle.getString("url");
        title = bundle.getString("title");
        service_name.setText(title);
        webView.loadUrl("/" + url);
        webView.requestFocusFromTouch();
        webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        WebSettings webSettings = webView.getSettings();
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setSupportZoom(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setUseWideViewPort(true);
    }


    private void initView() {
        edt_type = (EditText) findViewById(R.id.edt_type);
        btn_query = (Button) findViewById(R.id.btn_query);

        btn_query.setOnClickListener(this);
        edt_unm = (EditText) findViewById(R.id.edt_unm);
        edt_unm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_query:
                getQuery();
                break;
        }
    }

    private void getQuery() {
        String type = edt_type.getText().toString().trim();
        if (TextUtils.isEmpty(type)) {
            Toast.makeText(this, "输入号牌种类", Toast.LENGTH_SHORT).show();
            return;
        }
        String unm = edt_unm.getText().toString().trim();
        if (TextUtils.isEmpty(unm)) {
            Toast.makeText(this, "输入车牌号码", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(WeiZhangActivity.this,WZRecordActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("type",type);
        bundle.putString("unm",unm);
        intent.putExtras(bundle);
        startActivity(intent);





    }








}