package com.Dhiraj.OOP2.StaticExample;

public class StaticBlock {
    static int a = 4;
    static int b;

    // will only run once, when the first object is created i.e. when the class is loaded for the first time
    static {
        System.out.println("Iam in static block !!!");
        b = a*5;
    }

    public static void main(String[] args) {
        // NOTE : how the blocks will get executed
        // if an object is made then static variables get initialize for the first time
        // when second object is made of same class then static variables won't be initialize
        StaticBlock obj1 = new StaticBlock();
        System.out.println(StaticBlock.a + " " + StaticBlock.b);

        StaticBlock.b += 3;
        System.out.println(StaticBlock.a  + " " + StaticBlock.b);

        StaticBlock obj2 = new StaticBlock();
        System.out.println(StaticBlock.a + " " + StaticBlock.b);

        StaticBlock obj3 = new StaticBlock();
        System.out.println(StaticBlock.a + " " + StaticBlock.b);

        StaticBlock.b += 3;
        System.out.println(StaticBlock.a  + " " + StaticBlock.b);
    }
}

/*
If you need to do computation in order to initialize your static variables,
you can declare a static block that gets executed exactly once, when the class is first loaded.
 */


