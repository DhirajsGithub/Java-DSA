package com.Dhiraj.OOP3.Polymorphism;

public class Circle extends Shapes {
    // this will run when obj of Square class is reated
    // hence it will override the parent class area method
    void area (){
        System.out.println("Area From Circle");
    }
}
