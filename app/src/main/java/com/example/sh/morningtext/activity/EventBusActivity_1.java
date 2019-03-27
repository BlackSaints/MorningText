package com.example.sh.morningtext.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sh.morningtext.R;
import com.example.sh.morningtext.gitproject.eventbus.MessageEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class EventBusActivity_1 extends AppCompatActivity {

    private TextView tv_eb1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eb1);
        EventBus.getDefault().register(this);
        initView();
    }

    private void initView() {
        Button btn_eb1 = findViewById(R.id.btn_eb1);
        tv_eb1 = findViewById(R.id.tv_eb1);

        btn_eb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EventBusActivity_1.this,EventBusActivity_2.class));
                finish();
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void MessageEvent(MessageEvent event){
        tv_eb1.setText(event.getMes()+Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.e("eventbus","Thread=="+Thread.currentThread().getName());
    }

    @Subscribe(threadMode = ThreadMode.POSTING)
    public void MessageEvent1(MessageEvent event){
//        tv_eb1.setText(event.getMes()+Thread.currentThread().getName());
        Log.e("eventbus","Thread=="+Thread.currentThread().getName());
    }


    /**
     * 粘性事件订阅
     */

    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void onMessageEvent(String event){

        Log.e("eventbus","sticky=="+event);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
