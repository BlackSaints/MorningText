package com.example.sh.morningtext.mvdesign.mvp.text;

import com.example.sh.morningtext.mvdesign.mvc.text.PortryBean;

import io.reactivex.Observable;

public interface MainContract {


    interface Model{

        Observable<PortryBean> getData();
    }

    interface View extends BaseView{

        void onsuccess(PortryBean bean);

    }


    interface Presenter{

        void getData();
    }
}
