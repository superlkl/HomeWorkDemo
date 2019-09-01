package com.example.mythirddemo.LoginSolve;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
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
import com.example.mythirddemo.util.HttpUtil;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class FindPasswordActivity extends AppCompatActivity {
    private static final String TAG = "lklSet";
    String passWord;
    String cellPhoneNumber;
    String nickName;

    ImageView back3;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_password_activity);
        EditText setPassWord=findViewById(R.id.set_password);
        TextView setOk=findViewById(R.id.passWord_setOk);
        back3=findViewById(R.id.back_3);
        back3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        //获取传入的手机号
        final Intent intent=getIntent();
        cellPhoneNumber=intent.getStringExtra("cellPhoneNumber");
        nickName=intent.getStringExtra("nickName");

        setPassWord.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void afterTextChanged(Editable editable) {
                passWord=editable.toString().trim();
                Log.d(TAG, "修改密码的变化:"+passWord);
            }
        });
        setOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    //密码必须在六位数以上
                    if (passWord.length()>=6){
                        //发送验证码到手机上的接口
                        String address="http://39.100.233.149:3000/"+"captcha/sent?phone="+cellPhoneNumber;
                        HttpUtil.sendRequest(address, new Callback() {
                            @Override
                            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(FindPasswordActivity.this, "请求失败", Toast.LENGTH_SHORT).show();
                                    }
                                });

                            }
                            //这是需要一个验证码，不需要对response做其他操作
                            @Override
                            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                            }
                        });
                        //在网络请求之外了，已经在主线程了
                        Toast.makeText(FindPasswordActivity.this, "验证码已发送到手机,请注意查收", Toast.LENGTH_SHORT).show();
                        //跳转到让用户名输入验证码的界面
                        Intent intent1=new Intent(FindPasswordActivity.this,EnsureActivity.class);
                        //还是需要用户的手机信息,也把修改后的密码传过去还有网名
                        intent1.putExtra("userPassWord",passWord);
                        intent1.putExtra("userPhone",cellPhoneNumber);
                        intent1.putExtra("nickName",nickName);
                        startActivity(intent1);
                    }else {
                        Toast.makeText(FindPasswordActivity.this, "登录密码不少于6位", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(FindPasswordActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
                }

                /*
                测试使用，不用进行网络请求，不会发短信
                 */
//                Toast.makeText(FindPasswordActivity.this, "验证码已发送到手机,请注意查收", Toast.LENGTH_SHORT).show();
//                Intent intent1=new Intent(FindPasswordActivity.this,EnsureActivity.class);
//                intent1.putExtra("EnSure",cellPhoneNumber);
//                Log.d(TAG, "onClick:号码传入"+cellPhoneNumber);
//                startActivity(intent1);
            }
        });

    }
}
