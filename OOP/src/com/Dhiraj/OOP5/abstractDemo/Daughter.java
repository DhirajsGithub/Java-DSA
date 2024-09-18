package com.Dhiraj.OOP5.abstractDemo;

public class Daughter extends Parent{
    public Daughter(int age) {
        super(age);
    }

    @Override
    void career() {
        System.out.println("Iam coing to be a nurse");
    }

    @Override
    void partner() {
        System.out.println("I like any Boy");
    }
}
