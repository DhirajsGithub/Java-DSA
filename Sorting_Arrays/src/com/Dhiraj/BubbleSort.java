package com.Dhiraj;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        // a.k.a sinking sort/ exchange sort
        // In each step we are comparing adjacent elements
        // with the first pass through the array the largest element come at the end in this way with second pass the second large element will occupy the second last place
        /// with every pass the array is sorted from back hence we can reduce the size of array with every pass

        // space and time complexity for bubble sort algorithm
        // what is the maximum number of comparison we are making
        // space complexity is constant big O (1)     ---> No extra space is required i.e. is copying the array is not required a.k.a inplane sorting algorithm
        // time complexity: best case big O (N)  (when the array is sorted let say ascending order),  worst case big O (N^2) array is sorted in descending order and need to sort in ascending order
        // worst case big O (N^2) for i=0 and j = j (N-j-1) swaps(coz ignoring the last once) so total (N*N -1 ) - (n-1)(n)/2 swaps hence ignoring constants and taking the dominant once we have O(N^2)
        // stable sort

        // stable sorting and unstable sorting algorithm
        // stable sorting: Order should be same when the value is same i.e. order of different properties should be same when as their values are same before and after sorting
        // stable sorting: when the original order is maintain for values that are equal
        // unstable sorting: order is not maintain of same values element

        int [] arr = {-1, 7, -32, 89, 0, 0, 1, 1, 44};
        bubble(arr);
        System.out.println(Arrays.toString(arr));



    }
    static void bubble(int [] dis ){

        boolean swapped;

        // run the steps n times
        for (int i=0; i< dis.length; i++){
            swapped = false;

            // for each step maximum item will come at the last respective index
            for (int j=1; j< dis.length-i; j++){
                // swap if the item is smaller than the previous item
                if (dis[j] < dis[j-1]){
                    // swap
                    int temp = dis[j];
                    dis[j] = dis[j-1];
                    dis[j-1] = temp;
                    swapped = true;
                }
            }
            // if you did not swap for a particular value of i it means the array is sort hence stop the loop when i hits 1
            if (!swapped){
                break;
            }

        }
    }

    public static void bubbleSort(int [] arr){
        boolean swapped;
        for (int i = 0; i < arr.length; i++) {
            swapped = false;
            for (int j = 1; j < arr.length-i; j++) {
                if(arr[j-1] > arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    swapped = true;
                }
            }
            if(!swapped){
                return;
            }
        }
    }
}

