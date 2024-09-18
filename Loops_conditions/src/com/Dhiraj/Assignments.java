package com.Dhiraj;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;
public class Assignments {
    // Take integer inputs till the user enters 0 and print the sum of all numbers
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        boolean b = true;
//        int sum = 0;
//
//        while (b){
//            int n = in.nextInt();
//            if (n == 0){
//                b = false;
//            }
//            sum += n;
//
//        }
//        System.out.println(sum);

        //    Take integer inputs till the user enters 0 and print the largest number from all
//        boolean b = true;
//        int sum = 0;
//        int max = Integer.MIN_VALUE;
//        System.out.println(max);
//
//        while (b){
//            int n = in.nextInt();
//            if (n == 0){
//                b = false;
//            }
//            if (n>max){
//                max = n;
//            }
//
//
//        }
//        System.out.println(max);

//        Reverse A String In Java
//        String a = "kunal";
//        String ra = "";
//        for (int i=a.length()-1; i>=0; i--){
//           ra += a.charAt(i);
//
//        }
//        System.out.println(ra);

//        Find if a number is palindrome or not
//        int n = in.nextInt();
//        int k = n;               // to get the reference if we equate n to p then the ans will always be not a palindrome number coz n will be updated to 0 at the end of the while loop
//        int p = 0;
//        while (n>0){
//            int r = n%10;
//            p = p*10 + r;
//            n = n/10;
//
//        }
//        System.out.println(p);
//        System.out.println(k);
//        if (p == k){
//            System.out.println("palindrome number");
//        }else{
//            System.out.println("not plaindrome");
//        }

        // hcf and lcf
//        lcm = num1*num2/hcf
//          hcf = num1%num2        // provide num1>num2

//        // vowels and consonant
//        String v = "aeiouAEIOU";
////        String V = "";
//        char c = in.next().trim().charAt(0);
////        char d = in.next().trim().charAt(0);
////        char k = d.toLowerCase();
//
//        boolean isVowel = false;
//        for (char cha : v.toCharArray()){
//            if (cha == c){
//                System.out.println("Vowel");
//                isVowel = true;
//            }
//        }
//        if (!isVowel){
//            System.out.println("Constantnt");
//        }

        // perfect number in java
//        A number whose sum of factors (excluding the number itself) is equal to the number is called a perfect number.
        int n = 496;
        int temp = n;
        int sum = 0;


        for (int i=2; i<Math.sqrt(n); i++){
            if (n%i == 0){
                System.out.println(i);
                System.out.println(n/i);
                sum += i;
                sum += n/i;
            }else if (n% Math.sqrt(n) ==0){
                sum += Math.sqrt(n);
                System.out.println(Math.sqrt(n));
            }

        }

        sum ++; // can't foreget to add 1 as divisor NOTE: we didn't inlcuded n as divisor though

        System.out.println(sum);             // not to include 36 only perfect divisor are needed to check if number is perfect or not
        if (sum == n){
            System.out.println("perfect number");
        }else {
            System.out.println("not perfect number");
        }


    }
}
