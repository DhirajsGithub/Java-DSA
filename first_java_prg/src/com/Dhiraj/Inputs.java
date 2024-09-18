package com.Dhiraj;

import java.util.Scanner;

public class Inputs {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);          // System.out ---> systems inputs like keyboardR
//        Scanner input = new Scanner(from where you are taking the inputs);
//        input object of type scanner class and System.in is a constructor
        short p = 5;
        byte c = 34;
        if(p>c){
            System.out.println("pp");
        }else{
            System.out.println("cc");
        }
//        out and in are set to be null by default

//        System.out.print("Please enter your roll no: ");

//        int rollNo = input.nextInt();
//        System.out.println("your roll no is "+ rollNo);
//
//        String name = input.next();
//        System.out.println(name);
//        String fullName = input.nextLine();
//        System.out.println(fullName);

        float marks = input.nextFloat();   //input  867575.967436789
        System.out.println(marks);          //output 867575.94

        double Precise = input.nextDouble();
        System.out.println(Precise);

    }
}
