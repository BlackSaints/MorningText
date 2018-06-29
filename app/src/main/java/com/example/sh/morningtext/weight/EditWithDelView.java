package com.example.sh.morningtext.weight;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.sh.morningtext.R;

public class EditWithDelView extends android.support.v7.widget.AppCompatEditText implements View.OnFocusChangeListener{

    private Context context;
    private Drawable imgInable;
    private boolean hasFocus;

    public EditWithDelView(Context context) {
        this(context, null);
    }

    public EditWithDelView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    private void init() {

        imgInable = getCompoundDrawables()[2];
        if(imgInable == null){
            imgInable = context.getResources().getDrawable(R.mipmap.icon_close);
        }
        imgInable.setBounds(0,0,imgInable.getIntrinsicWidth(),imgInable.getIntrinsicHeight());
        //默认隐藏删除按钮
        setClearIconVisible(false);

        setOnFocusChangeListener(this);
        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(hasFocus){
                    setClearIconVisible(s.length()>0);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void setClearIconVisible(boolean visible) {
        Drawable right = visible ? imgInable : null;
        setCompoundDrawables(getCompoundDrawables()[0],getCompoundDrawables()[1],right,getCompoundDrawables()[3]);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if(getCompoundDrawables()[2] != null && event.getAction() == MotionEvent.ACTION_UP){
            int x = (int) event.getX();
            int y = (int) event.getY();

            Rect rect = getCompoundDrawables()[2].getBounds();

            int height = rect.height();
            int distance = (getHeight() - height)/2;
            boolean isInnerWidth = x > (getWidth() - getTotalPaddingRight() - 50) && x < (getWidth() - getPaddingRight());
            boolean isInnerHeight = y > distance && y <(distance + height);


            if(isInnerWidth && isInnerHeight){
                setText("");
            }
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }


    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        this.hasFocus = hasFocus;
        if(hasFocus){
            setClearIconVisible(getText().length()>0);
        }else{
            setClearIconVisible(false);
        }

    }
}
