package com.Dhiraj;

public class BinarySearch {

    public static void main(String[] args) {
	// here we know that arr is sorted !
        int [] arr = {-40,-33,-22, -15, -9, -8, -7, -3, 0, 1,2,3,4,5,6,7,8,9,44, 545, 3522, 3058903,3058905};
        int target = 545;
        System.out.println(arr.length);
        int ans = BinarySerach(arr, target);
        System.out.println((ans));

    }

    // note it is for asceding order elements only for descending order we need to apply end>=start and we increment end by mid+1 and start mid -1
    // return the index of target element in the array else return -1 if the target element does not exist
    static int BinarySerach(int [] array, int target){
        int start = 0;
        int end = array.length-1;

        while (start <= end){
            int mid = start + (end - start)/2;

            if (target < array[mid]){
                end = mid -1;
            }else if(target > array[mid]){
                start = mid +1 ;
            }else {
                // ans found time colexity bigO of (1)    -----> constant
                return mid;
            }

        }
//        worst time complexity bigO of log2(arra.length), but much better than worst time complexity of linear search i.e array.length
        return -1;

    }
}


/*
Linear Search Approach: A simple approach is to do a linear search. The time complexity of the Linear search is O(n). Another approach to perform the same task is using Binary Search.


Binary Search Approach: Binary Search is a searching algorithm used in a sorted array by repeatedly dividing the search interval in half. The idea of binary search is to use the information that the array is sorted and reduce the time complexity to O(Log n). The basic steps to perform Binary Search are:

Begin with an interval covering the whole array.
If the value of the search key is less than the item in the middle of the interval, narrow the interval to the lower half.
Otherwise, narrow it to the upper half.
Repeatedly check until the value is found or the interval is empty.
 */