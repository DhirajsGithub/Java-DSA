package com.Dhiraj;

public class ReverseNum {
    public static void main(String[] args) {
        int p = 0;
        int n = 73023808;
        while(n>0){
            int l = n%10;
            n /= 10;
            p = p*10 + l;

        }
        System.out.println(p);      // won't print 0 at starting if n ends with 0 note that

        // the difference of taking p, n as float the loop will go to infinity

//        float p = 0;
//        float n = 73023808;
//        while(n>0){
//            float l = n%10;
//            n /= 10;
//            p = p*10 + l;
//
//        }
//        System.out.println(p);      // won't print 0 at starting if n ends with 0 note that since n is integer
    }

}

