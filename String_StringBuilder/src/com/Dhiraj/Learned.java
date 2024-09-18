package com.Dhiraj;

import java.util.Arrays;

public class Learned {
    public static void main(String[] args) {
//        String j ="";
////        char arr[] =new char[4];
//        char[] arr = {'d', 'h', 'r', 'c'};
//        j = String.valueOf(arr);
//        System.out.println(j);


//        String k = "";
//        int[] arr1 = {1, 2, 34, -9};
//        k = String.valueOf(arr1);
//        System.out.println(k.toLowerCase());
//
//        // Convert valid number string to number int/long
//        String s = "10";
//        int ten = Integer.parseInt(s);
//        System.out.println(ten + 1);
//
//        // convert valid single digit number character to number int
//        String ss = "Str1";
//        int p = Character.getNumericValue(ss.charAt(3));
//        System.out.println(p);
//
//        // reverse a string using string builder with constant space complexity
//        StringBuilder i = new StringBuilder();
//        i.append("Let's");
//        for(int j=0; j<i.length()/2; j++){
//            char temp = i.charAt(j);
//            i.insert(j, i.charAt(i.length()-1-j));
//            i.deleteCharAt(j+1);
//            i.insert(i.length()-1-j, temp);
//            i.deleteCharAt(i.length()-1-j);
//        }
//        System.out.println(i.toString());
//
//        int l = 0;
//        for(int m=l; m<4; m++){
//w
//            if(m==2){
//                int kk = 9;
//                if(kk == 9){
//                    break;
//                }
//            }
//            System.out.println("exp");
//        }

        StringBuilder builder = new StringBuilder();
        String name = "alex";
        String typed = "aaleexa";
        int k  = 0;
        for(int i=0; i<name.length(); i++){
            for(int j=k; j<typed.length(); j++){
                if(name.charAt(i) == typed.charAt(j)){
                    builder.append(typed.charAt(j));
                    k = j+1;
                    break;
                }
            }
        }
        System.out.println(builder);


        // replace all method
        String str = "Marge, let's \"[went].\" I await {news} telegram.";
        str = str.replaceAll("[^0-9a-z]*", "");
        // all characters will be replace by "" except for array of [0-9a-z]
        System.out.println(str);



    }
}
