package com.example.sh.morningtext.bean;


import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.sh.morningtext.BR;


public class UserBean extends BaseObservable {
    @Bindable
    private String name; //姓名
    private int age; //年龄

    private boolean step = true;
    @Bindable
    public boolean isStep() {
        return step;
    }

    public void setStep(boolean step) {
        this.step = step;
        notifyPropertyChanged(BR.step);
    }

    public String getName() {
        return name == null ? "" : name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        notifyPropertyChanged(BR.name);
    }

    public UserBean(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
