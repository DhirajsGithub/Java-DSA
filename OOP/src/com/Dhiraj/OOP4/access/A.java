package com.Dhiraj.OOP4.access;

public class A {
    // private means within this class it can be access, only within this class
    // public means it can be access from anywhere
    private int num;
    public String name;
    int [] arr;
    // above are the data members

    // getter, basically get's the value of private object and returns it, hence we can access private num with getNum method
    public int getNum() {
        return num;
    }

    // setter, basically set's the value of private object
    public void setNum(int num) {
        this.num = num;
    }

    public A(int num, String name) {
        this.num = num;
        this.name = name;
        this.arr = new int[num];
    }
}
