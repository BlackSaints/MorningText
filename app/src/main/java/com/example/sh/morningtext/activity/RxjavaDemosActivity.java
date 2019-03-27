package com.example.sh.morningtext.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.sh.morningtext.R;
import com.example.sh.morningtext.bean.Translation;
import com.example.sh.morningtext.minterface.Api;
import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;
import java.sql.Time;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RxjavaDemosActivity extends MBaseActivity implements View.OnClickListener{

    private String mTag = "rxdemo";
    private String baseUrl1 = "http://fy.iciba.com/";
    private int mCurrentCount;
    private int maxCount = 3;
    private long waitTime ;

    private int i = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxdemo);

        Button btn_poll = findViewById(R.id.btn_poll);
        btn_poll.setOnClickListener(this);

        Button btn_poll1 = findViewById(R.id.btn_poll1);
        btn_poll1.setOnClickListener(this);

        Button btn_double = findViewById(R.id.btn_double);
        btn_double.setOnClickListener(this);

        Button btn_errtry = findViewById(R.id.btn_errtry);
        btn_errtry.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_poll:
                poll();
                break;
            case R.id.btn_poll1:
                poll1();
                break;
            case R.id.btn_double:
                doubleReq();
                break;
            case R.id.btn_errtry:
                errotry();
                break;
        }
    }

    /**
     * 有条件网络请求轮询
     * 操作符 repetWhen
     */
    private void poll1() {
        final HashMap<String,String> data = new HashMap<>();
        data.put("a","fy");
        data.put("f","auto");
        data.put("t","auto");
        data.put("w","hello%20world");

        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl1)
                .build();

        Api api = retrofit.create(Api.class);

        Observable<Translation> observable = api.getPoll(data);

        observable
                .repeatWhen(new Function<Observable<Object>, ObservableSource<?>>() {
                    @Override
                    public ObservableSource<?> apply(Observable<Object> objectObservable) throws Exception {
                        return objectObservable.flatMap(new Function<Object, ObservableSource<?>>() {
                            @Override
                            public ObservableSource<?> apply(Object o) throws Exception {
                                if(i < 3 ){
                                    return Observable.just(1).delay(3,TimeUnit.SECONDS);
                                }else{
                                    return Observable.error(new Throwable("轮询结束"));
                                }
                            }
                        });
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Translation>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Translation translation) {
                        translation.show();
                        i++;
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(mTag,"接收到错误事件"+e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });



    }

    /**
     * 利用操作符 错误重连
     */
    private void errotry() {

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(baseUrl1)
                .build();

        Api api = retrofit.create(Api.class);

        final Observable<Translation> observable = api.getError();

        observable.retryWhen(new Function<Observable<Throwable>, ObservableSource<?>>() {
            @Override
            public ObservableSource<?> apply(final Observable<Throwable> throwableObservable) throws Exception {
                return throwableObservable.flatMap(new Function<Throwable, ObservableSource<?>>() {
                    @Override
                    public ObservableSource<?> apply(Throwable throwable) throws Exception {
                        Log.e(mTag,"发生异常："+throwable.toString());
                        //判断异常类型
                        if(throwable instanceof IOException){
                            if(mCurrentCount < maxCount){
                                mCurrentCount++;
                                Log.e(mTag,"错误重试次数"+mCurrentCount);

                                waitTime = 1000+mCurrentCount*1000;
                                Log.e(mTag,"错误重试等待时间"+waitTime);
                                return Observable.just(1).delay(waitTime, TimeUnit.MILLISECONDS);
                            }else{
                                return Observable.error(new Throwable("错误重试次数达到上限"));
                            }

                        }else{
                            Log.e(mTag,"异常非IO异常");
                            return Observable.error(new Throwable("异常非IO异常"));
                        }

                    }
                });
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Translation>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(mTag,"onSubscribe");
                    }

                    @Override
                    public void onNext(Translation translation) {
                        Log.e(mTag,"onNext");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(mTag,"onError接收到异常信息"+e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.e(mTag,"onComplete");
                    }
                });

    }

    /**
     * 网络嵌套请求
     * 先注册在登陆
     */
    private void doubleReq() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl1)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        final Observable<Translation> loginObservable = api.getLogin();
        Observable<Translation> registerObservable = api.getRegister();

        registerObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<Translation>() {
                    @Override
                    public void accept(Translation translation) throws Exception {
                        Log.e(mTag,"第一次网络请求成功");
                        translation.show();
                 }
                })
                .observeOn(Schedulers.io())
                .flatMap(new Function<Translation, ObservableSource<Translation>>() {
                    @Override
                    public ObservableSource<Translation> apply(Translation translation) throws Exception {
                        Log.e(mTag,"  ");
                        return loginObservable;
                    }
                }).subscribe(new Observer<Translation>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(Translation translation) {
                                ;
                                Log.e(mTag,"第二次网络请求成功");

                                translation.show();
                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onComplete() {

                            }
                        });



    }

    /**
     * 网络请求轮询
     */
    public void poll(){

        final HashMap<String,String> data = new HashMap<>();
        data.put("a","fy");
        data.put("f","auto");
        data.put("t","auto");
        data.put("w","hello%20world");

        //1 每隔1秒发送一次请求
        Observable.interval(2,1, TimeUnit.SECONDS)
                .doOnNext(new Consumer<Long>() {
                            @Override
                            public void accept(Long aLong) throws Exception {
                                Log.d(mTag, "第 " + aLong + " 次轮询" );
                                //网络请求
                                Retrofit retrofit = new Retrofit.Builder()
                                        .baseUrl(baseUrl1)
                                        .addConverterFactory(GsonConverterFactory.create())
                                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                                        .build();

                        Api api = retrofit.create(Api.class);

                        Observable<Translation> observable = api.getPoll(data);

                        observable.subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new Observer<Translation>() {
                                    @Override
                                    public void onSubscribe(Disposable d) {

                                    }

                                    @Override
                                    public void onNext(Translation translation) {
                                        translation.show();
                                    }

                                    @Override
                                    public void onError(Throwable e) {

                                    }

                                    @Override
                                    public void onComplete() {

                                    }
                                });
                    }
                }).subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Long aLong) {
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
