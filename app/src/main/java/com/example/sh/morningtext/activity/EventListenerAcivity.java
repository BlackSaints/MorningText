package com.example.sh.morningtext.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.example.sh.morningtext.R;
import com.example.sh.morningtext.weight.MButtonView;
import com.example.sh.morningtext.weight.ToastManger;

public class EventListenerAcivity extends MBaseActivity implements View.OnClickListener{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listener);
        Button mBtnNoname = findViewById(R.id.btn_noname);
        mBtnNoname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastManger.show("监听器-匿名内部类",EventListenerAcivity.this);
            }
        });

        findViewById(R.id.btn_inner).setOnClickListener(new MOnClickListener());

        findViewById(R.id.btn_activity).setOnClickListener(this);

        findViewById(R.id.btn_activity).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });

        MButtonView view = new MButtonView(this);

    }

    public void listener(View view){
        ToastManger.show("监听器-xml",this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_activity){
            ToastManger.show("监听器-activity",this);
        }
    }

    private class MOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            ToastManger.show("监听器-内部类",EventListenerAcivity.this);
        }
    }
}
