package com.example.sh.morningtext.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.sh.morningtext.R;

import org.json.JSONObject;


public class VolleyActivity extends MBaseActivity implements View.OnClickListener{

    private Button mBtnPost;
    private Button mBtnGet;
    private Button mBtnUpload;

    private String mUrl = "http://www.wanandroid.com/tools/mockapi/5284/text1";
    private TextView mTvContent;
    private RequestQueue queue;
    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);

        initQueues();

        mBtnGet = (Button)findViewById(R.id.btn_get);
        mBtnPost = (Button)findViewById(R.id.btn_post);
        mBtnUpload = (Button)findViewById(R.id.btn_upload);
        mTvContent = (TextView)findViewById(R.id.tv_content);
        imageView = (ImageView)findViewById(R.id.iv_img);

        mBtnGet.setOnClickListener(this);
        mBtnPost.setOnClickListener(this);
        mBtnUpload.setOnClickListener(this);
    }

    /**
     * 初始化请求队列
     */
    private void initQueues() {
        queue = Volley.newRequestQueue(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_get:
//                StringRequestGet();
//                jsonRequestGet();
                ImageRequest();
                break;
            case R.id.btn_post:
                break;
            case R.id.btn_upload:
                break;
        }
    }

    private void ImageRequest() {

        String imageUrl = "https://www.baidu.com/img/bd_logo1.png?where=super";
        ImageRequest request = new ImageRequest(imageUrl, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap bitmap) {
                imageView.setImageBitmap(bitmap);
            }
        }, 0, 0, Bitmap.Config.RGB_565, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                imageView.setImageResource(R.drawable.ic_launcher_background);
            }
        });
        queue.add(request);
    }

    private void jsonRequestGet() {

        JsonObjectRequest request = new JsonObjectRequest("http://m.weather.com.cn/data/101010100.html", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                mTvContent.setText(jsonObject.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                mTvContent.setText("error code = "+volleyError.getCause()+"   "+volleyError.getMessage());
            }
        });
        queue.add(request);
    }

    private void StringRequestGet() {

        StringRequest request = new StringRequest(mUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                mTvContent.setText(s);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                mTvContent.setText(volleyError.getCause().toString());
            }
        });

        queue.add(request);
    }
}
