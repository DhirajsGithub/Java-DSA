package com.Dhiraj;

public class Maths2 {
    public static void main(String[] args) {

        // GCD/HCF
        // GCD
        System.out.println(gcd(99, 33));
        System.out.println(gcdLoop(99, 33));
        System.out.println(lcm(7, 35));
        int p = 11/10;
        System.out.println(p);

        System.out.println((int)Math.pow(3, 6));        // a is 3 and p is 7
        System.out.println((int)Math.pow(3, 6)%7);
        System.out.println(3%7);

    }
    static int gcd(int a, int b){
        if(a == 0){
            return b;
        }
        return (gcd(b%a, a));
    }

    static int gcdLoop(int a, int b){
        // eculid's gcd(a, b) = gcd(rem(b, a), b)

        int a1 = a;
        int b1 = b;
        // a1 > b1 let
        while (a1 !=0){
            int temp = b1;
            b1 = a1;
            a1 = temp%a1;
        }
        return b1;

    }

    static int lcm(int a, int b){
        return (a*b)/gcd(a, b);
    }

}


// Modulo Properties
// (a + b) % m  = ((a % m ) + (b % m) ) % m
// (a - b) % m  = ((a % m ) - (b % m) ) % m
// (a * b) % m  = ((a % m ) * (b % m) ) % m
// (a / b) % m  = ((a % m ) * (b^-1 % m) ) % m

// b^-1  --> multiplicative modulo inverse (mmi)  b^-1 % m means that b and m are co primes (nothing is common except for 1 factor)
// ( 6 * y ) % 7 = 1
// y = multiplicative modulo of 6 and y = 6
// ( a % m) % m  = a % m
// m ^ x % m = 0   for all x belong to +ve integers
// (m*n) % m = 0

// if "p" is a prime number and "a" is an integer not divisible by "p,", then a^(p-1) ≡ 1 (mod p)
// due to fermit's little theorem

// HCF of a and b is the min positve value of eqn ax + by  where x and y are integers
// ax + by = c remove common factor/ hcf of a and b divide it to c if c/hcf(a&b) = integer then   we can form c units of water with a and b amout of water
// ax + by = c   c/hcf(a&b)  and  c/hcf(a&b) is not an integer then we can't make c litre of water with a litre and b litre of water

// Euclid's Algorithm
// gcd(a, b)  =  gcd (rem(b, a), a)


// 12 = 2 × 2 × 3 and 28 = 2 × 2 × 7.
// The GCD is 2 × 2 = 4.
// The LCM is 2 × 2 × 3 × 7 = 84.

// LCM of a, b = is the number which is divided by both a and b
// let d = gcd(a, b)
// f = a/d  g = b/d        since d = hcf hance f and g have no common factors rather than 1
//  a = fd   and   b = gd
// lcm (a, b)  = c = lcm (fd, gd)  = f*g*d
//   a * b  = (f*d*g)*d  = lcm * gcd
