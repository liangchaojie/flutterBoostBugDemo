package com.demo.flutter_app_1;

import android.content.Context;

import java.util.Map;

import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugin.platform.PlatformViewFactory;

public class MyPlatformViewFactory extends PlatformViewFactory {

    private BinaryMessenger messenger;

    public MyPlatformViewFactory(BinaryMessenger messenger) {
        super(StandardMessageCodec.INSTANCE);
        this.messenger = messenger;
    }

    public MyPlatformViewFactory(MessageCodec<Object> createArgsCodec) {
        super(createArgsCodec);
    }

    @Override
    public PlatformView create(Context context, int viewId, Object args) {
        Map<String, Object> params = (Map<String, Object>) args;
       // return new MyPlatformScaleView(context, messenger, viewId, params);
        return new MyPlatformView(context, messenger, viewId, params);
    }
}
