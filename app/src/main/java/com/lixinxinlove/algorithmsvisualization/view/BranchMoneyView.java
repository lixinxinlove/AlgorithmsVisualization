package com.lixinxinlove.algorithmsvisualization.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.Arrays;
import java.util.Random;

/**
 * @description:
 * @author: lixinxin
 * @date: 2019/6/17 9:44
 * @version: 1.0
 */
public class BranchMoneyView extends View {

    private final int COUNT = 60;
    private int width;
    private int height;
    private int minSize;
    private Paint paint;

    private int[] moneyArr;
    private int algoWidth;

    private Random random;

    private Handler handler;

    public BranchMoneyView(Context context) {
        super(context);
        init(context);
    }


    public BranchMoneyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public BranchMoneyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        moneyArr = new int[COUNT];
        random = new Random();
        for (int i = 0; i < COUNT; i++) {
            moneyArr[i] = 100;
        }

        handler = new Handler(context.getMainLooper());
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = getMeasuredWidth();
        height = getMeasuredHeight();
        //minSize = Math.min(width, height);
        minSize = height / 2;
        // setMeasuredDimension(minSize, minSize);
        algoWidth = width / COUNT;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // canvas.drawOval(0, 0, minSize, minSize, paint);
        // paint.setColor(Color.BLUE);
        drawAlgo(canvas);
    }


    private void drawAlgo(Canvas canvas) {
        int l, t, b, r;
        for (int i = 0; i < COUNT; i++) {
            l = i * algoWidth + 2;
            t = minSize - (minSize / 400 * moneyArr[i]);
            b = minSize;
            r = (i + 1) * algoWidth - 2;

            if (t >minSize) {
                paint.setColor(Color.RED);
            } else {
                paint.setColor(Color.BLUE);
            }
            canvas.drawRect(l, t, r, b, paint);
        }


        int i = random.nextInt(COUNT);
        int j = random.nextInt(COUNT);
        if (i != j) {
            moneyArr[i] = moneyArr[i] - 5;
            moneyArr[j] = moneyArr[j] + 5;
        }

        Arrays.sort(moneyArr);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                invalidate();
            }
        }, 2);
    }

}
