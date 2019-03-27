package com.example.sh.morningtext.mvdesign.mvp.text;

/**
 * view 层基类
 */
public interface BaseView {

    void showLoading();

    void dissLoading();

    void showError(String error);

}
