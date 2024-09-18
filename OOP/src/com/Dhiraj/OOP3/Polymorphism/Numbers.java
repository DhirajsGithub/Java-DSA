package com.Dhiraj.OOP3.Polymorphism;

public class Numbers {

    // constructor overloading
    double sum (double a, int b){
        System.out.println("double Sum is : " + a+b);
        return a+b;
    }
    int sum (int a, int b){
        System.out.println("Integer Sum is : " + a+b);
        return a+b;
    }

    int sum (int a, int b, int c){
        System.out.println("Integer Sum with 3 arguments is : " + a+b + c);
        return a+b+c;
    }

    public static void main(String[] args) {
        Numbers obj = new Numbers();

        obj.sum(2, 4);
        obj.sum(2, 3, 5);
        obj.sum(2.0, 2);
    }


}
