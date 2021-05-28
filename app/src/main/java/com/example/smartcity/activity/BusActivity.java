package com.example.smartcity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.example.smartcity.R;

public class BusActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private WebView webView;
    private String title;
    private TextView service_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        service_name = findViewById(R.id.service_name);
        webView = (WebView) findViewById(R.id.webView);
        initData();
    }



    private void initData() {
        toolbar.setNavigationIcon(R.mipmap.top_bar_left_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

            Bundle bundle = new Bundle();
            bundle = getIntent().getExtras();
            title = bundle.getString("title");
            String url = bundle.getString("url");
            service_name.setText(title);
            webView.loadUrl("/"+url);
            webView.requestFocusFromTouch();
            webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
            webView.setWebViewClient(new WebViewClient(){
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return true;
                }
            });
    }
}