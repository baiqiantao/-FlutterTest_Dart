package com.example.qt_flutter_test

import android.content.Context
import android.os.BatteryManager
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.BinaryMessenger
import io.flutter.plugin.common.MethodChannel
import io.flutter.embedding.android.FlutterActivity
import io.flutter.plugin.platform.PlatformViewFactory

object QtFlutterEngineConfig {
    private const val CHANNEL_NAME = "com.bqt.test/base_channel"
    private const val VIEW_TYPE_ID = "com.bqt.test/QtCustomView" // 唯一标识符
    private const val METHOD_NAME = "getBatteryLevel"
    fun configureFlutterEngine(flutterActivity: FlutterActivity, flutterEngine: FlutterEngine) {
        val messenger: BinaryMessenger = flutterEngine.dartExecutor.binaryMessenger
        MethodChannel(messenger, CHANNEL_NAME).setMethodCallHandler { call, result ->
            when (call.method) {
                METHOD_NAME -> onCallGetBatteryLevel(flutterActivity, result)
                else -> result.notImplemented()
            }
        }

        val factory: PlatformViewFactory = QtPlatformViewFactory(messenger)
        flutterEngine.platformViewsController.registry.registerViewFactory(VIEW_TYPE_ID, factory) // 注册视图工厂
    }

    private fun onCallGetBatteryLevel(flutterActivity: FlutterActivity, result: MethodChannel.Result) {
        Thread {
            val batteryManager = flutterActivity.getSystemService(Context.BATTERY_SERVICE) as BatteryManager
            val batteryLevel = batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY)
            if (batteryLevel != -1) {
                result.success(batteryLevel) // 可在子线程响应请求
            } else {
                result.error("UNAVAILABLE", "Battery level not available.", null)
            }
        }.start()
    }
}