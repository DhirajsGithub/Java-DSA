package com.Dhiraj;

import java.util.Arrays;

public class FirstLastPosition {
    public static void main(String[] args) {
        // finding the starting and ending position of a target element in sorted array

        int [] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;

        int[] ans = {-1, -1};
        int start =search(nums, target, true);
        int end = search(nums, target, false);

        ans[0] = start;
        ans[1] = end;
        System.out.println(Arrays.toString(ans));

    }

    static int search(int [] nums, int target, boolean findStartIndex){
        // check for first occurence of target first
        int start = 0;
        int end = nums.length-1;
        int ans = -1;


        while(start<=end){
            int mid = start + (end - start)/2;
            if (target < nums[mid]){
                end = mid-1;
            }else if (target > nums[mid]){
                start = mid + 1;
            }else{
                // potential ans found
                ans = mid;
                if (findStartIndex){
                    end = mid -1;
                }else{
                    start = mid +1;
                }
            }
        }

        return ans;
    }
}
