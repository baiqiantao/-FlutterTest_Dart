import 'package:flutter/material.dart';
import 'main_widget_test.dart';

class MyWidgetState extends State<MyWidgetPage> {
  int _counter = 0;

  void _incrementCounter() => setState(() => _counter++);

  @override
  Widget build(BuildContext context) => Scaffold(
        appBar: AppBar(title: Text(widget.title)),
        body: Center(child: buildText()),
        floatingActionButton: buildButton(),
      );

  Text buildText() => Text(
        '已点击 $_counter 次',
        textAlign: TextAlign.center,
        style: const TextStyle(
          backgroundColor: Colors.orange,
          color: Colors.green,
        ),
      );

  FloatingActionButton buildButton() => FloatingActionButton(
        onPressed: _incrementCounter,
        child: Text('$_counter'),
      );
}
