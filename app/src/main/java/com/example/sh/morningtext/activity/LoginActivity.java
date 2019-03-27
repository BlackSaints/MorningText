package com.example.sh.morningtext.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.sh.morningtext.R;
import com.example.sh.morningtext.databinding.ActivityLoginBinding;
import com.example.sh.morningtext.utils.SPManger;
import com.example.sh.morningtext.weight.ToastManger;

@Route(path = "/activity/login")
public class LoginActivity extends MBaseActivity {

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.setAcy(this);
    }

    public void submit(){
        ToastManger.show("login success",this);
        SPManger.save(this,"token","logined");
        finish();
    }

    public void outlogin(){
        ToastManger.show("outlogin success",this);
        SPManger.save(this,"token","");
        finish();
    }
}
