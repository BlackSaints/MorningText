package com.example.sh.morningtext.mvdesign.mvp.text;

import com.example.sh.morningtext.mvdesign.mvc.text.Mservice;
import com.example.sh.morningtext.mvdesign.mvc.text.PortryBean;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainModel implements MainContract.Model {
    @Override
    public Observable<PortryBean> getData() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("https://api.apiopen.top")
                .build();

        Mservice mservice = retrofit.create(Mservice.class);

        return mservice.getData();
    }
}
