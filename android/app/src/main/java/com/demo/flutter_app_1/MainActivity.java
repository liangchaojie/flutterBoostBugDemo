package com.demo.flutter_app_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import io.flutter.app.FlutterActivity;
import io.flutter.plugins.GeneratedPluginRegistrant;

public class MainActivity extends FlutterActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_second);
        GeneratedPluginRegistrant.registerWith(this);
        MyPlatformViewFlutterPlugin.registerWith(this);
       // startActivity(new Intent(this, SecondActivity.class));
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.i("TAG", "onCreate: getFdCount finish "+ProcessUtil.getFdCount());

                finish();
            }
        },3000);
    }

    Handler handler = new Handler();

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("TAG", "onCreate: getFdCount "+ProcessUtil.getFdCount());
    }
}
