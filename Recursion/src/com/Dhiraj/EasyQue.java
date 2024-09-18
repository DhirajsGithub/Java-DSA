package com.Dhiraj;

public class EasyQue {
    public static void main(String[] args) {
//        Nto1(5);
//        a1toN(5);
        funBoth(5);
        // space complexity big O (N)

        fun2(5);

        reverse(5467);
        System.out.println(sum);

//        System.out.println(noOfZeroes(30100009, 0));
        // with the help of helper funciton
        System.out.println(noOfZeroes(8004300));

    }
    static void fun(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        fun(n-1);
    }

    static void funRev(int n) {
        if (n == 0) {
            return;
        }
        funRev(n-1);
        System.out.println(n);
    }

    static void funBoth(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        funBoth(n-1);
        System.out.println(n);
    }

    static int factorial(int n){
        if(n <=1){
            return 1;
        }
//        n*factorial(n-1);
        return n* factorial(n-1);    // since return type is int hence we need to return something which is int as well
    }
    static int sum(int n){
        if(n==0){
            return 0;
        }
       return  sum(n/10) + n%10;
//        return  sum(n/10) * n%10;  // if(n%10 == n) return n;
    }
    static void fun2(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
//        fun2(n--);   // stack over flow
        fun2(--n);
    }

    static int sum = 0;
    static void reverse(int n){
        if( n == 0){
            return;
        }
        int rem = n%10;
        sum = sum *10 + rem;
        reverse(n/10);

    }

    static int reverse2(int n ){
        // when we need additional variables in the arguments make another helper function
        int digits = (int)Math.log(n) + 1;      // for base 10 number system
        return helper(n, digits);
    }
    private static int helper(int n, int digits){
        // single digit number
        if(n%10 == n){
            return n;
        }
        int rem = n%10;
        // 1234  for 4 to be at first pofition we will be doing like 4 * 10^2 + 123
        return rem* (int)(Math.pow(10, digits-1)) + helper(n/10, digits - 1);

    }
    static boolean palindrome(int n ){
//        return n == reverse(n);    // reverse returns void hence can't be applied to it
        return  n == reverse2(n);
    }

//    static int noOfZeroes(int n , int count){
//        // note count must be zero when calling noOfZeroes for the first time in main funciton
//        if(n == 0){
//            return count;
//        }
//        if (n%10 == 0){
//            return noOfZeroes(n/10, count+1);
//        }else{
//           return noOfZeroes(n/10, count);
//        }
//    }
    // Or we can make a helper function
    static int noOfZeroes(int n){
        return helper2(n, 0);
    }

    // special patter how to pass a value to above calls
    private static int helper2(int n, int i) {
        if(n == 0){
            return i;
        }
        int rem = n%10;
        if (rem == 0){
            return helper2(n/10, i+1);
        }else{
           return helper2(n/10, i);
        }
    }


}


/*

n-- vs --n
n-- will pass the value of n first then substract 1 afterward   (will execute with n first then it will decrement n)
--n will substract 1 from n first then pass the substracted value   (will decrement n first then it will execute)



* */