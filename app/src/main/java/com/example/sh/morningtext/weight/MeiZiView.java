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

public class MeiZiView extends View {

    public float bitmapX;
    public float bitmapY;
    public MeiZiView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        bitmapX = 0;
        bitmapY = 200;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.s_1);

        canvas.drawBitmap(bitmap,bitmapX,bitmapY,paint);

        if(bitmap != null){
            bitmap.recycle();
        }
    }
}
