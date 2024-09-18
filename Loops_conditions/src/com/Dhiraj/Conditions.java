package com.Dhiraj;

public class Conditions {

    public static void main(String[] args) {
	// write your code here
        /* syntax for if statement
        if (boolean value){
        // do something
        }else{
        // do something different

         */

        // multiple if-else statements
        int salary = 25000;
        if (salary > 10000){
            salary += 500;
        }else if (salary > 20000){
            salary += 1000;
        }else {
            salary += 100;
        }
        System.out.println(salary);    // 25500   if if statement is executed then else if and else won't execute and vice versa for them also

        // ternary operator
        int time = 20;
        String result = (time < 18) ? "Good day." : "Good evening.";
        System.out.println(result);

    }

}

/*

There is also a short-hand if else, which is known as the ternary operator because it consists of three operands.
variable = (condition) ? expressionTrue :  expressionFalse;


* */


// note if can run without else-if and else
// else can work wihtout else-if
// but else if only work with if and else define