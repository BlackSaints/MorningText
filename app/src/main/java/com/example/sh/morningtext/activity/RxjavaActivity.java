package com.example.sh.morningtext.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.sh.morningtext.R;
import com.jakewharton.rxbinding2.view.RxView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import io.reactivex.Notification;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.operators.observable.ObservableFromCallable;
import io.reactivex.internal.operators.observable.ObservableLift;
import io.reactivex.schedulers.Schedulers;


public class RxjavaActivity extends MBaseActivity{

    String[] names = {"rose","tim","dog"};
    String mTAG = "rxjava";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava);
//        showNames1();
//        showNames2();
//        showImg();
//        flatMap();
        rxjava2();
//        rxbinding();
    }

    /**
     * rxbinding
     */
    private void rxbinding() {
        Button btn_sure = findViewById(R.id.btn);
        RxView.clicks(btn_sure).throttleFirst(2,TimeUnit.SECONDS).subscribe(new Consumer<Object>() {
            @Override
            public void accept(Object o) throws Exception {
                Log.e(mTAG,"我被点击了,2秒防抖 ");
            }
        });
    }

    private void rxjava2() {
        //创建形
//        creatRx();
//        justRx();
//        fromArrayRx();
//        fromIterableRx();
//        deferRx();
//        timerRx();
//        intervalRx();

        //转换型
//         mapRx();
//        flatMapRx();
//        concatMapRx();
//        bufferRx();

        //组合型
//        concatRx();
//        mergeRx();
//        concatDelayErrorRx();
//        cacheDemo();
//        inputDemo();
//        doRx();

        //布尔形
//        allRx();
//        takeWhileRx();
//        skipWhileRx();
//        sequenceEqualRx();
//        containsRx();
//        defaultIfEmptyRx();

        //过滤形
//        filterRx();
//        ofTypeRx();
//        skipRx();
//        distinctRx();
//        distinctUntilChangedRx();
//        takeRx();
//        throttleFirstRx();

    }

    /**
     * 操作符 throttleFirst
     *
     * 发送指定时间第一个事件
     */
    private void throttleFirstRx() {

        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("我被点击了1");
                Thread.sleep(100);
                emitter.onNext("我被点击了2");
                Thread.sleep(100);
                emitter.onNext("我被点击了3");
                Thread.sleep(100);
                emitter.onComplete();
            }
        }).throttleFirst(2,TimeUnit.SECONDS)
                .subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.e(mTAG,s);
            }
        });

    }

    /**
     * 操作符 take
     *
     * 按照事件数量筛选
     */
    private void takeRx() {

        Observable.just(1,2,3,4)
                .take(2)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e(mTAG,"take "+integer);
                    }
                });

    }

    /**
     * 操作符 distinct
     *
     * 过滤 连续重复事件
     */
    private void distinctUntilChangedRx() {
        Observable.just(1,1,3,3,4,5,6)
                .distinctUntilChanged()
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e(mTAG,"distinctUntilChanged"+integer);
                    }
                });
    }

    /**
     * 操作符 distinct
     *
     * 过滤 重复事件
     */
    private void distinctRx() {

        Observable.just(1,2,3,3,2,4)
                    .distinct()
                    .subscribe(new Consumer<Integer>() {
                        @Override
                        public void accept(Integer integer) throws Exception {
                            Log.e(mTAG,"distinct"+integer);
                        }
                    });

    }

    /**
     * 操作符 skip
     *
     * 跳过指定事件
     */
    private void skipRx() {

        Observable.just(1,2,3)
                .skip(1)
                .skipLast(1)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e(mTAG,"skip"+integer);
                    }
                });

    }

    /**
     * 操作符 ofType
     *
     * 过滤指定类型
     */
    private void ofTypeRx() {

        ObservableLift.just(1,"tom","dog")
                .ofType(String.class)
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Log.e(mTAG,s);
                    }
                });
    }

    /**
     * 操作符 filter
     *
     * 过滤制定条件
     */
    private void filterRx() {
        Observable.just(1,2,3,4,5)
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        return i<3;
                    }
                }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.e(mTAG,integer.toString());
            }
        });

    }

    /**
     * 操作符 defaultIfEmpty
     *
     * 不发送任何next事件 默认添加一个有效事件
     */
    private void defaultIfEmptyRx() {

        Observable.empty().defaultIfEmpty(10)
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Object o) {
                        Log.e(mTAG,"defalut = "+o.toString());
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
     * 操作符 contains
     *
     * 判断发送的数据是否包含 某个数据
     */
    private void containsRx() {
        Observable.just(1,2,3,4)
                .contains(1)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        Log.e(mTAG,"是否包含4  "+aBoolean);
                    }
                });


    }

    /**
     * 操作符 SequenceEqual
     *
     * 判断两个observerable 发送的事件是否相同
     *
     * 相同 true 不相同 false
     */
    private void sequenceEqualRx() {

        Observable.sequenceEqual(Observable.just(1,2,3),Observable.just(1,2,3))
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        Log.e(mTAG,"发送的数据是否相同"+aBoolean);
                    }
                });

    }

    /**
     * 操作符 takeWhile
     *
     * 和takeWhile相反  不满足条件的才发送数据
     */
    private void skipWhileRx() {

        Observable.just(1,2,3,4,5,6,7)
                .skipWhile(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        return integer < 3;
                    }
                }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {
                Log.e(mTAG,"满足条件的数据是  "+integer);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                Log.e(mTAG,"-------------------");
            }
        });

    }

    /**
     * 操作符 takeWhile
     *
     * 判断单个数据是否满足设置的条件
     *
     * 满足发送 不满足 不发送
     */
    private void takeWhileRx() {
        Observable.interval(1,TimeUnit.SECONDS)
                .takeWhile(new Predicate<Long>() {
                    @Override
                    public boolean test(Long aLong) throws Exception {
                        return aLong < 3;
                    }
                }).subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Long aLong) {
                Log.e(mTAG,"满足条件的数据是"+aLong);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                Log.e(mTAG,"-------------------");
            }
        });

    }

    /**
     * 操作符all
     * 判断每项数据是否都满足设置的函数条件
     *
     * 满足true 不满足false
     */
    private void allRx() {

        Observable.just(1,2,3,4)
                .all(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        return integer > 3;
                    }
                }).subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {
                Log.e(mTAG,"条件是否满足"+aBoolean);
            }



        });

    }

    /**
     * 操作符 doxx
     *
     * 用于发送事件前&接收事件后调用
     */
    private void doRx() {

        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("observable发送事件1");
                emitter.onNext("observable发送事件2");
                emitter.onError(new Throwable("错误来了"));
                emitter.onComplete();
            }
        }).doOnEach(new Consumer<Notification<String>>() {
            @Override
            public void accept(Notification<String> stringNotification) throws Exception {
                Log.e(mTAG,"doOnEach======"+stringNotification);
            }
        }).doOnNext(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.e(mTAG,"doOnNext======"+s);
            }
        }).doAfterNext(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.e(mTAG,"doAfterNext======"+s);
            }
        }).doOnComplete(new Action() {
            @Override
            public void run() throws Exception {
                Log.e(mTAG,"doOnComplete======");
            }
        }).doOnError(new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Log.e(mTAG,"doOnError======"+throwable.getMessage());
            }
        }).doOnSubscribe(new Consumer<Disposable>() {
            @Override
            public void accept(Disposable disposable) throws Exception {
                Log.e(mTAG,"doOnSubscribe======"+disposable.isDisposed());
            }
        }).doAfterTerminate(new Action() {
            @Override
            public void run() throws Exception {
                Log.e(mTAG,"doAfterTerminate======");
            }
        }).doFinally(new Action() {
            @Override
            public void run() throws Exception {
                Log.e(mTAG,"doFinally======");
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e(mTAG,"onSubscribe======");
            }

            @Override
            public void onNext(String s) {
                Log.e(mTAG,"onNext======"+s);
            }

            @Override
            public void onError(Throwable e) {
                Log.e(mTAG,"onError======"+e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.e(mTAG,"onComplete======");
            }
        });
    }

    /**
     * 联合判断
     */
    private void inputDemo() {
        final EditText et1 = findViewById(R.id.et_1);
        final EditText et2 = findViewById(R.id.et_2);
        final EditText et3 = findViewById(R.id.et_3);
        final Button btn = findViewById(R.id.btn);
        btn.setEnabled(false);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RxjavaActivity.this,"点中了",Toast.LENGTH_SHORT).show();
            }
        });

        Observable<Boolean> ob1 = Observable.defer(new Callable<ObservableSource<? extends Boolean>>() {
            @Override
            public ObservableSource<? extends Boolean> call() throws Exception {
                if(!TextUtils.isEmpty(et1.getText().toString())){
                    return Observable.just(true);
                }else{
                    return Observable.just(false);
                }
            }
        });

        Observable<Boolean> ob2 = Observable.defer(new Callable<ObservableSource<? extends Boolean>>() {
            @Override
            public ObservableSource<? extends Boolean> call() throws Exception {
                if(!TextUtils.isEmpty(et2.getText().toString())){
                    return Observable.just(true);
                }else{
                    return Observable.just(false);
                }
            }
        });

        Observable<Boolean> ob3 = Observable.defer(new Callable<ObservableSource<? extends Boolean>>() {
            @Override
            public ObservableSource<? extends Boolean> call() throws Exception {
                if(!TextUtils.isEmpty(et3.getText().toString())){
                    return Observable.just(true);
                }else{
                    return Observable.just(false);
                }
            }
        });

        Observable.combineLatest(ob1, ob2, ob3, new Function3<Boolean, Boolean, Boolean, Boolean>() {
            @Override
            public Boolean apply(Boolean aBoolean, Boolean aBoolean2, Boolean aBoolean3) throws Exception {
                return aBoolean&&aBoolean2&&aBoolean3;
            }
        }).subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean)      throws Exception {
                if(aBoolean)
                    btn.setEnabled(true);
            }
        });
    }

    /**
     * 获取缓存 内存-磁盘-网络
     */
    private void cacheDemo() {

        final String memoryCache = null;
        final String diskCache = "磁盘";

         Observable<String> memoryObservable = Observable.create(new ObservableOnSubscribe<String>() {
             @Override
             public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                  if(memoryCache != null){
                     emitter.onNext(memoryCache);
                 }else{
                     emitter.onComplete();
                 }
             }
         });

        Observable<String> diskObservable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                if(diskCache != null){
                    emitter.onNext(diskCache);
                }else{
                    emitter.onComplete();
                }
            }
        });

        Observable<String> netWorkObservable = Observable.just("网络");


        Observable.concat(memoryObservable,diskObservable,netWorkObservable)
                .firstElement()
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Log.e(mTAG,"数据来源于======"+s);
                    }
                });
    }

    /**
     * 操作符 concatDealyError
     *
     * 防止一个事件发出error错误 影响其他被观察者发送事件
     *
     */
    private void concatDelayErrorRx() {

        Observable.concatArrayDelayError(Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onError(new NullPointerException());
                emitter.onComplete();
            }
        }),Observable.just(3,4,5))
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(mTAG,"onSubscribe---------");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.e(mTAG,"接收到的事件信息是"+integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(mTAG,"onError---------");
                    }

                    @Override
                    public void onComplete() {
                        Log.e(mTAG,"onComplete---------");
                    }
                });
    }

    /**
     * 操作符merge
     *
     * 合并被观察者，并行发送事件
     */
    private void mergeRx() {

        Observable.merge(Observable.intervalRange(0,3,1,1,TimeUnit.SECONDS),
                Observable.intervalRange(2,3,1,1,TimeUnit.SECONDS))
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        Log.e(mTAG,"接收到的数据是"+aLong);
                    }
                });
    }

    /**
     * 操作符 concat
     *
     * 合并被观察者，按顺序一并发送
     */
    private void concatRx() {

        Observable.concat(Observable.just(1,2,3),
                Observable.just(4,5,6),
                Observable.just(7,8,9))
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e(mTAG,"接收到的信息是="+integer);
                    }
                });
    }

    /**
     * 操作符buffer
     * 作用
     * 设置一个缓冲区，并定期从被观察者发送的事件中缓存到缓冲区
     */
    private void bufferRx() {

        Observable.just(1,2,3,4,5)
                .buffer(3,1)
                .subscribe(new Observer<List<Integer>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Integer> integers) {
                        Log.e(mTAG,"缓存区事件数量"+integers.size());
                        Log.e(mTAG,"-------------------------");
                        for (int j = 0; j < integers.size(); j++) {
                            Log.e(mTAG,"缓存内容"+integers.get(j));
                        }

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
     * 操作符concatMap
     * 作用
     * 对原始事件进行拆分，合成新的事件
     * 和flatmap区别在于重新拆分的事件序列顺序不变
     */
    private void concatMapRx() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
            }
        }).concatMap(new Function<Integer, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(Integer integer) throws Exception {
                List<String> list = new ArrayList<>();
                for (int j = 0; j < 3; j++) {
                    list.add("我是事件"+integer+"的第"+j+"个子事件");
                }
                int delay = 0;
                if(integer == 1){
                    delay = 5;//延迟500ms发射
                }
                return Observable.fromIterable(list).delay(delay,TimeUnit.SECONDS);
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.e(mTAG,s);
            }
        });

    }

    /**
     * 操作符flatmap
     * 作用
     * 对原始事件进行拆分，合成新的事件
     */
    private void flatMapRx() {

        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
//                emitter.onComplete();
            }
        }).flatMap(new Function<Integer, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(Integer integer) throws Exception {
                List<String> list = new ArrayList<>();
                for (int j = 0; j < 3; j++) {
                    list.add("我是事件"+integer+"的第"+j+"个子事件");
                }
                int delay = 0;
                if(integer == 1){
                    delay = 5;//延迟500ms发射
                }
                return Observable.fromIterable(list).delay(delay,TimeUnit.SECONDS);
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                Log.e(mTAG,s);
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
     * 操作符interval
     * 作用
     * 快速创建1个被观察者对象（Observable）
     * 发送事件的特点：每隔指定时间 就发送 事件
     * 发送的事件序列 = 从0开始、无限递增1的的整数序列
     */
    private void intervalRx() {

        Observable.interval(3,TimeUnit.SECONDS).subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Long aLong) {
                Log.e(mTAG,"接收到的参数"+aLong);
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
     * 操作符timer
     * 本质 = 延迟指定时间后，调用一次 onNext(0)
     * 作用
     */

    private void timerRx() {

        Observable.timer(5, TimeUnit.SECONDS).subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Long aLong) {
                Log.e(mTAG,"timer"+aLong);
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
     * 操作符defer
     * 延时创建
     * 作用
     * 直到有观察者（Observer ）订阅时，才动态创建被观察者对象（Observable） & 发送事件
     * 通过 Observable工厂方法创建被观察者对象（Observable）
     * 每次订阅后，都会得到一个刚创建的最新的Observable对象，这可以确保Observable对象里的数据是最新的
     */
    Integer i = 10;
    private void deferRx() {

       Observable<Integer> observable = Observable.defer(new Callable<ObservableSource<? extends Integer>>() {
           @Override
           public ObservableSource<? extends Integer> call() throws Exception {
               return Observable.just(i);
           }
       });

        i = 15;

        observable.subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {
                Log.e(mTAG,"onNext="+integer);
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
     * 操作符fromIterableRx
     * 作用
     * 快速创建1个被观察者对象（Observable）
     * 发送事件的特点：直接发送 传入的集合List数据
     * 会将数组中的数据转换为Observable对象
     */
    private void fromIterableRx() {
        List<String> fas = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            fas.add(String.valueOf(i));
        }

        Observable.fromIterable(fas).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                Log.e(mTAG,s);
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
     * 操作符fromArray
     * 快速创建1个被观察者对象（Observable）
     * 发送事件的特点：直接发送 传入的数组数据
     * 会将数组中的数据转换为Observable对象
     */
    private void fromArrayRx() {

        List<String> fas = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            fas.add(String.valueOf(i));
        }
        Observable.fromArray(fas).subscribe(new Observer<List<String>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<String> strings) {

                for (int i = 0; i < strings.size(); i++) {
                    Log.e(mTAG,strings.get(i));
                }
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

        Observable.fromArray(names).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                Log.e(mTAG,"\n");
                Log.e(mTAG,s);
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
     * 操作符just
     * 快速创建1个被观察者对象（Observable）
     * 发送事件的特点：直接发送 传入的事件
     * 注：最多只能发送10个参数
     */
    private void justRx() {

        Observable.just(1,2,3,4)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.e(mTAG,"onNext"+integer);
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
     * 操作符map
     * 用于事件返回类型转换
     * 数据类型转换
     */
    private void mapRx() {

        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
            }
        }).map(new Function<Integer, String>() {
            @Override
            public String apply(Integer s) throws Exception {
                return "map"+String.valueOf(s);
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e(mTAG,"onSubscribe"+d.isDisposed());
            }

            @Override
            public void onNext(String s) {
                Log.e(mTAG,"onNext"+"  "+s);
            }

            @Override
            public void onError(Throwable e) {
                Log.e(mTAG,"onError");
            }

            @Override
            public void onComplete() {
                Log.e(mTAG,"onComplete");
            }
        });
    }

    /**
     * 操作符creat
     * 用于创建一个observable
     */
    private void creatRx() {

        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                for (int i = 0; i < names.length; i++) {
                    emitter.onNext(names[i]);
                }
                emitter.onComplete();
            }
            }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    private int i;
                    private Disposable disposable;
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(mTAG,"onSubscribe");
                        Log.e(mTAG,"onSubscribe Disposable="+d.isDisposed());
                        disposable = d;
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(mTAG,"onNext");
                        Log.e(mTAG,s);
                        i++;
                        if(i==1){
                            disposable.dispose();
                            Log.e(mTAG,"onNext Disposable="+disposable.isDisposed());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        Log.e(mTAG,"onComplete");
                    }
                });
    }

//    private void flatMap() {
//        List<Student> students = new ArrayList<>();
//        for (int i = 0; i < 3; i++) {
//            Student student = new Student();
//            student.setName("name"+i);
//            String[] courses = new String[]{"courses"+i,"courses"+i+1};
//            student.setCourse(courses);
//            students.add(student);
//        }
//
//
//        Observable.from(students)
//                .flatMap(new Func1<Student, Observable<String>>() {
//                    @Override
//                    public Observable<String> call(Student student) {
//
//                        return Observable.from(student.getCourse());
//                    }
//                })
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Action1<String>() {
//                    @Override
//                    public void call(String s) {
//                        Log.e("Rxjava",s);
//                    }
//                });
//
//    }
//
//    private void showImg() {
//        final ImageView img = findViewById(R.id.rx_img);
//
//        Observable.create(new Observable.OnSubscribe<Drawable>() {
//            @Override
//            public void call(Subscriber<? super Drawable> subscriber) {
//                Drawable drawable = getResources().getDrawable(R.drawable.s_2);
//                subscriber.onNext(drawable);
//                subscriber.onCompleted();
//            }
//        }).subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Drawable>() {
//            @Override
//            public void onCompleted() {
//                Toast.makeText(RxjavaActivity.this, "加载完成", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Toast.makeText(RxjavaActivity.this, "加载失败", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onNext(Drawable drawable) {
//
//                img.setImageDrawable(drawable);
//            }
//        });
//
//    }
//
//    private void showNames2() {
//        Observable.from(names).subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
//                Log.e("rxjava",s);
//            }
//        });
//    }
//
//    private void showNames1() {
//        Observable.create(new Observable.OnSubscribe<String>() {
//            @Override
//            public void call(Subscriber<? super String> subscriber) {
//                for (int i = 0; i < names.length; i++) {
//                    subscriber.onNext(names[i]);
//                }
//
//                subscriber.onCompleted();
//            }
//        }).subscribe(new Observer<String>() {
//            @Override
//            public void onCompleted() {
//                Log.e("rxjava","onCompleted");
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onNext(String s) {
//                Log.e("rxjava",s);
//            }
//        });
//    }

     class Student {

        public String name;
        public String[] course;

         public String getName() {
             return name == null ? "" : name;
         }

         public void setName(String name) {
             this.name = name;
         }

         public String[] getCourse() {
             return course;
         }

         public void setCourse(String[] course) {
             this.course = course;
         }
     }
}
