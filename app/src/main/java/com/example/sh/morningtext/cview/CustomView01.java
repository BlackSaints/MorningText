package com.example.sh.morningtext.cview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.example.sh.morningtext.R;

/**
 * 自定义view01
 */
public class CustomView01 extends View {

    public Context context;
    public AttributeSet attrs;
    private int backgroundcolor;
    private int progresscolor;
    private float stokewidth;
    private float radius;
    private String text;
    private int textcolor;
    private float textsize;
    private Paint backPaint;
    private Paint proPaint;
    private Paint textPaint;
    private Rect mText;

    public CustomView01(Context context) {
        this(context,null);
    }

    public CustomView01(Context context, AttributeSet attrs) {
        this(context, attrs,-1);
    }

    public CustomView01(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        this.attrs = attrs;
        initAttrs();
        initPaint();
    }

    private void initPaint() {
        backPaint = new Paint();
        backPaint.setAntiAlias(true);
        backPaint.setStyle(Paint.Style.STROKE);
        backPaint.setStrokeWidth(stokewidth);
        backPaint.setColor(backgroundcolor);


        proPaint = new Paint();
        proPaint.setAntiAlias(true);
        proPaint.setStyle(Paint.Style.STROKE);
        proPaint.setStrokeWidth(stokewidth);
        proPaint.setColor(progresscolor);
        proPaint.setStrokeCap(Paint.Cap.ROUND);

        textPaint = new Paint();
        textPaint.setAntiAlias(true);
        textPaint.setStyle(Paint.Style.STROKE);
        textPaint.setTextSize(textsize);
        textPaint.setColor(textcolor);
        textPaint.setTextAlign(Paint.Align.CENTER);
        mText = new Rect();
    }

    private void initAttrs() {
        TypedArray ta = context.obtainStyledAttributes(attrs,R.styleable.CustomView01);
        backgroundcolor = ta.getColor(R.styleable.CustomView01_backgroundcolor,0);
        progresscolor = ta.getColor(R.styleable.CustomView01_progresscolor,0);
        stokewidth = ta.getDimension(R.styleable.CustomView01_stokewidth,10);
        radius = ta.getDimension(R.styleable.CustomView01_radius,100);
        text = ta.getString(R.styleable.CustomView01_text);
        textcolor = ta.getColor(R.styleable.CustomView01_textcolor,0);
        textsize = ta.getDimension(R.styleable.CustomView01_textsize,10);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        RectF rectF = new RectF();
        rectF.left = getWidth()/2-radius-stokewidth;
        rectF.right = getWidth()/2+radius+stokewidth;
        rectF.top = getHeight()/2-radius-stokewidth;
        rectF.bottom = getHeight()/2+radius+stokewidth;
        canvas.drawArc(rectF,-90,360,false,backPaint);
        canvas.drawArc(rectF,-90,90,false,proPaint);

        //计算文本宽高
        textPaint.getTextBounds(text, 0, String.valueOf(text).length(), mText);
        canvas.drawText(text,getWidth()/2,getHeight()/2,textPaint);

    }
}
