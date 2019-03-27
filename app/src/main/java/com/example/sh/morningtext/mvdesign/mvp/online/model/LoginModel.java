package com.example.sh.morningtext.mvdesign.mvp.online.model;

import com.example.sh.morningtext.mvdesign.mvp.online.base.BaseModel;
import com.example.sh.morningtext.mvdesign.mvp.online.callback.ComCallback;
import com.example.sh.morningtext.mvdesign.mvp.online.contract.LoginContract;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginModel extends BaseModel implements LoginContract.Model {


    @Override
    public void login(String name, String pwd, final ComCallback callback) {
        Observable.timer(3, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Long aLong) {
                        callback.success("登录成功");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
