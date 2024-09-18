package com.Dhiraj;

public class StackMain {
    public static void main(String[] args) throws Exception {
        // we need to add throws Exception coz one of the method throws an exception
        // why we didn't throw StackException error coz internally StackException extends Exception class
//        CustomStack stack = new CustomStack(5);
//        stack.push(34);
//        stack.push(3);
//        stack.push(-23);
//        stack.push(67);
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());

//        DynamicStack stack2 = new DynamicStack(3);
//        stack2.push(34);
//        stack2.push(3);
//        stack2.push(-23);
//        stack2.push(67);
//        stack2.push(64);
//        System.out.println(stack2.pop());
//        System.out.println(stack2.pop());
//        System.out.println(stack2.pop());
//        System.out.println(stack2.pop());
//        System.out.println(stack2.pop());

        CustomStack stack2 = new DynamicStack(3);
        // stack2 is the ref variable which tells us which method we can access
        // DynamicStack is the object from which we are accessing the methods, hence push will be from DynamicStack class
        stack2.push(34);
        stack2.push(3);
        stack2.push(-23);
        stack2.push(67);
        stack2.push(64);
        System.out.println(stack2.pop());
        System.out.println(stack2.pop());
        System.out.println(stack2.pop());
        System.out.println(stack2.pop());
        System.out.println(stack2.pop());



    }
}
