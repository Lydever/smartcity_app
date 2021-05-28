package com.example.smartcity.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.example.smartcity.R;
import com.example.smartcity.bean.CommentBean;
import com.example.smartcity.bean.ResponseBean;
import com.example.smartcity.utils.APIConfig;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Callback;
import okhttp3.RequestBody;
import okhttp3.Response;


public class NewsWebViewActivity extends AppCompatActivity{

    private Toolbar toolbar;
    private TextView info_title;
    private TextView info_time;
    private ImageView info_img;
    private TextView info_context;
    private Toolbar toolbar_webcomment;
    private EditText comment_content;
    private ListView listView_comment;
    private Button btn_comment;
    private CommentAdapter commentAdapter;
    private CommentBean commentBean;
    private WebView webView;
    private TextView tv_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_info);
        initView();
        initData();
        getNewsComment();

    }

    public static void setListViewHeightBasedOnChildren(ListView listView){
        CommentAdapter commentAdapter = (CommentAdapter ) listView.getAdapter();
        if (commentAdapter==null){
            return;
        }
        int totalHeight=0;
        // getCount() 获取返回数据项的数目
        for (int i=0;commentAdapter.getCount()>i;i++){
            View listItem = commentAdapter.getView(i,null,listView);
            // 计算子项View的宽高
            listItem.measure(0,0);
            // 统计所有子项的总高度
            totalHeight+=listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight+(listView.getDividerHeight()*(commentAdapter.getCount()-1));
        //getDividerHeight()：获取子项间分隔符占用的高度， params.height 得到整个ListView 完整显示需要的高度
        listView.setLayoutParams(params);
    }


    private void initData() {
        Intent intent = getIntent();
        if (intent!=null && intent.getParcelableExtra("bitmap") !=null) {
            String title = intent.getStringExtra("title");
            String content = intent.getStringExtra("content");
            String time = intent.getStringExtra("time");
            Bitmap bitmap = getIntent().getParcelableExtra("bitmap");
            info_img.setImageBitmap(bitmap);
            info_title.setText(title);
            info_time.setText(time);
            info_context.setText(content);

            toolbar.setNavigationIcon(R.mipmap.top_bar_left_back);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });

        }
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar_webview);
        info_title = (TextView) findViewById(R.id.info_title);
        info_time = (TextView) findViewById(R.id.info_time);
        tv_title = findViewById(R.id.tv_title);
        info_img = (ImageView) findViewById(R.id.info_img);
        info_context = (TextView) findViewById(R.id.info_context);
        toolbar_webcomment = (Toolbar) findViewById(R.id.toolbar_webcomment);
        webView = findViewById(R.id.webView);
        comment_content = findViewById(R.id.comment_content);
        listView_comment = findViewById(R.id.listView_comment);
        btn_comment = findViewById(R.id.btn_comment);
        btn_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SendComment();
            }
        });
    }

    public void getNewsComment() {
    /*pageNum 当前页
    pressId 新闻编号
    pageSize*/
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://124.93.196.45:10002/press/comments/list?pageNum=1&pageSize=30&pressId=1")
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("请求失败：",e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String result = response.body().string();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Gson gson = new Gson();
                            commentBean = gson.fromJson(result,CommentBean.class);
                            commentAdapter = new CommentAdapter();
                            listView_comment.setAdapter(commentAdapter);
                            setListViewHeightBasedOnChildren(listView_comment);
                            listView_comment.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                    Toast.makeText(getApplication(),"点击了"+i,Toast.LENGTH_LONG).show();
                                }
                            });
                        }
                    });
                }
            }
        });
    }

    public void SendComment(){
        String content1 = comment_content.getText().toString().trim();
        SharedPreferences sp = this.getSharedPreferences("token_data",MODE_PRIVATE);
        String token = sp.getString("token","");
        OkHttpClient client = new OkHttpClient();
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("userId",1);
            jsonObject.put("pressId",1);
            jsonObject.put("content",content1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        MediaType mediaType = MediaType.parse("application/json;charset=utf-8");
        RequestBody requestBody = RequestBody.create(mediaType,jsonObject.toString());
        System.out.println(jsonObject.toString());
        Request request = new Request.Builder()
                .url(APIConfig.BASE_URL+"/press/pressComment")
                .post(requestBody)
                .addHeader("Authorization",token)
                .build();
        System.out.println(APIConfig.BASE_URL+"/press/pressComment");
        Call call  = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("请求失败：",e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String result = response.body().string();
                    Gson gson = new Gson();
                    ResponseBean responseBean = gson.fromJson(result,ResponseBean.class);
                    String code = responseBean.getCode();
                    System.out.println(code);
                    if (code=="200") {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext(),"评论成功："+result,Toast.LENGTH_LONG).show();
                                listView_comment.setAdapter(commentAdapter);
                                listView_comment.deferNotifyDataSetChanged();
                            }
                        });
                    }
                }
            }
        });

    }


    /**
     * 评论列表适配器
     */
    public class CommentAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return commentBean.getRows().size();
        }
        @Override
        public Object getItem(int i) {
            return commentBean.getRows().get(i);
        }
        @Override
        public long getItemId(int i) {
            return i;
        }
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder holder;
            if (view==null) {
                view = View.inflate(getApplicationContext(),R.layout.comment_item,null);
                holder = new ViewHolder();
                holder.comment_time = view.findViewById(R.id.comment_time);
                holder.comment_nick = view.findViewById(R.id.comment_nick);
                holder.comment_content = view.findViewById(R.id.comment_content);
                holder.comment_img = view.findViewById(R.id.comment_img);
                view.setTag(holder);
            } else {
                holder = (ViewHolder) view.getTag();
            }
            holder.comment_content.setText(commentBean.getRows().get(i).getContent());
            holder.comment_nick.setText(commentBean.getRows().get(i).getNickName());
            holder.comment_time.setText(commentBean.getRows().get(i).getCreateTime());
            String url = APIConfig.BASE_URL+commentBean.getRows().get(i).getAvatar();
            Glide.with(getApplicationContext()).load(url).into(holder.comment_img);
            return view;
        }

        // ListView优化类
        class ViewHolder{
            TextView comment_time;
            TextView comment_nick;
            TextView comment_content;
            ImageView comment_img;
        }
    }



}