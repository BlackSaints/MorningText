package com.example.sh.morningtext.weight;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.sh.morningtext.R;

public class SquareImageView extends View {
    private Context mContext;
    private int mWidth;
    private int mHeight;
    public SquareImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //获取测量的宽高
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        if(mWidth == 0){
            mWidth = width;
        }
        if(mHeight == 0){
            mHeight = height;
        }

        setMeasuredDimension(mWidth,mHeight);

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint mPaint = new Paint();

        Bitmap mBitmap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.s_8);
        canvas.drawBitmap(mBitmap,100,200,mPaint);

    }


    public void setProgress(int mWidth,int mHeight){
        if(mWidth != 0){
            this.mWidth += mWidth;
        }

        if(mHeight != 0){
            this.mHeight += mHeight;
        }

        requestLayout();
    }
}
