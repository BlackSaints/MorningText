package com.example.sh.morningtext.network.manger;

import com.example.sh.morningtext.network.bean.LoginRes;
import com.example.sh.morningtext.network.service.ApiService;

import java.util.HashMap;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class HttpLoader extends ObjectLoader {

    private final ApiService apiService;

    public HttpLoader(){
        apiService = RetrofitServiceManager.getIntance().creat(ApiService.class);
    }

    public  Observable<LoginRes> login(){
        HashMap<String,String> map = new HashMap();
//        OPT=123&_t=2018-12-18+11%3A01%3A00&body=&deviceType=2&mobile=13522531312&password=393194363C21A280&_s=17434dfc0dc86e065a8b404ac04b8749
        map.put("OPT","123");
        map.put("_t","2018-12-18+11%3A01%3A00");
        map.put("body","");
        map.put("deviceType","2");
        map.put("mobile","13522531312");
        map.put("password","393194363C21A280");
        map.put("_s","17434dfc0dc86e065a8b404ac04b8749");
            return observe(apiService.login(map));
    }

}
