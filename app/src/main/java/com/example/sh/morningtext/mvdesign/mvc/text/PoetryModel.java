package com.example.sh.morningtext.mvdesign.mvc.text;

import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;


import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * MVC MODEL层
 *
 * 处理网络请求
 */
public class PoetryModel {


    public static void getData(final ResponseListener listener){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.apiopen.top")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        Mservice mservice = retrofit.create(Mservice.class);
        Observable<PortryBean> observable =  mservice.getData();
        observable.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Observer<PortryBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(PortryBean  portryBean) {
                listener.accept(portryBean);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("mvc","出错了"+e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });

    }

}


interface ResponseListener{
    void accept(PortryBean bean);
}