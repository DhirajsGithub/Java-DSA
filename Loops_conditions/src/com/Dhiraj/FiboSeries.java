package com.Dhiraj;

import java.util.Scanner;

public class FiboSeries {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = 0;
        int b = 1;
        int c = a+b;

        int n = in.nextInt();

        // whole fibo series
//        if (n==1){
//            System.out.print("1");
//        }else if (n==0){
//            System.out.println("0");
//        }else {
//            System.out.print("0, 1, ");
//            for (int i=0; i<=n; i++){
//                System.out.print(c+", ");
//                a = b;
//                b = c;
//                c = a+b;
//            }

        // desire nth term of fibo series
            for (int j=0; j<=n-2; j++){
                a = b;
                b = c;
                c = a+b;
            }
            System.out.println(c);




        }


    }

