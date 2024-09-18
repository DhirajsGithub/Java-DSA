package com.Dhiraj.Upcasting_and_downcasting;

public class Dog extends Animal{
    @Override
    public void makeNoise(){
        System.out.println("Bow Bow");
    }

    public void growl(){
        System.out.println("grrrrrr");
    }

    public void commonClass(){
        System.out.println("Common class : from Dog");
    }

}
