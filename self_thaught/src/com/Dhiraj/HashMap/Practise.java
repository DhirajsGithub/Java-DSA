package com.Dhiraj.HashMap;

import java.util.HashMap;

public class Practise {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
//        System.out.println(NoOfSteps(45, map));
        System.out.println(fibo(4));
    }
    public static int NoOfSteps(int n, HashMap<Integer, Integer> map){
        if(n==1){
            return 1;
        }else if(n==2){
            return 2;
        }
        int ans = NoOfSteps(n-1, map) + NoOfSteps(n-2, map);
        if(map.containsKey(n)){
            System.out.println("present");
            return map.get(n);
        }else{
            System.out.println("value of "+n + " " +ans);
            map.put(n, ans);
        }
        return ans;
    }
    public static int fibo(int n){
        int a = 0;
        int b = 1;
        int c = a+b;
        for (int i = 0; i < n-1; i++) {
            a = b;
            b = c;
            c = a+b;
        }
        return c;
    }
}
