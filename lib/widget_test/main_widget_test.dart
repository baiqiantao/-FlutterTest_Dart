import 'dart:io';

import 'package:flutter/material.dart';
import 'widget_state.dart';

void main() => runApp(const MyApp());

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) => const MaterialApp(home: MyWidgetPage(title: 'main_widget_test'));
}

class MyWidgetPage extends StatefulWidget {
  const MyWidgetPage({super.key, required this.title});

  final String title;

  @override
  State<MyWidgetPage> createState() => MyWidgetState();
}
