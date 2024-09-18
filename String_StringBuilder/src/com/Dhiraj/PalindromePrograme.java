package com.Dhiraj;

import java.util.Locale;

public class PalindromePrograme {
    public static void main(String[] args) {

        String str = "abcdcba";
        System.out.println(isPalindrome(str));
        char [] p = str.toCharArray();
        System.out.println("a" + 'a');


    }
    static boolean isPalindrome(String s){
        if( s == null || s.length() == 0  ){      // why we take null first coz if s is null then length property can't be apply
            return true;
        }
        s = s.toLowerCase();
        for (int i=0; i<s.length()/2; i++){               // time complexity is O(N)
            char start = s.charAt(i);
            char end = s.charAt(s.length()-1-i);
            if(start != end){
                return false;
            }
        }
        return true;
    }
}
