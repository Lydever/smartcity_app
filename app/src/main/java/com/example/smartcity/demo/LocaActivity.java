package com.example.smartcity.demo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import com.example.smartcity.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LocaActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int TAKE_PHOTO = 1;
    private Uri imgUrl;
    private Button btn_photo;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loca);
        initView();
    }


    private void initView() {
        btn_photo = (Button) findViewById(R.id.btn_photo);
        img = (ImageView) findViewById(R.id.img);

        btn_photo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_photo:
                token_photo();
                break;
        }
    }

    private void token_photo() {
        File outImg = new File(getExternalCacheDir(),"outimg.jpg");
        try {
            if (outImg.exists()) {
                outImg.delete();
            }
            outImg.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (Build.VERSION.SDK_INT>=24) {
            imgUrl = FileProvider.getUriForFile(LocaActivity.this,"com.example.myapp4.demo",outImg);
        } else {
            imgUrl = Uri.fromFile(outImg);
        }
        // 启动相机
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra(MediaStore.EXTRA_OUTPUT,imgUrl);
        startActivityForResult(intent,TAKE_PHOTO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case TAKE_PHOTO:
                if (resultCode == RESULT_OK) {
                    try {
                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imgUrl));
                        img.setImageBitmap(bitmap);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
    }
}