package com.example.sh.morningtext.weight;

import android.content.ComponentName;
import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.Button;

public class MButtonView extends android.support.v7.widget.AppCompatButton {
    Context context;
    public MButtonView(Context context){
        super(context);
        this.context = context;
    }
    public MButtonView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        ToastManger.show("MButtonView onTouchEvent", context);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        ToastManger.show("MButtonView onKeyDown", context);
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        ToastManger.show("MButtonView onKeyLongPress", context);
        return super.onKeyLongPress(keyCode, event);
    }
}
