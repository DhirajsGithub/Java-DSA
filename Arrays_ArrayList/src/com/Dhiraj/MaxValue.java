package com.Dhiraj;

import java.util.Arrays;

public class MaxValue {
    public static void main(String[] args) {
        int [] arr = {1,24,576,33,458};
        int ans = maxRange(arr,1,3);
        System.out.println(ans);

//        int [][] mat = {{1,2,4},{3,99,5}};
//        int [] [] mat2 = mat;
//        System.out.println(mat2[1][1]);

       int [][] mat = {{0,0,0},{0,1,0},{1,1,1}};
       int [] [] target = {{1,1,1},{0,1,0},{0,0,0}};
        System.out.println(findRotation(mat, target));
    }
    // finding max value in provided index
    static int maxRange(int[] array, int index1, int index3){
        // let max value be array[index1]
        int maxValue = array[index1];
        for (int i=index1; i<=index3; i++){
            if (maxValue <array[i]){
                maxValue = array[i];
            }
        }
        return maxValue;

    }

        public static int findRotation(int[][] mat, int[][] target) {

            int c1 = 0;
            int c2 = 0;
            int c3 = 0;
            int c4 = 0;
            for(int i=0; i<mat.length; i++){
                for(int j=mat.length-1; j>=0; j--){
                    // checking for 90deg
                    if(mat[j][i] == target[i][mat.length-1 - j]  ){
                        c1 +=1;
                    }else if(mat[mat.length-1-i][j] == target[i][mat.length-1 - j])  {
                        c2 +=1;
                    }else if(mat[mat.length-1-j][mat.length-1-i] == target[i][mat.length-1 - j]){
                        c3 +=1;
                    }else if(mat[i][mat.length-1-j] == target[i][mat.length-1 - j]){
                        c4 +=1;
                    }

                }
            }

            if(c1 == mat.length || c2==mat.length || c3==mat.length || c4== mat.length){
                return c2;
            }


            return c2;
        }
    }


//    brute force: adj. Describes a primitive programming style, one in which the programmer relies on the computer's processing power instead of using his or her own intelligence to simplify the problem,
//    often ignoring problems of scale and applying native methods suited to small problems directly to large ones.