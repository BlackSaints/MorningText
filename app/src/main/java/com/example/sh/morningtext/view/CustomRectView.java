package com.example.sh.morningtext.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class CustomRectView extends View {
    public CustomRectView(Context context) {
        super(context);
    }

    public CustomRectView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomRectView(Context context,AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.RED);

        Rect rect = new Rect();
        rect.left = 100;
        rect.top = 100;
        rect.right = 300;
        rect.bottom = 300;
        canvas.drawRect(rect,paint);

        RectF rect1 = new RectF();
        rect1.left = 100;
        rect1.top = 400;
        rect1.right = 300;
        rect1.bottom = 600;
        canvas.drawRoundRect(rect1,10,10,paint);


        paint.setStrokeCap(Paint.Cap.ROUND);
        Rect rect2 = new Rect();
        rect2.left = 500;
        rect2.top = 100;
        rect2.right = 700;
        rect2.bottom = 300;
        canvas.drawRect(rect2,paint);

        paint.setStyle(Paint.Style.FILL);
        RectF rect3 = new RectF();
        rect3.left = 500;
        rect3.top = 400;
        rect3.right = 700;
        rect3.bottom = 600;
        canvas.drawRoundRect(rect3,10,10,paint);


    }
}
