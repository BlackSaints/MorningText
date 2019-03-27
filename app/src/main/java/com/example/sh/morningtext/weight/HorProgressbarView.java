package com.example.sh.morningtext.weight;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.example.sh.morningtext.R;

public class  HorProgressbarView extends View {

    private Context context;
    private Paint bgPaint;
    private int mWidth,mHeight;
    private Paint textPaint;
    private int progress = 50 ;
    public HorProgressbarView(Context context) {
        this(context,null);

    }

    public HorProgressbarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initPaint();
    }

    private void initPaint() {
        bgPaint = new Paint();
        bgPaint.setColor(context.getResources().getColor(R.color.gray));
        bgPaint.setAntiAlias(true);
        bgPaint.setStyle(Paint.Style.FILL);
        bgPaint.setStrokeWidth(2);

        textPaint = new Paint();
        textPaint.setAntiAlias(true);
        textPaint.setColor(Color.GREEN);
        textPaint.setTextSize(20);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = MeasureSpec.getSize(widthMeasureSpec);
        mHeight = getMeasuredSize(heightMeasureSpec);

        setMeasuredDimension(mWidth,mHeight);
    }

    private int getMeasuredSize(int measureSpec) {
        int result = 0;
        int size = MeasureSpec.getSize(measureSpec);
        int mode = MeasureSpec.getMode(measureSpec);
        if(mode == MeasureSpec.EXACTLY){
            result = size;
        }else{
            int textHeight = (int) (textPaint.descent() - textPaint.ascent());
            result = getPaddingTop()+getPaddingBottom() + Math.max(textHeight,size);
        }

        return result;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        RectF rectF = new RectF();
        rectF.left = getPaddingLeft();
        rectF.top = mHeight/2;
        rectF.right = mWidth - getPaddingRight();
        rectF.bottom = mHeight/2+25;
        canvas.drawRect(rectF,bgPaint);

        int startX = progress*(mWidth-getPaddingRight()) / 100;
        rectF.right = startX;
        bgPaint.setColor(Color.RED);
        canvas.drawRect(rectF,bgPaint);
        String pro = progress+"%";
        canvas.drawText(pro,startX,mHeight/2,textPaint);

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    //转换方法dp 2 px
    private int dp2px(int dpVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dpVal, getResources().getDisplayMetrics());
    }

    private int sp2px(int spVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                spVal, getResources().getDisplayMetrics());
    }
}
