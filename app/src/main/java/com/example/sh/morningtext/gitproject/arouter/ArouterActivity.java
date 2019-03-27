package com.example.sh.morningtext.gitproject.arouter;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.sh.morningtext.R;
import com.example.sh.morningtext.activity.MBaseActivity;
import com.example.sh.morningtext.weight.ToastManger;

import java.io.Serializable;

/**
 * https://github.com/alibaba/ARouter/blob/master/README_CN.md
 */
public class ArouterActivity extends MBaseActivity implements View.OnClickListener{

    private Button btn_text01,btn_text02,btn_text3;
    private String MTAG = "ArouterActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_router);
        btn_text01 = findViewById(R.id.btn_text1);
        btn_text01.setOnClickListener(this);

        btn_text02 = findViewById(R.id.btn_text2);
        btn_text02.setOnClickListener(this);

        btn_text3 = findViewById(R.id.btn_text3);
        btn_text3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btn_text1:
                ARouter.getInstance().build("/activity/text01").navigation(this, new NavigationCallback() {
                    @Override
                    public void onFound(Postcard postcard) {
                        Log.e("interceptor","onFound");
                    }

                    @Override
                    public void onLost(Postcard postcard) {
                        Log.e("interceptor","onLost");
                    }

                    @Override
                    public void onArrival(Postcard postcard) {
                        Log.e("interceptor","onArrival");
                    }

                    @Override
                    public void onInterrupt(Postcard postcard) {
                        Log.e("interceptor","onInterrupt");
                    }
                });
                break;

            case R.id.btn_text2:
                ARouter.getInstance().build("/activity/text02")
                        .withString("name","sunhao")
//                        .withObject("Person",new MPerson(13))
                        .navigation();
                break;
            case R.id.btn_text3:
                ARouter.getInstance().build("/activity/text03").navigation(this,123);
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 123 && resultCode == 123)
            ToastManger.show("onActivityResult="+data.getStringExtra("123"),this);
    }
}
