package com.Dhiraj;

import java.util.Locale;

public class stringg {
    public static void main(String[] args) {
        String greeting = "Hello";
        String txt = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String txt2 = "Please locate where 'locate' occurs!";

        // length() method
        System.out.println("The length of the txt string is: " + txt.length());

        // toUpperCase() / toLowerCase() method
        System.out.println(greeting.toUpperCase());

        // indexOf() method
        System.out.println(txt2.indexOf("where"));   // 14

        // concat method
        String firstName = "John ";
        String lastName = "Doe";
        System.out.println(firstName.concat(lastName));

        // If you add a number and a string, the result will be a string concatenation:

//        String txt3 = "We are the so-called "Vikings" from the north.";
        // The solution to avoid this problem, is to use the backslash escape character.
        String txt3 = "We\tare the so-called \"Viking\'s\" from thee\b north";
        System.out.println(txt3);
        /*

         \'  --> single quote
         \"  --> double quote
         \\  --> backslash
         \n  --> new line
         \t  --> tab
         \b  --> backspace
         \f  --> formfeed
         \r  --> carriage return

         */

        String text = "Hello\rWorld!";
        String text2 = "Helloo\b\tWorld";
        String text3 = "Hello\fWorld";

        System.out.println(text);
        System.out.println(text2);
        System.out.println(text3);

    }

}
