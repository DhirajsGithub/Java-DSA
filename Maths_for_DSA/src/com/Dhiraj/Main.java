package com.Dhiraj;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int num1 = 4 >> 2;          // right shift
        System.out.println(Integer.toBinaryString(4));          // 100
        System.out.println(Integer.toBinaryString(4>>2));       // 1
        int num2 = 3 << 2;          // left shift       1 1 < 2 --> 1100
        System.out.println(num2);
        int ans = num1 + num2;
        System.out.println(Integer.toHexString(ans));

        System.out.println(5^1^6);

        System.out.println("isArmstrong" + isArmstrong(153, 0));
        System.out.println(8^1);

        System.out.println("4&5 "+(4&5));       // 100 & 101  --> 100 or 4
        System.out.println("~ complment of 5: "+(~5));       // 101 -->

    }
    static int isArmstrong(int n, int ans){
        if(n < 1 ){
            System.out.println(n);
            return ans;
        }
        ans = ans + (int)(Math.pow((n%10), 3));     // 3 is total number of digits
        return isArmstrong(n/10, ans);

    }

    // 0000 0000 0000 0000 0000 0000 0000 0101  --> 1111 1111 1111 1111 1111 1111 1111 1010
}

//
//Maths for DSA
//
//        Bit-Manipulation
//        - [ ] Operators:
//
//        1. AND —> if both the quantities are true then the result will be true otherwise it is false. NOTE: when you make AND of any number with 1 the result is the number itself!
//        2. OR   —> if any one of the quantity is true the result will be true, if both quantities are false the result will be false
//        3. XOR (^)  —> if and only if / exclusive OR.   If atmost one of the quantity is true then the result is true, in case both quantities are false or true the result is false. a being true or false we have
//        OBSERVSTION:  a ^ 0(or false) == a,    a ^ a  == 0
//        4. Complement (N).  a  = 10110  a(complement)  == 01001
//         the bitwise operators also follows the associativity property
//
//
//        - [ ] Number System:
//
//        1. Decimal (base 10)  —>  0, 1, 2, …, 9. (Numbers being only made by this  ten digits)
//        2. Binary (base 2)  —> 0 and 1   (Number being only made using 1’s and 0’s)
//        3. Octal  (base 8)  —> 0, 1, 2, …, 7 (Numbers being made only using this eight digits)
//        4. Hexadecimal (base 16)  —> 0, 1, 2, 3, …, 9, A, B, … ,F  (Numbers being made only using this tex digits and six characters)
//        - Which means 0 and 1 in all systems being 0 and 1.
//        - 9 in decimal being 11 in octal and being 9 in decimal and 1001 in binary
//
//        Conversations:
//        1. Decimal to base : keep dividing by base, take remainders, write in opposite
//        - e.g. 9 in binary  9/2 quotient is 4 and remainder r1 is 1 —> 4/2 quotient is 2 and remainder r2 is 0 —> 2/2 quotient  is 1 and remained r3 is 0 —> 1/2 quotient is 0 and remainder  r4 is 1. Reverse all remaineder we have r4 r3 r2 r1 == 1 0 0 1  (ans)
//        - 9 in octal: 9/8 quotient is 1 and remainder r1 is 1 —> 1/8 quotient is 0 and remainder r2 is 1. Reverse all remainder we have r2 r1 == 11  (ans)
//        - 9 in hexadecimal : 9/16 quotient is 0 and remainder r1 is 9. Revers the remainders we have r1 = 9 (ans)
//        2. Convert any base b to decimal:  Multiply and add the power of base with digits
//        - 1 1 0 1 in decimal:  from right to left 2^0*1 + 2^1*0 + 2^2*1 + 2^3*1
//        - (21) base 8 to decimal:  8^0*1 + 8^1*2  ==  17
//        - 23A to decimal (2 × 16²) + (3 × 16¹) + (10 × 16⁰) = (570)₁₀
//
//        - [ ] Operators:
//        1. Left shift operator ( << ): shift the binary towards left by m means add m 0’s to the right as 1010 ( << by 2) —> 101000.
//        NOTE: convert to decimal and compare  a << 1 == 2*a. General point a << b == a * 2^b
//        2. Right shift operator ( >> ): Shift he binary to right by m means remove m bit’s from right as 0011001 >> 1  —> 0001100 same as 1100.
//        General point  a >> b  == a / 2^b

//        NOTE: leading zeros are ignore in any number systems

//  Negative Binary numbers:
// 1 byte = 8 bits
// 10  = 0 0 0 0 1 0 1 0
// -10  = ?      8th bit of any binary is a reserved bit for negatives if 8th bit from left to right is 1 ==> -ve and if 0 ==> +ve number
// Steps to find the -ve of number in binary :
// step 1 cal the complement of number
// step 2 add 1 to that complement like a binary addition
// 10          ===   0 0 0 0 1 0 1 0
// 10(comp)    ===   1 1 1 1 0 1 0 1
// add 1 (OR)       ===   0 0 0 0 0 0 0 1
// result     ===    1 1 1 1 0 1 1 0  == - 10   == 2's complement

// how the steps ? why 2's complement is -ve of number ?
// 0 - any natural number == -ve
// if there is only 1 in binary number and all the succedding bits are 0's this means the number is of form of power of 2
// e.g. 8 is 1000  == 7 +1  == 111 + 1
// any we have byet greater than 8 bits then 9th and 10th and ... from left will be ignore/ discarded
// 10   =   0 0 0 0 1 0 1 0
//  0    =  0 0 0 0 0 0 0 0
// 0 -10  = -10  =   1 0 0 0 0 0 0 0 0  - 0 0 0 0 1 0 1 0   (since 0 is 0 0 0 0 0 0 0 0 but written as  1 0 0 0 0 0 0 0 0 coz the 9th bit(1) will be discarded
//  1 0 0 0 0 0 0 0 0    ==  1 1 1 1 1 1 1 1 1  + 1
// so we have   1 1 1 1 1 1 1 1 1  + 1  -  0 0 0 0 1 0 1 0
//   1 1 1 1 1 1 1 1 1  -  0 0 0 0 1 0 1 0  + 1   =  1 1 1 1 0 1 0 1   + 1    = 10(comp) + 1

// Range of Numbers  we know  1 bit = |0,1|(first box decide the sign)|0,1||0,1||0,1||0,1||0,1||0,1||0,1|
// -0 = 0 = +ve  so we total have 255 numbers in 1 byte  ==> (-128 to 127)  ==  1 byte

// range formula for n bits
// -2^(n-1)  to  2^(n-1) -1


//
//   Here is an example of such conversion using the fraction 0.375.
//  0.375 * 2 = 0 + 0.75
//  0.75 * 2 = 1 + 0.5
//  o.5 * 2 =  1 + 0
//  Now, let’s just write out the resulting integer part at each step == 0.011. So, 0.375 in decimal system is represented as 0.011 in binary.
//  0.0011 binary to decimal = 0.0*(2^-1)+ 0*(2^-2)+ 1*(2^-3) + 1*(2^-4) = 3/16 = 0.1875
// 7.25 = 7 + 0.25 = 111 + (0.25)2 = 111 + 0.01 = 111.01
// 0.25 * 2 = 0 + 0.5
// 0.5 * 2 = 1 + 0

//       (1000.101)2
//        1    0    0     0   .   1   0    1
//        = (1 x 2^3 + 0 x 2^2 + 0 x 2^1 + 0 x 2^0) . (1 x 2^-1 + 0 x 2^-2 + 1 x 2^-3)
//        = (8 + 0 + 0) . (0.5 + 0 + 0.125)
//        = (8.625)10


/*

|0||0||1||1||0||0||0||1|    --> in 1 byte system the leftmost or the 8th bit from right is the most significant bit and the rightmost or the first bit from right is the least significant bit

signed vs unsigned bits:
in signed bit you have the most significant bit or (msb) reserved for sign whereas there is no reservation for sign in unisigned bit
aka signed --> positive, negative  and   unsigned --> positive

*/













