package com.Dhiraj;

public class Typecasting {
    public static void main(String[] args) {

        // Typecasting   ---> compressing the bigger number into smaller number explictly
//        int num = 9989.3434     // error
        int num = (int)(9989.3434);        // imp.
        System.out.println(num);

        // automatic type promotion in expressions
        int a = 257;
//        byte b = a;      //error as byte value is (256)
//        byte b = (byte)(a);             // imp.
//        System.out.println(b);      // output is 1     why caz value of b exceeding value of byte since we converted into byte hence
        // result will be 257%256 = 1  remainder        //imp.

        byte x = 40;
        byte y = 70;
        byte z = 100;

        int m = x*y / z;
        System.out.println(m);       // output = 28
        // byte *  byte must be a byte
        // the result of the intermediate terms of a*b  easily cross the threshold value of byte
        // to handle this problem java automatically promotes each byte to integer when it's evalauting this expression  byte ans22 = x*y;  (cast to byte) wrong
        // NOTE.
        // whenever you performing byte operation java will automaitcally convert it into int        ----(1)
        // i.e. x*y --> int*int

        byte bb = 50;             //  -----(2)
//        bb = bb*2;              //what is happening here since we assign b as byte giving value 50 in next line we are
        //performing task with byte but java had convert byte into integer from (1) now value of b is integer
        // from second value of b is byte hence the error
        bb = (byte)(500) *10;       // no error    // imp. compare with (2)
        bb = (byte)(500*100);     // result will be 50000%256
        System.out.println(bb);

        byte cat = (byte)257;
        System.out.println("cat "+cat);

        int numb = 'A';
        System.out.println(numb);       // will give the ascii value of char A


        byte b = 79;
        int i = 345;
        float f = 59.249f;
        double d = 8402.34;
        int c = 'c';
        short s = 342;
        double result = (f*b) + (i/c) -(d*s);
        System.out.println((f*b) +" "+ (i/c) +" "+(d*s));
        // float + int - double --> double (biggest one)
        System.out.println(result);



        long copyM = 1000000000000l;
        int k = (int)copyM%10;          // first typecasting is perform to copyM then it's modulo is evaluted
        int k2 = (int)(copyM%10);       // fitst modulo is evaluted then it's type is cast
        long l = copyM%10;
        int kk = (int)(l);
        System.out.println(k);
        System.out.println(k2);
        System.out.println(l);
        System.out.println(kk);


        // NOTE the difference
//        int a = 4;
//        int n = 6;
//        long cc = a*n;
//        System.out.println(cc);

//        long a = 4;
//        long n = 6;
//        int cc = (int)(a*n);
//        System.out.println(cc);


        // result of int operation with int will always be int
        // result of byte operation with byte will be int
        int p1 = 89945;
        int p2 = 32127;
        System.out.println("large int operations "+p1*p2);
        long ll = p1*p2;
        System.out.println("large int to long without casting "+ll);
        long ll2 = (long)p1* (long)p2;
        System.out.println("large int to long with casting "+ ll2);


    }
}

/*
Widening Casting (automatically) - converting a smaller type to a larger type size
byte -> short -> char -> int -> long -> float -> double

Narrowing Casting (manually) - converting a larger type to a smaller size type
double -> float -> long -> int -> char -> short -> byte
 */

// joining two or more things : condition- all things must be compatible; i.e. we can add int+int, int+float, flat+double and so on
// but we can't add int+string, or double+string, etc ehich are incompatible
// remember the output of adding compatible will be the bigger of all of them
// assigning variables must be like: destination(eqn ke left side walen) type should be greater than source type(eqn ke right side walen)   // very imp.
// float num = input.nextFloat();  agree
// int num = input.nextFloat();  error

/*
 double cc = input.nextInt();       // goes
 int cc = input.nextDouble();       // not goes
 */

// condition for type conversion
// our input must also match like if input.nextfloat(); then input must be integer of float input can't be double
// input.nextInt(); will take integer only            // imp. compare with the below one
// input.nextDouble(); can take integer, float, double


// Rules for type promotion
// 1. all the bytes, char and short are promoted to integer while performing operations
// 2. if any one of the operants is long quantity the whole operantion will be promoted to long quantity and vice versa for double, float, ...