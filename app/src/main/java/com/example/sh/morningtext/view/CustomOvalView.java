package com.example.sh.morningtext.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class CustomOvalView extends View {
    public CustomOvalView(Context context) {
        super(context);
    }

    public CustomOvalView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomOvalView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLACK);

        RectF rectF = new RectF();
        rectF.left = 100;
        rectF.right = 300;
        rectF.top = 100;
        rectF.bottom = 300;
        canvas.drawOval(rectF,paint);

        paint.setColor(Color.RED);
        RectF rectF1 = new RectF();
        rectF1.left = 400;
        rectF1.right = 600;
        rectF1.top = 100;
        rectF1.bottom = 200;
        canvas.drawOval(rectF1,paint);

        paint.setColor(Color.GREEN);
        RectF rectF2 = new RectF();
        rectF2.left = 100;
        rectF2.right = 50;
        rectF2.top = 300;
        rectF2.bottom = 500;
        canvas.drawOval(rectF2,paint);
    }
}
