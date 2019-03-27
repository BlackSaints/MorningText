package com.example.sh.morningtext;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;

import static org.junit.Assert.assertEquals;

public class DataMangerText {

    @Before
    public void setup() {
        RxJavaPlugins.reset();
        //设置Schedulers.io()返回的线程
        RxJavaPlugins.setIoSchedulerHandler(new Function<Scheduler, Scheduler>() {
            @Override
            public Scheduler apply(Scheduler scheduler) throws Exception {
                return Schedulers.trampoline();
            }
        });
    }

    @Test
    public void getData(){
         List<String> list = new ArrayList<>();
        DataManger dataManger = new DataManger();
        dataManger.getData().subscribe(new Observer<List<String>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<String> strings) {
                if(strings != null){
                    list.addAll(strings);
                }
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
//        dataManger.getData(new DataManger.ResponseCallback() {
//            @Override
//            public void success(List<String> data) {
//                list.addAll(data);
//            }
//
//            @Override
//            public void error(String error) {
//
//            }
//        });

        assertEquals(3,list.size());
    }

}
