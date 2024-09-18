package com.Dhiraj;

import java.util.Scanner;

public class Largest {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

//        let suppose
        int max = a;
        if (b>a){
            max = b;
        }
        if (c>b){
            max = c;
        }
        // note here all if statements will be executed and updating the value of max
        System.out.println(max);

        // we can do it with inbuilt max function
        int max1 = Math.max(a, b);      // only take integers as arguments
        int max2 = Math.max(max1, c);
        System.out.println(max2);


    }
}
