package com.Dhiraj.OOP5.abstractDemo;

public abstract class Parent {
//final public abstract class Parent {
  // final keyword prevents it from inheritance, hence for abstract class as well we cannot put final

    int age;

    // if abstract parent has a constructor then it must be in child classses
    public Parent(int age) {
        this.age = age;
    }

    // can we create abstract constructor, NO we cannot
//    abstract Parent(){
//
//    }

    // can we create 'abstract static method', NO we cannot as static methods cannot be overriden
    // but we can make static method inside abstract classes
    static void hello (){
        System.out.println("Hi there !");
    }

    // can abstaract classes contains normal method
    void normal (){
        System.out.println("This is normal method ");
    }

    abstract void career ();
    abstract void partner();
}
