# FlutterCrashDemo
This is a demo for revealing flutter bug.
[TOC]
## [Latest link](http://note.youdao.com/s/3xniXDek)
## 1 Problem Description

> When I use PlatformView with GestureDetector and swipe it quickly with multiple fingers in flutter app, the program crashes.

## 2 About Flutter SDK

```
gerry@GerrydeMacBook-Pro flutter_app_1 % flutter doctor -v
[✓] Flutter (Channel unknown, v1.9.1+hotfix.107-pre.3, on Mac OS X 10.15.5 19F101, locale zh-Hans-CN)
    • Flutter version 1.9.1+hotfix.107-pre.3 at /Users/gerry/.flutter_sdk
    • Framework revision 6184f052c2 (6 weeks ago), 2020-06-03 20:44:10 +0800
    • Engine revision 57630bd55d
    • Dart version 2.5.0

[✓] Android toolchain - develop for Android devices (Android SDK version 29.0.3)
    • Android SDK at /Users/gerry/Library/Android/sdk
    • Android NDK location not configured (optional; useful for native profiling support)
    • Platform android-29, build-tools 29.0.3
    • ANDROID_HOME = /Users/gerry/Library/Android/sdk
    • Java binary at: /Applications/Android Studio.app/Contents/jre/jdk/Contents/Home/bin/java
    • Java version OpenJDK Runtime Environment (build 1.8.0_242-release-1644-b3-6222593)
    • All Android licenses accepted.

[✓] Xcode - develop for iOS and macOS (Xcode 11.5)
    • Xcode at /Applications/Xcode.app/Contents/Developer
    • Xcode 11.5, Build version 11E608c
    • CocoaPods version 1.9.1

[✓] Android Studio (version 4.0)
    • Android Studio at /Applications/Android Studio.app/Contents
    • Flutter plugin version 46.0.2
    • Dart plugin version 193.7361
    • Java version OpenJDK Runtime Environment (build 1.8.0_242-release-1644-b3-6222593)

[✓] Android Studio (version 3.4)
    • Android Studio at /Applications/Android Studio2.app/Contents
    • Flutter plugin version 39.0.1
    • Dart plugin version 192.7761
    • Java version OpenJDK Runtime Environment (build 1.8.0_152-release-1343-b01)


```
## 3 Crash Logcat Info

```
2020-07-14 11:43:59.796 15182-15182/? A/DEBUG: SYSVMTYPE: Maple
    APPVMTYPE: Art
2020-07-14 11:43:59.796 15182-15182/? A/DEBUG: pid: 14419, tid: 14419, name: n.flutter_app_1  >>> com.meituan.flutter_app_1 <<<
2020-07-14 11:43:59.796 15182-15182/? A/DEBUG: signal 6 (SIGABRT), code -6 (SI_TKILL), fault addr --------
2020-07-14 11:43:59.796 15182-15182/? A/DEBUG: Abort message: 'ubsan: shift-out-of-bounds'
2020-07-14 11:43:59.796 15182-15182/? A/DEBUG:     r0  00000000  r1  00003853  r2  00000006  r3  00000008
2020-07-14 11:43:59.796 15182-15182/? A/DEBUG:     r4  00003853  r5  00003853  r6  fff4100c  r7  0000010c
2020-07-14 11:43:59.796 15182-15182/? A/DEBUG:     r8  da286080  r9  e3344000  r10 da286080  r11 00000000
2020-07-14 11:43:59.796 15182-15182/? A/DEBUG:     ip  00000041  sp  fff40ff8  lr  e5532a6d  pc  e552a796
2020-07-14 11:44:00.005 15182-15182/? A/DEBUG: backtrace:
2020-07-14 11:44:00.005 15182-15182/? A/DEBUG:     #00 pc 0001d796  /system/lib/libc.so (abort+58)
2020-07-14 11:44:00.005 15182-15182/? A/DEBUG:     #01 pc 0001e324  /system/lib/libinput.so (abort_with_message(char const*)+24)
2020-07-14 11:44:00.005 15182-15182/? A/DEBUG:     #02 pc 0001e560  /system/lib/libinput.so (__ubsan_handle_shift_out_of_bounds_minimal_abort+24)
2020-07-14 11:44:00.005 15182-15182/? A/DEBUG:     #03 pc 0001c807  /system/lib/libinput.so (android::VelocityTracker::addMovement(android::MotionEvent const*)+666)
2020-07-14 11:44:00.005 15182-15182/? A/DEBUG:     #04 pc 003f005b  /system/framework/arm/boot-framework.oat (offset 0x3ef000) (android.app.admin.SecurityLog.readEventsOnWrapping [DEDUPED]+130)
2020-07-14 11:44:00.005 15182-15182/? A/DEBUG:     #05 pc 0000f73b  /dev/ashmem/dalvik-jit-code-cache (deleted) (android.view.VelocityTracker.addMovement+58)
2020-07-14 11:44:00.005 15182-15182/? A/DEBUG:     #06 pc 000062f5  /dev/ashmem/dalvik-jit-code-cache (deleted) (android.view.GestureDetector.onTouchEvent+172)
2020-07-14 11:44:00.005 15182-15182/? A/DEBUG:     #07 pc 00011d9d  /dev/ashmem/dalvik-jit-code-cache (deleted) (com.meituan.flutter_app_1.GestureDemoView.onTouchEvent+92)
2020-07-14 11:44:00.005 15182-15182/? A/DEBUG:     #08 pc 0000eb4b  /dev/ashmem/dalvik-jit-code-cache (deleted) (android.view.View.dispatchTouchEvent+602)
2020-07-14 11:44:00.005 15182-15182/? A/DEBUG:     #09 pc 00012b95  /dev/ashmem/dalvik-jit-code-cache (deleted) (io.flutter.plugin.platform.PlatformViewsController$1.onTouch+852)
2020-07-14 11:44:00.005 15182-15182/? A/DEBUG:     #10 pc 0000e409  /dev/ashmem/dalvik-jit-code-cache (deleted) (io.flutter.embedding.engine.systemchannels.PlatformViewsChannel$1.touch+952)
2020-07-14 11:44:00.005 15182-15182/? A/DEBUG:     #11 pc 0000b585  /dev/ashmem/dalvik-jit-code-cache (deleted) (io.flutter.embedding.engine.systemchannels.PlatformViewsChannel$1.onMethodCall+812)
2020-07-14 11:44:00.005 15182-15182/? A/DEBUG:     #12 pc 00016021  /dev/ashmem/dalvik-jit-code-cache (deleted) (io.flutter.plugin.common.MethodChannel$IncomingMethodCallHandler.onMessage+168)
2020-07-14 11:44:00.005 15182-15182/? A/DEBUG:     #13 pc 0000b999  /dev/ashmem/dalvik-jit-code-cache (deleted) (io.flutter.embedding.engine.dart.DartMessenger.handleMessageFromDart+408)
2020-07-14 11:44:00.005 15182-15182/? A/DEBUG:     #14 pc 00015363  /dev/ashmem/dalvik-jit-code-cache (deleted) (io.flutter.embedding.engine.FlutterJNI.handlePlatformMessage+74)
2020-07-14 11:44:00.005 15182-15182/? A/DEBUG:     #15 pc 0043d975  /system/lib/libart.so (art_quick_invoke_stub_internal+68)
2020-07-14 11:44:00.005 15182-15182/? A/DEBUG:     #16 pc 00410061  /system/lib/libart.so (art_quick_invoke_stub+224)
2020-07-14 11:44:00.005 15182-15182/? A/DEBUG:     #17 pc 000a82ad  /system/lib/libart.so (art::ArtMethod::Invoke(art::Thread*, unsigned int*, unsigned int, art::JValue*, char const*)+136)
2020-07-14 11:44:00.005 15182-15182/? A/DEBUG:     #18 pc 0036b4e9  /system/lib/libart.so (art::(anonymous namespace)::InvokeWithArgArray(art::ScopedObjectAccessAlreadyRunnable const&, art::ArtMethod*, art::(anonymous namespace)::ArgArray*, art::JValue*, char const*)+52)
2020-07-14 11:44:00.005 15182-15182/? A/DEBUG:     #19 pc 0036c499  /system/lib/libart.so (art::InvokeVirtualOrInterfaceWithVarArgs(art::ScopedObjectAccessAlreadyRunnable const&, _jobject*, _jmethodID*, std::__va_list)+316)
2020-07-14 11:44:00.005 15182-15182/? A/DEBUG:     #20 pc 00285053  /system/lib/libart.so (art::JNI::CallVoidMethodV(_JNIEnv*, _jobject*, _jmethodID*, std::__va_list)+482)
2020-07-14 11:44:00.005 15182-15182/? A/DEBUG:     #21 pc 00f9f09b  /data/app/com.meituan.flutter_app_1-7LgB6uQz6o3Nb7R-J0d9Dw==/lib/arm/libflutter.so (offset 0xf9a000)
2020-07-14 11:44:00.005 15182-15182/? A/DEBUG:     #22 pc 00f9f055  /data/app/com.meituan.flutter_app_1-7LgB6uQz6o3Nb7R-J0d9Dw==/lib/arm/libflutter.so (offset 0xf9a000)
2020-07-14 11:44:00.005 15182-15182/? A/DEBUG:     #23 pc 00f9db77  /data/app/com.meituan.flutter_app_1-7LgB6uQz6o3Nb7R-J0d9Dw==/lib/arm/libflutter.so (offset 0xf9a000)
2020-07-14 11:44:00.005 15182-15182/? A/DEBUG:     #24 pc 00fd1e3b  /data/app/com.meituan.flutter_app_1-7LgB6uQz6o3Nb7R-J0d9Dw==/lib/arm/libflutter.so (offset 0xf9a000)
2020-07-14 11:44:00.005 15182-15182/? A/DEBUG:     #25 pc 00fa95dd  /data/app/com.meituan.flutter_app_1-7LgB6uQz6o3Nb7R-J0d9Dw==/lib/arm/libflutter.so (offset 0xf9a000)
2020-07-14 11:44:00.005 15182-15182/? A/DEBUG:     #26 pc 00facd4f  /data/app/com.meituan.flutter_app_1-7LgB6uQz6o3Nb7R-J0d9Dw==/lib/arm/libflutter.so (offset 0xf9a000)
2020-07-14 11:44:00.005 15182-15182/? A/DEBUG:     #27 pc 0000f3b7  /system/lib/libutils.so (android::Looper::pollInner(int)+726)
2020-07-14 11:44:00.005 15182-15182/? A/DEBUG:     #28 pc 0000f05f  /system/lib/libutils.so (android::Looper::pollOnce(int, int*, int*, void**)+26)
2020-07-14 11:44:00.006 15182-15182/? A/DEBUG:     #29 pc 000c0db9  /system/lib/libandroid_runtime.so (android::android_os_MessageQueue_nativePollOnce(_JNIEnv*, _jobject*, long long, int)+26)
2020-07-14 11:44:00.006 15182-15182/? A/DEBUG:     #30 pc 003fc45d  /system/framework/arm/boot-framework.oat (offset 0x3ef000) (android.media.MediaExtractor.seekTo [DEDUPED]+92)
2020-07-14 11:44:00.006 15182-15182/? A/DEBUG:     #31 pc 00001f33  /dev/ashmem/dalvik-jit-code-cache (deleted) (android.os.MessageQueue.next+194)
2020-07-14 11:44:00.006 15182-15182/? A/DEBUG:     #32 pc 00040b39  /dev/ashmem/dalvik-jit-code-cache (deleted) (android.os.Looper.loop+360)
2020-07-14 11:44:00.006 15182-15182/? A/DEBUG:     #33 pc 0043d9bb  /system/lib/libart.so (art_quick_osr_stub+42)
2020-07-14 11:44:00.006 15182-15182/? A/DEBUG:     #34 pc 0025a9c5  /system/lib/libart.so (art::jit::Jit::MaybeDoOnStackReplacement(art::Thread*, art::ArtMethod*, unsigned int, int, art::JValue*)+1472)
2020-07-14 11:44:00.006 15182-15182/? A/DEBUG:     #35 pc 0040f667  /system/lib/libart.so (MterpMaybeDoOnStackReplacement+86)
2020-07-14 11:44:00.006 15182-15182/? A/DEBUG:     #36 pc 0043d174  /system/lib/libart.so (ExecuteMterpImpl+66164)
2020-07-14 11:44:00.006 15182-15182/? A/DEBUG:     #37 pc 00b51512  /system/framework/boot-framework.vdex (android.os.Looper.loop+1036)
2020-07-14 11:44:00.006 15182-15182/? A/DEBUG:     #38 pc 001d3d1f  /system/lib/libart.so (_ZN3art11interpreterL7ExecuteEPNS_6ThreadERKNS_20CodeItemDataAccessorERNS_11ShadowFrameENS_6JValueEb.llvm.2251853088+354)
2020-07-14 11:44:00.006 15182-15182/? A/DEBUG:     #39 pc 001d8657  /system/lib/libart.so (art::interpreter::ArtInterpreterToInterpreterBridge(art::Thread*, art::CodeItemDataAccessor const&, art::ShadowFrame*, art::JValue*)+146)
2020-07-14 11:44:00.006 15182-15182/? A/DEBUG:     #40 pc 001ef353  /system/lib/libart.so (bool art::interpreter::DoCall<false, false>(art::ArtMethod*, art::Thread*, art::ShadowFrame&, art::Instruction const*, unsigned short, art::JValue*)+762)
2020-07-14 11:44:00.006 15182-15182/? A/DEBUG:     #41 pc 0040bcb7  /system/lib/libart.so (MterpInvokeStatic+130)
2020-07-14 11:44:00.006 15182-15182/? A/DEBUG:     #42 pc 00430814  /system/lib/libart.so (ExecuteMterpImpl+14612)
2020-07-14 11:44:00.006 15182-15182/? A/DEBUG:     #43 pc 003decbc  /system/framework/boot-framework.vdex (android.app.ActivityThread.main+428)
2020-07-14 11:44:00.006 15182-15182/? A/DEBUG:     #44 pc 001d3d1f  /system/lib/libart.so (_ZN3art11interpreterL7ExecuteEPNS_6ThreadERKNS_20CodeItemDataAccessorERNS_11ShadowFrameENS_6JValueEb.llvm.2251853088+354)
2020-07-14 11:44:00.006 15182-15182/? A/DEBUG:     #45 pc 001d85a3  /system/lib/libart.so (art::interpreter::EnterInterpreterFromEntryPoint(art::Thread*, art::CodeItemDataAccessor const&, art::ShadowFrame*)+82)
2020-07-14 11:44:00.006 15182-15182/? A/DEBUG:     #46 pc 003fa8cb  /system/lib/libart.so (artQuickToInterpreterBridge+882)
2020-07-14 11:44:00.006 15182-15182/? A/DEBUG:     #47 pc 00441eff  /system/lib/libart.so (art_quick_to_interpreter_bridge+30)
2020-07-14 11:44:00.006 15182-15182/? A/DEBUG:     #48 pc 0043d975  /system/lib/libart.so (art_quick_invoke_stub_internal+68)
2020-07-14 11:44:00.006 15182-15182/? A/DEBUG:     #49 pc 00410163  /system/lib/libart.so (art_quick_invoke_static_stub+222)
2020-07-14 11:44:00.006 15182-15182/? A/DEBUG:     #50 pc 000a82bf  /system/lib/libart.so (art::ArtMethod::Invoke(art::Thread*, unsigned int*, unsigned int, art::JValue*, char const*)+154)
2020-07-14 11:44:00.006 15182-15182/? A/DEBUG:     #51 pc 0036b4e9  /system/lib/libart.so (art::(anonymous namespace)::InvokeWithArgArray(art::ScopedObjectAccessAlreadyRunnable const&, art::ArtMethod*, art::(anonymous namespace)::ArgArray*, art::JValue*, char const*)+52)
2020-07-14 11:44:00.006 15182-15182/? A/DEBUG:     #52 pc 0036c93b  /system/lib/libart.so (art::InvokeMethod(art::ScopedObjectAccessAlreadyRunnable const&, _jobject*, _jobject*, _jobject*, unsigned int)+962)
2020-07-14 11:44:00.006 15182-15182/? A/DEBUG:     #53 pc 0031b791  /system/lib/libart.so (art::Method_invoke(_JNIEnv*, _jobject*, _jobject*, _jobjectArray*)+40)
2020-07-14 11:44:00.006 15182-15182/? A/DEBUG:     #54 pc 001381ff  /system/framework/arm/boot.oat (offset 0x132000) (java.lang.Class.getDeclaredMethodInternal [DEDUPED]+110)
2020-07-14 11:44:00.006 15182-15182/? A/DEBUG:     #55 pc 0043d975  /system/lib/libart.so (art_quick_invoke_stub_internal+68)
2020-07-14 11:44:00.006 15182-15182/? A/DEBUG:     #56 pc 00410061  /system/lib/libart.so (art_quick_invoke_stub+224)
2020-07-14 11:44:00.006 15182-15182/? A/DEBUG:     #57 pc 000a82ad  /system/lib/libart.so (art::ArtMethod::Invoke(art::Thread*, unsigned int*, unsigned int, art::JValue*, char const*)+136)
2020-07-14 11:44:00.006 15182-15182/? A/DEBUG:     #58 pc 001f46f7  /system/lib/libart.so (art::interpreter::ArtInterpreterToCompiledCodeBridge(art::Thread*, art::ArtMethod*, art::ShadowFrame*, unsigned short, art::JValue*)+230)
2020-07-14 11:44:00.006 15182-15182/? A/DEBUG:     #59 pc 001ef369  /system/lib/libart.so (bool art::interpreter::DoCall<false, false>(art::ArtMethod*, art::Thread*, art::ShadowFrame&, art::Instruction const*, unsigned short, art::JValue*)+784)
2020-07-14 11:44:00.006 15182-15182/? A/DEBUG:     #60 pc 0040acb7  /system/lib/libart.so (MterpInvokeVirtual+442)
2020-07-14 11:44:00.006 15182-15182/? A/DEBUG:     #61 pc 00430694  /system/lib/libart.so (ExecuteMterpImpl+14228)
2020-07-14 11:44:00.006 15182-15182/? A/DEBUG:     #62 pc 012310c0  /system/framework/boot-framework.vdex (com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run+22)
2020-07-14 11:44:00.006 15182-15182/? A/DEBUG:     #63 pc 001d3d1f  /system/lib/libart.so (_ZN3art11interpreterL7ExecuteEPNS_6ThreadERKNS_20CodeItemDataAccessorERNS_11ShadowFrameENS_6JValueEb.llvm.2251853088+354)
2020-07-14 11:44:00.006 15182-15182/? A/DEBUG:     #64 pc 001d85a3  /system/lib/libart.so (art::interpreter::EnterInterpreterFromEntryPoint(art::Thread*, art::CodeItemDataAccessor const&, art::ShadowFrame*)+82)
2020-07-14 11:44:00.006 15182-15182/? A/DEBUG:     #65 pc 003fa8cb  /system/lib/libart.so (artQuickToInterpreterBridge+882)
2020-07-14 11:44:00.006 15182-15182/? A/DEBUG:     #66 pc 00441eff  /system/lib/libart.so (art_quick_to_interpreter_bridge+30)
2020-07-14 11:44:00.006 15182-15182/? A/DEBUG:     #67 pc 00c7f46f  /system/framework/arm/boot-framework.oat (offset 0x3ef000) (com.android.internal.os.ZygoteInit.main+2070)
2020-07-14 11:44:00.006 15182-15182/? A/DEBUG:     #68 pc 0043d975  /system/lib/libart.so (art_quick_invoke_stub_internal+68)
2020-07-14 11:44:00.006 15182-15182/? A/DEBUG:     #69 pc 00410163  /system/lib/libart.so (art_quick_invoke_static_stub+222)
2020-07-14 11:44:00.006 15182-15182/? A/DEBUG:     #70 pc 000a82bf  /system/lib/libart.so (art::ArtMethod::Invoke(art::Thread*, unsigned int*, unsigned int, art::JValue*, char const*)+154)
2020-07-14 11:44:00.006 15182-15182/? A/DEBUG:     #71 pc 0036b4e9  /system/lib/libart.so (art::(anonymous namespace)::InvokeWithArgArray(art::ScopedObjectAccessAlreadyRunnable const&, art::ArtMethod*, art::(anonymous namespace)::ArgArray*, art::JValue*, char const*)+52)
2020-07-14 11:44:00.006 15182-15182/? A/DEBUG:     #72 pc 0036b2fd  /system/lib/libart.so (art::InvokeWithVarArgs(art::ScopedObjectAccessAlreadyRunnable const&, _jobject*, _jmethodID*, std::__va_list)+300)
2020-07-14 11:44:00.006 15182-15182/? A/DEBUG:     #73 pc 002a1479  /system/lib/libart.so (art::JNI::CallStaticVoidMethodV(_JNIEnv*, _jclass*, _jmethodID*, std::__va_list)+484)
2020-07-14 11:44:00.006 15182-15182/? A/DEBUG:     #74 pc 00072443  /system/lib/libandroid_runtime.so (_JNIEnv::CallStaticVoidMethod(_jclass*, _jmethodID*, ...)+38)
2020-07-14 11:44:00.006 15182-15182/? A/DEBUG:     #75 pc 00074a07  /system/lib/libandroid_runtime.so (android::AndroidRuntime::start(char const*, android::Vector<android::String8> const&, bool)+482)
2020-07-14 11:44:00.006 15182-15182/? A/DEBUG:     #76 pc 00001a93  /system/bin/app_process32 (main+898)
2020-07-14 11:44:00.006 15182-15182/? A/DEBUG:     #77 pc 0008e131  /system/lib/libc.so (__libc_init+48)
2020-07-14 11:44:00.006 15182-15182/? A/DEBUG:     #78 pc 000016d1  /system/bin/app_process32 (_start_main+40)
2020-07-14 11:44:00.006 15182-15182/? A/DEBUG:     #79 pc 00000306  <anonymous:e7af4000>
2020-07-14 11:44:01.528 1224-1966/? E/ProcessInfoCollector: getProcessInfo: failed to find this proc
```

## 4 Repeat Crash Steps

![image](http://note.youdao.com/yws/res/2118/7F3EFA0C5B9E427EB98A2F76C4FA0BAF)

[please click this to download  this video](https://github.com/liangchaojie/flutterCrashDemo/blob/master/crash.mp4)

you can watch this video and run this demo project to repeat this crash.