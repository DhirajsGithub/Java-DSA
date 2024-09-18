package com.Dhiraj.OOP4.access;

public class Main {
    public static void main(String[] args) {
        A obj = new A(78, "Kunal");
        // need to do a few things
        // 1. access the data members
        // 2. modify the data members

        // data hiding
//         obj.num      // coz num instance var is private


        System.out.println(obj.name);
        System.out.println(obj.getNum());
        System.out.println(obj.arr);
    }


}
