package com.example.sh.morningtext.mvdesign.mvp.online.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.example.sh.morningtext.R;
import com.example.sh.morningtext.mvdesign.mvp.online.base.BaseMvpActivity;
import com.example.sh.morningtext.mvdesign.mvp.online.contract.LoginContract;
import com.example.sh.morningtext.mvdesign.mvp.online.presenter.LoginPresenter;

public class OnlineMVPActivity extends BaseMvpActivity<LoginPresenter> implements LoginContract.View {


    private ProgressDialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vlogin(view);
            }
        });
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_mvp_online;
    }

    @Override
    public void showSuccess(String mes) {
        Toast.makeText(this,mes,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError(String err) {
        Toast.makeText(this,err,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        dialog = new ProgressDialog(this);
        dialog.setMessage("登录中");
        dialog.show();
    }

    @Override
    public void dissLoading() {
        dialog.dismiss();
    }

    @Override
    public void setPresenter() {
        presenter = new LoginPresenter();
    }

    public void vlogin(View view){
        presenter.login("123","123");
    }
}
