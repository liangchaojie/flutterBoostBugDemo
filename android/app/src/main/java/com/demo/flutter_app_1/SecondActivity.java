package com.demo.flutter_app_1;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

import java.util.Map;

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      // setContentView(R.layout.activity_second);
        initActivity();
    }


    private void initActivity() {
        getApplication().registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                if(activity instanceof MainActivity){
                    int threadSize = getThreadSize();
                    int fdCount = getFdCount();
                    Log.e("akakak","[QcsMap] uninit onActivityCreated threadSize:"+threadSize);
                    Log.e("akakak","[QcsMap] uninit onActivityCreated fdCount:"+fdCount);

                }
            }

            private int getFdCount() {
                return ProcessUtil.getFdCount();
            }

            private int getThreadSize() {
                Map<Thread, StackTraceElement[]> stacks = Thread.getAllStackTraces();
                return stacks.size();
            }




            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                if(activity instanceof MainActivity){
                    int threadSize = getThreadSize();
                    int fdCount = getFdCount();
                    Log.e("akakak","[QcsMap] uninit onActivityDestroyed threadSize:"+threadSize);
                    Log.e("akakak","[QcsMap] uninit onActivityDestroyed fdCount:"+fdCount);

                }
            }
        });
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
            gogogo();
            return true;
        }
        return super.onTouchEvent(event);
    }

    private void gogogo() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}