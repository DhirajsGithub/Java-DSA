package com.Dhiraj;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Questions {
    public static void main(String[] args) {
        // 1. find if the number is even or odd
        int N = 63;
//        every number is calculated in binary form internally
//        12 + 17  ==        1 1 0 0
//                           0 1 1 1
//                          1 0 0  1  1   (at column 2nd : 1 + 1 = 2 (1 0 as binary so 1 go to the power of 1 at column 1st again at column 1st 1+1 = 2 (1 0 in binary) written as it is

//        63  ---> binary ==   111111   which is  from left to right  2^0*1 + 2^1*1 + 2^2*1+ ...
//        the first step we done 2^0 * (1) defines if the number will gonna odd or even hence if the numbers last bit is 1 then it is odd if it is 0 then it is even
        // the last digit is known as LSB least significant bit
        System.out.println(Integer.toBinaryString(N));
        System.out.println(Integer.toBinaryString(N^1));
        System.out.println(Integer.toBinaryString(N-1));
        System.out.println(isOdd(N));

        // 2. finding the number which is not duplicate in the array;
//        we know a^a (XOR) is 0 and a^0 is a and a^1 is a(complement
        int [] arr = {2,3,3,4,2,6,4};
        System.out.println(isUnique(arr));

        // 3. find ith bit of a number
//        e.g.   1 0 1 1 0 1 1 0  5th bit starting from 1st from left is ?
        // we need to create a MASK for that AND it with the mask
        // NOTE:  mask = 1 << (5-1)  == 1 0 0 0 0  &  1 0 1 1 0 1 1 0     == 1

//        4. set the ith bit
//        e.g   1 0 1 1 0 1 1 0  set the 5th bit :  1 -->1, 0 --> 1
//      NOTE:   create a mask and make OR with the number
        //   1 << 4  ==     0 0 0 1 0 0 0 0  leading zeros uesless
//        1 0 1 1 0 1 1 0  OR   0z 0 0 1 0 0 0 0    ==  1 0 1 1 0 1 1 0


//        Q.
         // 1 0 1 0 1 1 0  & 1 1 0 1 1 1 1
        // how to get 1 1 0 1 1 1 1  --> 0 0 1 0 0 0 0 (compl)
        // how to get 0 0 1 0 0 0 0  --> 1 << 4
        // NOTE:  we can reset the ith bit my taking AND of it : reset means  1 --> 0, 0 --> 0


        // Q. 5 every element in the array is appearing three times (i.e. odd time) but one element is appearing one time only find that number
        int [] arr5 = {2,2,3,2,7,7,8,7,8,8};
        // every element is appearing 3 times hence it's bit also appearing 3 times hence except for that non repeating number sum of bit's of all the numbers to % 3 is 0
        // hence sum of all elements binary add and module of that is the req number
        // 2=   0 0 0 0 0 0 0 1 0  *3
        // 3 =  0 0 0 0 0 0 0 1 1   *1
        // 7 =  0 0 0 0 0 0 1 1 1   *3
        // 8 =  0 0 0 0 0 1 0 0 0    *3
        //  =   0 0 0 0 0 3 3 7 4      --> %3   we have 0 0 0 0 0 0 1 1 --> 3

        // NOTE: if every number is appearing odd time do multiply it all the number with n add them then take modulo with n
        // if every number is appearing even time except one then use xor operator on all the number return the xor result

        // Q.6 find nth Magic number        --> 2nd magic number 2 in binar = 10 --> 5^2*1 + 5^1*0  = 25 (nth magic number)
        int n = 6;
        System.out.println("magic number "+magicNumber(n));

//        Q.6 Find the position of the right most set bit of the number
//       NOTE:  n & (n-1) is the right most set bit

        //Q.7 no of digits in base b system
        int num = 34567;
        int base = 10;
        System.out.println(noOfDigits(num, base));

        //Q.8 sum of the digits in nth row of pascal triangle is combination of that row
        // NOTE:  i.e. 2^(n-1)  which is  1 << (n-1)


        //Q.9 Find out if the number is power of 2 or not
//        power of 2 numbers are like   10000....
//        10000(n) --> 1111 + 1  --> (n-1) + 1
//       NOTE:     if  n & (n-1)  == 0  --> power of 2

        // Q.10 calculate a^b (a power b) with time complexity of log(n)
        int base1 = 3;
        int power = 4;
        System.out.println(calPower(base1, power));

        // given number find the number of set bits(1's) in it
//        n & (n-1) == 0001
//         n - [n & (n-1)]   ==  binary + last(digit of n) -1
        System.out.println("set bits "+setBits(8));

        System.out.println(Integer.toBinaryString(898));

        // Q.11 Find XOR of number from 0 to a
        // 0 ^ 0 == 0
        // 1 ^ 0 == 0
        // 2 ^ 1 ^ 0  == 3   deal with binary as  1 0 ^ 0 1 ^ 0 0  == 1 1  which is 3 in decimal
        // 3 ^ 2 ^ 1 ^ 0  == 0    i..e     1 1 ^ 1 0 ^ 0 1 ^ 0 0  == 1 1 ^ 1 1 == 0
        // 4 ^3 ^ 2 ^ 1 ^ 0  == 4 ^ 0 == 4
        // 5 ^4 ^ 3 ^ 2 ^ 1 ^ 0  == 5 ^ 4  == 0 1 0 1 ^ 0 1 0 0  == 0 0 0 1 ==1
        // 6 ^ 5 .. ==  7
        // 7 ^ 6..   == 0
        // 8 ^ 7 .. == 8
        // 9 ^ 8 ..  == 1
//        the pattern

//        if a % 4 = 0 then 0 to a xor is a
//        if a % 4 = 1 then 0 to a xor is 1
//        if a % 4 = 2 then 0 to a xor is a + 1
//        if a % 4 = 3 then 0 to a xor is 0


        // Q.12
        // xor of numbers between a and b
        // we know 4 ^ 4 = 0
        // we know  xor of 0 to b and also xor of 0 to a using above Q.11 hence we can do
        // f(b) = xor 0 to b ,  f(a-1) = xor 0 to a-1
        // hence ans = f(b) xor f(a-1)      // since f(b) is in f(a-1) hence it's f(b) xor f(b) = 0, since  operator follow associativity
        int a = 3;
        int b = 9;
//        range xor for a, b = xor(b) ^ xor(a-1)
        int ans = calXor(b) ^ calXor(a-1);

        System.out.println(reverseBits(43261596));
        System.out.println(Integer.bitCount(3));        // 5 in binar is 101

        // NOTE: to flip a bit use xor operator

        System.out.println("even odd "+ (12&(-12)));

    }

    static boolean isOdd(int n){
        // N = 63 = 111111
        // N^1 = 111110    same as 111111 ^ 000001
        // N-1 = 111110    if N is odd then N-1 is even hence lsb is 0 also 1 xor with N lsb is 0 coz N is odd
        // how to get the last digit,  1 AND n == 1(true)(if last digit is 1 of N)
//        return (n & 1) == 1;          // NOTE
//          return (n ^ 1) == 0;        // wrong
        // or
         return (n^1) == n-1;  // it is odd NOTE

    }
    static int isUnique(int [] arr){
        int unique = 0;

        // IMP : all the operators follow associative rule i.e. 2^3^3^4^2^6^4  = 2^2^3^3^4^4^6 = ....
        System.out.println(Arrays.toString(arr));
        for (int n : arr){
            unique = unique ^ n;
            System.out.println("unique is "+unique);
        }
        return unique;
    }
    //    Q7 Find the position of the right most set bit of the number
    static int rightMostSetBit(int number){
        int iteration = 0;

//        before running the while loop, checking of the LSB is 1 by default i.e. the number passed
        if ((number & 1)==1){
            return 1;
        }

        while ((number & 1) != 1){
            number = number >> 1;
            iteration++;
        }
        return iteration+1;
    }

    static int magicNumber(int n){
        int ans = 0;
        int base = 5;
        while(n>0){
            int last = n & 1;
            n = n >> 1;
            ans += last * base;
            base = base*5;
        }
        return  ans;
    }
    static int noOfDigits(int num, int base ){
        // approach is take a log of num to the base b integer and add 1 to it
        int ans = (int)(Math.log(num) / Math.log(base)) + 1;
        return  ans;

    }

    static int calPower(int base, int power){
        int ans = 1;
        while (power > 0){
            if ((power & 1) == 1 ){
                ans *= base;
            }
            base = base * base;
            power = power >> 1;
        }
        return ans;
    }

    static int setBits (int n){
        int count = 0;
        while(n > 0){
            n = n - (n & (-n));     // every time we are substracting the rightmost bit
            count ++;
            // or
//            n -= n & (n-1);     // every time we are substracting the rightmost bit
//            count ++;

        }
        return count;
    }

    static int calXor(int a){
        if (a%4 == 0){
            return a;
        }
        if (a%4 == 1){
            return 1;
        }
        if (a%4 == 2){
            return 1+a;
        }
//        if (a%4 == 3){
//            return 0;
//        }
        return 0;
    }

    static int reverseBits(int n){
        int result = 0;
        for (int i = 0; i < 32; i++) {
//            11111111111111111111111111111101
            int lsb = n&1;    //  least significant bit or right most big i.e. 1
            int reverseLsb = lsb << (31-i);     // shifting lsb to left, now reverseLsb = 10000000000000000000000000000000
            result = result | reverseLsb;        // or opertaion with result itself and reverseLsb
            n = n>>1;       // decreasing n
        }
        System.out.println(Integer.toBinaryString(result));
        return result;


//        StringBuilder builder = new StringBuilder();
//        boolean isNegative = false;
//        if(n<0){
//            isNegative = true;
//            n = n*-1;
//        }
//        while(n>0){
//            builder.append(n%2);
//            n = n/2;
//        }
//        System.out.println(builder);
//        while (builder.length()<32){
//            if(isNegative){
//                builder.insert(builder.length(), 1);
//            }else{
//                builder.insert(builder.length(), 0);
//            }
//
//        }
//        int ans = 0;
//        builder = builder.reverse();
//        String temp = "10111111111111111111111111111111";
//        for (int i = 0; i < temp.length(); i++) {
//            ans+= ((int)Math.pow(2, i))*Integer.parseInt(temp.charAt(i)+"");
//            System.out.println(ans);
//        }
//        System.out.println(builder);
//
//        return ans;

    }

    public static List<String> readBinaryWatch(int turnedOn){
        List<String> li = new ArrayList<String>();
        for (int i = 0; i < 12; i++) {      // hours
            for (int j = 0; j < 60; j++) {      // minutes
                if(Integer.bitCount(i) + Integer.bitCount(j) == turnedOn){      // hours and minutes led are 2's complement and 2's complement have only one bitcount
                    if(j<10){
                        li.add(i+":0"+j);          //  01:00 not valid, 1:00  valid,
                    }else{                          // 10:2 not valid, 10:20 valid
                        li.add(i+":"+j);
                    }
                }
            }
        }
        return li;
    }





}
