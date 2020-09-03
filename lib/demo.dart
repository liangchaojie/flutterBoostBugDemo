import 'package:flutter/cupertino.dart';
import 'package:flutter/services.dart';
import 'dart:async';

import 'base_state.dart';

class DemoWidget extends StatefulWidget{
  @override
  State<StatefulWidget> createState() {
    return DemoState();
  }

}

class DemoState extends State<DemoWidget>{

  @override
  void initState() {
    // TODO: implement initState
    super.initState();

    Timer(Duration(seconds: 3), () {
      Navigator.pop(context);
      print("onCreate: getFdCount 页面已关闭，手动打开看看");
    });
  }

  @override
  Widget buildPage() {
    try {
      print("shenzhixinsss,buildPage");

      return AndroidView(
          viewType: 'plugins.test/my_view',
          creationParams: {
            "myContent": "通过参数传入的文本内容",
          },
          creationParamsCodec: StandardMessageCodec(),
          onPlatformViewCreated: onMyViewCreated);
    }catch(e){
      return null;
    }
  }

  MethodChannel _channel;

  void onMyViewCreated(int id) {
    print("shenzhixin onMyViewCreated");
    _channel = new MethodChannel('plugins.test/my_view_$id');
    setMyViewText("aaa");
  }

  Future<void> setMyViewText(String text) async {
    print("shenzhixin setMyViewText");
    assert(text != null);
    return _channel.invokeMethod('setText', text);
  }

  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return null;
  }
}