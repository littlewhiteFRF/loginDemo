package com.fangrongfu.myfirstapp.Controller;

import android.widget.ImageView;

import com.fangrongfu.myfirstapp.Bean.User;

import java.io.IOException;

public interface UserController {

    /**
     * 登陆
     * @param user
     * @return
     * @throws IOException
     */
    public Boolean login(User user) throws IOException;

    /**
     * 使用第三方图片加载Glide加载图片
     * @param url
     * @param view
     */
    public void loadImage(String url, ImageView view);
}
