import 'dart:developer';

import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class SampleView extends StatelessWidget {
  final int clickCount;
  static String viewType = "com.bqt.test/QtCustomView"; // 唯一标识符

  const SampleView({super.key, required this.clickCount});

  @override
  Widget build(BuildContext context) {
    return AndroidView(
      viewType: viewType,
      creationParams: "初始化参数：$clickCount", // 初始化参数，动态变更时不能通过这里传给 Android 端
      creationParamsCodec: const StandardMessageCodec(), // 初始化参数的编码
      onPlatformViewCreated: (id) => log("onPlatformViewCreated, id: $id"), // 原生视图创建完成后回调
    );
  }
}
