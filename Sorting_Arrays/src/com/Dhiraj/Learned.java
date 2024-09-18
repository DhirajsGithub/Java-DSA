package com.Dhiraj;

import java.util.Arrays;

public class Learned {
    public static void main(String[] args) {
        // sort array in descending order irrespective of the sign of elements
        int [] arr = {2, 3, 4, 0, -3, -5, 8, -99};
        for(int i=0; i<arr.length-1; i++){
            for(int j=i+1; j>0; j--){
                int n1 = arr[j] > 0 ? arr[j] : -1*arr[j];
                int n2 = arr[j-1] > 0 ? arr[j-1] : -1*arr[j-1];
                if(n1 < n2){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }else{
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(arr));

        int [] arr2 = {2, 3, 4, 0, -3, -5, 8, -99};
        int [] arr3 = arr2;
        arr2[0] = 999;
        System.out.println(Arrays.toString(arr3));

        // clone an array
        int [] arr4 = arr2.clone();

        // sort the array with best possible algorithm internal
    }
}


/*
Ascending order is when there are numbers in a series that increase at every step also called strictly increasing for eg 1 2 4 6 7
Non decreasing order is when the numbers may or may not increase but they never deccrease for eg 1 2 2 3 3 4 5 6 6
*/