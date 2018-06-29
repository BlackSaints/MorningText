package com.example.sh.morningtext.weight;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.sh.morningtext.R;

public class MProgressBar extends View{

    private Paint backPaint;
    private Paint proPaint;
    private Paint textPaint;
    private float strokeWidth = 20;
    private int mRadius = 200;
    private int mWidth;
    private int mHeight;
    private RectF mRect;
    private float mProgress = 0;
    private int mMax = 100;
    private int mTargetProgress = 90;
    private float mHalfStrokeWidth = strokeWidth / 2;



    public MProgressBar(Context context) {
        this(context,null);
    }

    public MProgressBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        initPaint();
    }

    private void initPaint() {

        backPaint = new Paint();
        backPaint.setColor(getResources().getColor(R.color.gray));
        backPaint.setAntiAlias(true);
        backPaint.setStyle(Paint.Style.STROKE);
        backPaint.setStrokeWidth(strokeWidth);

        proPaint = new Paint();
        proPaint.setAntiAlias(true);
        proPaint.setColor(getResources().getColor(R.color.colorAccent));
        proPaint.setStrokeWidth(strokeWidth);
        proPaint.setStyle(Paint.Style.STROKE);
        textPaint = new Paint();
        textPaint.setColor(getResources().getColor(R.color.colorPrimary));
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(80);
        textPaint.setTextAlign(Paint.Align.CENTER);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = getMeasure(widthMeasureSpec);
        mHeight = getMeasure(heightMeasureSpec);
        setMeasuredDimension(mWidth,mHeight);
    }

    private int getMeasure(int measureSpec) {
        int result = 1;
        int mode = MeasureSpec.getMode(measureSpec);
        int size = MeasureSpec.getSize(measureSpec);

        if(mode == MeasureSpec.AT_MOST || mode == MeasureSpec.UNSPECIFIED){
            result = (int) (mRadius*2+strokeWidth);
        }else{
            result = size;
        }
        return result;

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        initRect();
        float angle = mProgress / (float) mMax * 360;
        canvas.drawCircle(mWidth/2,mHeight/2,mRadius,backPaint);
        canvas.drawArc(mRect,-90,angle,false,proPaint);

        canvas.drawText(mProgress + "%", mWidth / 2 + mHalfStrokeWidth, mHeight / 2 + mHalfStrokeWidth, textPaint);
        if (mProgress < mTargetProgress) {
            mProgress += 1;
            invalidate();
        }

    }

    private void initRect() {
        if(mRect == null){
            mRect = new RectF();
            int viewSize = mRadius*2;
            mRect.left = (mWidth - viewSize)/2;
            mRect.top = (mHeight - viewSize)/2;
            mRect.right = mRect.left+viewSize;
            mRect.bottom = mRect.top+viewSize;
        }

    }
}
