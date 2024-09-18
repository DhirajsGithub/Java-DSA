package com.Dhiraj.OOP5.Interfaces.extendDemo2;

public interface A {

    // static interface method should always have a body, coz they cannot be overridden by inheritance
    // call via the interface name
    static void greeting(){
        System.out.println("Iam from A of extend Demo 2");
    }

    // since we can't have body of method in interface class, but we can give a default body using default keyword
    default void fun(){
        System.out.println("Iam from A");
    }
}
