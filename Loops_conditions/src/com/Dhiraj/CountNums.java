package com.Dhiraj;

public class CountNums {
    public static void main(String[] args) {
//        int n = 56;
//        System.out.println(n/10);      // 5
//        float n = 56;
//        System.out.println(n/10);       // 5.6

        int n = 34552125;

        // count the numbers of 5 in given n
        // the idea is basically get remainder by 10 of given number which will give the last one and count it
        int count = 0;
        while (n>0){
            if (n%10 == 5){
                count++;
            }
            n = n/10;                      // since n is initialized as int hence it will omit the last digit everytime

        }
        System.out.println(count);
    }
}
