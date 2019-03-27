package com.example.sh.morningtext.minterface;


import com.example.sh.morningtext.bean.Person;
import com.example.sh.morningtext.bean.Translation;


import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;


/**
 * retrofit 接口类
 *
 * 存放请求接口
 */
public interface Api {

    @GET("5284/text")
    Call<Person> getPerson();

    @GET("ajax.php")
    Observable<Translation> getPoll(@QueryMap HashMap<String,String> data);

    @GET("ajax.php?a=fy&f=auto&t=auto&w=hi%20login")
    Observable<Translation> getLogin();

    @GET("ajax.php?a=fy&f=auto&t=auto&w=hi%20register")
    Observable<Translation> getRegister();

    @GET("ajax.php?a=fy&f=auto&t=auto&w=hi%20error")
    Observable<Translation> getError();
}
