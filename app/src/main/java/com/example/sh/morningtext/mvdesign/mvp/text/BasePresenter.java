package com.example.sh.morningtext.mvdesign.mvp.text;

public class BasePresenter <V extends BaseView>{


    private V view;

    public void attachView(V view){
        this.view = view;
    }


    public void detachView(V view){
        view = null;
    }


    public boolean isAttachedView(){
        return view != null;
    }


    public V getView(){
        return view;
    }
}
