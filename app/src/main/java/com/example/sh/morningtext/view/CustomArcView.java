package com.example.sh.morningtext.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class CustomArcView extends View {


    public CustomArcView(Context context) {
        super(context);
    }

    public CustomArcView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomArcView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);
        RectF rectF = new RectF();
        rectF.left = 100;
        rectF.top = 100;
        rectF.right = 300;
        rectF.bottom = 300;
        canvas.drawArc(rectF,0,90,true,paint);

        paint.setColor(Color.GREEN);
        RectF rectF1 = new RectF();
        rectF1.left = 100;
        rectF1.top = 100;
        rectF1.right = 300;
        rectF1.bottom = 300;
        canvas.drawArc(rectF1,90,180,true,paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.GREEN);
        RectF rectF2 = new RectF();
        rectF2.left = 100;
        rectF2.top = 500;
        rectF2.right = 300;
        rectF2.bottom = 700;
        canvas.drawArc(rectF2,0,360,true,paint);

    }
}
