package com.example.mythirddemo.findother;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.mythirddemo.MyApplication;
import com.example.mythirddemo.R;
import com.example.mythirddemo.adapter.RecommendSingsClass;
import com.example.mythirddemo.adapter.SystemRecommendAdapter;
import com.example.mythirddemo.my.RecommendSings;
import com.example.mythirddemo.my.SystemRecommend;
import com.example.mythirddemo.util.HttpUtil;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class RecommendListActivity extends AppCompatActivity {
    private static final String TAG = "适配歌单";
    RecyclerView recyclerView;
    private List<RecommendSingsClass>recommendSingsList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recommend_list_activity);
        //请求推荐歌单数据
       recommend();
//        recyclerView=findViewById(R.id.recommend_recycler);
//        LinearLayoutManager manager=new LinearLayoutManager(this);
//        SystemRecommendAdapter adapter=new SystemRecommendAdapter(recommendSingsList);
//        recyclerView.setLayoutManager(manager);
//        recyclerView.setAdapter(adapter);
    }


    /*
    请求每日推荐歌单
     */
    private void recommend(){
        String address="http://39.100.233.149:3000/recommend/songs";
        HttpUtil.sendRequest(address, new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String systemRecommend=response.body().string();
                SystemRecommend recommend=HttpUtil.handSystemRecommend(systemRecommend);
                String name=recommend.getRecommend().get(0).getName();
                Log.d(TAG, "每日推荐的歌名:"+name);
                for (int i=0;i<recommend.getRecommend().size();i++){
                    String singName=recommend.getRecommend().get(i).getName();
                    //要注意这里取得歌手对象有两个 0和1
                    String singerName=recommend.getRecommend().get(i).getArtists().get(0).getName();
                    Log.d(TAG, "onResponse: "+singerName);
                    String imgUrl=recommend.getRecommend().get(i).getAlbum().getPicUrl();
                    RecommendSingsClass recommendSingsClass=new RecommendSingsClass(imgUrl,singName,singerName);
                    recommendSingsList.add(recommendSingsClass);
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        recyclerView=findViewById(R.id.recommend_recycler);
                        LinearLayoutManager manager=new LinearLayoutManager(RecommendListActivity.this);
                        SystemRecommendAdapter adapter=new SystemRecommendAdapter(recommendSingsList);
                        recyclerView.setLayoutManager(manager);
                        recyclerView.setAdapter(adapter);
                    }
                });
            }
        });

    }

}
