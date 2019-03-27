package com.example.sh.morningtext.activity;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.sh.morningtext.R;
import com.example.sh.morningtext.service.LoopService;
import com.example.sh.morningtext.service.MIntentService;
import com.example.sh.morningtext.service.MService;
import com.example.sh.morningtext.service.NotificationServices;
import com.example.sh.morningtext.weight.ToastManger;

public class ServiceActivity extends MBaseActivity{

    private ServiceConnection conn;
    private MService.MBinder binder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        final Intent intent = new Intent(this,MService.class);

        find(R.id.btn_ser_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(intent);
            }
        });

        find(R.id.btn_ser_stop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(intent);
            }
        });


        find(R.id.btn_ser_bind).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindService(intent,conn,BIND_AUTO_CREATE);
            }
        });

        find(R.id.btn_ser_unbind).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unbindService(conn);
            }
        });


        find(R.id.btn_ser_count).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastManger.show("count="+binder.getCount(),ServiceActivity.this);
            }
        });

        find(R.id.btn_noti_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(ServiceActivity.this, NotificationServices.class);
                startService(intent1);
            }
        });

        findViewById(R.id.btn_ser_loop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(ServiceActivity.this, LoopService.class);
                startService(intent1);
            }
        });

        conn = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                binder = (MService.MBinder) service;

            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };

        find(R.id.btn_iser_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(ServiceActivity.this,MIntentService.class);
                intent1.putExtra("parms","s1");
                startService(intent1);

                Intent intent2 = new Intent(ServiceActivity.this,MIntentService.class);
                intent2.putExtra("parms","s2");
                startService(intent2);

                Intent intent3 = new Intent(ServiceActivity.this,MIntentService.class);
                intent3.putExtra("parms","s3");
                startService(intent3);


            }
        });
    }
}
