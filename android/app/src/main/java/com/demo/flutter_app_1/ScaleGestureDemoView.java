package com.demo.flutter_app_1;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;

public class ScaleGestureDemoView extends View {
    private static final String TAG = "ScaleGestureDemoView";

    private ScaleGestureDetector mScaleGestureDetector;

    public ScaleGestureDemoView(Context context) {
        super(context);
    }

    public ScaleGestureDemoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initScaleGestureDetector();
    }

    private void initScaleGestureDetector() {
        mScaleGestureDetector = new ScaleGestureDetector(getContext(), new ScaleGestureDetector.SimpleOnScaleGestureListener() {
            @Override
            public boolean onScaleBegin(ScaleGestureDetector detector) {
                return true;
            }

            @Override
            public boolean onScale(ScaleGestureDetector detector) {
                Log.i(TAG, "focusX = " + detector.getFocusX());       // 缩放中心，x坐标
                Log.i(TAG, "focusY = " + detector.getFocusY());       // 缩放中心y坐标
                Log.i(TAG, "scale = " + detector.getScaleFactor());   // 缩放因子
                return true;
            }

            @Override
            public void onScaleEnd(ScaleGestureDetector detector) {
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mScaleGestureDetector.onTouchEvent(event);
        return true;
    }
}
