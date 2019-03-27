package com.example.sh.morningtext.service;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

public class MIntentService extends IntentService {
    private String MTAG = "MIntentService";

    public MIntentService(){
        super("MIntentService");
    }

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public MIntentService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        String parms = intent.getStringExtra("parms");
        if(parms.equals("s1")){
            Log.e(MTAG,"SERVICE1启动了...");
        }else if(parms.equals("s2")){
            Log.e(MTAG,"SERVICE2启动了...");
        }else if(parms.equals("s3")){
            Log.e(MTAG,"SERVICE3启动了...");
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        Log.e(MTAG,"onStartCommand...");
        return super.onStartCommand(intent, flags, startId);
    }
}
