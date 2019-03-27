package com.example.sh.morningtext.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.sh.morningtext.R;
import com.example.sh.morningtext.databinding.ActivityAppbarlayoutBinding;

public class MAppbarLayoutActivity extends MBaseActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       ActivityAppbarlayoutBinding binding =  DataBindingUtil.setContentView(this,R.layout.activity_appbarlayout);
       String conent = "";
        for (int i = 0; i < 100; i++) {
            conent = conent+"a爱的发的发发发覅覅uqorqorueru 日确认确认确认uroqeuroqeurqo如期如";
        }
       binding.tv.setText(conent);
    }
}
