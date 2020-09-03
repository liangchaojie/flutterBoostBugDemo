package com.demo.flutter_app_1;

import android.app.Activity;
import android.content.Intent;
import android.view.MotionEvent;

class SplashActivity extends Activity {
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_UP){
            gogogo();
            return true;
        }
        return super.onTouchEvent(event);
    }

    private void gogogo() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
