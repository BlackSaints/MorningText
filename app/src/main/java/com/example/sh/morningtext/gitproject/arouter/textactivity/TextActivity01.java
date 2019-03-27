package com.example.sh.morningtext.gitproject.arouter.textactivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.sh.morningtext.activity.MBaseActivity;

@Route(path = "/activity/text01",extras = 1)
public class TextActivity01 extends MBaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView tv = new TextView(this);
        tv.setText("TextActivity01");
        setContentView(tv);
    }
}
