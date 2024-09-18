package com.Dhiraj;

import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        // when given numbers are from 1 to n natural NON BREAKING numbers!
        int [] arr2 = {4,7,8,2,3,1,5,6, 9, 10, 11};
        cyclicSort(arr2);
        System.out.println(Arrays.toString(arr2));

    }
    static void cyclicSort(int [] arr){
        int i = 0;
        while (i< arr.length){
            int correct = arr[i] -1;     // index and value must be  index + 1 = arr[index]
            if (arr[i] != arr[correct]){            // comparing elements
                swap(arr, i, correct);
            }else{
                i++;
            }
            // total number of comparison ares n-1 + n == 2n-1  both cases time complexity is big O (N)
        }
    }
    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static void cyclic(int arr[]){
        int i=0;
        while (i<arr.length){
            int val = arr[i]-1;
            if(val != i){           // comparing indexes
                swap(arr, i, val);
            }else{
                i++;
            }
        }
    }
}
