package com.example.sh.morningtext.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class MService extends Service {
    private String MTAG = "MService";
    int count;
    public MBinder binder = new MBinder();
    private boolean isQuit = false;
    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(MTAG,"onCreate调用了");
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!isQuit){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    count++;
                }
            }
        }).start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(MTAG,"onStartCommand调用了");
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e(MTAG,"onBind调用了");
        return binder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e(MTAG,"onUnbind(调用了");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Log.e(MTAG,"onDestroy调用了");
        isQuit = true;
        super.onDestroy();
    }

    public class MBinder extends Binder {

        public int getCount(){
            return count;
        }
    }
}
