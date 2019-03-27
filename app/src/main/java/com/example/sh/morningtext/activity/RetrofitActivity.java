package com.example.sh.morningtext.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sh.morningtext.R;
import com.example.sh.morningtext.bean.Person;
import com.example.sh.morningtext.minterface.Api;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitActivity extends MBaseActivity implements View.OnClickListener{

    private Button btn_get;
    private Button btn_post;
    private TextView tv_mes;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_retrofit);

        btn_get = findViewById(R.id.btn_get);
        btn_post = findViewById(R.id.btn_post);

        btn_get.setOnClickListener(this);
        btn_post.setOnClickListener(this);

        tv_mes = findViewById(R.id.tv_mes);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_get:
                getReq();
                break;
            case R.id.btn_post:
                break;
        }
    }

    /**
     * retrofit get req
     */
    public void getReq() {

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://www.wanandroid.com/tools/mockapi/")
                .build();

        Api api = retrofit.create(Api.class);
        Call<Person> call = api.getPerson();
        call.enqueue(new Callback<Person>() {
            @Override
            public void onResponse(Call<Person> call, Response<Person> response) {
                tv_mes.setText(response.body().getAddress());
            }

            @Override
            public void onFailure(Call<Person> call, Throwable t) {

            }
        });


    }
}
