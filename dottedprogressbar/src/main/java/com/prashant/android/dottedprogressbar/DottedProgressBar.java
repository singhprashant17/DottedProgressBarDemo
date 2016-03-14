package com.prashant.android.dottedprogressbar;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;

public class DottedProgressBar extends View {
    private final float dotSize;
    private final DisplayMetrics displaymetrics;
    private int emptyDotsColor;
    private int activeDotColor;
    private int numberOfDots;
    private Paint mPaint;
    private int levels;

    public DottedProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);

        displaymetrics = new DisplayMetrics();
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs, R.styleable.DottedProgressBar, 0, 0);

        try {
            emptyDotsColor = a.getColor(R.styleable.DottedProgressBar_emptyDotsColor, Color.WHITE);
            activeDotColor = a.getColor(R.styleable.DottedProgressBar_activeDotColor, Color.BLUE);

            TypedValue value = new TypedValue();

            if (value.type >= TypedValue.TYPE_FIRST_COLOR_INT && value.type <= TypedValue
                    .TYPE_LAST_COLOR_INT) {
                // It's a color
                activeDotColor = getResources().getColor(value.resourceId);
            }

            if (value.type >= TypedValue.TYPE_FIRST_COLOR_INT && value.type <= TypedValue
                    .TYPE_LAST_COLOR_INT) {
                // It's a color
                emptyDotsColor = getResources().getColor(value.resourceId);
            }

            dotSize = a.getDimensionPixelSize(R.styleable.DottedProgressBar_dotSize, 5);

            numberOfDots = a.getInteger(R.styleable.DottedProgressBar_noOfDots, 7);

            levels = a.getInteger(R.styleable.DottedProgressBar_level, 0);

            mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            mPaint.setStyle(Paint.Style.FILL);

        } finally {
            a.recycle();
        }
    }

    public float getDotSize() {
        return dotSize;
    }

    public int getEmptyDotsColor() {
        return emptyDotsColor;
    }

    public void setEmptyDotsColor(int emptyDotsColor) {
        this.emptyDotsColor = emptyDotsColor;
    }

    public int getActiveDotColor() {
        return activeDotColor;
    }

    public void setActiveDotColor(int activeDotColor) {
        this.activeDotColor = activeDotColor;
    }

    public int getNumberOfDots() {
        return numberOfDots;
    }

    public void setNumberOfDots(int numberOfDots) {
        this.numberOfDots = numberOfDots;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int startPoint = (int) (dotSize / 2);
        int endPoint = (int) (getWidth() - (dotSize / 2));
        int spaceBetweenPoints = (endPoint - startPoint) / (numberOfDots - 1);

        int counter = startPoint;

        /**
         * Draw a white line from start to end
         */
        mPaint.setStrokeWidth(20);
        mPaint.setColor(emptyDotsColor);
        canvas.drawLine(startPoint, getHeight() / 2, endPoint, getHeight() / 2, mPaint);


        /**
         * Draw as much number of highlighted dots
         */
        for (int i = 0; i < levels; i++, counter += spaceBetweenPoints) {
            mPaint.setColor(activeDotColor);
            canvas.drawCircle(counter, getPaddingTop() + dotSize / 2, dotSize / 2, mPaint);
        }

        /**
         * Draw highlighted line
         */
        canvas.drawLine(startPoint, getHeight() / 2, counter - spaceBetweenPoints, getHeight() /
                2, mPaint);

        /**
         * Draw inactive dots
         */
        for (int i = levels; i < numberOfDots; i++, counter += spaceBetweenPoints) {
            mPaint.setColor(emptyDotsColor);
            canvas.drawCircle(counter, getPaddingTop() + dotSize / 2, dotSize / 2, mPaint);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int calculatedHeight = getPaddingTop() + getPaddingBottom() + (int) dotSize;
        ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int width = displaymetrics.widthPixels;
        setMeasuredDimension(width - getPaddingLeft() - getPaddingRight(), calculatedHeight);
    }

    public void setLevel(int levels) {
        if (levels <= numberOfDots) {
            this.levels = levels;
        }
        invalidate();
    }
}