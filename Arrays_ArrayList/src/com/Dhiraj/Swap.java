package com.Dhiraj;

import java.util.Scanner;
import java.util.Arrays;

public class Swap {
    public static void main(String[] args) {
        int [] arr = {1,23,54, 6, 99};
        // calling swap function to swap index1 and index3
        swap(arr, 1, 3);

        // initially [1,23,54, 6, 99]
        System.out.println(Arrays.toString(arr));


        Scanner in = new Scanner((System.in));
        String[] str2 = new String[4];
        for (int i=0; i<str2.length; i++) {         // no problem with str2.length though
            str2[i] = in.next();
        }
        System.out.println(Arrays.toString(str2));
        // modify
        str2[1] = "kunal";
        System.out.println(Arrays.toString(str2));



    }
    static void swap(int[] array, int index1, int index3){
        int temp = array[index1];
        array[index1] = array[index3];
        array[index3] = temp;
    }
}
