package com.Dhiraj.OOP2.StaticExample;

public class Human {
    int age;
    int salary;
    String name;
    boolean married;

    // such variable that DO NOT RELATED TO OBJECT of class
    static long population;

    static void message(){
        System.out.println("message....!!!!");
//        System.out.println(this.age);
//        cannot do this from staic you cannot access non static for that you need to create an object inside static
    }

    public Human(int age, int salary, String name, boolean married) {
        this.age = age;
        this.salary = salary;
        this.name = name;
        this.married = married;
//        this.population +=1;          // this statement will check if an instance of class has any static variable population if there then it will update it
        // but if not then it will update the static variable

        Human.population += 1;         // this will directly look in class for population static variable
        Human.message();
    }
}
