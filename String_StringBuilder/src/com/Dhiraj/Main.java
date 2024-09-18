package com.Dhiraj;

public class Main {

    public static void main(String[] args) {
	// write your code here
        // String --> collection sequence of characters
        // String Pool --> seperate memory structure inside the heap
        // why seperate --> all the similar objects in the pool won't be created again --> makes our programme more optimise
        // Strings are immutable in java so any object representing string data structure won't be able to change
        String a = "Kunal";

        String b = "Kunal";
        // a and b both pointing to the object "kunal" in the string pool

        a = "Kushwaha";      // new object being created and a points towards it and now object "kunal" left alone without any reference variable hence it will be go in garbage collection
        System.out.println(a);
        b += "dj";               // here what's happening initially b ---> "Kunal"  then now b---> "Kunaldj"   now "kunal" don't have any ref variable hence it is collected as garbage collection
        System.out.println(b);

        String str1 = "Value1";
        String str2 = str1;
        str1 = "value2";
        System.out.println(str2);

    }
}

/*
using new with string
String are immutable no need to use new keyword
- we would want to use new because it allows us to create a seperate object that references a seperate value
- when working with string this is not needed because the original string will not be modified because string are immutable


* */