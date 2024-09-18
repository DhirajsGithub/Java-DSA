package com.Dhiraj.OOP6.LambdaFunction;

import java.util.ArrayList;
import java.util.function.Consumer;

public class LambdaFunction {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            arr.add(i+1);
        }

//        arr.forEach((item) -> System.out.println(item* 2) );
        Consumer<Integer> fun = (item) -> System.out.println(item*2);
        arr.forEach(fun);       // same as arr.forEach((item) -> System.out.println(item* 2) ); 

        Operation sum = (a, b) -> a+b;
        Operation prod = (a, b) -> a*b;
        Operation div = (a, b) -> a/b;
        System.out.println(sum);

        LambdaFunction myCalculator = new LambdaFunction();
        System.out.println(myCalculator.operate(5, 3, sum));
        System.out.println(myCalculator.operate(5, 3, prod));
        System.out.println(myCalculator.operate(5, 3, div));


    }
    private int operate (int a, int b, Operation op){
        return op.operation(a, b);
    }
}

interface Operation {
    int operation (int a, int b);
}

/*
A lambda expression is a short block of code which takes in parameters and returns a value. Lambda expressions are similar to methods,
 but they do not need a name and they can be implemented right in the body of a method.


 */