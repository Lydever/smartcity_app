package com.example.smartcity.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.appcompat.widget.Toolbar;

import com.example.smartcity.R;
import com.example.smartcity.activity.AdviseActivity;
import com.example.smartcity.activity.LoginActivity;
import com.example.smartcity.activity.OrderActivity;
import com.example.smartcity.activity.UpdataPSWActivity;
import com.example.smartcity.activity.UserInfoActivity;

/**
 * @ProjectName: smartcity
 * @Package: com.example.smartcity.fragment
 * @ClassName: UserFragment
 * @Description:
 * @Author: liyingxia
 * @CreateDate: 2021/05/06 22:50
 */
public class UserFragment extends BaseFragment implements View.OnClickListener {
    private static final String TAG = UserFragment.class.getSimpleName();

    private TextView tv_usercenter;
    private TextView tv_username;
    private ImageButton user_img;
    private Button btn_out;
    private Intent intent = null;
    private LinearLayout ll_info;
    private LinearLayout ll_order;
    private LinearLayout ll_update;
    private LinearLayout ll_advice;
    private Toolbar toolbar;



    @Override
    public View initView() {
        Log.i(TAG, "用户中心的视图被实例化了");
        View view = View.inflate(getContext(), R.layout.fragment_user, null);
        ll_advice = view.findViewById(R.id.ll_advice);
        ll_info = view.findViewById(R.id.ll_info);
        ll_order = view.findViewById(R.id.ll_order);
        ll_update = view.findViewById(R.id.ll_update);
        btn_out = view.findViewById(R.id.btn_out);
        tv_username = view.findViewById(R.id.tv_username);
        user_img = view.findViewById(R.id.user_img);
        ll_update.setOnClickListener(this);
        ll_info.setOnClickListener(this);
        ll_order.setOnClickListener(this);
        ll_advice.setOnClickListener(this);
        btn_out.setOnClickListener(this);
        user_img.setOnClickListener(this);
        return view;
    }
/*    @Override
    public void onStart() {
        super.onStart();
        toolbar.setTitle("个人中心");
        //setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.top_bar_left_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // finish();

            }
        });
    }*/

    @Override
    public void initData() {
        super.initData();
        // 读取本地保存用户的登录信息
        SharedPreferences sp = getActivity().getSharedPreferences("token_data", Context.MODE_PRIVATE);
        String user = sp.getString("username","");
        // 把用户名显示到textView控件上
        tv_username.setText(user);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_info:
                intent = new Intent(getContext(), UserInfoActivity.class);
                break;
            case R.id.ll_order:
                intent = new Intent(getContext(), OrderActivity.class);
                break;
            case R.id.ll_update:
                intent = new Intent(getContext(), UpdataPSWActivity.class);
                break;
            case R.id.ll_advice:
                intent = new Intent(getContext(), AdviseActivity.class);
                break;
            case R.id.btn_out:
                SharedPreferences.Editor editor = getActivity().getSharedPreferences("token_data", Context.MODE_PRIVATE).edit();
                editor.clear(); // 清除本地保存的token值
                editor.apply();
                intent = new Intent(getContext(), LoginActivity.class);
                break;
            case R.id.user_img:

                break;
        }
        // 页面跳转
        startActivity(intent);

    }
}
