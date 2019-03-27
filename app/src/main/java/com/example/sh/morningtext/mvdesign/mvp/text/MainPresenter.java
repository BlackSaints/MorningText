package com.example.sh.morningtext.mvdesign.mvp.text;

import com.example.sh.morningtext.mvdesign.mvc.text.PortryBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter extends BasePresenter implements MainContract.Presenter {

    private  MainContract.View view;

    @Override
    public void getData() {
//        view.showProgress();
        MainModel mainModel = new MainModel();
        mainModel.getData().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally(new Action() {
                    @Override
                    public void run() throws Exception {
//                        view.dissProgress();
                    }
                })
                .subscribe(new Observer<PortryBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PortryBean bean) {
                        if(isAttachedView()){
                            view.onsuccess(bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if(isAttachedView()){
                            view.showError(e.getMessage().toString());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
