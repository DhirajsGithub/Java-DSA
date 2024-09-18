package com.Dhiraj;

import java.util.ArrayList;
import java.util.Arrays;

public class Maths {
    public static void main(String[] args) {
        System.out.println(isPrime(79));
        // Q. 1  find prime numbers between 1 and given number
        int n = 98;
        for (int i = 2; i<n; i++){
            System.out.println(i + " is  prime " +isPrime(i));
        }

        // Q.2 optimising the soulution of Q.1 with Sieve Of Eratosthenes
        // if 2 is prime then multiple of 2 are composite similiary if 3 is prime then multiple of 3 are composite
        // checking till sqrt of n and remaing all are prime
        boolean [] primes = new boolean[n+1];      // including n
        SieveOfEratosthenes(n, primes);
        // big(O) n  --> space complexity or auxiliary space complexity
        // time complexit for the n/2 + n/3 + n/4 + ... n/p   p --> highest prime number less than n
        // hence time complexity is big(O) of n+log(log(n))

        // Q.3 Binary Search for root of a number
        int n3 = 40;
        int p = 3;         // precision like 0.1 will be increament in first time then 0.2 then 0.3
        System.out.println("sqrt");
        System.out.printf("%.5f",sqrt(n3, p));
        System.out.println();

        // Q.4 sqrt with Newton Raphson Method
        // sqrt of N  = sqrt of (x + N/x )/2 : x is the closest root of N : error = root - x
        // precision while error < 1/ 0.5 / 0.05 / ..
        System.out.println(NewtonSqrt(40));
        // The time complexity of calculating a root of a function f(x) with n-digit precision is O((\log n) F(n)). F(n) is the cost of calculating f(x)/f'(x)\, with n-digit precision

        // Q. 5 factors
//        System.out.println(optFactors(35));      // cannot resolve method println(void)
        optFactors(36);


    }
    static boolean isPrime(int n){
        if(n<=1){
            return false;
        }
        int c = 2;
        while (c*c <= n){
            if(n%c == 0){
                return false;
            }

            c++;
        }
        return true;
    }
    static void SieveOfEratosthenes(int n, boolean [] primes){
        // updating the multiples of number
        // the concept is that initally all values of boolean array are false let say false ==> prime
        // then updating values which are multiple of number (number from 2 to sqrt n)
        // checking till sqrt of n
        for (int i = 2; i*i <= n; i++){    // i*i < n ==> sqrt n > i
            if(!primes[i]){
                // going through all the multiple upto sqrt n
                for (int j = i*2; j< n; j= i+j){
                    // for i = 2  j = 4, 6, 8, ...
                    // for i = 3 j = 6, 9, 12, 15, ...
                    primes[j] = true;
                }
            }
        }
        // ans
        for (int i=2; i<=n; i++){
            if (! primes[i]){
                System.out.println(i);
            }
        }

    }

    // time big(O) log n
    static double sqrt(int n , int p){
        int s= 0;
        int e = n;
        double root = 0.0;
//        while(s<=e){
//            int m = s + (e-s)/2;
//            if (m*m == n){
//                return m;
//            }
//            if (m*m > n){
//                e = m-1;
//            }else{
//                s = m+1;
//            }
//        }
        double incr = 0.1;
        for (int i=0; i<p; i++){
            while(root*root <= n){
                root += incr;
            }
            root -= incr;
            incr /= 10;
        }
        return root;
    }

    static double NewtonSqrt(double n){
        double x = n;
        double root;
        while(true){
            root = 0.5*(x + (n/x));

            if (Math.abs(root - x) < 1){         // 1 is the precision
                break;
            }
            x = root;
        }
        return  root;


    }
    // factors
    static void factors(int n){
        for (int i=1; i<=n; i++){
            if (n%i == 0){
                System.out.print(i + " ");
            }
        }
    }

    // optamize factor
    static void optFactors(int n ){

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (n/i == i) {
                    System.out.print(i + " ");
                }else {
                    System.out.print(i + " ");
                    list.add(n/i);
                }
            }
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }



    }
}
