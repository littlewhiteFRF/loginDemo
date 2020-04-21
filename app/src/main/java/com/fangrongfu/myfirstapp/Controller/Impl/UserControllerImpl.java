package com.fangrongfu.myfirstapp.Controller.Impl;

import android.widget.ImageView;

import com.fangrongfu.myfirstapp.Bean.User;
import com.fangrongfu.myfirstapp.Controller.UserController;
import com.fangrongfu.myfirstapp.Model.UserModel;

import java.io.IOException;

/**
 * 作者：方荣福
 * 控制器层
 * 根据Model层的方法，加上我们的业务逻辑处理，对外提供方法并暴露接口
 */
public class UserControllerImpl implements UserController {
    private UserModel userModel;

    public UserControllerImpl(){
        userModel = new UserModel();
    }

    /**
     * 登陆
     * @param user
     * @return Boolean
     */
    public Boolean login(User user) throws IOException {
        return userModel.login(user);
    }

    /**
     * 使用第三方图片加载Glide加载图片
     * @param url
     * @param view
     */
    public void loadImage(String url, ImageView view) {
        userModel.loadImage(url,view);
    }
}
