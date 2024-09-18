package com.Dhiraj;

import java.util.Arrays;

public class RoadmapQuestions {
    public static void main(String[] args) {
        int arr[] = {3, 4, 6, 0};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));

        int arr2 [] = {7,6,4,3,1};
        System.out.println((maxProfit(arr2)));

        int arr3[] = {1,2,3,4,5,6,7};
        rotate(arr3, 3);
    }
//    https://leetcode.com/problems/move-zeroes/
    public static void moveZeroes(int arr[]){
        int i=0;
        int j=i+1;
        while (i<arr.length && j<arr.length){
            if(arr[i] ==0 && arr[j]!=0){
                swap(arr, i, j);
                i++;
                j++;
            }else if(arr[i] ==0 && arr[j] ==0){
                j++;
            }else{
                i++;
                j++;
            }
        }
    }

    public static void swap(int [] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


//    https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
    public static int maxProfit(int [] prizes){

//        // brute force
//        int profit = 0;
//        for (int i = 0; i < prizes.length; i++) {
//            for (int j = i+1; j < prizes.length; j++) {
//                if(prizes[j] - prizes[i] > profit){
//                    profit = prizes[j] - prizes[i];
//                }
//            }
//        }
//        return profit;

        // sliding window
        int l=0;    // buy
        int r=1;    // sell
        int profit = 0;
//        visualize using graph for the same
        while (r<prizes.length){
            // buying is less than selling
            if(prizes[l] < prizes[r] ){

                profit = Math.max(prizes[r] - prizes[l], profit);
            }else{
                l = r;
            }
            r++;
        }
        return profit;
    }

//    https://leetcode.com/problems/rotate-array/
    public static void rotate(int nums [], int k){


//        // space O(n)  and  O(N) time
//        if(k>nums.length){
//            k = k%nums.length;
//        }
//        System.out.println((k));
//        int [] ans = new int[nums.length];      // space O(n)   extra space
//        int j=0;
//        for (int i = nums.length-k; i < nums.length; i++) {
//            ans[j] = nums[i];
//            j++;
//        }
//        for (int i = 0; i < nums.length-k; i++) {
//            ans[j] = nums[i];
//            j++;
//        }
//
//        for(int i=0; i<nums.length; i++){
//            nums[i] = ans[i];
//        }
//        System.out.println(Arrays.toString(nums));


        // O(1) space and O(N) time
        // reverse the array
        // then reverse the first k half and last k half
        if(k>nums.length){
            k = k%nums.length;
        }
        if(k == 0){
            return;
        }
        int i=0;
        int j=nums.length-1;
        while (i<j){
            swap(nums, i, j);
            i++;
            j--;
        }
        System.out.println(Arrays.toString(nums));
        int m=0;
        int n=k-1;
        while (m<n){
            swap(nums, m, n);
            m++;
            n--;
        }
        System.out.println(Arrays.toString(nums));
        int o=k;
        int p=nums.length-1;
        while (o<p){
            swap(nums, o, p);
            o++;
            p--;
        }

        System.out.println(Arrays.toString(nums));

    }
}
