package com.fangrongfu.myfirstapp.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.fangrongfu.myfirstapp.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);//隐藏状态栏
        getSupportActionBar().hide();//隐藏标题栏
        setContentView(R.layout.activity_splash);//前面两句执行了，这句才能执行
        Thread myThread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(3000);//程序休眠5秒
                    Intent it = new Intent(getApplicationContext(),LoginActivity.class);//启动LoginActivity
                    startActivity(it);
                    finish();//关闭当前活动
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };
        myThread.start();//启动线程
    }
}
