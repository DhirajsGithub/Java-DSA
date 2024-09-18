package com.Dhiraj;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        // select an element and put it at it's correct index
        // total comparison can be done as n-1 + n-2 + .... 1 + 0  == (n-1)(n)/2  which is bigO(N^2) in both best and worst case senerio
        // space complexity is constant big O (1)
        // not stable
        // Selection sort is also pretty good for smaller arrays of maybe 10 to 20 elements.
        int [] arr = {3,1,5,4,2};
        selection(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void selection(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // find the max item in the remaining array and swap with correct index
            int last = arr.length - i - 1;
            int maxIndex = getMaxIndex(arr, 0, last);
            swap(arr, maxIndex, last);

        }
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    static int getMaxIndex(int[] arr, int start, int end) {
        int max = start;
        for (int i = start; i <= end; i++) {
            if (arr[max] < arr[i]) {
                max = i;
            }
        }
        return max;
    }

    public static void selectionSort(int arr []){

        int i=0;
        while (i<arr.length){
            int last = arr.length - i - 1;
            int maxIndex = getMaxIndex(arr, 0, last);
            swap(arr, maxIndex, last);
            i++;
        }
    }
}
