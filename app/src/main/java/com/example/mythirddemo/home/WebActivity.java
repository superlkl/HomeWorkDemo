package com.example.mythirddemo.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.mythirddemo.R;

public class WebActivity extends AppCompatActivity {
    String web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        WebView webView=findViewById(R.id.web_view);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        //获取传过来的网站
        Intent intent=getIntent();
        web=intent.getStringExtra("url");
        webView.loadUrl(web);
    }
}
