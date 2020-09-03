package com.demo.flutter_app_1;

import android.content.Context;
import android.view.View;

import java.util.Map;

import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.platform.PlatformView;

public class MyPlatformScaleView implements PlatformView {

    private GestureDemoView myNativeView;

    MyPlatformScaleView(Context context, BinaryMessenger messenger, int id, Map<String, Object> params) {
        GestureDemoView myNativeView = new GestureDemoView(context);
        this.myNativeView = myNativeView;
    }

    @Override
    public View getView() {
        return myNativeView;
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
}
