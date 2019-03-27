package com.example.sh.morningtext.mvdesign.mvp.online.contract;

import com.example.sh.morningtext.mvdesign.mvp.online.base.BaseModel;
import com.example.sh.morningtext.mvdesign.mvp.online.base.BaseView;
import com.example.sh.morningtext.mvdesign.mvp.online.callback.ComCallback;

public interface LoginContract {

    interface Model {
        void login(String name, String pwd, ComCallback callback);
    }

    interface View extends BaseView{
        void showSuccess(String mes);

        void showError(String err);

        void showLoading();

        void dissLoading();
    }

    interface Presenter{
        void login(String name,String pwd);
    }
}
