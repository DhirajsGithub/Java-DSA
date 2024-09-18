package com.Dhiraj.OOP3.Inheritance;

public class BoxWeight extends Box {
    double weight;

    public BoxWeight() {
        this.weight = -1;
    }

    public BoxWeight(double l, double h, double b, double weight) {
        super(l, h, b);       // what is super       // basically means it is the derivative of class Box which is further derivative of class Object
        // super calls the parent class constructor --> constructor overloading
        // used to initialised values present in the parent class

//        System.out.println(this.h);       // will first check in child class if h is accessible or not then check in parent class
//        System.out.println(super.h);      // will directly check in parent class
        this.weight = weight;

//        super(l, h, b);
        // child class cares about what parent class contains but parent class didn't, hence super must be called at top in constructor body
    }

    BoxWeight(BoxWeight other){         // we inherite double h now we are Box other
        super(other);                   // hence Box other = new BoxWeight(2, 3, 5, 89);
        weight = other.weight;
    }
//    Box(Box old){
//        this.l = old.l;
//        this.h = old.h;
//        this.b = old.b;
//    }
//Box box5 = new BoxWeight(3, 2, 5, 89);


    public BoxWeight(Box old, double weight) {
        super(old);
        this.weight = weight;
    }

    public BoxWeight(double side, double weight){
        super(side);
        this.weight = weight;
    }

//    @Override        // showing error it means static method can't be overriden
    static void greeting(){
        System.out.println("Iam In BoxWeight class Greetings from BoxWeight");
    }
}
