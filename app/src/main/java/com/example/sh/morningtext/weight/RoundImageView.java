package com.example.sh.morningtext.weight;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class RoundImageView extends android.support.v7.widget.AppCompatImageView{

    private Paint paint;
    private Bitmap mBitmap;
    public RoundImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setFlags(Paint.ANTI_ALIAS_FLAG);
        paint.setAntiAlias(true);
    }

    public void setBitmap(Bitmap bitmap){
        this.mBitmap = bitmap;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(mBitmap == null) return;

        Rect rect = new Rect();
        rect.set(0,0,getWidth(),getHeight());
        canvas.save();
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG));

        Path path = new Path();
        path.addCircle(getWidth()/2,getWidth()/2,getHeight()/2, Path.Direction.CCW);
        canvas.clipPath(path);
        canvas.drawBitmap(mBitmap,null,rect,paint);
        canvas.restore();


    }
}
