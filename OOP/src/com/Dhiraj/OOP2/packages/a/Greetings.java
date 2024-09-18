package com.Dhiraj.OOP2.packages.a;

import static com.Dhiraj.OOP2.packages.a.message2.msg2;
import static com.Dhiraj.OOP2.packages.b.Message.message;
// importing the function message from file Message of package b of directory/package(parent) packages which then lies in OOP2 which further lies in package Dhiraj and the com

public class Greetings {
    public static void main(String[] args) {
        System.out.println("Hellow World from package a");
        message();
        msg2();
    }
}
