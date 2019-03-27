package com.example.sh.morningtext.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.example.sh.morningtext.R;
import com.jakewharton.rxbinding2.view.RxView;
import com.jakewharton.rxbinding2.widget.RxTextView;
import com.jakewharton.rxbinding2.widget.TextViewEditorActionEvent;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;

public class RxBindingActivity extends MBaseActivity {

    private String mTag = "RxBindingActivity";

    private int MAXSECOND = 20;
    private Button btn_click;
    private Button btn_code;
    private Observable<Object> codeObservable;
    private EditText et_username;
    private EditText et_pwd;
    private Button btn_sure;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_binding);

        btn_click = findViewById(R.id.btn_click);
        btn_code = findViewById(R.id.btn_code);

        et_username = findViewById(R.id.et_username);
        et_pwd = findViewById(R.id.et_pwd);

        btn_sure = findViewById(R.id.btn_sure);
        click1();

        click2();

        click3();
    }

    /**
     * 表单验证
     */
    private void click3() {

        Observable<CharSequence> ob1 = RxTextView.textChanges(et_username);
        Observable<CharSequence> ob2 = RxTextView.textChanges(et_pwd);

        Observable.combineLatest(ob1, ob2, new BiFunction<CharSequence, CharSequence, Boolean>() {
            @Override
            public Boolean apply(CharSequence charSequence, CharSequence charSequence2) throws Exception {
                return isPhone(charSequence) && isPwd(charSequence2);
            }
        }).subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean o) throws Exception {
                RxView.enabled(btn_sure).accept(o);
            }
        });
    }

    private boolean isPwd(CharSequence charSequence2) {
        return charSequence2.length() >= 6;
    }

    private boolean isPhone(CharSequence charSequence) {
        return charSequence.length() == 11;
    }

    /**
     * 发送验证码
     */
    private void click2() {

        codeObservable = RxView.clicks(btn_code)
                 .throttleFirst(MAXSECOND, TimeUnit.SECONDS)
                 .subscribeOn(AndroidSchedulers.mainThread())
                 .doOnNext(new Consumer<Object>() {
                     @Override
                     public void accept(Object o) throws Exception {
                         RxView.enabled(btn_code).accept(false);
                     }
                 });


        codeObservable.subscribe(new Observer<Object>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object o) {
                Observable.intervalRange(0,MAXSECOND+1,0,1,TimeUnit.SECONDS,AndroidSchedulers.mainThread())
                        .subscribe(new Observer<Long>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(Long aLong) {

                                try {
                                    RxTextView.text(btn_code).accept(MAXSECOND - aLong+"s");
                                    RxView.enabled(btn_code).accept(false);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onComplete() {
                                CharSequence c = "重新发送";
                                try {
                                    RxTextView.text(btn_code).accept(c);
                                    RxView.enabled(btn_code).accept(true);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
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
     * 防抖点击
     */
    private void click1() {

        addDisposable(RxView.clicks(btn_click)
                .throttleFirst(2, TimeUnit.SECONDS)
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        Log.e(mTag,"防抖点击");
                    }
                }));
        RxView.longClicks(btn_click).subscribe(new Consumer<Object>() {
            @Override
            public void accept(Object o) throws Exception {
                     Log.e(mTag,"长按点击");
            }
        });
    }
}
