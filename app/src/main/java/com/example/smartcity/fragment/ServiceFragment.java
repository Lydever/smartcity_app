package com.example.smartcity.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartcity.R;
import com.example.smartcity.activity.ApponitmentActivity;
import com.example.smartcity.activity.BusActivity;
import com.example.smartcity.activity.CityStateActivity;
import com.example.smartcity.activity.LivingPayActivity;
import com.example.smartcity.activity.ParkActivity;
import com.example.smartcity.activity.WeiZhangActivity;
import com.example.smartcity.adapter.RecycleServiceAdapter;
import com.example.smartcity.bean.ServiceBean;
import com.example.smartcity.utils.APIConfig;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @ProjectName: smartcity
 * @Package: com.example.smartcity.fragment
 * @ClassName: ServiceFragment
 * @Description:
 * @Author: liyingxia
 * @CreateDate: 2021/3/22 22:48
 */
public class ServiceFragment extends BaseFragment {
    private static final String TAG = ServiceFragment.class.getSimpleName();
    private RecyclerView service_reView;
    private RecycleServiceAdapter adapter;
    private List<ServiceBean.RowsBean> rowsBeanList;
    private EditText edt_search;
    private RecyclerView serviceReView;



    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what==0) {
                ServiceBean serviceBean = (ServiceBean) msg.obj;
                rowsBeanList = serviceBean.getRows();
                adapter = new RecycleServiceAdapter(getActivity(), rowsBeanList);
                service_reView.setLayoutManager(new GridLayoutManager(getActivity(),5));
                service_reView.setAdapter(adapter);
                adapter.setItemClickListener(new RecycleServiceAdapter.MyItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        String url = APIConfig.BASE_URL+"/"+rowsBeanList.get(position).getLink();
                        Toast.makeText(getContext(), url, Toast.LENGTH_SHORT).show();
                        Intent intent = null;
                        if (position==0){
                            intent = new Intent(getActivity(), CityStateActivity.class);
                        } else if (position==1) {
                            intent = new Intent(getActivity(), BusActivity.class);
                        } else if (position==2) {
                            intent = new Intent(getActivity(), ApponitmentActivity.class);
                        } else if (position==3) {
                            intent = new Intent(getActivity(), LivingPayActivity.class);
                        } else if (position==4) {
                            intent = new Intent(getActivity(), WeiZhangActivity.class);
                        } else if (position==5) {
                            intent = new Intent(getActivity(), ParkActivity.class);
                        }
                        Bundle bundle = new Bundle();
                        bundle.putString("title",rowsBeanList.get(position).getServiceName());
                        bundle.putString("url",url);
                        intent.putExtras(bundle);
                        getActivity().startActivity(intent);
                    }
                });
            }
        }
    };

    @Override
    public View initView() {
        Log.i(TAG, "服务的视图被初始化了");
        View view = View.inflate(getContext(), R.layout.fragment_service, null);
        service_reView = view.findViewById(R.id.service_reView);
        edt_search = view. findViewById(R.id.edt_search);
        serviceReView = view.findViewById(R.id.service_reView);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        getServiceData();
        initListener();
    }

    private void initListener() {
        edt_search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i== EditorInfo.IME_ACTION_SEARCH) {
                    Intent intent = null;
                    String search = edt_search.getText().toString();
                    if (search=="城市地铁") {
                        intent = new Intent(getActivity(),CityStateActivity.class);
                    } else if (search=="智慧巴士"){
                        intent = new Intent(getActivity(),BusActivity.class);
                    } else if (search=="门诊预约"){
                        intent = new Intent(getActivity(),ApponitmentActivity.class);
                    } else if (search=="停车场"){
                        intent = new Intent(getActivity(),ParkActivity.class);
                    } else if (search=="生活缴费"){
                        intent = new Intent(getActivity(),LivingPayActivity.class);
                    } else if (search=="违章查询"){
                        intent = new Intent(getActivity(),WeiZhangActivity.class);
                    }
                    intent.putExtra("search",search);
                    startActivity(intent);
                }
                return false;
            }

        });
    }

    public void getServiceData(){
       OkHttpClient client = new OkHttpClient();
       Request request = new Request.Builder()
               .url(APIConfig.BASE_URL+"/service/service/list")
               .build();
       Call call = client.newCall(request);
       call.enqueue(new Callback() {
           @Override
           public void onFailure(Call call, IOException e) {
               Log.i("onFailure",e.getMessage());
           }

           @Override
           public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String result = response.body().string();
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Gson gson = new Gson();
                            ServiceBean serviceBean = gson.fromJson(result,ServiceBean.class);
                            Message msg = new Message();
                            msg.what  = 0;
                            msg.obj = serviceBean;
                            handler.sendMessage(msg);
                        }
                    });
                }
           }
       });
    }
}
