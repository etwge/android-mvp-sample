package com.example.mvp.test.testandroidmvp;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvp.test.testandroidmvp.presenter.ILoginPresenter;
import com.example.mvp.test.testandroidmvp.presenter.LoginPresenterImpl;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ILoginView{

    EditText userNameEdit;
    EditText passEdit;
    Button loginBtn;
    ILoginPresenter loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        passEdit = (EditText) findViewById(R.id.edit_password);
        userNameEdit = (EditText) findViewById(R.id.edit_user_name);

        loginBtn = (Button) findViewById(R.id.btn_login);
        loginBtn.setOnClickListener(this);
        loginPresenter = new LoginPresenterImpl(this);
    }

    @Override
    public void onClick(View v) {
        hideSoftKeyBroad();
        loginPresenter.doLogin(userNameEdit.getText().toString(), passEdit.getText().toString());
    }

    private void hideSoftKeyBroad() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

    ProgressDialog dialog;
    @Override
    public void showProgressDialog() {
        dialog = new ProgressDialog(this);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setCancelable(false);
        dialog.setIndeterminate(false);
        dialog.show();
    }

    @Override
    public void loginResult(final int result) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                dialog.dismiss();
                if(result >=0){
                    Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "登录失败", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
    @Override
    public void clear() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                userNameEdit.setText(null);
                passEdit.setText(null);
            }
        });
    }


}
