package com.example.sh.morningtext.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sh.morningtext.R;
import com.example.sh.morningtext.weight.RoundImageView;

public class TextViewActivity extends AppCompatActivity{

    private TextView tv_friend;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_textview);

        tv_friend = findViewById(R.id.tv_friend);

        RoundImageView roundview = findViewById(R.id.roundview);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.s_6);
        roundview.setBitmap(bitmap);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 20 ; i++) {
            sb.append("好友"+i+",");
        }

        String likeUsers = sb.substring(0,sb.lastIndexOf(",")).toString();
        tv_friend.setMovementMethod(LinkMovementMethod.getInstance());
        tv_friend.setText(addClickPart(likeUsers), TextView.BufferType.SPANNABLE);

    }

    private SpannableStringBuilder addClickPart(String str) {

        ImageSpan imageSpan = new ImageSpan(TextViewActivity.this,R.drawable.ic_home_black_24dp);
        SpannableString sbs = new SpannableString("p.");
        sbs.setSpan(imageSpan,0,1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);


        SpannableStringBuilder ssb = new SpannableStringBuilder(sbs);
        ssb.append(str);

        String[] likeUsers = str.split(",");
        if(likeUsers.length>0){
            for (int i = 0; i < likeUsers.length; i++) {
                final String name = likeUsers[i];
                int start = str.indexOf(name)+sbs.length();
                ssb.setSpan(new ClickableSpan() {
                    @Override
                    public void onClick(View widget) {
                        Toast.makeText(TextViewActivity.this, name, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void updateDrawState(TextPaint ds) {
                        super.updateDrawState(ds);
                        ds.setColor(Color.WHITE);
                    }
                }
                ,start,start+name.length(),0);

            }
        }

        return ssb.append("等"+likeUsers.length+"个人觉得很赞");
    }
}
