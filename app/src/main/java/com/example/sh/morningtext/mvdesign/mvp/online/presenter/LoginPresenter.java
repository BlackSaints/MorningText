package com.example.sh.morningtext.mvdesign.mvp.online.presenter;

import com.example.sh.morningtext.mvdesign.mvp.online.base.BasePresenter;
import com.example.sh.morningtext.mvdesign.mvp.online.base.BaseView;
import com.example.sh.morningtext.mvdesign.mvp.online.callback.ComCallback;
import com.example.sh.morningtext.mvdesign.mvp.online.contract.LoginContract;
import com.example.sh.morningtext.mvdesign.mvp.online.model.LoginModel;
import com.example.sh.morningtext.mvdesign.mvp.online.view.OnlineMVPActivity;

public class LoginPresenter extends BasePresenter<LoginModel,OnlineMVPActivity> implements LoginContract.Presenter {


    @Override
    public LoginModel getModel() {
        return new LoginModel();
    }

    @Override
    public void login(String name, String pwd) {
        view.showLoading();
        model.login(name, pwd, new ComCallback<String>() {
            @Override
            public void success(String model) {
                view.showSuccess(model);
                view.dissLoading();
            }

            @Override
            public void error(String error) {
                view.showError(error);
                view.dissLoading();
            }
        });
    }
}
