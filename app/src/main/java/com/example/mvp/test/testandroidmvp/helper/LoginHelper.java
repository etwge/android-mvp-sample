package com.example.mvp.test.testandroidmvp.helper;

import com.example.mvp.test.testandroidmvp.model.IUser;
import com.example.mvp.test.testandroidmvp.model.UserModel;

import java.util.Random;

/**
 * Author: lhy
 * Date: 2016/9/8
 */
public class LoginHelper {

    public interface LoginCallBack{
        void onSuccess();
        void onError();
    }
    public static void login(IUser userModel, final LoginCallBack callBack){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                }catch (Exception ex){
                    callBack.onError();
                }
                if(new Random().nextInt(10) > 2){
                    callBack.onSuccess();
                }else {
                    callBack.onError();
                }
            }
        }).start();
    }
}
