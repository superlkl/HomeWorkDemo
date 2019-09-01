package com.example.mythirddemo.LoginSolve;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
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
import com.example.mythirddemo.my.Ensure;
import com.example.mythirddemo.util.HttpUtil;
import com.example.mythirddemo.util.IOUtil;

import org.jetbrains.annotations.NotNull;
import org.litepal.LitePal;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class EnsureActivity extends AppCompatActivity {
    private static final String TAG = "lklSure";
    private EditText editText1,editText2,editText3,editText4;
    private String cellNumber;
    private String nickName;
    private String replacePassWord;
    private String maskNumber;
    private TextView showCellNumber;
    private TextView showSecond;
    private ImageView icBlack;
    //返回码和返回信息
    int backCode;
    String backMessage;

    int second=60;
    private boolean isRunning;
    private String securityCode="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ensure_activity);
        editText1=findViewById(R.id.editText1);
        editText2=findViewById(R.id.editText2);
        editText3=findViewById(R.id.editText3);
        editText4=findViewById(R.id.editText4);
        showCellNumber=findViewById(R.id.show_cellNumber);
        showSecond=findViewById(R.id.show_second);
        icBlack=findViewById(R.id.ensure_back);

        //先拿到手机信息和修改后的密码还有网名
        Intent intent=getIntent();
        cellNumber=intent.getStringExtra("userPhone");
        replacePassWord=intent.getStringExtra("userPassWord");
        nickName=intent.getStringExtra("nickName");
        Log.d(TAG, "手机号码为:"+cellNumber);
        Log.d(TAG, "修改的密码为："+replacePassWord);
        //可以同时判断是null还是空字符串的情况
        if (!TextUtils.isEmpty(cellNumber)){
            //基于隐私把号码中间的四个数字用****代替
            maskNumber=cellNumber.substring(0,3)+"****"+cellNumber.substring(7,11);
            showCellNumber.setText(maskNumber);
            Log.d(TAG, "被掩盖后的号码:"+maskNumber);
        }
        //开一个线程来演示倒计时的效果
        new Thread(new Runnable() {
            @Override
            public void run() {
                //可以随时停掉线程
                isRunning=true;
                //当isRunning为false时就停掉线程
                while (isRunning){
                    try {
                        Thread.sleep(1000);
                        second--;
                        Log.d(TAG, "倒计时:"+second);
                        if (backCode==200){
                            isRunning=false;
                            Log.d(TAG, "返回码中断线程"+backCode);
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //用setText()在里面传入int型的值会报异常,需要转换成String型
                            showSecond.setText(String.valueOf(second));
                            //从60s到0s
                            if (second<=1){
                                isRunning=false;
                                //验证超时就重新挑战到填写密码的页面
                                Toast.makeText(EnsureActivity.this, "验证超时", Toast.LENGTH_SHORT).show();
                                Intent intent1=new Intent(EnsureActivity.this,FindPasswordActivity.class);
                                //没必要再次传入号码回去，在活动还未被销毁前数据依旧存在
                                //intent1.putExtra("cellNumber",cellNumber);
                                startActivity(intent1);
                            }
                        }
                    });
                }
            }
        }).start();
        //手动点击返回键
        icBlack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(EnsureActivity.this,FindPasswordActivity.class);
                intent1.putExtra("cellNumber",cellNumber);
                startActivity(intent1);
                finish();
            }
        });

        editText1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void afterTextChanged(Editable editable) {
                //拿到第一个编辑框的数字
                String number1=editable.toString();
                //识别数字之后把光标自动移到下一个编辑框
                if (!TextUtils.isEmpty(number1)) {
                    editText2.setFocusableInTouchMode(true);
                    editText2.setFocusable(true);
                    editText2.requestFocus();

                    //拼接验证码
                    securityCode+=number1;
                }
            }
        });
        editText2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void afterTextChanged(Editable editable) {
                String number2=editable.toString();
                if (!TextUtils.isEmpty(number2)) {
                    //发现输入回车符或换行符
                    editText3.setFocusableInTouchMode(true);
                    editText3.setFocusable(true);
                    editText3.requestFocus();

                    securityCode+=number2;
                }
            }
        });
        editText3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void afterTextChanged(Editable editable) {
                String number3=editable.toString();
                if (!TextUtils.isEmpty(number3)) {

                    editText4.setFocusableInTouchMode(true);
                    editText4.setFocusable(true);
                    editText4.requestFocus();

                    securityCode+=number3;
                }
            }
        });
        editText4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                String number4=editable.toString();
                if (!TextUtils.isEmpty(number4)){
                    securityCode+=number4;
                    //在最后一个编辑框输入完成后拼接完成
                    Log.d(TAG, "输入的验证码:"+securityCode);
                    //验证验证码是否正确的接口
                    String address="http://39.100.233.149:3000/"+"captcha/verify?phone="
                            +cellNumber
                            +"&"
                            +"captcha="
                            +securityCode;
                    Log.d(TAG, "验证接口："+address);
                    HttpUtil.sendRequest(address, new Callback() {
                        @Override
                        public void onFailure(@NotNull Call call, @NotNull IOException e) {
                           runOnUiThread(new Runnable() {
                               @Override
                               public void run() {
                                   Toast.makeText(EnsureActivity.this, "未知错误", Toast.LENGTH_SHORT).show();
                               }
                           });
                        }
                        @Override
                        public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                            final String responseData=response.body().string();
                             Ensure ensure=HttpUtil.handResponseEnsure(responseData);
                             backCode=ensure.getCode();
                             backMessage=ensure.getMessage();
                            Log.d(TAG, " 返回码:"+backCode);
                            Log.d(TAG, " 返回报告:"+backMessage);
                            //返回码为503和返回报告为“验证码错误”就说明失败
                            if (!TextUtils.isEmpty(backMessage)&&backMessage.equals("验证码错误")){
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(EnsureActivity.this, "验证码错误", Toast.LENGTH_SHORT).show();
                                        //清除输入框的所有数据并把光标设置到第一个
                                        editText1.setText("");
                                        editText2.setText("");
                                        editText3.setText("");
                                        editText4.setText("");
                                        editText1.setFocusableInTouchMode(true);
                                        editText1.setFocusable(true);
                                        editText1.requestFocus();
                                        Log.d(TAG, "清除错误验证码为:"+securityCode);
                                        securityCode="";
                                        Log.d(TAG, "清除之后的验证码为:"+securityCode);
                                    }
                                });
                                //返回码为200就说明验证成功
                            }else if (backCode==200){
                                //关闭线程
                                isRunning=false;
                                //修改密码的接口
                                //需要传入用户网名

                               runOnUiThread(new Runnable() {
                                   @Override
                                   public void run() {
                                       //密码被修改
                                       replaceRegisterStatue();
                                       Toast.makeText(EnsureActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                                       Intent intent1=new Intent(EnsureActivity.this, ViewPagerActivity.class);
                                       intent1.putExtra("userPhone",cellNumber);
                                       intent1.putExtra("userPassWord",replacePassWord);
                                       Log.d(TAG, "修改后传入的密码为"+replacePassWord);
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
    //注册也可以修改密码
    private void replaceRegisterStatue(){
        String address="http://39.100.233.149:3000/register/cellphone?phone="
                +cellNumber
                +"&password="
                +replacePassWord
                +"&captcha="
                +securityCode;
        Log.d(TAG, "修改注册接口："+address);
        //保存数据
        Log.d(TAG, "要保存的密码"+replacePassWord);
        IOUtil.saveUserPassword(replacePassWord);

        HttpUtil.sendRequest(address, new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
            }
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String responseData=response.body().string();
                Log.d(TAG, "修改密码的返回："+responseData);
            }
        });
    }

}
