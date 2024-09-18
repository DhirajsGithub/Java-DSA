package com.Dhiraj;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int arr [] = {6, 3, 9, 5, 2, 8};
        // NOTE : new object are being created for every function call
        // hence oirignal array won't chage
        arr = mergeSort(arr);
        System.out.println(Arrays.toString(arr));

        // this will change the original order of the array
//        mergeSortInPlace(arr, 0, arr.length);
//        System.out.println(Arrays.toString(arr));
    }

    static int[] mergeSort(int[] arr) {
        System.out.println("mergeSort !!! ");
        if (arr.length == 1) {
            return arr;
        }

        int mid = arr.length / 2;

        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        System.out.print("Left");
        System.out.println(Arrays.toString(left));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
        System.out.print("Right");
        System.out.println(Arrays.toString(right));

        return merge(left, right);
    }

    private static int[] merge(int[] first, int[] second) {
        System.out.println("merge");
        int[] mix = new int[first.length + second.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < first.length && j < second.length) {
            if (first[i] < second[j]) {
                mix[k] = first[i];
                i++;
            } else {
                mix[k] = second[j];
                j++;
            }
            k++;
        }

        // it may be possible that one of the arrays is not complete
        // copy the remaining elements
        while (i < first.length) {
            mix[k] = first[i];
            i++;
            k++;
        }

        while (j < second.length) {
            mix[k] = second[j];
            j++;
            k++;
        }

        System.out.print("mix is");
        System.out.println(Arrays.toString(mix));

        return mix;
    }



    static void mergeSortInPlace(int[] arr, int s, int e) {
        if (e - s == 1) {
            return;
        }

        int mid = (s + e) / 2;

        mergeSortInPlace(arr, s, mid);
        mergeSortInPlace(arr, mid, e);

        mergeInPlace(arr, s, mid, e);
    }

    private static void mergeInPlace(int[] arr, int s, int m, int e) {
        int[] mix = new int[e - s];
        int i = s;
        int j = m;
        int k = 0;

        while (i < m && j < e) {
            if (arr[i] < arr[j]) {
                mix[k] = arr[i];
                i++;
            } else {
                mix[k] = arr[j];
                j++;
            }
            k++;
        }
        // it may be possible that one of the arrays is not complete
        // copy the remaining elements
        while (i < m) {
            mix[k] = arr[i];
            i++;
            k++;
        }
        while (j < e) {
            mix[k] = arr[j];
            j++;
            k++;
        }
        for (int l = 0; l < mix.length; l++) {
            arr[s+l] = mix[l];
        }
    }

}

/*

an example of the divide and conquer strategy.
stable sort
array is initially divided into two equal halves and then they are combined in a sorted manner.
We can think of it as a recursive algorithm that continuously splits the array in half until it cannot be further divided.
This means that if the array becomes empty or has only one element left, the dividing will stop, i.e. it is the base case to stop the recursion.

 with time complexity of O(N*log(N))
 space complxity being O(N)
 */
