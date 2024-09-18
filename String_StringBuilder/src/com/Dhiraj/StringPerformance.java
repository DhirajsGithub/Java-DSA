package com.Dhiraj;
import java.lang.Math;
import java.util.ArrayList;

public class StringPerformance {
    public static void main(String[] args) {
        System.out.println("a" + 'c');       // ac   if any of the type is string result will be string
        String series = "";
        for (int i=0; i< 26; i++){
            char ch = (char)('a' + i);      // instead of creating 26 new object we can add all of the character object in string builder
            series += ch;
        }

        System.out.println(series);
        // total wastage of memory with space complexity of O(N^2)
        // as we are making 1 + 2 + 3 + 4 + .... + N
        // storage will be a , ab, abc, ....., abcde..yz

        // wouldn't be there any method which will just change the orignal string like the array
        // series = "abc"
        // series += "d"
        // hecne series is "abcd"
        // yes there is string builder, StringBuilder itself a class

    }
}
