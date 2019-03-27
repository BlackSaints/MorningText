package com.example.sh.morningtext.network.manger;

import com.example.sh.morningtext.network.interceptor.LoggerInterceptor;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.sql.BatchUpdateException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitServiceManager {

    private static final int DEFAULT_TIME_OUT = 5;//超时时间 5s
    private static final int DEFAULT_READ_TIME_OUT = 10;
    private final Retrofit retrofit;

    private RetrofitServiceManager(){

        // 创建 OKHttpClient

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIME_OUT,TimeUnit.SECONDS);
        builder.readTimeout(DEFAULT_READ_TIME_OUT, TimeUnit.SECONDS);
        builder.writeTimeout(DEFAULT_READ_TIME_OUT,TimeUnit.SECONDS);
        // 添加公共参数拦截器
        builder.addInterceptor( new LoggerInterceptor());


        // 创建Retrofit
        retrofit = new Retrofit.Builder()
                .baseUrl(ApiConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(builder.build())
                .build();

    }

    /**
     * 对外获取manger入口
     * @return
     */
    public static RetrofitServiceManager getIntance(){
        return SingletonHolder.manger;
    }

    /**
     * 单例模式获取manger
     */
    private static class SingletonHolder{
        private static final RetrofitServiceManager manger = new RetrofitServiceManager();
    }

    /**
     * @param service
     * @param <T>
     * @return
     */
    public <T> T creat(Class<T> service){
        return retrofit.create(service);
    }
}
