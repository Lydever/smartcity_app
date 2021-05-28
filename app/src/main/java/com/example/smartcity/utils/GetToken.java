package com.example.smartcity.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @ProjectName: smartcity
 * @Package: com.example.smartcity.utils
 * @ClassName: GetToken
 * @Description:
 * @Author: liyingxia
 * @CreateDate: 2021/4/3 14:57
 */
public class GetToken {
    public String getToken(Context context){
        SharedPreferences sp = context.getSharedPreferences("token_data",Context.MODE_PRIVATE);
        String token = sp.getString("token","");
        return token;
    }
}
