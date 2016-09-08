package com.example.mvp.test.testandroidmvp.presenter;

import com.example.mvp.test.testandroidmvp.ILoginView;
import com.example.mvp.test.testandroidmvp.helper.LoginHelper;
import com.example.mvp.test.testandroidmvp.model.IUser;
import com.example.mvp.test.testandroidmvp.model.UserModel;

/**
 * Author: lhy
 * Date: 2016/9/8
 */
public class LoginPresenterImpl implements ILoginPresenter {

    IUser user;
    ILoginView loginView;

    public LoginPresenterImpl(ILoginView loginView){
        this.loginView = loginView;
    }

    @Override
    public void doLogin(final String userName, String password) {
        int result = -1;
        user = new UserModel(userName, password);
        loginView.showProgressDialog();
        if(user.checkIsValid()){
            LoginHelper.login(user, new LoginHelper.LoginCallBack(){
                @Override
                public void onSuccess(){
                    loginView.loginResult(1);
                }

                @Override
                public void onError(){
                    loginView.loginResult(-1);
                }
            });
        }else {
            loginView.loginResult(result);
        }

    }

    @Override
    public void clear() {
        loginView.clear();
    }

    @Override
    public void loginResult() {

    }
}
