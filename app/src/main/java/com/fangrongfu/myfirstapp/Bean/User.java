package com.fangrongfu.myfirstapp.Bean;

/**
 * 作者：方荣福
 * 实体类
 */
public class User {
    //账号
    private String name;

    //密码
    private String password;

    //构造函数
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    //get和set
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
