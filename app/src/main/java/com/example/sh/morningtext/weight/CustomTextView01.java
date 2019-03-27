package com.example.sh.morningtext.weight;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.sh.morningtext.R;

public class CustomTextView01 extends View {
    private Context context;
    private Paint mPaint;

    public CustomTextView01(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initPaint();

    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(context.getResources().getColor(R.color.colorPrimary));
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(10);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(context.getResources().getColor(R.color.colorAccent));

        canvas.drawCircle(200,200,100,mPaint);
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(500,200,100,mPaint);

        canvas.drawLine(0,400,800,400,mPaint);

        RectF rectF = new RectF();
        rectF.left = 200;
        rectF.top = 600;
        rectF.right = 400;
        rectF.bottom = 800;
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.RED);
        canvas.drawArc(rectF,-90,0,true,mPaint);
        mPaint.setColor(Color.YELLOW);
        canvas.drawArc(rectF,0,90,true,mPaint);

        mPaint.setColor(Color.GREEN);
        canvas.drawArc(rectF,90,180,true,mPaint);
    }
}
