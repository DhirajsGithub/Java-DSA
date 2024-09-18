package com.Dhiraj;

import java.util.Arrays;

public class BinarySearch2Darray {
    public static void main(String[] args) {

        // need to see 2d array is sorted in a row and in column
        int [] [] arr = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {28, 29, 38, 49},
                {33, 34, 38, 50}
        };

        // below matrix will take O(N) complexity but with SortedMatrix algo it will take Olog(n+m) complexity
//        int [][] arr = {
//                {1,2,3},
//                {4,5,6},
//                {7,8,9}
//        };

        System.out.println(Arrays.toString(BinarySearch2D(arr, 6)));

    }

    // given array which is sorted "row and column wise"
    static int [] BinarySearch2D(int[][] matrix, int target){
        int r = 0;
        int c = matrix.length-1;      // checking from last column

        while (r < matrix.length && c >=0){
            if (matrix[r][c] == target){
//                int [] m = {r, c};
//                return m;
                return new int [] {r, c};
            }else if (matrix [r][c] < target){
                r ++ ;
            }else{
                c --;
            }
        }
        return new int [] {-1, -1};
    }
    // Time comlexity for the above is n + n    i.e bigO of n    (constants are ignore)

}
