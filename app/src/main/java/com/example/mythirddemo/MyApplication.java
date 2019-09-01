package com.example.mythirddemo;


import android.app.Application;
import android.content.Context;

import org.litepal.LitePal;

public class MyApplication extends Application{
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        // 初始化数据库配置
        LitePal.initialize(this);
    }

    public static Context getContext(){
        return context;
    }
}
