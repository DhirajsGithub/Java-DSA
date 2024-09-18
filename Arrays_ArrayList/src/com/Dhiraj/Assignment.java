package com.Dhiraj;

import java.util.Arrays;

public class Assignment {
    public static void main(String[] args) {
        // 1.) if return type of the function is List<Boolean> then we need to initialised the array as
//        List<Boolean> ans = new ArrayList<>(size of array);

        int [] a = {1,2,3,4,5};
        char [] apl = {'a', 'b','u'};
        System.out.println(apl[0]);

        String s = "Kunal";

        System.out.println(apl[0] > apl[1]);

        char [] req = s.toCharArray();
        for (int c : req){
            System.out.println(c);     // ascii values will be printed
        }
        // or
        System.out.println("characters");
        for(char c : s.toCharArray()){
            System.out.println(c);
        }
        // or
        for(int i=0; i<s.length(); i++){
            System.out.println(req[i]);     // characters will be printed
        }

//        we have pass and continue as well in java


    }
}
