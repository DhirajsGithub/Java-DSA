package com.Dhiraj;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {

        int [] arr = {2, 45, 48, 99};
        reverse(arr);
        System.out.println(Arrays.toString(arr));


       long p = 1 + 999999999;

//        // reverse reqR
//        double revR = 0;
//        while(reqR >0){
//            revR = revR*10 + reqR%10;
//            reqR = reqR/10;
//        }
//        System.out.println(revR);

    }

    static void swap(int [] array, int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;

    }

    static void reverse(int [] array){
        int start = 0;
        int end = array.length-1;
        while (start < end){
            // swap
            swap(array, start, end);
            start ++;
            end --;
        }
    }



}
