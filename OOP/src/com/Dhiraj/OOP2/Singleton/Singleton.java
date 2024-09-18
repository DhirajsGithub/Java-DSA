package com.Dhiraj.OOP2.Singleton;

public class Singleton {
    // private means it can only be access in this class only
    private int num = 10;

//    Singleton (){
//
//    }
    // can't use normal constructor

    private static Singleton instance;

    // use static since we are using the constructor and getInstance method in other files static function
    public  static Singleton getInstance(){
        // check whether 1 obj is created or not
        if(instance == null){
            // creating an object for first time, calling the constructor for the first time
            instance = new Singleton();
        }
        // otherwise returning the old instnace again and again
        return instance;
    }
}

/*
Singleton class means we only want one obj of that class if more than one object exist for that class they must be point towards the same object all the time
one way of doing so is to avoid calling the constructor more than once
 */