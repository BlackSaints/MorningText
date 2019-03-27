package com.example.sh.morningtext.mvdesign.mvp.online.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public abstract class BaseMvpActivity<P extends BasePresenter> extends AppCompatActivity implements BaseView {

    protected P presenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        initData();
    }

    private void initData() {
        if(this instanceof BaseView){
            this.setPresenter();
            if(presenter != null){
                presenter.attachView(this);
            }
            Log.d("mvp","presenter attach view");
        }else{
            Log.e("mvp","this view not BaseView");
        }
    }


    @Override
    protected void onDestroy() {
        if(presenter != null){
            presenter.detachView();
        }
        super.onDestroy();
    }

    /**
     * 获取Activity 布局文件
     * @return
     */
    public abstract int getLayoutID();

}
