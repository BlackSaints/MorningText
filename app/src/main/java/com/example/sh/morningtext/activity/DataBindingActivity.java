package com.example.sh.morningtext.activity;

import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.sh.morningtext.R;
import com.example.sh.morningtext.bean.UserBean;
import com.example.sh.morningtext.databinding.ActivityBindBinding;
import com.example.sh.morningtext.weight.ToastManger;

public class DataBindingActivity extends MBaseActivity{

    private UserBean bean;
    ActivityBindBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_bind);
        bean = new UserBean("user1",1);
        binding.setUser(bean);

        TextClickListener listener = new TextClickListener();
        binding.setListener(listener);

        bean.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                ToastManger.show("改变了",DataBindingActivity.this);

            }
        });
    }

    public class TextClickListener{
        public void click(){
            ToastManger.show("11",DataBindingActivity.this);
        }

        public void onInputListener(){
            ToastManger.show(bean.getName(),DataBindingActivity.this);
//            bean.setStep(false);
            bean.setName("123");
        }

        public void onTextChanged(){
            bean.setName(binding.etInput.getText().toString());
        }
    }

}



