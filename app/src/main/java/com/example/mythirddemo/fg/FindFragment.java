package com.example.mythirddemo.fg;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.mythirddemo.R;
import com.example.mythirddemo.findother.RecommendListActivity;
import com.example.mythirddemo.home.WebActivity;
import com.example.mythirddemo.my.BannerPicture;
import com.example.mythirddemo.my.BannersBean;
import com.example.mythirddemo.my.Login;
import com.example.mythirddemo.my.RecommendBean;
import com.example.mythirddemo.my.RecommendSings;
import com.example.mythirddemo.my.SystemRecommend;
import com.example.mythirddemo.util.HttpUtil;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class FindFragment extends Fragment implements OnBannerListener,View.OnClickListener {
    private static final String TAG = "load";
    private View view;
    private Banner banner;
    //存放图片的路径
    private ArrayList<String> list_path;
    //存放图片下方的注释标题
    private ArrayList<String> list_title;
    //歌单和描述
    ImageView imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9;
    TextView textView1,textView2,textView3,textView4,textView5,textView6,textView7,textView8,textView9;
    ImageView recommend;

    private ProgressDialog progressDialog;
    private List<RecommendBean> recommendBeanList=new ArrayList<>();
    private List<BannersBean> banners;
    List<String>pictures;

    //刷新
    private SwipeRefreshLayout refreshLayout;


    public FindFragment() {
        // Required empty public constructor
    }
    public FindFragment(List<RecommendBean> recommendBeanList) {
        // Required empty public constructor
        this.recommendBeanList=recommendBeanList;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.find_fg, container, false);
        initSings();
        Log.d(TAG, "onCreateView: 实现");
        Log.d(TAG, "onCreateView: "+recommendBeanList.size());
        //轮播图数据
        bannerPictures();

        /*
        提取歌单数据
         */
        String addressSings="http://39.100.233.149:3000/recommend/resource";
        HttpUtil.sendRequest(addressSings, new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
            }
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                final String singsData=response.body().string();
                Log.d(TAG, "onResponse: "+singsData);
                RecommendSings sings=HttpUtil.handResponseSings(singsData);
                recommendBeanList=sings.getRecommend();
                Log.d(TAG, "onResponse:返回码"+sings.getCode());
                Log.d(TAG, "onResponse: "+recommendBeanList.size());
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //加载推荐歌单的封面和描述
                        Glide.with(view.getContext()).load(recommendBeanList.get(0).getPicUrl()).into(imageView1);
                        textView1.setText(recommendBeanList.get(0).getName());
                        Glide.with(view.getContext()).load(recommendBeanList.get(1).getPicUrl()).into(imageView2);
                        textView2.setText(recommendBeanList.get(1).getName());
                        Glide.with(view.getContext()).load(recommendBeanList.get(2).getPicUrl()).into(imageView3);
                        textView3.setText(recommendBeanList.get(2).getName());
                        Glide.with(view.getContext()).load(recommendBeanList.get(3).getPicUrl()).into(imageView4);
                        textView4.setText(recommendBeanList.get(3).getName());
                        Glide.with(view.getContext()).load(recommendBeanList.get(4).getPicUrl()).into(imageView5);
                        textView5.setText(recommendBeanList.get(4).getName());
                        Glide.with(view.getContext()).load(recommendBeanList.get(5).getPicUrl()).into(imageView6);
                        textView6.setText(recommendBeanList.get(5).getName());
                        Glide.with(view.getContext()).load(recommendBeanList.get(6).getPicUrl()).into(imageView7);
                        textView7.setText(recommendBeanList.get(6).getName());
                        Glide.with(view.getContext()).load(recommendBeanList.get(6).getCreator().getAvatarUrl()).into(imageView8);
                        textView8.setText(recommendBeanList.get(6).getCreator().getNickname());
                        Glide.with(view.getContext()).load(recommendBeanList.get(1).getCreator().getAvatarUrl()).into(imageView9);
                        textView9.setText(recommendBeanList.get(1).getCreator().getNickname());
                    }
                });
            }
        });
        refresh();

        return view;
    }

    /*
    刷新功能,重新读取登录状态
     */
    private void refresh(){
        refreshLayout=view.findViewById(R.id.swiper_refresh);
        refreshLayout.setColorSchemeResources(R.color.colorPrimary);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1000);
                            //刷新登录
                            String address="http://39.100.233.149:3000/login/refresh";
                            HttpUtil.sendRequest(address, new Callback() {
                                @Override
                                public void onFailure(@NotNull Call call, @NotNull IOException e) {
                                }
                                @Override
                                public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                                    Log.d(TAG, "onResponse:刷新成功"+response.code());
                                }
                            });
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                refreshLayout.setRefreshing(false);
                                Toast.makeText(view.getContext(), "新的登录状态", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }).start();
            }
        });
    }

    /*
    获取轮播图数据
     */
    private void bannerPictures(){
        String address="http://39.100.233.149:3000/banner?type=1";
        HttpUtil.sendRequestWithoutCookie(address, new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
            }
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String responsePicture=response.body().string();
                pictures=HttpUtil.handResponsePicture(responsePicture);
                Log.d(TAG, "轮播图地址 "+pictures.get(0));
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //初始化轮播图数据
                        initView();
                    }
                });
            }
        });
    }

    //初始化
    private void initView() {
        banner =  view.findViewById(R.id.banner);
        //放图片地址的集合
        list_path = new ArrayList<>();
        //放标题的集合
        list_title = new ArrayList<>();

        for (int i=0;i<pictures.size();i++){
            list_path.add(pictures.get(i));
            list_title.add("");
        }
        //设置内置样式，共有六种可以点入方法内逐一体验使用。
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        //设置图片加载器，图片加载器在下方
        banner.setImageLoader(new MyLoader());
        //设置图片网址或地址的集合
        banner.setImages(list_path);
        //设置轮播的动画效果，内含多种特效，可点入方法内查找后内逐一体验
        banner.setBannerAnimation(Transformer.Default);
        //设置轮播图的标题集合
        banner.setBannerTitles(list_title);
        //设置轮播间隔时间
        banner.setDelayTime(3000);
        //设置是否为自动轮播，默认是“是”。
        banner.isAutoPlay(true);
        //设置指示器的位置，小点点，左中右。
        banner.setIndicatorGravity(BannerConfig.CENTER)
                //以上内容都可写成链式布局，这是轮播图的监听。比较重要。方法在下面。
                .setOnBannerListener(this)
                //必须最后调用的方法，启动轮播图。
                .start();
    }

    //轮播图的监听方法
    @Override
    public void OnBannerClick(int position) {
        Log.i("tag", "你点了第"+(position+1)+"张轮播图");
        Toast.makeText(view.getContext(), "你点了第"+(position+1)+"张轮播图", Toast.LENGTH_SHORT).show();
//                Intent intent1=new Intent(view.getContext(), WebActivity.class);
//                intent1.putExtra("url",pictures.get(position+1));
//        Log.d(TAG, "传过去的网站是： "+pictures.get(position+1));
//                if (position<=pictures.size()){
//                    startActivity(intent1);
//                }
    }

    /*
    发现页面的监听事件
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.system_recommend:
                Log.d(TAG, "歌单被单击");
                Intent intent1=new Intent(view.getContext(), RecommendListActivity.class);
                startActivity(intent1);
        }

    }

    //自定义的图片加载器
    private class MyLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load((String) path).into(imageView);
        }
    }

    /*
    初始化歌单控件
     */
    private void initSings(){
        recommend=view.findViewById(R.id.system_recommend);
        recommend.setOnClickListener(this);

        imageView1=view.findViewById(R.id.every_sing1);
        imageView2=view.findViewById(R.id.every_sing2);
        imageView3=view.findViewById(R.id.every_sing3);
        imageView4=view.findViewById(R.id.every_sing11);
        imageView5=view.findViewById(R.id.every_sing22);
        imageView6=view.findViewById(R.id.every_sing33);
        imageView7=view.findViewById(R.id.every_sing111);
        imageView8=view.findViewById(R.id.every_sing222);
        imageView9=view.findViewById(R.id.every_sing333);
        textView1=view.findViewById(R.id.every_dsc1);
        textView2=view.findViewById(R.id.every_dsc2);
        textView3=view.findViewById(R.id.every_dsc3);
        textView4=view.findViewById(R.id.every_dsc11);
        textView5=view.findViewById(R.id.every_dsc22);
        textView6=view.findViewById(R.id.every_dsc33);
        textView7=view.findViewById(R.id.every_dsc111);
        textView8=view.findViewById(R.id.every_dsc222);
        textView9=view.findViewById(R.id.every_dsc333);
    }

}
