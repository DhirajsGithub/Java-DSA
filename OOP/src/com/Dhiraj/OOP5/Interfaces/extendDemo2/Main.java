package com.Dhiraj.OOP5.Interfaces.extendDemo2;

public class Main implements A, B{
    public static void main(String[] args) {
        Main obj = new Main();
        A.greeting();       // static method can work with or without implementation of A
        obj.fun();          // normal method can be taken form interface class
//        obj.greeting();       // as greeting is a static class and not abstract class
    }
}


/*

NOTE: the overridden method should be better than parent one
e.g. if parent method is protected then the child method must be protected or public it shouldn't be private
 */