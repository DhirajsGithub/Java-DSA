package com.Dhiraj;
//import java.lang.math;

public class EvenDigit {
    public static void main(String[] args) {

        int arr [] = {2,4354,13,45,677,11,24,4674,241,5773,225578};

        int ans = findEvenDigits(arr);
        System.out.println(ans);

    }
    static int findEvenDigits(int [] nums){
        int count = 0;

        for (int num: nums){
            if(even(num)){
                count ++;
            }
        }

        return count;
    }
    // this function basically counts if the digit in the numbers are sum upto a even number
    static boolean even(int n){
        int count = 0;
        while(n>0){          // since n is  an integer so it will be zero by diving it with 10 consecutely
            count ++ ;
            n = n/10;
        }
        if (count %2 == 0){
            return true;
        }
        return false;
    }
    static int Digits(int num ){
        if (num<0){
            num = num*-1;
        }
        if (num ==0 ){
            return 1;
        }
        int count = 0;
        while(num > 0){
            count ++;
            num = num/10;

        }
        return count;
    }
//    static int digits2(int num){
//        if (num <0){
//            num = num*-1;
//        }
////        return (int(Math.log10(num))) +1 ;          // log10(num)    ---> 10**x == num  if num == 13 then x = 1.320 int of x =1 we add extra for the total two digit
//    }
    // Finding the number of digits in a number Math.log10(num) NOTE: Math.log(num) have base e

}
