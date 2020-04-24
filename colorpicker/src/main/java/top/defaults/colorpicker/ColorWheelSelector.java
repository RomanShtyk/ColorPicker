package top.defaults.colorpicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import static top.defaults.colorpicker.Constants.SELECTOR_RADIUS_DP;

public class ColorWheelSelector extends View {

    private Paint selectorPaint;
    private Paint borderPaint;
    private float selectorRadiusPx = SELECTOR_RADIUS_DP * 3;
    private PointF currentPoint = new PointF();

    public ColorWheelSelector(Context context) {
        this(context, null);
    }

    public ColorWheelSelector(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ColorWheelSelector(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setElevation(50F);
        }

        selectorPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        selectorPaint.setColor(Color.WHITE);
        selectorPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        selectorPaint.setStrokeWidth(2);

        borderPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        borderPaint.setColor(Color.LTGRAY);
        borderPaint.setStyle(Paint.Style.STROKE);
        borderPaint.setStrokeWidth(2);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(currentPoint.x, currentPoint.y, selectorRadiusPx * 0.66f, selectorPaint);
        canvas.drawCircle(currentPoint.x, currentPoint.y, selectorRadiusPx * 0.66f, borderPaint);
    }

    public void setSelectorRadiusPx(float selectorRadiusPx) {
        this.selectorRadiusPx = selectorRadiusPx;
    }

    public void setCurrentPoint(PointF currentPoint) {
        this.currentPoint = currentPoint;
        invalidate();
    }
}
