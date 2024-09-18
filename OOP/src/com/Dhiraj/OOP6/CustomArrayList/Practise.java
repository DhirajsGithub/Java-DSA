package com.Dhiraj.OOP6.CustomArrayList;

import java.util.Arrays;

public class Practise {
    public static void main(String[] args) {
        int [] arr_1 = new int[3];
        int i=0;
        arr_1[i++] = 2;
        arr_1[++i] = 2;
        System.out.println(Arrays.toString(arr_1));
    }
}
