package com.example.sh.morningtext.gitproject.arouter.textactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.sh.morningtext.activity.MBaseActivity;

@Route(path = "/activity/text03")
public class TextActivity03 extends MBaseActivity {

    @Autowired
    public String name;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouter.getInstance().inject(this);
        TextView textView = new TextView(this);
        textView.setText("name==="+name);
        setContentView(textView);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("123","TextActivity03返回的result");
                setResult(123,intent);
                finish();
            }
        });
    }
}
