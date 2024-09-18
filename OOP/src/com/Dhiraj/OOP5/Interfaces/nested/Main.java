package com.Dhiraj.OOP5.Interfaces.nested;

public class Main {
    public static void main(String[] args) {
        B obj = new B();
        System.out.println(obj.isOdd(5));
    }
}

/*
An interface, i.e., declared within another interface or class, is known as a nested interface.
The nested interfaces are used to group related interfaces so that they can be easy to maintain.
The nested interface must be referred to by the outer interface or class. It can't be accessed directly.
 */