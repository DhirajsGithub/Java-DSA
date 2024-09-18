package com.Dhiraj.OOP6.ObjectCloning;

public class Human implements Cloneable {
    // implemnts Cloneable to tell the JVM that we are using clone() method
    int age;
    String name;
    int [] arr;

    public Human(int age, String name) {
        this.age = age;
        this.name = name;
        this.arr = new int [] {3, 4, 5, 6, 7};
    }

    public Human(Human other) {
        this.age = other.age;
        this.name = other.name;
    }

    // clone a Human object with less time and avoding above construcor method to clone an object
    @Override     // allows to override
    public Object clone() throws CloneNotSupportedException{
//        return super.clone();   // shallow copy
        Human twin = (Human) super.clone();         // this is actaully a shallow copy

        // make a deep copy
        twin.arr = new int [twin.arr.length];
        for (int i = 0; i < twin.arr.length; i++) {
            twin.arr[i] = this.arr[i];
        }
        return twin;
    }
}

/*
shallow copy --> primitives will be copy as it is, but the reference variable will be point towards safe object like array and string
 */
