package com.Dhiraj.OOP2.StaticExample;

public class Main {
    public static void main(String[] args) {
        // same directory class no need to import it
        Human kunal  = new Human(22, 100000, "Kunal", false);
        Human rahul = new Human(34, 15000, "Rahul", true);
        Human soumya = new Human(18, 10000, "Saumya", false);
        
        System.out.println(kunal.population);    // it will first look in as if there any population present as instance variable
        // convention to use static variables
        System.out.println(Human.population);

        Main obj = new Main();
        obj.greeeting2();
    }

    // this is not dependent on object
    static void fun(){
        System.out.println("FUNNN");
//        // you can use this function coz it depends on object/ it requres an instance
//        // but the function you are using it in does not depend on instances
//        greeting();       // NOT valid
    }
    void greeeting2(){
        System.out.println("greeting from greeting 2");
        // here it is fine, we can use non static function inside non static function why?
        // everything you write in the end it will be called inside the static method i.e. main method and we know that an object for greeting2 will be created hence gretting() can be called from greeting2();
        greeting();
    }
    // we know that something that is not belong to static, belong to instance/an object
    void greeting(){
        System.out.println("Hellow World");
        fun2();
        fun();  // --> static function (fun)  inside non-static function (greeting) --> valid
    }
    // a.k.a you cannot use something which depend on instance inside something that is not depend on instance
    // but we can use static function/variable inside non static function

    static void fun2(){
        System.out.println("greeting from func 2");

        // so if you want to use non static inside static make sure to make object inside static
        Main obj = new Main();
        obj.greeting();
    }

}

/*
When a member is declared static, it can be accessed before any objects of its class are created,
and without reference to any object. You can declare both methods and variables to be static.
The most common example of a static member is main( ).
main( ) is declared as static because it must be called before any objects exist.
Static method/ static variables  in Java is a method which belongs to the class and not to the object.

A static method can access only static data. It cannot access non-static data (instance variables)
A non-static member belongs to an instance. It's meaningless without somehow resolving which instance of a class you
are talking about. In a static context, you don't have an instance, that's why you can't access a non-static member
without explicitly mentioning an object reference.
In fact, you can access a non-static member in a static context by specifying the object reference explicitly :

A static method can call only other static methods and cannot call a non-static method from it.
A static method can be accessed directly by the class name and doesn’t need any object
A static method cannot refer to "this" or "super" keywords in anyway

Note: main method is static, since it must be accessible for an application to run, before any instantiation takes place.

 */








