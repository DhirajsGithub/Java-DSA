package com.Dhiraj.BigIntegerDecimal;
import java.math.BigInteger;


class Factorial {

    static BigInteger fact(int num) {
        BigInteger ans = new BigInteger("1");

        for (int i=2; i<= num; i++)   {
            // BigInteger.valueOf(i) --> converts int to BigInteger
            ans = ans.multiply(BigInteger.valueOf(i));
        }

        return ans;
    }
}