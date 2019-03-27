package com.example.sh.morningtext.mvdesign.mvc.text;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Mservice {

    @GET("/singlePoetry")
    Observable<PortryBean> getData();
}
