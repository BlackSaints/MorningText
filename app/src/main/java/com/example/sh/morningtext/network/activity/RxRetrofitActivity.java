package com.example.sh.morningtext.network.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sh.morningtext.R;
import com.example.sh.morningtext.network.bean.LoginRes;
import com.example.sh.morningtext.network.manger.HttpLoader;
import com.jakewharton.rxbinding2.view.RxView;
import com.jakewharton.rxbinding2.widget.RxTextView;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


public class RxRetrofitActivity extends AppCompatActivity {

    private EditText vPhone;
    private EditText vPwd;
    private Button vLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_net);

        initView();
    }

    private void initView() {

        vPhone = findViewById(R.id.et_phone);
        vPwd = findViewById(R.id.et_pwd);
        vLogin = findViewById(R.id.btn_login);

        vLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                HttpLoader loader = new HttpLoader();
                loader.login().subscribeOn(Schedulers.io())
                        .subscribe(new Observer<LoginRes>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(LoginRes loginRes) {
                                Log.e("RX","CODE");
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.e("RX","e"+e.toString());
                            }

                            @Override
                            public void onComplete() {
                                Log.e("RX","onComplete");
                            }
                        });
            }
        });

        Observable<CharSequence> mPhoneOb = RxTextView.textChanges(vPhone);
        Observable<CharSequence> mPwdOb = RxTextView.textChanges(vPwd);

        Observable.combineLatest(mPhoneOb, mPwdOb, new BiFunction<CharSequence, CharSequence, Boolean>() {
            @Override
            public Boolean apply(CharSequence charSequence, CharSequence charSequence2) throws Exception {
                return isPhone(charSequence) && isPwd(charSequence2);
            }
        }).subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {
                    RxView.enabled(vLogin).accept(aBoolean);
            }
        });

    }

    /**
     * 判断密码是否正确
     * @param charSequence2
     * @return
     */
    private Boolean isPwd(CharSequence charSequence2) {
        return charSequence2.length() >= 6;
    }

    /**
     * 判断手机号是否正确
     * @param charSequence
     * @return
     */
    private Boolean isPhone(CharSequence charSequence) {

        return charSequence.length() == 11;
    }
}
