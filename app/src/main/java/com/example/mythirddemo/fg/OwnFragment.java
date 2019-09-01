package com.example.mythirddemo.fg;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.mythirddemo.R;
import com.example.mythirddemo.adapter.MyAdapter;
import com.example.mythirddemo.adapter.OwnCollectAdapter;
import com.example.mythirddemo.adapterclass.MyTop;
import com.example.mythirddemo.adapterclass.SubCollect;
import com.example.mythirddemo.my.UserMessage;
import com.example.mythirddemo.my.UserPlayList;
import com.example.mythirddemo.util.HttpUtil;
import com.example.mythirddemo.util.IOUtil;

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
public class OwnFragment extends Fragment {
    private static final String TAG = "lklMy";
    private List<MyTop> myTopList=new ArrayList<>();
    private View view;
    String userId;

    ImageView imageView;
    TextView textView;

    //创建的歌单数量
    int createdPlaylistCount;
    //收藏的歌单数量
    int subPlaylistCount;
    //歌单数据
    private List<SubCollect>subCollectList=new ArrayList<>();

    //我的喜欢
    String myLove;
    String myLoveImg;



    public OwnFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.own_fg, container, false);
        imageView=view.findViewById(R.id.playlist_1);
        textView=view.findViewById(R.id.play_des1);
        //找到用户id
        userId= IOUtil.restoreUserId();
        Log.d(TAG, "取出用户id:"+userId);
        initTop();
        RecyclerView recyclerView = view.findViewById(R.id.recycler_my);
        LinearLayoutManager manager = new LinearLayoutManager(view.getContext());
        manager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(manager);
        MyAdapter adapterTop = new MyAdapter(myTopList);
        recyclerView.setAdapter(adapterTop);

        //歌单数量
        userDetail();

        return view;
    }

    //子项的初始化
    private void initTop() {
        MyTop myTop0 = new MyTop("私人FM", R.drawable.img1);
        myTopList.add(myTop0);
        MyTop myTop1 = new MyTop("最新电音", R.drawable.img2);
        myTopList.add(myTop1);
        MyTop myTop2 = new MyTop("Sati空间", R.drawable.img3);
        myTopList.add(myTop2);
        MyTop myTop3 = new MyTop("私藏推荐", R.drawable.img4);
        myTopList.add(myTop3);
        MyTop myTop4 = new MyTop("因乐交友", R.drawable.img5);
        myTopList.add(myTop4);
        MyTop myTop5 = new MyTop("亲子频道", R.drawable.img6);
        myTopList.add(myTop5);
        MyTop myTop6 = new MyTop("古典专区", R.drawable.img7);
        myTopList.add(myTop6);
        MyTop myTop7 = new MyTop("跑步FM", R.drawable.img8);
        myTopList.add(myTop7);
        MyTop myTop8 = new MyTop("爵士电台", R.drawable.img9);
        myTopList.add(myTop8);
        MyTop myTop9 = new MyTop("驾驶模式", R.drawable.img10);
        myTopList.add(myTop9);
    }

    /*
    歌单数量
     */
    private void userDetail(){
        String address="http://39.100.233.149:3000/user/subcount";
        HttpUtil.sendRequest(address, new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
            }
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String responseDetail=response.body().string();
                UserMessage message=HttpUtil.handUserMsg(responseDetail);
                createdPlaylistCount=message.getCreatedPlaylistCount();
                subPlaylistCount=message.getSubPlaylistCount();
                Log.d(TAG, "创建歌单数量:"+createdPlaylistCount);
                Log.d(TAG, "收藏歌单数量:"+subPlaylistCount);
                userPlayList();
            }
        });
    }
    /*
    用户创建和收藏的歌单
     */
    private void userPlayList(){
        String address="http://39.100.233.149:3000/user/playlist?uid="+userId;
        HttpUtil.sendRequest(address, new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
            }
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String responseUserPlay=response.body().string();
                final UserPlayList playList=HttpUtil.handUserPlayList(responseUserPlay);
                if (subPlaylistCount>0){
                    for (int i=0;i<subPlaylistCount;i++){
                        myLove=playList.getPlaylist().get(0).getName();
                        myLoveImg=playList.getPlaylist().get(0).getCoverImgUrl();
                        String des= playList.getPlaylist().get(createdPlaylistCount+i).getName();
                        String pictUrl=playList.getPlaylist().get(createdPlaylistCount+i).getCoverImgUrl();
                        Log.d(TAG, "我创建歌单的描述"+des);
                        Log.d(TAG, "图片地址"+pictUrl);
                        SubCollect subCollect=new SubCollect(des,pictUrl);
                        subCollectList.add(subCollect);
                        Log.d(TAG, "存入的对象数组："+subCollectList.size());
                    }
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Glide.with(view.getContext()).load(myLoveImg).into(imageView);
                            textView.setText(myLove);
                            RecyclerView recyclerView1=view.findViewById(R.id.recycler_collect);
                            LinearLayoutManager manager1=new LinearLayoutManager(view.getContext());
                            recyclerView1.setLayoutManager(manager1);
                            //给数据
                            Log.d(TAG, "存入的对象数组确定："+subCollectList.size());
                            OwnCollectAdapter adapterCollect=new OwnCollectAdapter(subCollectList);
                            recyclerView1.setAdapter(adapterCollect);
                        }
                    });

                }
            }
        });
    }
}
