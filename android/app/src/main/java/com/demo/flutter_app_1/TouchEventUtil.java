package com.demo.flutter_app_1;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;

import static android.view.MotionEvent.ACTION_POINTER_1_DOWN;
import static android.view.MotionEvent.ACTION_POINTER_1_UP;
import static android.view.MotionEvent.ACTION_POINTER_2_DOWN;
import static android.view.MotionEvent.ACTION_POINTER_2_UP;
import static android.view.MotionEvent.ACTION_POINTER_3_DOWN;
import static android.view.MotionEvent.ACTION_POINTER_3_UP;
import static android.view.MotionEvent.ACTION_POINTER_ID_MASK;

public class TouchEventUtil {
    public static String getTouchEventName(MotionEvent event) {
        String result = "";
        switch (event.getAction()) {
            case ACTION_POINTER_1_DOWN:
                result = "ACTION_POINTER_1_DOWN";
                break;
            case ACTION_POINTER_2_DOWN:
                result = "ACTION_POINTER_2_DOWN";
                break;
            case ACTION_POINTER_3_DOWN:
                result = "ACTION_POINTER_3_DOWN";
                break;
            case ACTION_POINTER_1_UP:
                result = "ACTION_POINTER_1_UP";
                break;
            case ACTION_POINTER_2_UP:
                result = "ACTION_POINTER_2_UP";
                break;
            case ACTION_POINTER_3_UP:
                result = "ACTION_POINTER_3_UP";
                break;
            case ACTION_POINTER_ID_MASK:
                result = "ACTION_POINTER_ID_MASK";
                break;
        }
//        if (event.getAction() == 773) {
//            Log.i("TAG", "getTouchEventName: " + event.toString());
//            Log.i("TAG", "getTouchEventName: " + ACTION_POINTER_3_DOWN);
//            Log.i("TAG", "getTouchEventName:KKK " + (event.getAction() == ACTION_POINTER_3_DOWN));
//        }
        Log.i("TAG", "getTouchEventName: total " + event.toString());
        Log.i("TAG", "getTouchEventName: action " + event.getAction());
        String s = TextUtils.isEmpty(result) ? event.getAction() + "" : result;
        Log.i("TAG", "getTouchEventName: name " + s);
        return result;
    }
}
