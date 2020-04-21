package com.fangrongfu.myfirstapp.Util;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

/**
 * 作者：方荣福
 * 全局获取Context
 */
public class MyApplication extends Application {
    private static Context context;

    @SuppressLint("MissingSuperCall")
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext(){
        return context;
    }
}
