package com.example.sh.morningtext.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.sh.morningtext.R;
import com.example.sh.morningtext.adapter.BaseViewAdapter;
import com.example.sh.morningtext.gitproject.arouter.ArouterActivity;
import com.example.sh.morningtext.network.activity.RxRetrofitActivity;

public class ThreeFrameActivity extends MBaseActivity{

    Class[] acy = {OkHttpActivity.class,VolleyActivity.class,RxjavaActivity.class,
            RxjavaDemosActivity.class,RetrofitActivity.class,RxBindingActivity.class,
            RxRetrofitActivity.class,EventBusActivity_1.class,DataBindingActivity.class,ArouterActivity.class};
    String[] btnName = {"OkHttp","volley","Rxjava","RxjavaDemo","Retrofit","RxBinding",
            "RxRetrofitActivity","EventBus","DataBinding","ARouter"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baseview);

        ListView mListView = findViewById(R.id.base_listview);
        BaseViewAdapter adapter = new BaseViewAdapter(btnName,R.layout.adapter_baseview) {
            @Override
            public void bindView(BaseViewAdapter.BaseViewHolder viewHolder, Object item) {
                TextView mTextView = (TextView) viewHolder.getView(R.id.tv_baseview);
                mTextView.setText(item.toString());
            }
        };

        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(ThreeFrameActivity.this,acy[position]));
            }
        });


    }
}
