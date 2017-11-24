package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.Data;

public class Practice10HistogramView extends View {

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private Paint mPaint = new Paint();
    // x轴长度
    private final int X = 800;
    // y轴长度
    private final int Y = 500;
    // 设坐标原点为100, 600
    private float[] mCoordinate = new float[]{100, 600, 100, 600 - Y, 100, 600, 100 + X, 600};
    // 柱形之间的间隔
    private final int INTERVAL = 20;
    // Android各版本占比数据
    private Data mData = new Data();

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图

        // 画坐标
        mPaint.setColor(Color.WHITE);
        mPaint.setStrokeWidth(2);
        canvas.drawLines(mCoordinate, mPaint);

        // 画柱形
        mPaint.setColor(Color.GREEN);
        int count = mData.mList.size();
        int width = ((X - INTERVAL) / count) - INTERVAL;// 柱形的宽度
        for (int i = 0; i < count; i++) {
            Data.Bean bean = mData.mList.get(i);
            int left = 100 + INTERVAL * (i + 1) + width * i;

            canvas.drawRect(left, 600 - bean.getProportion() * (2 * Y),
                    left + width, 600, mPaint);
        }
    }
}
