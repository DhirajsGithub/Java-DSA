package com.Dhiraj.Upcasting_and_downcasting;

public class Casting {
    public static void main(String[] args) {

        // upcasting
        // upcasting always works and always happens automatically
        Animal myAnimal = new Dog();
//         or
//        Animal myAnimal = (Animal) new Dog();     // no new to upcast as java will upcast any object automatically, but we need to downcast if necessarly

//        myAnimal.growl();     // conz growl doesn't exist in Animal class

        myAnimal.onlyAnimal();
        myAnimal.commonClass();     // if both methods are common in parent and class and it's upcasting then overriding will take place


        // downcasting
//        Dog myDog = new Animal();     // need to casti
        Dog myDog = (Dog) new Animal();
        myDog.growl();
        myDog.commonClass();

        // downcasting will fail in this cast
//        Cat myDog = (Dog) new Animal();   // betrayal
    }
}

/*
both in upcasting and downcasting
- the type of method i.e. reference type deteremines which method to call for
- and the actual method will be called from the object itself
 */
