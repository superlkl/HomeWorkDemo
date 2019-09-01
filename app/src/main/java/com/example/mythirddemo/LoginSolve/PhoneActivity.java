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
import com.example.mythirddemo.adapter.RecommendSingsClass;
import com.example.mythirddemo.db.User;
import com.example.mythirddemo.my.CheckExist;
import com.example.mythirddemo.util.HttpUtil;
import com.example.mythirddemo.util.IOUtil;

import org.jetbrains.annotations.NotNull;
import org.litepal.LitePal;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class PhoneActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "lklPhone";
    String text;
    ImageView back1;


    //检查手机是否注册
    CheckExist checkExist;
    int exist;
    String name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phone_activity);
        TextView nextStep=findViewById(R.id.phone_nextStep);
        EditText phoneEdit=findViewById(R.id.input_phone);
        back1=findViewById(R.id.back_1);
        nextStep.setOnClickListener(this);
        phoneEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void afterTextChanged(Editable editable) {
                text=editable.toString().trim();
                //检查手机号码是否已经注册的接口
                String address="http://39.100.233.149:3000/"
                        +"cellphone/existence/check?phone="
                        +text;

                //手机号为11位，确定是手机号再请求数据
                if (text.length()==11){
                    HttpUtil.sendRequest(address, new Callback() {
                        @Override
                        public void onFailure(@NotNull Call call, @NotNull IOException e) {
                            //Toast.makeText(PhoneActivity.this, "网络异常", Toast.LENGTH_SHORT).show();
                        }
                        @Override
                        public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                            String responseData=response.body().string();
                            checkExist=HttpUtil.handResponseExist(responseData);
                            //若是手机号已经注册返回码为1，否则为-1
                            exist=checkExist.getExist();
                            name=checkExist.getNickname();
                            Log.d(TAG, "onResponse: 取出绰号:"+name);

                            if (exist==-1||name==null){
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(PhoneActivity.this,
                                                "该手机号还未注册,请立即注册", Toast.LENGTH_SHORT).show();
                                        Intent intent1=new Intent(PhoneActivity.this,PasswordActivity.class);
                                        startActivity(intent1);
                                    }
                                });
                            }
                        }
                    });
                }
            }
        });
    }
    @Override
    public void onClick(View view) {
      switch (view.getId()){
          case R.id.phone_nextStep:
              //号码注册存在才跳转
              try {
                  if ((exist==1||name!=null)&&text.length()==11){
                      //保存数据
                      IOUtil.saveUserPhone(text);
                      IOUtil.saveNickName(name);
                      Intent intent=new Intent(PhoneActivity.this, PasswordActivity.class);
                      //把用户的号码和网名传到下一个活动使用
                      intent.putExtra("userPhone",text);
                      intent.putExtra("nickName",name);
                      startActivity(intent);
                      break;
                  }
                  else if (text.length()<11){
                      Toast.makeText(this, "请输入正确的手机号码", Toast.LENGTH_SHORT).show();
                      break;
                  }
              } catch (Exception e) {
                  e.printStackTrace();
                  Toast.makeText(this, "请输入手机号码", Toast.LENGTH_SHORT).show();
              }
          case R.id.back_1:
              finish();
      }
    }
}
