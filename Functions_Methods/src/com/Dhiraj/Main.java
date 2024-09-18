package com.Dhiraj;

public class Main {
    public static void main(String[] args) {

        String Name = "Kunal Kushwaha";
        changeName(Name);
        System.out.println(Name);             // Kunal Kushwaha
        String ans = changeName(Name);
        System.out.println(ans);                // Rahul Rana

        int a = 24;
        {
//            int a = 5;
            // errror
             a = 5; // good
        }


    }
    static String changeName(String Name){
//        a = 5;         // initialization error
        int a = 5;   // no error
        Name = "Rahul Rana";
        return  Name;
    }
}
