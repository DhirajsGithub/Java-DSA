package com.Dhiraj;

import java.util.Arrays;

public class SortedMatrix {
    public static void main(String[] args) {

        int [][] arr = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        System.out.println(Arrays.toString(search(arr, 7)));

    }

    // search in the row provided, between the columns provided
    // apply binary search in specific row of a matrix
    static int[] binarySearch(int[] [] matrix, int row, int cStart, int cEnd, int target ){
        while(cStart <= cEnd){
            int mid = cStart + (cEnd - cStart)/2;
            if (matrix[row][mid] == target){
                return new int [] {row, mid};
            }if (matrix[row][mid] > target){

                cEnd = mid -1;

            }else{
                cStart = mid+1;
            }
        }
        return new int [] {-1, -1};
    }

    static int [] search(int[][] matrix, int target){
        int rows = matrix.length;
        int cols = matrix[0].length;      // be cautious matrix may be zero

        if (rows == 1){
            return binarySearch(matrix, 0, 0, cols-1,target );
        }
        // run the loop till two rows are remaining
        int rStart = 0;
        int rEnd = rows -1;
        int cMid = cols/2;
        while (rStart < rEnd-1){      // while this is true it will have more than two rows
            int mid = rStart + (rEnd - rStart)/2;
            if (matrix[mid][cMid] == target){
                return new int []{mid, cMid};
            }
            // if element is < than target rows above it can be ignored sinced it is sorted array
            if (matrix[mid][cMid] < target){
                rStart = mid;
            }else{
                rEnd = mid;
            }

        }
        // now we have two rows
        // check whether the target is in the col of 2 rows
        /*
        1 2 3 4
        5 6 7 8
        we are in the mid col and below two if conditions check for if 2 or 6 is the target
         */
        if (matrix[rStart][cMid] == target){
            return new int [] {rStart, rEnd};
        }
        if (matrix[rStart + 1][cMid] == target){
            return new int [] {rStart+1, cMid};
        }

        /*
        if out target is not 2 or 6 then we have four halfs : [0, 1) [2, 3] [1, 1) [2, 3]
         */
        // search in the 1st half
        if (target <= matrix[rStart][cMid -1]){
            return binarySearch(matrix, rStart, 0, cMid-1, target);
        }
        // search in the 2ns half
        if (target >= matrix[rStart][cMid + 1] && target <= matrix[rStart][cols-1]){    // target <= matrix[rStart][cols-1] is important as we don't want to return -1 as one row is remaining
            return binarySearch(matrix, rStart, cMid+1, cols-1, target);

        }
        // search in the 3rd half
        if (target <= matrix[rStart+1][cMid-1]){
            return binarySearch(matrix, rStart+1, 0, cMid-1, target);

        }
        // search in the 1st half
        else{
            return binarySearch(matrix, rStart+1, cMid+1, cols-1, target);

        }

        // time colexity log(rows) + log (clumns)


    }
}

/*

given sorted matrix from [0,0] to [n, m] like completly sorted, then perform binary search on it with log(row+column) complexity
- linear search will take O(n^2)
- convert the 2d matrix to 1d sorted and then apply binary search --> will take N(log(N)) complexity
- by applying binary search in 2d it will take O(N) complexity so ,
- by above code it will take log(row*column) complexity

 */