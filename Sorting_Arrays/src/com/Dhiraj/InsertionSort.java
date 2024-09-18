package com.Dhiraj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertionSort {
    public static void main(String[] args) {
        // transferring one element to a partially sorted array at a time
        // taking an element and comparing it with n-1 elements one by one
        // time complexity worst case: when the array is sorted in descending order and
        // want to sort in ascending order
        // total comparison will be n-1 + n-2 + n-3 + ... + 1 == big O (N^2)
        // best case is array is already sorted in ascending order and making only n-1
        // comparison == big O (N)
        // Why insertion sort:
        // 1. Adaptive: steps get reduced if array is sorted. No of sort get reduced as
        // comparsion to bubble sort
        // 2. stable
        // 3. used for smaller value of n ==> works good when array is partially sorted
        // /
        // 4. It takes part in hybrid sorting algorithm (inbuilt sort method in other
        // languages high possibility that they used insertion sort)

        // int [] arr = {5,3,4,1,2};
        int[] arr = { 4, 5, 1, 2, 3, 9, -888 };
        insertion(arr);
        System.out.println(Arrays.toString(arr));
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        temp.remove(1);

        System.out.println(temp);

    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 1 + i; j > 0; j--) {
                if (arr[j - 1] > arr[j]) { // same as if (arr[i] > arr[j])
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void insertion(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }
}
