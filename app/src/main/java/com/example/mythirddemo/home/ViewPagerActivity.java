package com.example.mythirddemo.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.mythirddemo.R;
import com.example.mythirddemo.db.User;
import com.example.mythirddemo.fg.FindFragment;
import com.example.mythirddemo.fg.MyFragmentPagerAdapter;
import com.example.mythirddemo.fg.OwnFragment;
import com.example.mythirddemo.fg.VideoFragment;
import com.example.mythirddemo.fg.YunFragment;
import com.example.mythirddemo.my.Login;
import com.example.mythirddemo.my.RecommendBean;
import com.example.mythirddemo.my.RecommendSings;
import com.example.mythirddemo.util.CookieManager;
import com.example.mythirddemo.util.HttpUtil;
import com.google.android.material.navigation.NavigationView;

import org.jetbrains.annotations.NotNull;
import org.litepal.LitePal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Response;

//给控件设置监听接口
public class ViewPagerActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener,
        ViewPager.OnPageChangeListener,
        View.OnClickListener {
    private ViewPager viewPager;
    private static final String TAG = "lkl";
    private DrawerLayout drawerLayout;
    private RadioGroup rgTabBar;
    private RadioButton rbMy;
    private RadioButton rbFind;
    private RadioButton rbYun;
    private RadioButton rbVd;
    ImageView findMsg;

    ImageView backLogin;

    String userPhone;
    String userPassWord;
    /*
    当前的碎片数量
     */
    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;
    public static final int PAGE_FOUR=3;
    private List<Fragment> fragmentList=new ArrayList<>();

    //登录对象
    Login login;
    ImageView userHeader;
    TextView userNickName;
    NavigationView navigationView;

    private List<RecommendBean> recommendBeanList=new ArrayList<>();
    private List<User>userList ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager_layout);

        //得到用户的手机号和密码
        Intent intent1=getIntent();
        userPhone=intent1.getStringExtra("userPhone");
        userPassWord=intent1.getStringExtra("userPassWord");
        Log.d(TAG, "取出密码"+userPassWord);

        //初始化碎片数据
        initFragment();
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.nav_view);
        //初始化控件和取得监听效果
        initView();
        //设置标题栏
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        //把home键设置为可点击并且更换默认图标
        if (actionBar!=null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_head);
        }
        //管理碎片
        FragmentManager manager=getSupportFragmentManager();
        MyFragmentPagerAdapter adapter=new MyFragmentPagerAdapter(manager,fragmentList);
        //关联碎片
        viewPager.setAdapter(adapter);



        /*
        给抽屉菜单里的选项设置点击事件
         */
        //先设置一个默认的被选项
        navigationView.setCheckedItem(R.id.nav_people);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.nav_sign:
                    case R.id.nav_email:
                }
                return true;
            }
        });

        /*
        网络请求，获取用户头像和别名
         */
        String address="http://39.100.233.149:3000/login/cellphone?phone="
                +userPhone
                +"&"
                +"password="
                +userPassWord;
        Log.d(TAG, "最后登录时手机号"+userPhone);
        Log.d(TAG, "最后登录时密码"+userPassWord);
        Log.d(TAG, "修改后的登录接口"+address);
        HttpUtil.sendRequest(address, new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                //Toast.makeText(ViewPagerActivity.this, "网络异常", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onFailure: 错误");
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String responseData=response.body().string();
                Log.d(TAG, "登录返回数据"+responseData);
                //这里需要cookie
                //findRequest();
                login=HttpUtil.handResponseLogin(responseData);
                int statue=login.getLoginType();
                int code=login.getCode();
                if (statue==1||code==200){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Log.d(TAG, "run:验证成功");
                            //设置用户名头像和网名
                            String pictureURL=login.getProfile().getAvatarUrl();
                            Log.d(TAG, "run:"+pictureURL);
                            Glide.with(ViewPagerActivity.this).load(pictureURL).into(userHeader);
                            Log.d(TAG, "run:头像加载成功 ");
                            userNickName.setText(login.getProfile().getNickname());
                            Log.d(TAG, "run:网名加载成功");
                        }
                    });
                }
            }
        });
    }
    /*
    给菜单栏侧拉菜单设置点击事件
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
                if (item.getItemId()==android.R.id.home){
                    Log.d(TAG, "onOptionsItemSelected:被点击了");
                    drawerLayout.openDrawer(GravityCompat.START);
                }
        return true;
    }

    //初始化碎片
    public void initFragment(){
        OwnFragment fragment1=new OwnFragment();
        FindFragment fragment2=new FindFragment(recommendBeanList);
        YunFragment fragment3=new YunFragment();
        VideoFragment fragment4=new VideoFragment();
        fragmentList.add(fragment1);
        fragmentList.add(fragment2);
        fragmentList.add(fragment3);
        fragmentList.add(fragment4);
    }
    public void findRequest(){
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
            }
        });
    }

    /*
    获取登录状态
     */


    /*
    初始化控件和监听对象
     */
    public void initView(){
      findMsg=findViewById(R.id.find_music);
        rgTabBar = (RadioGroup) findViewById(R.id.rg_tab_bar);
        rbMy=findViewById(R.id.text1);
        rbFind=findViewById(R.id.text2);
        rbYun = findViewById(R.id.text3);
        rbVd = findViewById(R.id.text4);

        backLogin=findViewById(R.id.nav_view).findViewById(R.id.back_login);

        //先得到头布局
        View headView=navigationView.getHeaderView(0);
        //从头布局的到里面的父布局
        RelativeLayout relativeLayout=headView.findViewById(R.id.relative_user);
        //再从父布局找到子控件
        userHeader=relativeLayout.findViewById(R.id.nav_image);
        userNickName=relativeLayout.findViewById(R.id.nav_sign);


        viewPager=findViewById(R.id.view_pager);
        //当前子项数量这个属性非常重要
        viewPager.setCurrentItem(0);
        viewPager.addOnPageChangeListener(this);
        rgTabBar.setOnCheckedChangeListener(this);
        //设置被点击默认项
        rbMy.setChecked(true);
    }
    /*
    radioButton的监听事件
     */
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        switch (checkedId) {
            case R.id.text1:
                viewPager.setCurrentItem(PAGE_ONE);
                break;
            case R.id.text2:
                viewPager.setCurrentItem(PAGE_TWO);
                break;
            case R.id.text3:
                viewPager.setCurrentItem(PAGE_THREE);
                break;
            case R.id.text4:
                viewPager.setCurrentItem(PAGE_FOUR);
                break;
        }

    }

    //给viewpager设置滑动监听事件
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
    }
          /*
            state=0,1,2
            0:滑动结束
            1:正在滑动
            2：滑动结束
             */
    @Override
    public void onPageScrollStateChanged(int state) {
        Log.i(TAG, "onPageScrollStateChanged: state:" + state);
        if (state == 2) {
            int currentItemPosition = viewPager.getCurrentItem();
            Log.w(TAG, "onPageScrollStateChanged: currentItemPosition::" + currentItemPosition);
            switch (currentItemPosition) {
                case PAGE_ONE:
                    rbMy.setChecked(true);
                    break;
                case PAGE_TWO:
                    rbFind.setChecked(true);
                    break;
                case  PAGE_THREE:
                    rbYun.setChecked(true);
                    break;
                case  PAGE_FOUR:
                    rbVd.setChecked(true);
                    break;
            }
        }

    }
    //菜单栏操作
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            //退出登录接口
            case R.id.back_login:
                String address="http://39.100.233.149:3000/logout";
                Log.d(TAG, "退出键被点击");
                HttpUtil.sendRequest(address, new Callback() {
                    @Override
                    public void onFailure(@NotNull Call call, @NotNull IOException e) {
                    }
                    @Override
                    public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                    }
                });
        }
    }
}
