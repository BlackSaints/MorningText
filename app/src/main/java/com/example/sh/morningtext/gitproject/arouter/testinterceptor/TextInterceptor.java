package com.example.sh.morningtext.gitproject.arouter.testinterceptor;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.sh.morningtext.MApplication;
import com.example.sh.morningtext.utils.SPManger;

@Interceptor(priority = 1)
public class TextInterceptor implements IInterceptor {
    Context context;
    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        Log.e("interceptor","TextInterceptor拦截器开始执行"+"路径"+postcard.getPath());

        if(postcard.getExtra() == 1){
            if(TextUtils.isEmpty((CharSequence) SPManger.read(context,"token",""))){
                ARouter.getInstance().build("/activity/login").greenChannel().navigation();
            }else{
                callback.onContinue(postcard);
            }
        }else{
            callback.onContinue(postcard);
        }



    }

    @Override
    public void init(Context context) {
        this.context = context;
        Log.e("interceptor","TextInterceptor拦截器init");
    }
}
