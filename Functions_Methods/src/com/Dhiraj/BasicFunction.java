package com.Dhiraj;
import java.util.Scanner;

public class BasicFunction {

    public static void main(String[] args) {
        //
	// Note: main is the first function which is going to run first then other functions will run according to procudural calling
        sum();    // to call the function from another function both function must be of same kind i.e. static and static
         /*1.) return_type sum();  ---> calling a function when we call a function that function will have some value i.e. sum();
        has some value and that is of type return_type
        2.) if you don't want to return something or just want to display then return_type is void
          */

        int ans = sum2();            // stores the value of sum2() as the function sum2 is returning a value
        System.out.println(ans);

        String message = greet();
        System.out.println(message);

        // arguments
        int ans3 = sum3(30,10);
        System.out.println(ans3);


        Scanner in = new Scanner(System.in);
        String naam = in.next();
        String personalised = greet2(naam);
        System.out.println(personalised);
    }

 //   void sum(){
    static void sum(){
        int num1;
        int num2;
        int sum;
        Scanner in = new Scanner(System.in);
        num1 = in.nextInt();
        num2 = in.nextInt();

        sum = num1 + num2;
        System.out.println(sum);
    }

    // return the value
        static int sum2(){
        int num1;
        int num2;
        int sum;
        Scanner in = new Scanner(System.in);
        num1 = in.nextInt();
        num2 = in.nextInt();

        sum = num1 + num2;
        return sum;
//        System.out.println("this statemnet will never be executed");    // unreachable statement
    }

    // return a string
    static String greet(){
        String greeting = "How are YOU";
        return greeting;
    }

    // parameters
    static int sum3(int a, int b){
        int sum = a+b;
        return sum;
    }

    static String greet2(String name){
        String message = "Hellow "+name;
        return message;
    }



}


    /*
    access modifier(will look in OOP)  return_type  function_name(){
        // body
        return statement (type must be same as return_type)
    }
     */