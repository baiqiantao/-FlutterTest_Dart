package com.example.qt_flutter_test

import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine

class MainActivity: FlutterActivity() {
    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        intent.putExtra(io.flutter.embedding.engine.FlutterShellArgs.ARG_KEY_DISABLE_SERVICE_AUTH_CODES, true) // 禁用 auth_code
        intent.putExtra(io.flutter.embedding.engine.FlutterShellArgs.ARG_KEY_OBSERVATORY_PORT, 9999) // 写死端口
        super.onCreate(savedInstanceState)
    }

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        QtFlutterEngineConfig.configureFlutterEngine(this, flutterEngine)
    }

}