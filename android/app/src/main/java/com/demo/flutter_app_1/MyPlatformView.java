package com.demo.flutter_app_1;

import android.content.Context;
import android.util.Log;
import android.view.View;

import java.util.Map;

import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.platform.PlatformView;

public class MyPlatformView implements PlatformView, MethodChannel.MethodCallHandler {

    private GestureDemoView mGestureDemoView;

    MyPlatformView(Context context, BinaryMessenger messenger, int id, Map<String, Object> params) {
        Log.e("shenzhixinsss","MyPlatformView");
        mGestureDemoView = new GestureDemoView(context);
    }


    @Override
    public View getView() {
        return mGestureDemoView;
    }

    @Override
    public void dispose() {

    }

    @Override
    public void onInputConnectionLocked() {

    }

    @Override
    public void onInputConnectionUnlocked() {

    }

    @Override
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        //在接口的回调方法中可以接收到来自Flutter的调用

        System.out.println("methodCall.method" + methodCall.method);

        if ("setText".equals(methodCall.method)) {
            String text = (String) methodCall.arguments;
            Log.e("shenzhixinflutter","text:"+text);
           // myNativeView.setText(text);
            result.success(null);
        }
    }
}
