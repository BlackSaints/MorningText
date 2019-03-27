package com.example.sh.morningtext.mvdesign.mvp.online.callback;

public interface ComCallback<T> {

    void success(T model);

    void error(String error);
}
