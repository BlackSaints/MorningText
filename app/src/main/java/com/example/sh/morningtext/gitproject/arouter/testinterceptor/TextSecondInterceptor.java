package com.example.sh.morningtext.gitproject.arouter.testinterceptor;


import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;

@Interceptor(priority = 2)
public class TextSecondInterceptor implements IInterceptor {
    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        Log.e("interceptor","TextSecondInterceptor拦截器开始执行"+"路径"+postcard.getPath());
        callback.onContinue(postcard);
    }

    @Override
    public void init(Context context) {
        Log.e("interceptor","TextSecondInterceptorr拦截器init");
    }
}
