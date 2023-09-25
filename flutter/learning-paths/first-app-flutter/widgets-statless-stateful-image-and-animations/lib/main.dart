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
      title: 'FWSSII',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.amberAccent),
        useMaterial3: true,
      ),
      home: Row(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          Container(
            color: Colors.amberAccent,
            width: 100,
            height: 100,
          ),
          Container(
            color: Colors.lightBlue,
            width: 50,
            height: 50,
          ),
          Column(
            children: [
              Container(
                  height: 280,
                  width: 280,
                  child: Text(
                    'Oi',
                    style: TextStyle(
                        color: Colors.deepPurpleAccent, fontSize: 100),
                    textAlign: TextAlign.center,
                  ))
            ],
          )
        ],
      ),
    );
  }
}
