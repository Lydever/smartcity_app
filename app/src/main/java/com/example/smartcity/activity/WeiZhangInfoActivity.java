package com.example.smartcity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.smartcity.R;

public class WeiZhangInfoActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView tv;
    private TextView wzDate;
    private TextView wzMoney;
    private TextView wzTrafficOffence;
    private TextView wzIllegalSites;
    private TextView wzDeductMarks;
    private TextView wzDisposeState;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weizhang_info);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tv = (TextView) findViewById(R.id.tv);
        wzDate = (TextView) findViewById(R.id.wz_date);
        wzMoney = (TextView) findViewById(R.id.wz_money);
        wzTrafficOffence = (TextView) findViewById(R.id.wz_trafficOffence);
        wzIllegalSites = (TextView) findViewById(R.id.wz_illegalSites);
        wzDeductMarks = (TextView) findViewById(R.id.wz_deductMarks);
        wzDisposeState = (TextView) findViewById(R.id.wz_disposeState);


        Bundle bundle  =new Bundle();
        bundle = getIntent().getExtras();
        String money = bundle.getString("money");
        String date = bundle.getString("date");
        String didian = bundle.getString("didian");
        String no = bundle.getString("no");
        String type = bundle.getString("type");
        String mark = bundle.getString("mark");
        wzDate.setText(date);
        wzDeductMarks.setText(mark);
        wzDisposeState.setText(type);
        wzIllegalSites.setText(didian);
        wzMoney.setText(money);
        wzTrafficOffence.setText(no);

        toolbar.setNavigationIcon(R.mipmap.top_bar_left_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}