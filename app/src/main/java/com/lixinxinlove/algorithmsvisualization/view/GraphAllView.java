package com.lixinxinlove.algorithmsvisualization.view;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import androidx.annotation.Nullable;

import com.lixinxinlove.algorithmsvisualization.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: lixinxin
 * @date: 2019/6/19 11:06
 * @version: 1.0
 */
public class GraphAllView extends View {

    private int pointCount = 5;
    private int size;
    private List<Point> points;
    private int maxRadius = 500;
    private int minRadius = 15;
    private Paint paint;
    private Path path;
    private PathMeasure pathMeasure;


    @SuppressLint("ResourceAsColor")
    private int[] colors;


    private ObjectAnimator animator;


    public GraphAllView(Context context) {
        super(context);
        init();
    }

    public GraphAllView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public GraphAllView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
        size = getMeasuredWidth();
    }


    private void init() {
        points = new ArrayList<>();
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(2);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.RED);
        path = new Path();
        path.addCircle(0, 0, maxRadius, Path.Direction.CW);
        pathMeasure = new PathMeasure(path, false);


        colors = new int[]{
                R.color.event_color_0,
                R.color.event_color_1,
                R.color.event_color_2,
                R.color.event_color_3,
                R.color.event_color_4,
                R.color.event_color_5,
                R.color.event_color_6,
                R.color.event_color_7,
                R.color.event_color_8,
                R.color.event_color_9,
                R.color.event_color_10,
                R.color.event_color_11,
                R.color.event_color_12,
                R.color.event_color_13,
                R.color.event_color_14,
                R.color.event_color_15,
                R.color.event_color_16,
                R.color.event_color_17,
                R.color.event_color_18,
                R.color.event_color_19
        };


        animator = ObjectAnimator.ofInt(this, "pointCount", 5, 51);
        animator.setDuration(10000);
        animator.setRepeatCount(1);
        //animator.setInterpolator(new BounceInterpolator());
        animator.setInterpolator(new LinearInterpolator());


    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //移动canvas坐标系到中心
        canvas.translate(size / 2, size / 2);
        // canvas.drawPath(path, paint);
        paint.setStrokeWidth(1f);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);

        float distanceRatio = 0;
        float[] pos = new float[2]; //记录位置
        float[] tan = new float[2]; //记录切点值xy

        float distance;
        points.clear();
        for (int i = 0; i < pointCount; i++) {
            distance = pathMeasure.getLength() * distanceRatio;
            pathMeasure.getPosTan(distance, pos, tan);
            distanceRatio += 1f / pointCount;
            pathMeasure.getPosTan(distance, pos, tan);
            points.add(new Point((int) pos[0], (int) pos[1]));
        }


        for (int i = 0; i < pointCount; i++) {
            paint.setColor(getResources().getColor(colors[i % 20]));
            for (Point point : points) {
                canvas.drawLine(points.get(i).x, points.get(i).y, point.x, point.y, paint);
            }
        }

//        for (int i = 0; i < pointCount; i++) {
//            paint.setColor(getResources().getColor(colors[i % 20]));
//            canvas.drawCircle(points.get(i).x, points.get(i).y, minRadius, paint);
//        }


    }


    public void add() {
        pointCount++;
        invalidate();
        //animator.start();
    }


    public int getPointCount() {
        return pointCount;
    }

    public void setPointCount(int pointCount) {
        this.pointCount = pointCount;
        invalidate();
    }
}
