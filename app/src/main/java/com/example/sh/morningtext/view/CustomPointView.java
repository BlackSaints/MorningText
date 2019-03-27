package com.example.sh.morningtext.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class CustomPointView extends View {
    public CustomPointView(Context context) {
        super(context);
    }

    public CustomPointView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomPointView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLACK);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(40);
        canvas.drawPoint(100,100,paint);

        paint.setStrokeCap(Paint.Cap.BUTT);
        canvas.drawPoint(100,200,paint);

        paint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawPoint(100,300,paint);

    }
}
