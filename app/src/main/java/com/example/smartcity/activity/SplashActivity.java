package com.example.smartcity.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.smartcity.R;

public class SplashActivity extends AppCompatActivity {
    private ImageView main_iv;
    private TextView main_tv;
    private LinearLayout main_ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        main_iv = (ImageView) findViewById(R.id.main_iv);
        main_tv = (TextView) findViewById(R.id.main_tv);
        main_ll = (LinearLayout) findViewById(R.id.main_ll);
        // 设置渐变效果
        setAnimation();
    }

    private void setAnimation() {
        AlphaAnimation animation = new AlphaAnimation(0.3f,1.0f);
        animation.setDuration(3000);
        main_ll.setAnimation(animation);
        // 设置动画监听
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                intentActivity();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    /**
     * 根据首次启动是否跳转到对应的界面
     */
    private void intentActivity() {
        SharedPreferences sp = getSharedPreferences("start_app",MODE_PRIVATE);
        String First = sp.getString("isFirst","0");
        Intent intent = new Intent();
        if ("0".equals(First)) {
            intent.setClass(this,GuideActivity.class);
        } else {
            intent.setClass(this,LoginActivity.class);
        }
        startActivity(intent);
        finish();
    }


}