package com.example.sh.morningtext.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.example.sh.morningtext.R;
import com.example.sh.morningtext.weight.ToastManger;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpActivity extends MBaseActivity{


    private String MTAG = "OkHttpActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);

        findViewById(R.id.btn_get).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();
            }
        });

        findViewById(R.id.btn_post).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void getData() {
        String url = "http://www.wanandroid.com/tools/mockapi/5284/text";
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new MInterceptor())
                .build();

        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e(MTAG,e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e(MTAG,response.body().string());
            }
        });
    }

    /**
     * 拦截器  记录请求时间
     */
    private class MInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {

            Request request = chain.request();

            long startTime = System.nanoTime();
            Log.d(MTAG, String.format("Sending request %s on %s%n%s",
                    request.url(), chain.connection(), request.headers()));

            Response response =  chain.proceed(request);

            long endTime = System.nanoTime();
            Log.d(MTAG, String.format("Received response for %s in %.1fms%n%s",
                    response.request().url(), (endTime - startTime) / 1e6d, response.headers()));

            return response;

        }
    }
}
