package com.Dhiraj.OOP3.Polymorphism;

public class Square extends Shapes{

    // this will run when obj of Square class is reated
    // hence it will override the parent class area method    --> late binding/dynamic binding
    @Override      // this is called annotation   // which tells us if the method is overriding the parent method or not
    void area (){
        System.out.println("Area From Square");
    }

//    @Override                 // showing an error
//    void areaa(){
//        System.out.println("Area From Sqaureeee");
//    }

}
