package com.Dhiraj;

import java.lang.reflect.Array;
import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int arr [] = {5, 6, 6, -9, 8, 3, 0, 0};
        QuickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    static void QuickSort(int [] nums, int low, int high){
        if(low >= high){
            return;
        }
        int start = low;
        int end = high;
        int mid = start + (end - start)/2;

        // selecting pivot element to be the middle one
//        nums[mid] *= nums[mid];
        int pivot = nums[mid];

        // placing the pivot at it's right place
        while( start <= end){
            // also, a reason why if its already being sorted it will not swap
            while(nums[start] < pivot){
                start++;
            }
            while(nums[end] > pivot){
                end--;
            }

            // above both while block attend suck start and end index such that they both can be swapped and there will be no violation
            if(start <= end){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }
        // now my pivot is ar correct index, sort two halves now divide and conquer again
        QuickSort(nums, low, end);
        QuickSort(nums, start, high);
    }
}

/*
Idea is that choose the element called pivot and the elements to it's left must be less than the number itself and elements to the right of it must be greater than number itself
choosing a pivot  : can be a random number, middle number or the last number
Time Complexity in worst case, if the pivot chosen is the max or min in the array O(N^2)
Time Complexity base case, if the pivot choosen is the middle element N*(log*N)

Quick Sort : is not Stable
In-place hence preferred over merge sort as merge sort takes O(N) space in the mix array
Merge Sort is better with linked list due to memory allocation not continuous


Hypbird Sorting algorithm(Tim Sort) :
uses merge sort + insertion sort

*/