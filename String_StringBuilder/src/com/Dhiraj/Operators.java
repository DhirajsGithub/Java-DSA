package com.Dhiraj;

import java.util.ArrayList;

public class Operators {
    public static void main(String[] args) {
        System.out.println('a' + 'b');      // adding the ascii values
        System.out.println("a" + "b");     // adding two of the string  // a and b in heap get's add up to ab and after that since no reference  variable they will be garbage collected
        System.out.println('a' + 3);        // 97 + 3
        System.out.println((char)('a' + 3));     // char at ascii value 100, d

        System.out.println("a" + 1);
        // this is same after few steps as:  "a" + "1"
        // integer will be converted to Integer that will call .toString()

        System.out.println("Kunal" + new ArrayList<>());
        System.out.println("kunal" + new Integer(56));

//        System.out.println(new Integer(56) + new ArrayList< >());
//        // the operator + in java is define for primitives and any one of the value is string
        // we can use + with complex data types as well provided atleast one of this object should be of type string

        String ans = new Integer(56) +"" + new ArrayList<>();
        System.out.println(ans);


    }
}
