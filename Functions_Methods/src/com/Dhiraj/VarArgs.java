package com.Dhiraj;


import java.util.Arrays;

public class VarArgs {
    // ...v  ---> takes any number of arguments and store them in array of collection
    public static void main(String[] args) {
        fun(1,2,3,5,3,3,4,5);

        mixed(3, 4, "Kunal", "Rahul", "Monu");      // NOTE the order of parameters and hence the arguments
    }
    static void fun(int ...v){
        System.out.println(Arrays.toString(v));
    }
//    static void fun2(int a, int b, int...v, int c){
//
//    }
    // error Vararg parameter must be at the last of the list coz we don't know how much Vararg take the arguments
    static void mixed(int a, int b, String ...v){

    }




}
