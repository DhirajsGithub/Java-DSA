package com.Dhiraj;

public class Primitives {
    public static void main(String[] args) {
        int rollNo = 19;
        float marks = 99.34f;       // 99.34F  (big F can work as well)

        double pecentile = 96.789298332;
        System.out.println(pecentile);
        long population = 4837543982L;      // 4837543982l  (small l can work as well)
        System.out.println(population);
        char letter = 'd';
        // characters are store in single quotes

        int a = 234_000_000;
        // it's like 234,000,000 234 million
        System.out.println(a);

        int charAciiValue = 'A';
        System.out.println(charAciiValue);         // output 65  A ki accii value as integer
        int char2AciiValue = 'a';
        System.out.println(char2AciiValue);      // output 97

    }
}

// primitive data types matlab we can't break them even further (they are immutable)
//String name = "kunal"
// string is not a primitive data type

// why float ends with f and long with l caz large decimal numbers are store in double to store short decimal number we can use float
// hence f lagana jaruri ho jata hain . and intergers are store in int agar bade integer store karne hain toh we store them in long hence l lagana jaruri ho jata hain

// Literals and identifiers
// literals are the syntaxtical represention of boolean, char, int, float, etc
//
// int a = 10;
// here object 10 is literal and a the reference variable is called the identifier(name of variable, class, packages, interfaces in java)

