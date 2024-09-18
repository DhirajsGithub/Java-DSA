package com.Dhiraj.OOP6.ObjectCloning;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
//    public static void main(String[] args) {
    public static void main(String[] args) throws CloneNotSupportedException {

        Human Kunal = new Human(34, "Kunal");
//        Human twin = new Human(Kunal);     // time consuming

        Human twin = (Human) Kunal.clone();
        System.out.println(twin.age + " " + twin.name);

//        // shallow copy --> primitive will be copied but not primitives(object to be specific)  will have reference/pointer in twin, before making a deep copy
        // deep copy --> primitive as well non primitves will get copied, after making a deep copy in Human class
        // see Human class

        System.out.println(Arrays.toString(twin.arr));
        twin.arr[0] = 100;
        System.out.println(Arrays.toString(Kunal.arr));



    }
}

/*
Obect Cloning --> method to make a copies of object
 */