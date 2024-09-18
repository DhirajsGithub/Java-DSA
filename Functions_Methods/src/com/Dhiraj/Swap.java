package com.Dhiraj;

public class Swap {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        // swap numbers code
//        int temp = a;
//        a = b;
//        b = temp;
//                                          prob.3   // int a --point to-->10   int b ---->20
//        System.out.println(a +" "+b);     // 20, 10
        // this doesn't hold for a function

        swap(a, b);
        System.out.println(a+" "+b);        // 10, 20   no swaping     as   prob.3   // int a ---->10   int b ---->20

        String name = "Kunal Kushwaha";   // Prob.2   name ---> "Kunal Kushwaha" sout(name) will be Kunal Kushwaha. name/naam ----> "Rahul Rana"(valid to functional scope only)
        changeName(name);
        System.out.println(name);      // won't print Rahul Rana it's still Kunal Kushwaha


        String name2 = "Anurag Goel";                     //Prob.1  name2 ----> "Anurag Goel" <---- naam , copy of value of reference variable is pass in the function
        greet(name2);         // -----(1)
    }
//    // Shortcut to make a template function  from line (1) if we call function before it is created use option + return will create a private function like below automatically
//    private static void greet(String name2) {
//    }

    static void greet(String naam) {
        System.out.println(naam);
    }
    /*
     naam and name are same internally naam have value of name
     in java there is only pass by value not pass by reference for primitives
     */



    static void swap(int a, int b){
        int temp = a;                              // int a ---->10   int b ---->20
        a = b;
        b = temp;

    }
    static void changeName(String name){
        name = "Rahul Rana";         // not changing but creating a new object
    }

}

//    Java doesn't support Pass by reference. Instead of passing only the value part of a variable, Java passes a reference to the original object for non-primitives. For primitive types, Java makes a copy of the variables and sends it to the function.
