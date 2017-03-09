package candrwow.cn.circlepercent;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Dimension;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Candrwow on 2017/3/9.
 */

public class CoverPercentProgressBar extends View {
    int radius;
    int ringRadius;
    int circleLineSize;
    int circleBackground;
    int ringBackground;
    int circleLineColor;
    int textColor;

    /**
     * 不支持代码注入
     *
     * @param context
     */
    public CoverPercentProgressBar(Context context) {
        super(context);
    }

    public CoverPercentProgressBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CoverArcPercent);
        radius = typedArray.getDimensionPixelSize(R.styleable.CoverArcPercent_radius, 100);
        ringRadius = typedArray.getDimensionPixelSize(R.styleable.CoverArcPercent_ringRadius, 100);
        circleLineSize = typedArray.getDimensionPixelSize(R.styleable.CoverArcPercent_circleLineSize, 100);
        circleBackground = typedArray.getColor(R.styleable.CoverArcPercent_circleBackground, Color.TRANSPARENT);
        ringBackground = typedArray.getColor(R.styleable.CoverArcPercent_ringBackground, Color.GRAY);
        circleLineColor = typedArray.getColor(R.styleable.CoverArcPercent_circleLineColor, Color.GRAY);
        textColor = typedArray.getColor(R.styleable.CoverArcPercent_textColor, Color.WHITE);
        typedArray.recycle();
        initPaint();
    }

    Paint circlePaint;
    Paint ringPaint;
    Paint textPaint;
    RectF circleRectF;
    RectF ringRectF;
    RectF textRectF;

    int sweepAngle = 0;
    int startAngle = -90;

    public void initPaint() {
        circlePaint = new Paint();
        circlePaint.setAntiAlias(true);//使用抗锯齿功能
        circlePaint.setColor(Color.GREEN);    //设置画笔的颜色为绿色
        circlePaint.setStyle(Paint.Style.STROKE);
        ringPaint = new Paint();
        ringPaint.setAntiAlias(true);
        ringPaint.setColor(ringBackground);
        ringPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        circleRectF = new RectF(0, 0, 2 * radius, 2 * radius);
        canvas.drawArc(circleRectF, startAngle, 360, false, circlePaint);
        ringRectF = new RectF((radius - ringRadius) / 2, (radius - ringRadius) / 2, radius + ringRadius, radius + ringRadius);
        canvas.drawArc(ringRectF, startAngle, sweepAngle, true, ringPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
