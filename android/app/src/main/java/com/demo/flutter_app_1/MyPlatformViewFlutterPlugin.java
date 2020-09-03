package com.demo.flutter_app_1;


import io.flutter.plugin.common.PluginRegistry;

public class MyPlatformViewFlutterPlugin {

    public static void registerWith(PluginRegistry registry) {
        final String key = MyPlatformViewFlutterPlugin.class.getCanonicalName();
        if (registry.hasPlugin(key)) return;
        PluginRegistry.Registrar registrar = registry.registrarFor(key);
        registrar.platformViewRegistry().registerViewFactory("plugins.test/my_view", new MyPlatformViewFactory(registrar.messenger()));
    }
}
