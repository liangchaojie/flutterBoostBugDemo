
import 'package:flutter/material.dart';

/**
    页面状态
 */
enum QCSPageStatus {
  Normal,                      //0:有数据,页面正常展示
  Loading,                     //1:加载中
  Fail,                        //2:请求失败
  Empty,                       //3:没有数据
}

class QCSAppBarAction {
  final String image;  //AppBar右边的图片
  final String package; //AppBar右边的图片所在的package，image存在的情况下，必传
  final String title;  //AppBar右边的文案
  final VoidCallback action;//AppBar右边的事件

  QCSAppBarAction({
    this.image,
    this.package,
    this.title,
    this.action
  }) : assert((title != null) || (image != null && package != null)),
       assert(action != null);
}


/// Widget的基础类
abstract class BaseState<T extends StatefulWidget> extends State<T> with TickerProviderStateMixin{
  
  @override
  void setState(VoidCallback fn) {
    if(context == null) return;

    Future.delayed(Duration.zero, () {
      if(mounted){
        super.setState(fn);
      }
    });
  }
}


///页面的基础类
abstract class BasePageState<T extends StatefulWidget> extends BaseState<T> {

  ///设置基础信息相关
  String emptyString = '没有数据';
  
  QCSPageStatus _pageStatus = QCSPageStatus.Normal;
  setPageStatus(QCSPageStatus value) {
    assert(value != null);

    _pageStatus = value;
    setState((){});
  }


  ///返回按钮的点击控制
  bool _canPop = true;

  ///导航栏相关
  ///是否显示appbar; 不显示appbar的情况下,pageTitle不起作用;
  bool _isShowAppBar = true;

  ///是否显示返回按钮
  bool _isShowBack = true;

  ///是否显示安全区域
  bool _isSafeArea = true;

  ///是否支持安卓物理返回键
  bool _isWillPopScope = true;

  ///页面标题
  String _pageTitle = '';

  ///存储右侧显示元素事件,设置APPBar使用
  List<Widget> _rightBarActions = List();
  
  ///设置导航栏右边的显示元素和事件
  Widget _rightBarAction(QCSAppBarAction action){
    if(action.title != null && action.title.isNotEmpty){
      return MaterialButton(
        onPressed: action.action,
        child: Container(
          height: 44,
          alignment: Alignment.center,
          child: Text(
            action.title,
            textAlign: TextAlign.center,
            style: TextStyle(
              color: Color.fromRGBO(0, 0, 0, 0.84),
              fontSize: 14,
              fontWeight: FontWeight.normal,
            ),
          ),
        ),
      );
    }
    else if(action.image != null && action.image.isNotEmpty){
      return IconButton(
        padding: EdgeInsets.all(13),
        icon: Image.asset(
          action.image,
          package: action.package,
          width: 18,
          height: 18,
        ),
        onPressed: action.action,
      );
    }

    return Container();
  }

  ///配置AppBar
  ///isShowAppBar是否显示导航栏
  void configAppBar({
    bool isWillPopScope,
    bool isShowAppBar,
    bool isShowBack,
    bool isSafeArea,
    String pageTitle,
    List<QCSAppBarAction> actions,
  }){
    _isWillPopScope = isWillPopScope != null ? isWillPopScope : true;
    _isSafeArea = isSafeArea != null ? isSafeArea : true;
    _isShowAppBar = isShowAppBar != null ? isShowAppBar : true;
    _isShowBack = isShowBack != null ? isShowBack : true;
    _pageTitle = pageTitle != null ? pageTitle : '';
    if (actions != null && actions.isNotEmpty) {
        actions.forEach((action) =>
            _rightBarActions.add(_rightBarAction(action))
        );
    }
  }

  ///导航栏布局，可重写此方法，自定义布局
  @protected
  Widget appBar(){
    return AppBar(
      backgroundColor: Colors.white,
      leading: _isShowBack ? IconButton(
        padding: EdgeInsets.all(8),
        icon: Image.asset(
          "assets/images/base/icon_nav_back_black.png",
          package: 'qcs_r_flutter_widgets',
          width: 18,
          height: 18,
        ),
      ) : null,
      title: Text(
        _pageTitle,
        softWrap: false,
        maxLines: 1,
        textAlign: TextAlign.center,
        style: new TextStyle(
          fontSize: 17.0,
          color: Color.fromRGBO(0, 0, 0, 0.84),
        ),
      ),
      centerTitle: true,
      elevation: 0,
      actions: _rightBarActions,
    );
  }

  ///页面布局
  @protected
  Widget buildPage();

  ///加载失败，重新加载
  @protected
  void reloadPage(){

  }
  

  ///initState
  @override
  void initState() {
    ///页面title，右上角配置
    ///configAppBar()

    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return WillPopScope(
      child: Scaffold(
        backgroundColor: Colors.white,
        appBar: _isShowAppBar
            ? appBar()
            : null,
        body: _isSafeArea
            ? SafeArea(child: _buildBody())
            : _buildBody(),
      ),
      onWillPop: (){
        return Future.value(_isWillPopScope);
      },
    );
  }

  Widget _buildBody(){
    return buildPage();
  }
}
