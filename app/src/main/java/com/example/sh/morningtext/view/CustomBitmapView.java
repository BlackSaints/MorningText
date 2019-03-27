package com.example.sh.morningtext.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.example.sh.morningtext.R;

public class CustomBitmapView extends View {
    Context context;
    public CustomBitmapView(Context context) {
        super(context);
        this.context = context;
    }

    public CustomBitmapView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public CustomBitmapView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.s_1);
        canvas.drawBitmap(bitmap,100,300,new Paint());
    }
}
