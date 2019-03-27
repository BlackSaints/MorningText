package com.example.sh.morningtext.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.example.sh.morningtext.R;
import com.example.sh.morningtext.mvdesign.mvc.text.MvcActivity;
import com.example.sh.morningtext.mvdesign.mvp.online.view.OnlineMVPActivity;
import com.example.sh.morningtext.mvdesign.mvp.text.MvpActivity;

public class MVDesignActivity extends MBaseActivity implements View.OnClickListener{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvdesign);

        Button vMvc = findViewById(R.id.btn_mvc);
        vMvc.setOnClickListener(this);

        Button vMvp = findViewById(R.id.btn_mvp);
        vMvp.setOnClickListener(this);

        Button vMvvm = findViewById(R.id.btn_mvvm);
        vMvvm.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_mvc:
                startActivity(new Intent(this,MvcActivity.class));

                break;
            case R.id.btn_mvp:

//                startActivity(new Intent(this,MvpActivity.class));
                startActivity(new Intent(this,OnlineMVPActivity.class));
                break;
            case R.id.btn_mvvm:
                break;
        }
    }
}
