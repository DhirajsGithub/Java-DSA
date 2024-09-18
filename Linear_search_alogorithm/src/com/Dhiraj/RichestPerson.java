package com.Dhiraj;

public class RichestPerson {
    public static void main(String[] args) {
        int [][] array = {{3,5,6},{1,3,5},{4}};
        int ans = Rich(array);
        System.out.println(ans);

    }
    // given 2 d array like [[3,5,6],[1,3,5],[4,5,6,7,8]]     ---> each element is a person and each person has num of items in rows bank account and each bank account has value of item money
    static int Rich(int [][] arr){
        int [] money = new int[arr.length];
        for (int row=0; row<arr.length; row++){
            money[row] = sum(arr[row]);
        }
        return max(money);
    }
    static int sum(int[] array){
        int count = 0;
        for (int item : array){
            count = count + item;
        }
        return count;
    }
    static int max(int[] n){
        int maxValue = Integer.MIN_VALUE;
        for (int item: n){
            if (item>maxValue){
                maxValue = item;

            }
        }
        return  maxValue;
    }

//    // OR
//    static int Rich(int [][] arr){
//        int maxValue = Integer.MIN_VALUE;
//        int [] money = new int[arr.length];
//        for (int row=0; row<arr.length; row++){
//            int sum = 0;
//            for(int col=0; col<arr[row].length; col++){
//                sum = sum + arr[row][col];
//            }
//            if (sum>maxValue){
//                maxValue = sum;
//            }
//        }
//        return maxValue;
//    }

}
