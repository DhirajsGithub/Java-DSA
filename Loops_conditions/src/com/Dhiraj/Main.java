package com.Dhiraj;

public class Main {
    public static void main(String[] args) {
        String a = "kunal";
        String b = "kunal";
        String c = a;
        System.out.println(a==b);
        System.out.println(a.equals(b));
        System.out.println(c==a);
        System.out.println(b==c);
//        int [] a = {1, 2, 3};
//        int [] b = {1, 2, 3};
//        System.out.println(a.equals(b));
//        System.out.println(a==b);

//        == should be used during reference comparison. == checks if both references points to same location or not.
//        equals() method should be used for content comparison.
//        equals() method evaluates the content to check the equality

    }
}
