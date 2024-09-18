package com.Dhiraj;

import java.util.Arrays;
import java.util.Locale;

public class Methods {
    public static void main(String[] args) {
        String name = "Dhiraj Borse Hellow World";
        System.out.println(name.toCharArray());
        System.out.println(Arrays.toString(name.toCharArray()));

        System.out.println(name.toLowerCase());    // not changing the orginal one

        System.out.println(name.indexOf('a'));    // first occurence of 'a'
        System.out.println(name.indexOf('z'));     // -1
        System.out.println(name.lastIndexOf('r'));

        System.out.println("     Kunal  ".strip());    // clearing white spaces from left and righ
        System.out.println(Arrays.toString(name.split(" ")));      // split through space

        String arr [] = name.split(" ");
        System.out.println(Arrays.toString(arr));
        String ss = "Str1";
        int p = Character.getNumericValue(ss.charAt(0));    // used to get the integer value that a specified Unicode character represents
        System.out.println(p);

//        isEmpty() method checks whether a string is empty or not.
        System.out.println(ss.isEmpty());

        // substring() method  takes the argume
        System.out.println(ss.substring(1));     // start from char 1 and goes upto the end
        System.out.println(ss.substring(0, 2));     // start from char 0 and goes upto char 1

        // startsWith() method finds a string which is provided as an argument
        String apple = "appleaDay";
        System.out.println(apple.startsWith("apple"));

    }
}
