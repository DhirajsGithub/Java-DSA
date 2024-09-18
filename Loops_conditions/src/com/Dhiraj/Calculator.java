package com.Dhiraj;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char op = in.next().trim().charAt(0);
        int ans = 0;
        while(true){
            if (op == '+' || op == '*' || op == '-' || op == '/' || op == '%'){
                // input two numbers
                int num1 = in.nextInt();
                int num2 = in.nextInt();

                if (op == '+'){
                    ans = num1 + num2;
                }
                if (op == '-'){
                    ans = num1 - num2;
                }
                if (op == '*'){
                    ans = num1 + num2;
                }
                if (op == '/' && num2 !=0){
                    ans = num1 + num2;
                }else{
                    System.out.println("can't divide by zero");
                }
                if (op == '%'){
                    ans = num1 % num2;
                }
            }else if(op == 'x' || op =='X'){
                break;
            }else {
                System.out.println("invalid operation!! ");
            }
            System.out.println(ans);
        }


    }
}
