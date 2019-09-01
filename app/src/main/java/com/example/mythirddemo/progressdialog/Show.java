package com.example.mythirddemo.progressdialog;

import android.app.ProgressDialog;

import com.example.mythirddemo.MyApplication;

public class Show {
    private static ProgressDialog progressDialog;
    /*
    进度对话框的显示和关闭
    */
    private static void showProgressDialog(){
        if (progressDialog==null){
            progressDialog=new ProgressDialog(MyApplication.getContext());
            progressDialog.setCancelable(false);
        }
        progressDialog.show();
    }
    private static void closeProgressDialog(){
        if (progressDialog!=null){
            progressDialog.dismiss();
        }
    }
}
