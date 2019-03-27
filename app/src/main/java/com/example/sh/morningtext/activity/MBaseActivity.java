package com.example.sh.morningtext.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.example.sh.morningtext.utils.AppManger;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class MBaseActivity<T> extends AppCompatActivity {

    private AppManger appManger;
    private CompositeDisposable compositeDisposable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        appManger = AppManger.getInstance();
        appManger.addStack(this);
        compositeDisposable = new CompositeDisposable();
    }

    public void addDisposable(Disposable disposable){
        if(compositeDisposable == null){
            compositeDisposable = new CompositeDisposable();
        }

        compositeDisposable.add(disposable);
    }


    public void clearDisposable(){
        if(compositeDisposable != null){
            compositeDisposable.clear();
        }
    }

    public <T extends View> T  find(int id){
        T t = findViewById(id);
        return t;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        appManger.finishActivity(this.getClass());
        clearDisposable();
    }
}
