package com.example.sh.morningtext.mvdesign.mvp.text;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.sh.morningtext.R;
import com.example.sh.morningtext.mvdesign.mvc.text.PortryBean;

/**
 * mvp view层
 */
public class MvpActivity extends AppCompatActivity implements MainContract.View,View.OnClickListener{


    private Button btn_mvp;
    private TextView tv_mes;
    private ProgressBar progressBar;
    private MainPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        presenter = new MainPresenter();
        presenter.attachView(this);
        initView();
    }

    private void initView() {

        btn_mvp = findViewById(R.id.btn_mvp);
        tv_mes = findViewById(R.id.tv_mvp);
        progressBar = findViewById(R.id.progressbar);
        btn_mvp.setOnClickListener(this);
    }


    @Override
    public void onsuccess(PortryBean bean) {
        tv_mes.setText(bean.getMessage());
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_mvp:
                presenter.getData();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView(this);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dissLoading() {

    }

    @Override
    public void showError(String error) {
        tv_mes.setText(error);
    }
}
