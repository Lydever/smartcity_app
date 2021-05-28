package com.example.smartcity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.smartcity.R;
import com.example.smartcity.bean.RecommendBean;
import com.example.smartcity.utils.APIConfig;

import java.util.List;

/**
 * @ProjectName: smartcity
 * @Package: com.example.smartcity.adapter
 * @ClassName: RecommendAdapter
 * @Description:
 * @Author: liyingxia
 * @CreateDate: 2021/4/5 15:58
 */
public class RecommendAdapter extends RecyclerView.Adapter<RecommendAdapter.MyViewHolder> {
private List<RecommendBean.RowsDTO> list;
private LayoutInflater layoutInflater;
private Context context;


// 3. 声明接口
private OnItemClickListener mOnItemClickListener;

// 1. 定义接口
public interface OnItemClickListener{
    void onItemClick(int position,List<RecommendBean.RowsDTO> list);
}
// 2. 提供set方法给Activity/fragment调用
public void setOnItemClickListener(OnItemClickListener listener){
    mOnItemClickListener = listener;
}


    public RecommendAdapter(Context context,List<RecommendBean.RowsDTO> list) {
        this.list=list;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.recommend_item,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.theme_name.setText(list.get(position).getServiceName());
        holder.theme_desc.setText(list.get(position).getServiceDesc());
        Glide.with(context).load(APIConfig.BASE_URL+list.get(position).getImgUrl()).into(holder.theme_img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView theme_name;
        private TextView theme_desc;
        private ImageView theme_img;

        public MyViewHolder(@NonNull View view) {
            super(view);
            this.theme_desc = view.findViewById(R.id.theme_desc);
            this.theme_name = view.findViewById(R.id.theme_name);
            this.theme_img = view.findViewById(R.id.theme_img);
            // 4. 将监听传递给自定义接口
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mOnItemClickListener!=null) {
                        mOnItemClickListener.onItemClick(getAdapterPosition(),list);
                    }
                }
            });
        }
    }
}
