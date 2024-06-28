// ignore_for_file: prefer_const_constructors


import 'package:flutter/material.dart';

class Welcome extends StatelessWidget {
  const Welcome({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.pink[200],
        title: Text(
          "welcome",
          style: TextStyle(fontSize: 30),
        ),
        centerTitle: true,
      ),
      

      body: SizedBox(
        width: double.infinity,
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          crossAxisAlignment: CrossAxisAlignment.center,
          children: [
            ElevatedButton(
              onPressed: () {
                Navigator.pushNamed(context, '/login');
              },
              style: ButtonStyle(
                backgroundColor: MaterialStateProperty.all(Colors.pink[600]),
                shape: MaterialStateProperty.all(RoundedRectangleBorder(
                    borderRadius: BorderRadius.circular(20))),
                fixedSize: MaterialStateProperty.all(Size(300, 45)),
              ),
              child: Text(
                "Login",
                style: TextStyle(fontSize: 20),
              ),
            ),
            SizedBox(
              height: 10,
            ),
            ElevatedButton(
              onPressed: () {
                Navigator.pushNamed(context, '/signup');
              },
              style: ButtonStyle(
                backgroundColor: MaterialStateProperty.all(Colors.white),
                shape: MaterialStateProperty.all(RoundedRectangleBorder(
                    borderRadius: BorderRadius.circular(20))),
                fixedSize: MaterialStateProperty.all(Size(300, 45)),
                side: MaterialStateProperty.all(BorderSide(
                    color: Colors.pink,
                    strokeAlign: BorderSide.strokeAlignOutside,
                    width: 2)),
              ),
              child: Text(
                "Sign up",
                style: TextStyle(fontSize: 20, color: Colors.pink),
              ),
            ),
          ],
        ),
      ),
    );
  }
}
