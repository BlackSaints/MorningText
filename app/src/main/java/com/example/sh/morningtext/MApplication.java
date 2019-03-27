package com.example.sh.morningtext;

import android.app.Application;
import android.graphics.Bitmap;

import com.alibaba.android.arouter.launcher.ARouter;
import com.github.cyc.eventbus.subscriberindexdemo.MyEventBusIndex;

import org.greenrobot.eventbus.EventBus;

public class MApplication extends Application {

    public static MApplication instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        EventBus.builder().addIndex(new MyEventBusIndex()).build();
        ARouter.openLog();
        ARouter.openDebug();
        ARouter.init(this);
    }

    public static MApplication getInstance() {
        return instance;
    }
}
