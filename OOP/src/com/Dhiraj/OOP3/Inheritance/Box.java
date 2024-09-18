package com.Dhiraj.OOP3.Inheritance;

public class Box {
//public final class Box {
    // earlier binding to stop inheritance
    // when you declare a class to final, implicitly it declares all of it's method to final too

    private double l;
    double h;
    double b;

    // check if static method can be overriden or not       --> can't overriden
    static void greeting(){
        System.out.println("Iam in Box, greetings from Box");
    }

    Box(){
//        super();
        // All objects, including arrays, implement the methods of the Object class
        this.l = -1;
        this.h = -1;
        this.b = -1;
    }
    Box(double side){
        this.l = this.h = this.b = side;
    }

    Box(double l, double h, double b) {
        this.l = l;
        this.h = h;
        this.b = b;
    }

    Box(Box old){
        this.l = old.l;
        this.h = old.h;
        this.b = old.b;
    }
    public void information (){
        System.out.println("Running the box");
    }
}
