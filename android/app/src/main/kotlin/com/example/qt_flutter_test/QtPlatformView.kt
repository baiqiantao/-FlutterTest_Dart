package com.example.qt_flutter_test

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View
import io.flutter.plugin.common.BinaryMessenger
import io.flutter.plugin.common.StandardMessageCodec
import io.flutter.plugin.platform.PlatformView
import io.flutter.plugin.platform.PlatformViewFactory

// 视图工厂类
class QtPlatformViewFactory(private val messenger: BinaryMessenger): PlatformViewFactory(StandardMessageCodec.INSTANCE) {
    override fun create(context: Context, id: Int, obj: Any?) = QtPlatformView(context, id, obj)// 关联原生视图封装类
}

// 原生视图封装类
class QtPlatformView(context: Context, id: Int, obj: Any?): PlatformView {

    private val qtView: View by lazy { QtCustomView(context, "$obj") } // 缓存原生视图

    override fun getView(): View = qtView // 返回原生视图
    override fun dispose() = Unit // 原生视图销毁回调
}

// 原生视图
class QtCustomView(context: Context, private val text: String): View(context) {
    private val qtPaint: Paint = Paint()

    init {
        qtPaint.color = Color.RED
        qtPaint.textSize = 50f
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawColor(Color.GREEN)
        canvas.drawText(text, 20f, qtPaint.textSize, qtPaint)
    }
}