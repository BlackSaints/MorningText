package com.example.sh.morningtext.weight;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.nfc.Tag;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.sh.morningtext.R;

@SuppressLint("AppCompatCustomView")
public class WaterButtonView extends Button {

    private String TAG = WaterButtonView.class.getSimpleName();
    private Paint bottomPaint;
    private Paint colorPaint;
    private int eventX;
    private int eventY;
    private int viewWidth;
    private int viewHeight;
    private int maxRadius;
    private boolean isPushButton;
    private int pointX, pointY;
    private int shaderRadio;
    private int INVALIDATE_DURATION = 15;
    private long downTime;
    private static int DIFFUSE_GAP = 10;
    private static int TAP_TIMEOUT;

    public WaterButtonView(Context context) {
        this(context, null);
    }

    public WaterButtonView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
        TAP_TIMEOUT = ViewConfiguration.getLongPressTimeout();
    }

    private void initPaint() {
        bottomPaint = new Paint();
        bottomPaint.setColor(getResources().getColor(R.color.colorAccent));

        colorPaint = new Paint();
        colorPaint.setColor(getResources().getColor(R.color.colorPrimary));
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                if (downTime == 0)
                    downTime = SystemClock.elapsedRealtime();
                eventX = (int) event.getX();
                eventY = (int) event.getY();
                //计算最大半径
                countMaxRadio();
                isPushButton = true;
                postInvalidateDelayed(INVALIDATE_DURATION);
                break;
            case MotionEvent.ACTION_UP:
                break;
            case MotionEvent.ACTION_CANCEL:
                if(SystemClock.elapsedRealtime() - downTime < TAP_TIMEOUT){
                    DIFFUSE_GAP = 30;
                    postInvalidate();
                }else{
                    clearData();
                }
                break;
        }

        return super.onTouchEvent(event);
    }


    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if(!isPushButton) return; //如果按钮没有被按下则返回
        //绘制按下后的整个背景
        canvas.drawRect(pointX, pointY, pointX + viewWidth, pointY + viewHeight, bottomPaint);
        canvas.save();
        //绘制扩散圆形背景
        canvas.clipRect(pointX, pointY, pointX + viewWidth, pointY + viewHeight);
        canvas.drawCircle(eventX, eventY, shaderRadio, colorPaint);
        canvas.restore();
        //直到半径等于最大半径
        if(shaderRadio < maxRadius){
            postInvalidateDelayed(INVALIDATE_DURATION,
                    pointX, pointY, pointX + viewWidth, pointY + viewHeight);
            shaderRadio += DIFFUSE_GAP;
        }else{
            clearData();
        }
    }

//    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//        //没有按下则取消
//        if (isPushButton) return;
//
//        //绘制按下后的背景
//        canvas.drawRect(pointX, pointY, pointX + viewWidth, pointY + viewHeight, bottomPaint);
//        canvas.save();
//
//        //绘制扩散背景
//        canvas.clipRect(pointX, pointY, pointX + viewWidth, pointY + viewHeight);
//        canvas.drawCircle(eventX, eventY, maxRadius, colorPaint);
//        canvas.restore();
//
//        if (shaderRadio < maxRadius) {
//            postInvalidateDelayed(INVALIDATE_DURATION,
//                    pointX, pointY, pointX + viewWidth, pointY + viewHeight);
//            shaderRadio += DIFFUSE_GAP;
//        } else {
//            clearData();
//        }
//    }

    /**
     * 扩散到最大清除信息
     */
    private void clearData() {

        downTime = 0;
        DIFFUSE_GAP = 10;
        isPushButton = false;
        shaderRadio = 0;
        postInvalidate();
    }

    /**
     * 计算最大半径
     */
    private void countMaxRadio() {

        if (viewWidth > viewHeight) {
            if (eventX < viewWidth / 2) {
                maxRadius = viewWidth - eventX;
            } else {
                maxRadius = viewWidth / 2 + eventX;
            }
        } else {
            if (eventY < viewHeight / 2) {
                maxRadius = viewHeight - eventY;
            } else {
                maxRadius = viewHeight / 2 + eventY;
            }
        }

//        int leftDiance = eventX - getPaddingLeft();
//        int rightDiance = viewWidth - getPaddingLeft() - getPaddingRight() - eventX;
//        Log.e(TAG, "leftDiance==" + leftDiance + ", rightDiance=" + rightDiance);
//        if (leftDiance == rightDiance) {
//            maxRadius = leftDiance;
//        } else if (leftDiance > rightDiance) {
//            maxRadius = leftDiance;
//        } else {
//            maxRadius = rightDiance;
//        }

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.viewWidth = w;
        this.viewHeight = h;
    }
}
