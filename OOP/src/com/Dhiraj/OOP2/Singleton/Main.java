package com.Dhiraj.OOP2.Singleton;

public class Main {
    public static void main(String[] args) {
//        Singleton obj = new Singleton();
//        obj.num     // private


        Singleton obj1 =  Singleton.getInstance();
        // omiting the new key ward coz getInstance method is doing that for us

        Singleton obj2 =  Singleton.getInstance();      // pointing to obj1

        Singleton obj3 =  Singleton.getInstance();      // pointing to obj1
    }
}
