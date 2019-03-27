package com.example.sh.morningtext.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.sh.morningtext.R;
import com.example.sh.morningtext.gitproject.eventbus.MessageEvent;

import org.greenrobot.eventbus.EventBus;

public class EventBusActivity_2 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eb2);
        initView();
    }

    private void initView() {
        Button btn_eb2 = findViewById(R.id.btn_eb2);
        btn_eb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                finish();

                threadPost();

            }
        });

        Button btn_eb2_sticky = findViewById(R.id.btn_eb2_sticky);

        btn_eb2_sticky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().postSticky("sticky");
            }
        });
    }

    private void threadPost() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                MessageEvent event = new MessageEvent("来自EventBusActivity_2的消息");
                EventBus.getDefault().post(event);
            }
        }).start();
    }

}
