package com.Dhiraj;

import java.util.ArrayList;
import java.util.Arrays;

public class Practise {
    public static void main(String[] args) {
//        ArrayList<Integer> missing = new ArrayList<>();
//        int [] arr = {2,3,4,7,11};
//        for (int i=1; i<=arr[arr.length-1]; i++){
//            // considering every i as target applyin binary search at every i if i not found place it in missing list
//            int start = 0;
//            int end = arr.length-1;
//            while(start <=end){
//
//                int mid = start + (end-start)/2;
//                if(i == arr[mid]){
//                    System.out.println(i);
//                    break;
//
//                }else if(i > arr[mid]){
//                    start = mid+1;
//
//                }else if(i<arr[mid]){
//                    end = mid-1;
//                    System.out.println(start);
//                }
//            }
//            missing.add(i);
//
//
//        }
//        System.out.println(missing);
        int [] [] arr = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {28, 29, 38, 49},
                {33, 34, 38, 50}
        };

        System.out.println(Arrays.toString(biarySIn2D(arr, 90)));

        int [] [] arr2 = {  {1, 2, 3, 4,},
                            {5, 6, 7, 8},
                            {9, 10, 11, 12},
                            {13, 14, 15, 16} };

    }

    static int [] biarySIn2D (int [][] arr, int target){

        int row = 0;
        int col = arr[0].length-1;
        while (row < arr.length && col >=0){
            if(arr[row][col] == target){
                return new int [] {row, col};
            }
            if(arr[row][col] > target){
                col --;
            }else{
                row ++;
            }
        }

        return new int [] {-1, -1};
    }
}
