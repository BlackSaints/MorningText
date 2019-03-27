package com.example.sh.morningtext.recevier;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.sh.morningtext.service.LoopService;

public class AlarmReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent intent1 = new Intent(context, LoopService.class);
        context.startService(intent1);
    }
}
