package com.example.sh.morningtext.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.sh.morningtext.R;
import com.example.sh.morningtext.adapter.BaseViewAdapter;
import com.example.sh.morningtext.utils.SPManger;
import com.example.sh.morningtext.weight.ToastManger;

public class SharedPreferencesActivity extends MBaseActivity{

    String[] btnName = {"保存用户名"};
    private EditText vUserName,vPassword;
    private Button vLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        vUserName = findViewById(R.id.et_username);
        vPassword = findViewById(R.id.et_password);
        vLogin = findViewById(R.id.btn_login);
        vLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SPManger.save(SharedPreferencesActivity.this,"userName",vUserName.getText().toString());
                SPManger.save(SharedPreferencesActivity.this,"password",vPassword.getText().toString());
                SPManger.save(SharedPreferencesActivity.this,"isLogin",true);
            }
        });



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


            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        boolean isLogin = (boolean) SPManger.read(SharedPreferencesActivity.this,"isLogin",false);
        if(isLogin){

            String mUserName = (String) SPManger.read(SharedPreferencesActivity.this,"userName","");
            vUserName.setText(mUserName);
            ToastManger.show("已经登录,username="+mUserName,SharedPreferencesActivity.this);
        }

    }
}
