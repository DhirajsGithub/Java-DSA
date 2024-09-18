package com.Dhiraj;

import java.util.Arrays;

public class MinMaxValues {
    public static void main(String[] args) {
        int [][] arr = {
                {2,5,8},
                {35,22},
                {20,0,90,34,41}
        };
//        int target = 90;
//        int[] ans = search(arr, target);
//        System.out.println(Arrays.toString(ans));

        System.out.println(max(arr));


        System.out.println(Integer.MAX_VALUE);        // min of min value of the OS
        System.out.println(Integer.MIN_VALUE);
    }

    // function returning 1D array
//    static int[] search(int[][] arr, int target) {
//        for (int row=0; row< arr.length; row++){
//            for (int col=0; col< arr[row].length; col++){
//                if (arr[row][col] == target){
////                    return {row, col};
//                    // need to declare the array first
//                    return new int[] {row, col};
//                }
//            }
//        }
//        return new int[] {-1, -1};
//    }

    // funtion returning max of 2d array using for of loop

    static int max (int [][] array){
        int maxValue = Integer.MIN_VALUE;
        for(int [] row: array){
            for (int colItem : row){
                if (colItem > maxValue){
                    maxValue = colItem;
                }
            }
        }
        return maxValue;

    }

}
