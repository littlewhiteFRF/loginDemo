package com.fangrongfu.myfirstapp.Model;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.fangrongfu.myfirstapp.Bean.User;
import com.fangrongfu.myfirstapp.R;
import com.fangrongfu.myfirstapp.Util.MyApplication;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * 作者：方荣福
 * 模型层
 * 通常是对本地数据库的操作（增删改查，具有粒子性）或者是通过网络请求获取网络数据的操作
 */
public class UserModel {
    /**
     * 利用网络请求框架Okhttp做一个登陆请求
     * 如果可以的话，可以对OkHttp进行二次封装，项目大的话，二次封装这样会更好
     * @param user
     * @return Boolean
     */
    public Boolean login(User user) throws IOException {
        //创建okHttpClient对象
        OkHttpClient client = new OkHttpClient();

        //创建表单请求体
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");//数据类型为json格式，
        String jsonStr = "{\"name\":\"fangrongfu\",\"password\":\"123456\"}";//json数据.
        RequestBody body = RequestBody.create(JSON, jsonStr);

        //创建一个Request
        Request request = new Request.Builder()//创建Request 对象。
                .url("http://rap2.taobao.org:38080/app/mock/251528/mainshi/login")
                .post(body)//传递请求体
                .build();
        //new call
        Response response = client.newCall(request).execute();

        //处理响应结果
        if (response.isSuccessful()) {//回调的方法执行在子线程。
            String htmlStr = response.body().string();
            try {
                JSONObject jsonObject = new JSONObject(htmlStr);
                if("true".equals(jsonObject.get("isLogin"))){
                    return true;
                }else{
                    return false;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }else{
            throw new IOException("Unexpected code " + response);
        }

        return false;
    }

    /**
     * 使用第三方图片加载Glide加载图片
     * @param url
     * @param view
     */
    public void loadImage(String url, ImageView view){
        Glide.with(MyApplication.getContext())
                .load(url)
                .asBitmap()
                .placeholder(R.drawable.loading)
                .error(R.drawable.error)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .override(100, 100)
                .into(view);
    }
}
