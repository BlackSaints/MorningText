package com.example.sh.morningtext.network.service;

import com.example.sh.morningtext.network.bean.LoginRes;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface ApiService {

    /**
     * 登录
     * @return
     */
    @GET("app/services")
    Observable<LoginRes> login(@QueryMap HashMap<String,String> map);
}
