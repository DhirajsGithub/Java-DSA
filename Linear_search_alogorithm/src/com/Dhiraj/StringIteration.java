package com.Dhiraj;
import java.util.Arrays;

public class StringIteration {
    public static void main(String[] args) {

        String name = "Kunal";
        char c = 'u';

        System.out.println(Arrays.toString(name.toCharArray()));

//        boolean ans =  search(name, c);
//        System.out.println(ans);

//        boolean ans =  search2(name, c);
//        System.out.println(ans);

    }
//    static boolean search(String str, char target){
//        if(str.length() == 0){                    // .length() is the function here  we use .length with other array data type which is variable basically
//            return false;
//        }
//        for (int i=0; i< str.length(); i++){
//            if (target == str.charAt(i)){
//                return true;
//            }
//        }
//        return false;
//    }
static boolean search2(String str, char target){
    if(str.length() == 0){
        return false;
    }
    for (char ch : str.toCharArray()){
        if (target == ch){
            return true;
        }
    }
    return false;
}
}
