package com.example.sh.morningtext.mvdesign.mvp.online.base;

/**
 *  presenter 基类
 *
 *  绑定\解绑BaseView
 *
 */
public abstract class BasePresenter<M,V> {

    public V view;
    public M model;

    /**
     * 绑定BaseView
     * @param view
     */
    public void attachView(V view){
        this.model = getModel();
        this.view = view;
    }

    /**
     * 解绑view
     */
    public void detachView(){
        view = null;
    }

    /**
     * 获取mode对象
     * @return
     */
    public abstract M getModel();


}
