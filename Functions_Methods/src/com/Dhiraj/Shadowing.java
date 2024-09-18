package com.Dhiraj;

public class Shadowing {
    static int x = 90;               // you cannot use object dependent thing in object independent thing that's why static. // this will be shadowed by line 9
    public static void main(String[] args) {

        // shadowning in java is practise of using two variables with the same name "within the scope" that overlaps
//        System.out.println(x);
//        int x = 45;         //the class variable at line 4 is shadowed by this
//        System.out.println(x);
        int x;   // know as decleration of variable x
//        System.out.println(x);      // error variable x is not initialised. Scope will begin when the value is initialised . can't access value b/w the decleration and initialisation
        x = 32;    // know as initialisation
        System.out.println(x);

        func();

    }

    static void func() {
//        int x = 34;       this z initialisation will shadow static int x = 90;
        System.out.println(x);     //  x = 90 coz x= 45 is not in the scope of func
    }
}
