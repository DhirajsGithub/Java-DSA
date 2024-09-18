package com.Dhiraj;


public class Practise {
    public static void main(String[] args) {
        int [] array = {2,3,5,9, 14, 16, 18};
        int target = 4;
        int ans = ceilingNumber(array, target);
        System.out.println(array[ans]);
    }
    static int searchInInfiniteSortedArray (int arr [], int target){

        return -1;
    }
    static int ceilingNumber(int [] arr, int target){
        int start = 0;
        int end = arr.length-1;
        while (start<=end){
            int mid = start + (end-start)/2;
            if (arr[mid] == target){
                return mid+1;
            }else if (arr[mid] > target){
                end = mid-1;
            }else {
                start = mid+1;
            }
        }
        return start;
    }

}
