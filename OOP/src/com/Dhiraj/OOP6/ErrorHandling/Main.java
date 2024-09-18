package com.Dhiraj.OOP6.ErrorHandling;

public class Main {

    public static void main(String[] args) {
        int a = 5;
        int b = 0;
//    int c = a/b;
        try{
//            int c = a/b;
            divides(a, b);                              // since b=0 and divides method throws ArithmeticException hence below condition and catch blocks won't be executed
            // mimicking
//            throw new Exception("just for fun");     // it won't allow any catch block to execute
            String name = "Jyoti";
            if(name.equals("Jyoti")){
                throw new MyException("Name is Jyoti");     // throw new --> custom exception
            }
        }catch (ArithmeticException e){
            System.out.println(e.getMessage());

        }catch (Exception e){                  // order of catch matters  since Exception is the parent class of Arithmetic Exception it is better place below it's subclas
            System.out.println(e.getMessage());
        }finally {
            System.out.println("this block will always execute not matter try is true or false");
        }
    }

    static int divides(int a, int b) throws ArithmeticException {
        if(b==0){
            throw new ArithmeticException("Division by zero is not allowed");       // throws new --> inbuilt exception

        }
        return a/b;
    }

}

/*

error --> something which is cause due to lack of resources, cannot be avoided with code, no recoverable  . e.g. out of bound, stack overflow, etc
exception --> something that prevents normal flow of the programme. e.g. dividing something by 0, null pointer exception

Throwable class handles all of errors
Throwable inherited Object class
Throwable has exceptions and error
exception is of two type --> checked(checked exception is done at compile time) and  un-checked (compiler will not be able to detect)

 */