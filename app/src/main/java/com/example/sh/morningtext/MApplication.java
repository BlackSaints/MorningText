package com.example.sh.morningtext;

import android.app.Application;

public class MApplication extends Application {

    MApplication instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public MApplication getInstance() {
        return instance;
    }
}
