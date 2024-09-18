package com.Dhiraj;

import org.w3c.dom.ls.LSOutput;

public class Comparison {
    public static void main(String[] args) {
        // 1. == method, checks if the reference variable pointing to the same object
        String a = "Kunal";
        String b = "Kunal";
        // above a and b are same as  b = a   ---> pointing towards same object
        System.out.println(a == b);      // true
        String c = a;
        System.out.println(c == a);      // true

        // NOTE:
        // How to create different objects of same value
        // using new keyword
        String d = new String("Aditya");
        String e = new String("Aditya");
        // creating this objects outside the string pool but in the heap
        System.out.println(d == e);        // false
        String f  = e;
        System.out.println(f == e);        // true

        // 2. when you only need to check values use .equals method
        System.out.println(d.equals(e));      // true

        System.out.println(d.charAt(0));     //  need to use the method

        char [] name = d.toCharArray();
        System.out.println(name[1]);



    }

}
