package com.Dhiraj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/split-array-largest-sum/

public class SplitArrayLargestSum {
    public static void main(String[] args) {
        // given an array of non-negative integers and an integer m , you can split the array into m non empty continuous subarrays
        // wrtie an algorithm to minimize the largest sum among these m subarrays
        int [] arr = {7,2,5,10,8};
        int ans = splitArray(arr, 2);
        System.out.println(ans);

    }
    static int splitArray(int [] nums, int m){
        int start = 0;
        int end = 0;

        for (int i=0; i<nums.length; i++){
            start = Math.max(start, nums[i]);     // in the end of loop this will contains max item from the array
            end += nums[i];
        }
        // maximum ans possible will be sum of all the elements i.e. when m is nums.length
        // min ans possible will be max element of nums, i.e. when m is 1
        // binary search
        while(start < end){
            // try for the middle as potential
            int mid = start + (end-start)/2;

            // calculate how many pieces you can divide this in with this max sum
            int sum = 0;
            int pieces = 1;
            for (int num : nums){
                if (sum + num > mid){
                    // you cannot add this in this subarray, make new one
                    // say add this num in new subarray then sum = num
                    sum = num;      // started new subarray from here
                    pieces ++;      // new subarray hence pieces will increase
                }else{
                    sum += num;     // subarray continue
                }
            }
            if (pieces > m){            // implies subarrays are more, to reduce subarray we should increase the sum
                start = mid+1;
            }else{
                end = mid;          // implies subarrasy are less to increase subarray we should decrease the sum
            }
        }
        return start;    // end = mid = start
    }

}


// case1 : min num of subarray is 1 the given array itslef and hence the ans be sum of elements maximum possible ans we can have is the sum of the elements
// case2 : max no of subarray will be no of elements and minimum possible ans we can have is the max element