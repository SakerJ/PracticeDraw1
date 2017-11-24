package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.Data;

public class Practice11PieChartView extends View {

    public Practice11PieChartView(Context context) {
        super(context);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private RectF mRectF = new RectF(100, 100, 600, 600);
    // 数据
    private Data mData = new Data();
    // 扇形的间隔Paint
    private Paint mStrokePaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图

        mPaint.setColor(Color.GREEN);

        mStrokePaint.setStyle(Paint.Style.STROKE);
        mStrokePaint.setStrokeWidth(3);// 间隔的宽度/2
        mStrokePaint.setColor(Color.rgb(80, 110, 122));// 颜色与底色相同

        // 画扇形
        float angle = 0;// 记录已绘制的角度
        int count = mData.mList.size();
        for (int i = 0; i < count; i++) {
            Data.Bean bean = mData.mList.get(i);
            float sweep = bean.getProportion() * 360;// 所占的角度
            canvas.drawArc(mRectF, angle, sweep, true, mPaint);
            // 绘制扇形之间的间隔：绘制一个相同的扇形(Paint为STROKE)
            canvas.drawArc(mRectF, angle, sweep, true, mStrokePaint);
            angle += sweep;
        }
    }

    // TODO: 2017/11/24 点击扇形放大：将mRectF放大，再重画该扇形
}
