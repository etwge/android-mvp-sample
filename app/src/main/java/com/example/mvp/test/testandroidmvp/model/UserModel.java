package com.example.mvp.test.testandroidmvp.model;

import android.text.TextUtils;

/**
 * Author: lhy
 * Date: 2016/9/8
 */
public class UserModel implements IUser {

    public String userName;
    public String password;

    public UserModel(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public boolean checkIsValid() {
        return !(TextUtils.isEmpty(userName) || TextUtils.isEmpty(password));
    }
}
