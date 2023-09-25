import 'dart:ffi';

import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Tasks',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.amberAccent),
        useMaterial3: true,
      ),
      home: Scaffold(
        appBar: AppBar(
          title: Text("Tasks Control"),
        ),
        body: ListView(
          children: [
            Task("Task 1", 24),
            Task("Task 2", 24),
            Task("Task 3", 24),
            Task("Task 4", 24),
          ],
        ),
        floatingActionButton: FloatingActionButton(
          onPressed: () {},
        ),
      ),
    );
  }
}

class Task extends StatelessWidget {
  final String task;
  final double textSize;

  const Task(this.task, this.textSize, {super.key});
  

  @override
  Widget build(BuildContext context) {
    return Padding(
        padding: const EdgeInsets.all(8.0),
        child: Container(
          child: Stack(
            children: [
              Container(
                color: Colors.blue,
                height: 140,
              ),
              Container(
                color: Colors.white,
                height: 100,
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  children: [
                    Container(
                      color: Colors.black26,
                      width: 72,
                      height: 100,
                    ),
                    Text(
                      task,
                      style: TextStyle(fontSize: textSize),
                      overflow: TextOverflow.ellipsis,
                    ),
                    ElevatedButton(
                        onPressed: () {}, child: Icon(Icons.arrow_drop_up))
                  ],
                ),
              )
            ],
          ),
        ));
  }
}
