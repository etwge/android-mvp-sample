package com.example.mvp.test.testandroidmvp;

/**
 * Author: lhy
 * Date: 2016/9/8
 */
public interface ILoginView {
    void showProgressDialog();

    /**
     *
     * @param result positive mean login success, otherwise
     */
    void loginResult(int result);

    void clear();
}
