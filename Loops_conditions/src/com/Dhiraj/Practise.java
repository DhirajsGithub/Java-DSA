package com.Dhiraj;

public class Practise {
    public static void main(String[] args) {

                String v = "aeiouAEIOU";
//        String V = "";
//        char c = in.next().trim().charAt(0);
        char c = 'k';
//        char d = in.next().trim().charAt(0);
//        char k = d.toLowerCase();

        boolean isVowel = false;
        for (char cha : v.toCharArray()){
            if (cha == c){
                System.out.println("Vowel");
                isVowel = true;
            }
        }
        if (!isVowel){
            System.out.println("Constantnt");
        }

//        int num = 4;
//        switch (num){
//            case 2:
//                System.out.println("two");
//            case 3:
//                System.out.println("three");
//            default:
//                System.out.println("default");
//            case 5:
//                System.out.println("five");
//                break;
//        }
    }
}
