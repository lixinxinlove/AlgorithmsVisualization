package com.lixinxinlove.algorithmsvisualization.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author: lixinxin
 * @date: 2019/6/17 11:50
 * @version: 1.0
 */
public class PiView extends View {
    private int N = 100000;

    private int size;
    private Paint paint;
    private Paint greenPaint;
    private Paint redPaint;
    public volatile List<Point> data;

    public PiView(Context context) {
        super(context);
        init(context);
    }

    public PiView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public PiView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(2);
        paint.setStyle(Paint.Style.STROKE);

        greenPaint = new Paint();
        greenPaint.setAntiAlias(true);
        greenPaint.setColor(Color.GREEN);
        greenPaint.setStrokeWidth(5);

        redPaint = new Paint();
        redPaint.setAntiAlias(true);
        redPaint.setColor(Color.RED);
        redPaint.setStrokeWidth(5);

        data = new LinkedList<>();


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
        size = getMeasuredWidth();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawOval(0, 0, size, size, paint);
        drawPoint(canvas);
    }

    public void drawPoint(Canvas canvas) {
        for (int i = 0; i < N; i++) {
            Point point = new Point();
            point.x = (int) (Math.random() * size);
            point.y = (int) (Math.random() * size);
            data.add(point);

            if (concatPoint(point)) {
                canvas.drawPoint(point.x, point.y, redPaint);
            } else {
                canvas.drawPoint(point.x, point.y, greenPaint);
            }
        }
    }


    public boolean concatPoint(Point point) {
        if (Math.abs(point.x - size / 2) * Math.abs(point.x - size / 2) + Math.abs(point.y - size / 2) * Math.abs(point.y - size / 2)
                <= (size / 2) * (size / 2)) {
            return true;
        }
        return false;
    }


}
