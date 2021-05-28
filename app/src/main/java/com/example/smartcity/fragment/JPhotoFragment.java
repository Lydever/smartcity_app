package com.example.smartcity.fragment;

import android.content.Intent;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.smartcity.R;
import com.example.smartcity.activity.TakePhotoActivity;

/**
 * @ProjectName: smartcity
 * @Package: com.example.smartcity.fragment
 * @ClassName: JPhotoFragment
 * @Description:
 * @Author: liyingxia
 * @CreateDate: 2021/4/4 12:13
 */
public class JPhotoFragment extends BaseFragment {
    private Button btn_photo;
    private TextView tv;
    private ImageView img;
    private static final String TAG = JPhotoFragment.class.getSimpleName();
    @Override
    public View initView() {
        Log.i(TAG,"建党拍照");
        View view = View.inflate(getContext(), R.layout.jd_photo, null);
        btn_photo = view.findViewById(R.id.btn_photo);
        img = view.findViewById(R.id.img);
        return view;
    }

    @Override
    public void initData() {
        super.initData();

        // 解决android7调用照相机后直接闪退问题
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
            StrictMode.setVmPolicy(builder.build());
            builder.detectFileUriExposure();
        }
        initListener();
    }

    private void initListener() {
        btn_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TakePhotoActivity.class);
                startActivity(intent);
            }
        });
    }

}
