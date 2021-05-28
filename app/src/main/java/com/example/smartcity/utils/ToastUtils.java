package com.example.smartcity.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * @ProjectName: smartcity
 * @Package: com.example.smartcity.utils
 * @ClassName: ToastUtils
 * @Description:
 * @Author: liyingxia
 * @CreateDate: 2021/4/3 11:59
 */
public class ToastUtils {
    public void Toast (Context context,String s) {
        Toast.makeText(context,s,Toast.LENGTH_LONG).show();
    }
}
