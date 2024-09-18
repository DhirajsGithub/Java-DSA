package com.Dhiraj.algo;

/**
 * KadanesAlgo
 * problem statement : Given an array of integers, find the contiguous subarray
 * (containing at least one number) which has the largest sum and return its
 * sum.
 * Approach: we will use kadanes algorithm to solve this problem, we will keep
 * track of
 * current sum and max sum, if current sum is greater than max sum then we will
 * update max sum
 * else we will update current sum to 0.
 * 
 * 
 */
public class KadanesAlgo {
    public static void main(String[] args) {
        int arr[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
        System.out.println("Max sum of subarray is: " + kadanesAlgo(arr));

    }

    private static int kadanesAlgo(int[] nums) {
        int maxSoFar = Integer.MIN_VALUE;
        int maxEndingHere = 0;
        for (int i = 0; i < nums.length; i++) {
            maxEndingHere += nums[i];
            maxSoFar = Math.max(maxEndingHere, maxSoFar);
            if (maxEndingHere < 0) {
                maxEndingHere = 0;
            }
        }
        return maxSoFar;
    }

}