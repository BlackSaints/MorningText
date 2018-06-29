package com.example.sh.morningtext.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.sh.morningtext.R;

/**
 * 基础布局
 */
public class BaseViewActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baseview);

        TextView btn_textview = findViewById(R.id.btn_textview);
        btn_textview.setOnClickListener(this);

        TextView btn_edittext = findViewById(R.id.btn_edittext);
        btn_edittext.setOnClickListener(this);

        TextView btn_button = findViewById(R.id.btn_button);
        btn_button.setOnClickListener(this);

        TextView btn_listview = findViewById(R.id.btn_listview);
        btn_listview.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_textview:
                startActivity(new Intent(BaseViewActivity.this,TextViewActivity.class));
                break;
            case R.id.btn_edittext:
                startActivity(new Intent(BaseViewActivity.this,EditViewActivity.class));
                break;
            case R.id.btn_button:
                startActivity(new Intent(BaseViewActivity.this,ButtonActivity.class));
                break;
            case R.id.btn_listview:
                startActivity(new Intent(BaseViewActivity.this,ListViewActivity.class));
                break;
        }
    }
}
