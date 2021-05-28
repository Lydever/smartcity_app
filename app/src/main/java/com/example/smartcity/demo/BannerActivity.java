package com.example.smartcity.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.smartcity.R;
import com.example.smartcity.bean.BannerBean;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.listener.OnBannerListener;
import java.util.ArrayList;
import java.util.List;

public class BannerActivity extends AppCompatActivity {
private Banner banner;
private Toolbar tool;
private List<BannerBean> bannerData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);
        banner = findViewById(R.id.banner);
 /*       tool = findViewById(R.id.tool);
        tool.setTitle("首页");
        setSupportActionBar(tool);
        tool.setNavigationIcon(R.mipmap.main_cart);
        tool.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });*/
/*        banner.setAdapter(new MyBannerAdapter(bannerData))
                .addBannerLifecycleObserver(this)
                .setIndicator(new CircleIndicator(getApplication()))
                .setOnBannerListener(new OnBannerListener() {
                    @Override
                    public void OnBannerClick(Object o, int i) {
                        //
                    }
                });*/
        //网络加载图片
        List<DataBean> list = new ArrayList<>();
        list.add(new DataBean("https://img.zcool.cn/community/013de756fb63036ac7257948747896.jpg", null));
        list.add(new DataBean("https://img.zcool.cn/community/01639a56fb62ff6ac725794891960d.jpg", null));
        list.add(new DataBean("https://img.zcool.cn/community/01270156fb62fd6ac72579485aa893.jpg", null));
        list.add(new DataBean("https://img.zcool.cn/community/01233056fb62fe32f875a9447400e1.jpg", null));
        list.add(new DataBean("https://img.zcool.cn/community/016a2256fb63006ac7257948f83349.jpg", null));

        banner.setAdapter(new BannerImageAdapter<DataBean>(list) {
            @Override
            public void onBindView(BannerImageHolder holder, DataBean data, int position, int size) {
                //图片加载自己实现
                Glide.with(getApplicationContext())
                        .load(data.imageUrl)
                        .apply(RequestOptions.bitmapTransform(new RoundedCorners(30)))
                        .into(holder.imageView);
            }
        })
                .addBannerLifecycleObserver(this)//添加生命周期观察者
                .setIndicator(new CircleIndicator(this))
                .setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(Object o, int position) {
              //  getIntent(position);
}
        });
    }
    // 构造方法
    public static class DataBean {
        public String imageUrl;
        public String title;
        public DataBean(String imageUrl, String title) {
            this.imageUrl = imageUrl;
            this.title = title;
        }
    }




    /**
     * 自定义布局，图片
     */
  /*  public class ImageAdapter extends BannerAdapter<DataBean, ImageAdapter.ImageHolder> {
        public ImageAdapter(List<DataBean> mDatas) {
            //设置数据，也可以调用banner提供的方法,或者自己在adapter中实现
            super(mDatas);
        }
*//*        //更新数据
        public void updateData(List<DataBean> data) {
            //这里的代码自己发挥，比如如下的写法等等
            mDatas.clear();
            mDatas.addAll(data);
            notifyDataSetChanged();
        }*/
    /*
        //创建ViewHolder
        @Override
        public ImageHolder onCreateHolder(ViewGroup parent, int viewType) {
            ImageView imageView = new ImageView(parent.getContext());
            //注意，必须设置为match_parent，这个是viewpager2强制要求的
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT);
            imageView.setLayoutParams(params);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            return new ImageHolder(imageView);
        }
        @Override
        public void onBindView(ImageHolder holder, DataBean data, int position, int size) {
            holder.imageView.setImageResource(data.imageRes);
        }
        public class ImageHolder extends RecyclerView.ViewHolder {
            public ImageView imageView;

            public ImageHolder(@NonNull View view) {
                super(view);
                this.imageView = (ImageView) view;
            }
        }
    }
*/



         /*
*/
         /*        //    public static List<DataBean> getTestData() {
//        List<DataBean> list = new ArrayList<>();
//        list.add(new DataBean(R.drawable.image1, "相信自己,你努力的样子真的很美", 1));
//        list.add(new DataBean(R.drawable.image2, "极致简约,梦幻小屋", 3));
//        list.add(new DataBean(R.drawable.image3, "超级卖梦人", 3));
//        list.add(new DataBean(R.drawable.image4, "夏季新搭配", 1));
//        list.add(new DataBean(R.drawable.image5, "绝美风格搭配", 1));
//        list.add(new DataBean(R.drawable.image6, "微微一笑 很倾城", 3));
//        return list;
//    }
//
        public static List<DataBean> getTestData2() {
            List<DataBean> list = new ArrayList<>();
            list.add(new DataBean(R.mipmap.b1, "", 0));
            list.add(new DataBean(R.mipmap.b2, "", 1));
            //        list.add(new DataBean(R.drawable.rl, "听风.赏雨", 3));
//        list.add(new DataBean(R.drawable.agree_image, "迪丽热巴.迪力木拉提", 1));
//        list.add(new DataBean(R.drawable.image_delete, "爱美.人间有之", 3));
//        list.add(new DataBean(R.drawable.umcsdk_check_image, "洋洋洋.气质篇", 1));
//        list.add(new DataBean(R.drawable.umcsdk_uncheck_image, "生活的态度", 3));
            return list;
        }*/
        /*

        *//**
         * 仿淘宝商品详情第一个是视频
         *
         * @return
         */
        /*
        public static List<DataBean> getTestDataVideo() {
            List<DataBean> list = new ArrayList<>();
            list.add(new DataBean("http://vfx.mtime.cn/Video/2019/03/09/mp4/190309153658147087.mp4", "第一个放视频", 2));
//        list.add(new DataBean(R.drawable.image7, "听风.赏雨", 1));
//        list.add(new DataBean(R.drawable.image8, "迪丽热巴.迪力木拉提", 1));
//        list.add(new DataBean(R.drawable.image9, "爱美.人间有之", 1));
//        list.add(new DataBean(R.drawable.image10, "洋洋洋.气质篇", 1));
//        list.add(new DataBean(R.drawable.image11, "生活的态度", 1));
            return list;
        }

        public static List<DataBean> getTestData3() {
            List<DataBean> list = new ArrayList<>();
            list.add(new DataBean("https://img.zcool.cn/community/013de756fb63036ac7257948747896.jpg", null, 1));
            list.add(new DataBean("https://img.zcool.cn/community/01639a56fb62ff6ac725794891960d.jpg", null, 1));
            list.add(new DataBean("https://img.zcool.cn/community/01270156fb62fd6ac72579485aa893.jpg", null, 1));
            list.add(new DataBean("https://img.zcool.cn/community/01233056fb62fe32f875a9447400e1.jpg", null, 1));
            list.add(new DataBean("https://img.zcool.cn/community/016a2256fb63006ac7257948f83349.jpg", null, 1));
            return list;
        }

        public static List<String> getColors(int size) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                list.add(getRandColor());
            }
            return list;
        }

        *//**
         * 获取十六进制的颜色代码.例如  "#5A6677"
         * 分别取R、G、B的随机值，然后加起来即可
         *
         * @return String
         */
        /*
        public static String getRandColor() {
            String R, G, B;
            Random random = new Random();
            R = Integer.toHexString(random.nextInt(256)).toUpperCase();
            G = Integer.toHexString(random.nextInt(256)).toUpperCase();
            B = Integer.toHexString(random.nextInt(256)).toUpperCase();

            R = R.length() == 1 ? "0" + R : R;
            G = G.length() == 1 ? "0" + G : G;
            B = B.length() == 1 ? "0" + B : B;

            return "#" + R + G + B;
        }*/








}