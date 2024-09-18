package com.Dhiraj;

import java.util.Arrays;
import java.util.ArrayList;

public class P2 {
    public static void main(String[] args) {
//        int [] digits = {9,8,7,6,5,4,3,2,1,0};
//        long num = 0;
//        for(int i=0; i<digits.length; i++){
//            num = num*10 + digits[i];
//        }
//        num +=1;
//        long temp = num;
//        int size =0;
//        while(temp > 0){
//            size = size +1;
//            temp = temp/10;
//        }
//        System.out.println(num);
//
//        long ans [] = new long[size];
//
//        for(int i=size-1; i>=0; i--){
//            ans[i] =  num%10;
//            num = num/10;
//        }
//        System.out.println(Arrays.toString(ans));

        int [][] matrix = {{1,10,4,2},{9,3,8,7},{15,16,-1,-1}};

        ArrayList<Integer> luckyNo = new ArrayList<>();
        int row = 0;
        int col = 0;
        while(true){
            // keeping the row common finding the min number
            int minVal = Integer.MAX_VALUE;
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[row][j] < minVal){
                    minVal = matrix[row][j];
                }
            }

            // keeping the column common finding the max number
            int maxVal = Integer.MIN_VALUE;
            for(int i=0; i<matrix.length; i++){
                if(matrix[i][col] > maxVal){
                    maxVal = matrix[i][col];
                }
            }
            if(maxVal == minVal){
                luckyNo.add(maxVal);
            }
            System.out.println("max is "+ maxVal);
            System.out.println("min is "+ minVal);
            row++;
            col++;

        }
        
    }
}
