package com.example.sh.morningtext.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class CustomLineView extends View {
    public CustomLineView(Context context) {
        super(context);
    }

    public CustomLineView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomLineView(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(10);
        paint.setColor(Color.BLACK);

        canvas.drawLine(100,100,300,300,paint);

        paint.setStrokeCap(Paint.Cap.ROUND);

        canvas.drawLine(300,100,500,300,paint);

    }
}
