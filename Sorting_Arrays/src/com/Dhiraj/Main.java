package com.Dhiraj;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// Every sorting algorithm going to sort step by step
        // all the sorting algorithm differ by each step
//
//        int[] nums = {1,2,4};
//        int [] nums2 = nums;
//        nums[1] = 99;
//        System.out.println(Arrays.toString(nums2));

        int[] nums = {1,2,4};
        int [] nums2 = {2,4,5};
        insertionSort(nums);
        System.out.println(Arrays.toString(nums));
        for (int i : nums){
            if ( 1==1){
                System.out.println("true");

            }
            if(2==2){
                System.out.println("true2");
            }
        }
    }
    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    static void insertionSort(int [] arr){
        for (int i=0; i<arr.length -1; i++) {
            for (int j = 1 + i; j > 0; j--) {
                if (arr[j-1] < arr[j]) {          // same as if (arr[i] > arr[j])
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }
}

