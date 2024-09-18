package com.Dhiraj;

public class math {
    public static void main(String[] args) {
        // The Java Math class has many methods that allows you to perform mathematical tasks on numbers.

        // max/min methods
        System.out.println(Math.max(89, 90));
        System.out.println(Math.min(-89, 223));

        // sqrt method
        System.out.println(Math.sqrt(34));    // double // 5.830951894845301

        // absoulte
        System.out.println(Math.abs(-3));
        System.out.println(Math.abs(-8.9));

        // random
        System.out.println(Math.random());
//        int randomNo = (int)Math.random()*100;   // always give zero   // coz Math.random() gives number b/w 0 to less than 1 and (int) will convert them to 0 and 0*100 is 0
        int randomNo = (int)(Math.random()*100);
        System.out.println(randomNo);


    }
}
