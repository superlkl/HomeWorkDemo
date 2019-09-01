package com.example.mythirddemo.LoginSolve;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.mythirddemo.R;
import com.example.mythirddemo.findother.RecommendListActivity;
import com.example.mythirddemo.home.ViewPagerActivity;

import org.litepal.LitePal;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "lkl";
    private CheckBox checkBox;
    private Button phoneLog;
    private Boolean isCheck;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.login_activity);
        checkBox=findViewById(R.id.check_box);
        phoneLog=findViewById(R.id.phone_log);
        pref = super.getSharedPreferences("data", MODE_PRIVATE);
        editor = pref.edit();
            editor.clear();
            editor.apply();
            checkBox.setChecked(false);
        isCheck = pref.getBoolean("isAgree", false);
        if (isCheck) {
            checkBox.setChecked(true);}
        Log.d(TAG, "onCreate: "+isCheck);
        phoneLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if (checkBox.isChecked()) {
                        editor.putBoolean("isAgree", true);
                        Intent intent=new Intent(LoginActivity.this, PhoneActivity.class);
                        startActivity(intent);
                    } else {
                        editor.clear();
                        Toast.makeText(LoginActivity.this, "请先勾选同意“用户协议”和“隐私政策”", Toast.LENGTH_SHORT).show();
                    }
                    editor.apply();
                }
        });
   }
}
