package com.Dhiraj;
import java.util.Scanner;

public class Questions {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        boolean ans = isPrime(n);
//        System.out.println(ans);

        int num = in.nextInt();
        boolean ans2 = isArmstrongNumber(num);
        System.out.println(ans2);
        // print all three digits armstrong number
        for (int i=100; i<1000; i++){
            if (isArmstrongNumber(i)){
                System.out.println(i);
            }
        }

        int n = 121;
        System.out.println(isPalindrome(n));

        System.out.println("is prime");
        System.out.println(isPrime(17));

    }

    static boolean isPrime(int n) {
        if (n<=1){
            return false;
        }
        int c = 2;
        while(c*c < n){
            if (n%c == 0){
                return false;
            }
            c ++;

        }
        return c*c > n  ;
    }

//    a narcissistic number in a given number base b is a number that is the sum of its own digits each raised to the power of the number of digits
    static boolean isArmstrongNumber(int num){
        int add = 0;
        while (num % 10 >0){             /// NOTE: num%10 > 0 stricktly karna jaruri hain
            int lastDigit = num%10;
            add += lastDigit*lastDigit*lastDigit;       // adding is commutative
            num = num/10;                      // think like after every division num tends to <1 but num will always >0

        }
       return num == add;
    }

    static boolean isPalindrome (int num){
        int revNum = 0;
        int r = 0;
        while(num > 0){
            r = num%10;           // taking the last digit
            revNum = revNum*10 + r;
            num = num/10;         // eliminating the last digit
        }

        return revNum == num;
    }
}
