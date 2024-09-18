package com.Dhiraj;

public class SubsetSubsequenceString {
    public static void main(String[] args) {
        String s = "aabscda d";
        System.out.println(skipA(s, "", 0));
        skikA2(s, "");
        System.out.println(skipA3(s));
        System.out.println(skipApple("bsfsdfsapplekfjskd"));
        System.out.println(skipAppNotApple("skdjappfklsaj"));
        System.out.println(skipAppNotApple("fsjkapplejksaj"));
    }
    static String skipA(String s, String ans, int start){
        if(start == s.length()){
            return ans;
        }
        if(s.charAt(start) != 'a'){
            ans += s.charAt(start);
        }

        return skipA(s, ans, start+1);

    }

    // taking ans string in the argument
    static void skikA2(String s, String ans){
        if(s.isEmpty()){
            System.out.println(ans);
            return;
        }
        char ch = s.charAt(0);
        if(ch == 'a'){
            skikA2(s.substring(1), ans);
        }else{
            skikA2(s.substring(1), ans + ch);
        }
    }

    // taking ans string in the body of the funciton call
    static String skipA3 (String s){
        if(s.isEmpty()){
            return "";
        }
        char ch = s.charAt(0);
        if(ch == 'a'){
            return skipA3(s.substring(1));
        }else{
            return ch + skipA3(s.substring(1));
        }
    }

    // taking ans string in the body of the function call
    static String skipApple(String s){
        if(s.isEmpty()){
            return "";
        }
        if(s.startsWith("apple")){
            return skipApple(s.substring(5));
        }else{
            return s.charAt(0) + skipApple(s.substring(1));
        }
    }

    static String skipAppNotApple(String s){
        if(s.isEmpty()){
            return "";
        }
        if(s.startsWith("app") && !s.startsWith("apple")){
            return skipAppNotApple(s.substring(3));
        }else{
            return s.charAt(0) + skipAppNotApple(s.substring(1));
        }
    }
}
