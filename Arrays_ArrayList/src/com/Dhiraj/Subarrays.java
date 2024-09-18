package com.Dhiraj;

import java.util.Arrays;

public class Subarrays {
    public static void main(String[] args) {
        Integer[] originalArray = {1, 2, 3, 4, 5};
        int fromIndex = 1;
        int toIndex = 4;

        Integer[] subArray = Arrays.copyOfRange(originalArray, fromIndex, toIndex);
        System.out.println(Arrays.toString(subArray));


    }
}
