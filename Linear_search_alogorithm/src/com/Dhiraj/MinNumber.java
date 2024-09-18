package com.Dhiraj;

public class MinNumber {
    public static void main(String[] args) {
        int [] arr = {2,35,6,2,6,7,-1,45};
        int mi = min(arr);
        System.out.println(mi);

    }

    // assume arr.length!= 0;
    // return the min value in the array
    static int min(int[] arr) {
        int m = arr[0];
        for (int i=0; i<arr.length; i++){
            if (m > arr[i]){
                m = arr[i];
            }
        }
        return m;
    }
}
