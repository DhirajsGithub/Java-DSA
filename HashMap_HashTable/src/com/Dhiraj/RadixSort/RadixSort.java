package com.Dhiraj.RadixSort;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int arr[] = {29, 31, 471, 36, 91, 8};
        System.out.println("Original array " + Arrays.toString(arr));
        radixsort(arr);
        System.out.println("Sorted array " + Arrays.toString(arr));
    }

    public static void radixsort(int arr[]){
        int max = Arrays.stream(arr).max().getAsInt();

        // do count sort for every digit
        // 29, 31, 471, 36, 91, 8
        // 471/1, 471/10, 471/100, not valid 471/1000
        for(int exp=1; max/exp>0; exp*= 10){
            countSort(arr, exp);
        }
    }

    public static void countSort(int arr[], int exp){
//        int arr[] = {29, 31, 471, 36, 91, 8};
        int n = arr.length;
        int output[] = new int[n];
        int count[] = new int[10];

        Arrays.fill(count, 0);

//     arr = 29, 31, 471, 36, 91, 8   (for exp 1)
        // (arr[i]/exp)%10  will give the last digit for that exp
        for (int i = 0; i < n; i++) {
            count[(arr[i]/exp)%10]++;
        }

        System.out.println("Count array for : " + exp + " " + Arrays.toString(count));

        // to tackle the zeroes, like for exp 1 the count will look like  [0, 3, 0, 0, 0, 0, 1, 0, 1, 1]
        // so most elements will be place at 0th index and we don't want that
        for (int i = 1; i < 10; i++) {
            count[i] = count[i] + count[i-1];
        }

        System.out.println("Updated count array : "+ Arrays.toString(count));
//        Updated count array : [0, 3, 3, 3, 3, 3, 4, 4, 5, 6]


        // count[(arr[i]/exp)%10]-1 = count[(8/exp)%10]-1 = count[7] = 4
        for (int i = n-1; i >= 0; i--) {
            output[count[(arr[i]/exp)%10]-1] = arr[i];
            count[(arr[i]/exp)%10]--;
        }

        System.out.println("Output array " + Arrays.toString(output));

        // copies an array i.e. output array wil be copied to arr from 0th index to last index
        System.arraycopy(output, 0, arr, 0, n);

    }
}



















