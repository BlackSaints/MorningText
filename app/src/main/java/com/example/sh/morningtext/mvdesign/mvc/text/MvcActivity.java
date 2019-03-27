package com.example.sh.morningtext.mvdesign.mvc.text;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sh.morningtext.R;
import com.example.sh.morningtext.activity.MBaseActivity;

/**
 * mvc view层
 * 用户交互处理，界面显示
 */
public class MvcActivity extends MBaseActivity{

    private TextView vTvRes;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc_text);

        Button vBtnSub = findViewById(R.id.btn_submit);
        vBtnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submit();
            }
        });

        vTvRes = findViewById(R.id.tv_res);
    }

    private void submit() {

        PoetryModel.getData(new ResponseListener() {
            @Override
            public void accept(PortryBean bean) {
                vTvRes.setText(bean.getMessage());
            }
        });
    }
}
