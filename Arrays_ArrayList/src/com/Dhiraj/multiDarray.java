package com.Dhiraj;

import java.util.Arrays;
import java.util.Scanner;

public class multiDarray {
    public static void main(String[] args) {
        int arr3D [][][] = new int[3][3][3];
        System.out.println(Arrays.deepToString(arr3D));
        /*
                1 3 4
                2 2 3
                1 1 1

         */
//        int [][] arr = new int[3][];
//        int [row][column] arr = new int[size_row][size_column];
//        note: specifying the size of column is not mendatory
        int[][] arr = {
                {1,2,3},
                {2,3,4},
                {1,1,1}
        };
//        System.out.println(Arrays.toString(arr));
//        System.out.println(arr[1]);         // [2,3,4]
//        System.out.println(arr[1][0]);      // 2

        // imagine this as an array of arrays

        Scanner in = new Scanner(System.in);
        int [][] arr2d = new int[3][3];
        System.out.println(arr2d.length);        // length of the rows

        // feeding an array first
        for (int row=0; row< arr2d.length; row++){
            for (int col=0; col<arr2d[row].length; col++){
                arr2d[row][col] = in.nextInt();
            }
        }

        // output of an array using row and col individually
        for (int row=0; row< arr2d.length; row++){
            for (int col=0; col<arr2d[row].length; col++){
                System.out.print(col +" ");
            }
            System.out.println();
        }
        /*
        1 2 3
        4 5 6
        7 8 9
         */

        // ouput of an array using each row
        for (int row=0; row< arr2d.length; row++){
            System.out.println(Arrays.toString(arr2d[row]));       // every element of arr2d is an array itself
        }
             /*
        [1, 2, 3]
        [4, 5, 6,]
        [7, 8, 9,]
         */

        System.out.println(Arrays.toString(arr2d));

        // prints 2d array in single line
        System.out.println(Arrays.deepToString(arr2d));
                   /*
        [1, 2, 3,
        4, 5, 6,
        7, 8, 9,]
         */

        for (int[] a : arr2d){
            System.out.println(Arrays.toString(a));
        }
        /*
        [1, 2, 3]
        [4, 5, 6,]
        [7, 8, 9,]
         */


    }
}
