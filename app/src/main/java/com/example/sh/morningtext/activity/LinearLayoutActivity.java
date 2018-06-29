package com.example.sh.morningtext.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.example.sh.morningtext.R;

/**
 * android 布局
 */
public class LinearLayoutActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_linearlayout);
//        setContentView(R.layout.activity_relactivelayout);
//        setContentView(R.layout.activity_tablayout);
//        findViewById(R.id.btn_frame01).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(LinearLayoutActivity.this,FramelayoutDemo01.class));
//            }
//        });
//        setContentView(R.layout.activity_gridlayout);
        //TextView 边框

        setContentView(R.layout.activity_textview_stroke);
    }
}
