package com.example.mythirddemo.util;

import android.text.TextUtils;
import android.util.Log;

import com.example.mythirddemo.MyApplication;
import com.example.mythirddemo.my.CheckExist;
import com.example.mythirddemo.my.Ensure;
import com.example.mythirddemo.my.Login;
import com.example.mythirddemo.my.RecommendSings;
import com.example.mythirddemo.my.SystemRecommend;
import com.example.mythirddemo.my.UserMessage;
import com.example.mythirddemo.my.UserPlayList;
import com.franmontiel.persistentcookiejar.ClearableCookieJar;
import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class HttpUtil {
    public static void sendRequest(String address, Callback callback) {

        ClearableCookieJar cookieJar =
                new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(MyApplication.getContext()));
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .cookieJar(cookieJar)
                .build();
        Request request = new Request.Builder()
                .url(address)
                .build();
       okHttpClient.newCall(request).enqueue(callback);
    }
    public static void sendRequestWithoutCookie(String address, Callback callback) {
        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }


    /**
     * 为HttpGet 的 url 方便的添加多个name value 参数。
     *
     * @param url
     * @param params
     * @return
     */
    public static String attachHttpGetParams(String url, LinkedHashMap<String, String> params) {

        Iterator<String> keys = params.keySet().iterator();
        Iterator<String> values = params.values().iterator();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("?");

        for (int i = 0; i < params.size(); i++) {
            String value = null;
            try {
                value = URLEncoder.encode(values.next(), "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }

            stringBuffer.append(keys.next() + "=" + value);
            if (i != params.size() - 1) {
                stringBuffer.append("&");
            }
        }

        return url + stringBuffer.toString();
    }

    public static void sendRequestJust(String url, okhttp3.Callback callback) {

        //1.创建OkHttpClient对象
//        OkHttpClient okHttpClient = new OkHttpClient();
        //2.创建Request对象，设置一个url地址（百度地址）,设置请求方式。
        Request request = new Request.Builder().url(url).method("GET", null).build();
        //3.创建一个call对象,参数就是Request请求对象
        Call call = okHttpClient.newCall(request);
        //4.请求加入调度，重写回调方法
        call.enqueue(callback);
    }


    public static void HTTP_POST(String url, RequestBody requestBody, okhttp3.Callback callback) {

        //1.创建OkHttpClient对象
//        OkHttpClient okHttpClient = new OkHttpClient();
        //2.通过new FormBody()调用build方法,创建一个RequestBody,可以用add添加键值对
        //3.创建Request对象，设置URL地址，将RequestBody作为post方法的参数传入
        Request request = new Request.Builder().url(url).post(requestBody).build();
        //4.创建一个call对象,参数就是Request请求对象
        Call call = okHttpClient.newCall(request);
        //5.请求加入调度,重写回调方法
        call.enqueue(callback);


    }

    private static final HashMap<String, List<Cookie>> cookieStore = new HashMap<>();
    private static OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .cookieJar(new CookieJar() {
                @Override
                public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
                    cookieStore.put(httpUrl.host(), list);
                }

                @Override
                public List<Cookie> loadForRequest(HttpUrl httpUrl) {
                    List<Cookie> cookies = cookieStore.get(httpUrl.host());
                    return cookies != null ? cookies : new ArrayList<Cookie>();
                }
            })
            .build();





    public static int handResponse(String response){
        if (!TextUtils.isEmpty(response)){
            try {
                JSONObject object=new JSONObject(response);
                JSONObject jsonObject=object.getJSONObject("account");
                String userName=jsonObject.getString("userName");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }
    /*
    登录账号
     */
    public static Login handResponseLogin(String response1){
        if (!TextUtils.isEmpty(response1)){
            Gson gson=new Gson();
            return gson.fromJson(response1,Login.class);
        }
        return null;
    }

     /*
    在用短信修改密码时确定是否为本人
     */
    public static Ensure handResponseEnsure(String response2){
        if (!TextUtils.isEmpty(response2)){
            Gson gson=new Gson();
            return gson.fromJson(response2,Ensure.class);
        }
        return null;
    }

     /*
    确定用户是否已经用这个手机号注册了账号
     */
    public static CheckExist handResponseExist(String response3){
        if (!TextUtils.isEmpty(response3)){
            Gson gson=new Gson();
            return gson.fromJson(response3,CheckExist.class);
        }
        return null;
    }
    /*
    获取每日推荐歌单
     */
    public static RecommendSings handResponseSings(String response4){
        if (!TextUtils.isEmpty(response4)){
            Gson gson=new Gson();
            return gson.fromJson(response4,RecommendSings.class);
        }
        return null;
    }

    /*
    获取轮播图
     */
    public static List<String> handResponsePicture(String response){
        List<String> picturesList=new ArrayList<>();
        if (!TextUtils.isEmpty(response)){
            try {
                JSONObject object=new JSONObject(response);
                JSONArray bannersArray=object.getJSONArray("banners");
                for (int i=0;i<bannersArray.length();i++){
                    JSONObject jsonObject=bannersArray.getJSONObject(i);
                    Log.d("请求图片地址", jsonObject.getString("pic"));
                    String address=jsonObject.getString("pic");
                    //在手机里加载为黑屏
                    //String addressUrl=jsonObject.getString("url");
                    picturesList.add(address);
                    //picturesList.add(addressUrl);
                    Log.d("存进来的是：", picturesList.get(i));
                }
                return picturesList;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /*
    每日推荐
     */
    public static SystemRecommend handSystemRecommend(String response){
        if (!TextUtils.isEmpty(response)){
            Gson gson=new Gson();
            return gson.fromJson(response,SystemRecommend.class);
        }
        return null;
    }

    /*
    用户歌单数量
     */
    public static UserMessage handUserMsg(String response){
        if (!TextUtils.isEmpty(response)){
            Gson gson=new Gson();
            return gson.fromJson(response,UserMessage.class);
        }
        return null;
    }

    /*
    用户创建的歌单和收藏的歌单
     */
    public static UserPlayList handUserPlayList(String response){
        if (!TextUtils.isEmpty(response)){
            Gson gson=new Gson();
            return gson.fromJson(response,UserPlayList.class);
        }
        return null;
    }
}
