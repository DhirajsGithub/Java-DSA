package com.Dhiraj;

public class Practise {
    public static void main(String[] args) {
        byte x = 40;
        byte y = 70;
        byte z = 100;
        int m = x*y / z;
        System.out.println(m);

                int a = 247;
//        byte b = a;      //error as byte value is (256)
        byte b = (byte)(a);             // imp.
        System.out.println(b);      // output is 1     why caz value of b exceeding value of byte since we converted into byte hence
//         result will be 257%256 = 1
        int c = (byte)(a);
        System.out.println(c);

        int c2 = a;
        System.out.println(c2);

        byte l = 30;
        System.out.println(l);
        // error must need to intialize as primitives always has value unlike non-primitives
    }
}
