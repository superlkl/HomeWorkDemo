package com.example.mythirddemo.LoginSolve;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mythirddemo.R;
import com.example.mythirddemo.db.User;
import com.example.mythirddemo.home.ViewPagerActivity;
import com.example.mythirddemo.util.HttpUtil;
import com.example.mythirddemo.my.Login;
import com.example.mythirddemo.util.IOUtil;

import org.jetbrains.annotations.NotNull;
import org.litepal.LitePal;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class PasswordActivity extends AppCompatActivity {
    private static final String TAG = "lklLogin";
    String phoneNumber;
    String phonePassword;
    String responseData;
    String nickName;
    private EditText passwordEdit;
    ImageView back2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.password_activity);
        passwordEdit=findViewById(R.id.input_password);
        final TextView login=findViewById(R.id.phone_login);
        TextView forgetPassword=findViewById(R.id.forget_password);
        back2=findViewById(R.id.back_2);
        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        //先取出号码和网名信息
        final Intent intent=getIntent();
        phoneNumber=intent.getStringExtra("userPhone");
        nickName=intent.getStringExtra("nickName");

        Log.d(TAG, "onCreate: "+phoneNumber);
        passwordEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void afterTextChanged(Editable editable) {
                phonePassword=editable.toString().trim();
                Log.d(TAG, "密码正在输入: "+phonePassword);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //用户登录的接口
                String address="http://39.100.233.149:3000/login/cellphone?phone="
                        +phoneNumber
                        +"&"
                        +"password="
                        +phonePassword;
                Log.d(TAG, "用户输入的密码："+phonePassword);
                Log.d(TAG, "登录接口:"+address);
                HttpUtil.sendRequest(address, new Callback() {
                    @Override
                    public void onFailure(@NotNull Call call, @NotNull IOException e) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                //Toast也是UI操作
                                Toast.makeText(PasswordActivity.this, "请确定是否联网", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    @Override
                    public void onResponse(@NotNull Call call, @NotNull final Response response) throws IOException {
                        responseData=response.body().string();
                        final Login login1 =HttpUtil.handResponseLogin(responseData);
                        //登录成功的返回状态为1，返回码为200
                        int statue=login1.getLoginType();
                        int code=login1.getCode();

                        Log.d(TAG, "onResponse: "+statue);
                        Log.d(TAG, "onResponse: "+responseData);
                        if (statue==1||code==200){
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(PasswordActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                                    //保存数据
                                    int userId=login1.getAccount().getId();
                                    IOUtil.saveUserId(String.valueOf(userId));
                                    IOUtil.saveUserPassword(phonePassword);
                                    Intent intent1=new Intent(PasswordActivity.this, ViewPagerActivity.class);
                                    // 把手机号和密码还有网名传过去
                                    intent1.putExtra("userPhone",phoneNumber);
                                    intent1.putExtra("userPassWord",phonePassword);
                                    intent1.putExtra("nickName",nickName);
                                    Log.d(TAG, "传过去的号码"+phoneNumber);
                                    Log.d(TAG, "传过去的密码"+phonePassword);
                                    startActivity(intent1);
                                }
                            });
                        }else {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(PasswordActivity.this, "密码错误,请重新输入", Toast.LENGTH_SHORT).show();
                                    //清除编辑框的内容并把监听到的数据清空重新监听数据
                                    Log.d(TAG, "用户名:"+phoneNumber+"密码:"+phonePassword);
                                    passwordEdit.setText("");
                                    responseData="";
                                    Log.d(TAG, "清除之后的密码："+responseData);
                                }
                            });;
                        }
                    }
                });
            }
        });
        //忘记密码的情况
        forgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(PasswordActivity.this,FindPasswordActivity.class);
                //需要传入手机号,因为还需要发短信
                intent2.putExtra("cellPhoneNumber",phoneNumber);
                intent2.putExtra("nickName",nickName);
                startActivity(intent2);
            }
        });
    }
}
