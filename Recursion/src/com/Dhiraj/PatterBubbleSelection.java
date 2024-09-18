package com.Dhiraj;

import java.util.Arrays;

public class PatterBubbleSelection {
    public static void main(String[] args) {
        patter1(5, 5, 0);
        patter2(5, 5, 0);

        int [] arr = {4,2,5,6,2,1};
//        bubble(arr, arr.length-1, 0);
//        System.out.println(Arrays.toString(arr)); 

        selection(arr, arr.length, 0, 0);
        System.out.println(Arrays.toString(arr));

    }
    static void patter1(int n, int row, int column){
        if(row == 0){
            return;
        }
       if(row > column){
           System.out.print("*");
           patter1(n, row, column+1);
       }else{
           System.out.println();
           patter1(n, row-1, 0);
       }
    }
    static void patter2(int n, int row, int column){
        if(row == 0){
            return;
        }
        if(row > column){
            patter2(n, row, column+1);
            System.out.print("*");

        }else{

            patter2(n, row-1, 0);
            System.out.println();
        }
    }
    static void bubble (int [] arr, int r, int c){
        if(r == 0){
            return;
        }
        // putting the largest one at the end
        if(c < r){
            if(arr[c] > arr[c+1]){
                // swap
                int temp = arr[c];
                arr[c] = arr[c+1];
                arr[c+1] = temp;
            }
            bubble(arr, r, c+1);
        }
        // putting the last second to the last second place
        else{
            bubble(arr, r-1, 0);
        }

    }

    static void selection(int [] arr, int r, int c, int max){
        // let say max element is at index 0
        if(r == 0){
            return;
        }
        if(r > c){
            // checking in the first row or say chekcing the entire array from 0 to last index
            if(arr[c] > arr[max]){
                // updating max to c
                selection(arr, r, c+1, c);
            }else{
                selection(arr, r, c+1, max);
            }
            // till here we found the max element index
        }else{
            // r== arr.length
            swap(arr, r-1, max);
            // max element is at last index
            selection(arr, r-1, 0, 0);
            // second max index is at second last index and so on ...

        }

    }


    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

}
