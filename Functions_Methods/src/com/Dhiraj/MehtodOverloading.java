package com.Dhiraj;


public class MehtodOverloading {
    public static void main(String[] args) {
        // when two or more function have same name or may be different return type, but different order of arguments are passed that argument define which method to call
        // function overloading happens at compile time
        // for function overloading either the number of arguments should be differnt or type of argument should be different
        fun(56, "Kunal", 34);
        fun(24, 524, "Rahul");
//        fun();      // The ambiguities are those issues that are not defined clearly in the Java language specification
    }
    static void fun(int a, String name, int b){
        System.out.println(name);
        System.out.println(a+b);
    }
//    static void fun(int a,String name, int b ){
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(name);
//    }
    // error    ---> function is already define

    static void fun(int a, int b, String name){
        System.out.println(a);
        System.out.println(b);
        System.out.println(name);
    }

}
