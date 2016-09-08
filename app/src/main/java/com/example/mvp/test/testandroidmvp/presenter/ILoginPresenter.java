package com.example.mvp.test.testandroidmvp.presenter;

/**
 * Author: lhy
 * Date: 2016/9/8
 */
public interface ILoginPresenter {
    void doLogin(String userName, String password);
    void clear();
    void loginResult();
}
