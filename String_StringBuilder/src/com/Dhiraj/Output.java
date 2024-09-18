package com.Dhiraj;

import java.util.Arrays;

public class Output {
    public static void main(String[] args) {
        // function overloading
        // everything we use print out using System.out.println method are in string
        System.out.println(56);     // calls a toString method internally
        // internally it is like
        Integer num = new Integer(56);     // wrapper class 
        System.out.println(num.toString());

        System.out.println("Kunal");
        System.out.println(new int [] {1,2,3,4});     //  coz this object have some access to functions and methods obj.toString
        // object can be of any types array, hashmap, human class, etc java will not know what to print therefore it takes the hashcode add something to it and give it as a string

        // to pretty print something
        System.out.println(Arrays.toString(new int [] {1,2,3,4}));      // don't use toString method use the .toSting method available in the array // function overriding

        String name = null;     // null.method  --> nothing null pointer exception
        System.out.println(name);
    }
}
