package com.Dhiraj;

public class Main {

    public static void main(String[] args) {
        // write your code here
        // write a prgoram which prints hellow wrold 5 times
        message();
    }

    static void message() {
        System.out.println("Hellow world");
        message1();
    }

    static void message1() {
        System.out.println("Hellow world");
        // return;
        message2(); // unreachable statement if we used return above
        // return;
    }

    static void message2() {
        System.out.println("Hellow world");
        message3();
    }

    static void message3() {
        System.out.println("Hellow world");
        message4();
    }

    static void message4() {
        System.out.println("Hellow world");
    }
}

// Working of function calls
// first main function goes into the stact at the bottom and it's the one which
// removed from the stack at last
// here main function call message() then message fucntion calls message1() and
// so ..
// at last after printing hellow world from message4() it will be removed from
// the stact then message3() will be removed from stack, ... then main()
// function will be removed from stack
// When a fucntino finishes executing it is removed from the stack and the flow
// programme is restored to when the first function is called
// While a function call is not
