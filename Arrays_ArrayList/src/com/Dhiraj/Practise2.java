package com.Dhiraj;

import java.util.Arrays;

public class Practise2 {
    public static void main(String[] args) {
        int arr [][] = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9,}};
        System.out.println(Arrays.deepToString(arr));
        rotate90(arr, 3);


    }
    static void rotate90 (int arr [][], int n){
        // layers
        for(int i=0; i<n/2; i++){
            // swapping
            int last = n -1-i;
            for(int j=0; j<n-1; j++){
                int top = i;
                int bottom = last; 
                int topLeft = arr[top][i+j];
                arr[top][i+j] = arr[bottom-i][i] ;
                arr[bottom-i][i]  = arr[bottom][last-i];
                arr[bottom][last-i] = arr[top+i][last];
                arr[top+i][last] =  topLeft;

            }
        }
        System.out.println(Arrays.deepToString(arr));
    }
}
