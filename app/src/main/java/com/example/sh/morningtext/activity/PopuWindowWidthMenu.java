package com.example.sh.morningtext.activity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import com.example.sh.morningtext.R;

public class PopuWindowWidthMenu extends MBaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popu_menu);

        findViewById(R.id.btn_popu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopu(v);
            }
        });
    }

    /**
     * 显示Popuwindow
     */
    private void showPopu(View v) {
        View popuView = LayoutInflater.from(this).inflate(R.layout.popu_view,null);
        PopupWindow popupWindow = new PopupWindow(popuView,ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,true);
        popupWindow.setContentView(popuView);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
        popupWindow.setOutsideTouchable(true);

        popupWindow.showAsDropDown(v,50,0);
        popupWindow.setTouchable(true);
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
    }
}
