package com.example.sh.morningtext.gitproject.arouter.textactivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.sh.morningtext.activity.MBaseActivity;
import com.example.sh.morningtext.gitproject.arouter.ArouterActivity;

@Route(path = "/activity/text02")
public class TextActivity02 extends MBaseActivity {

    @Autowired
    public String name;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouter.getInstance().inject(this);
        TextView textView = new TextView(this);
        textView.setText("name==="+name);
        setContentView(textView);
    }
}
