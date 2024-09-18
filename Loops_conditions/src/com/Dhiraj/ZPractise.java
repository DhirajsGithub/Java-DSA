package com.Dhiraj;

public class ZPractise {
    public static void main(String[] args) {
        System.out.println(fiboRecursion(10));
    }
   public static void fiboLoop(int endNum){
        int a = 0;
        int b = 1;
       if(endNum <=0){
           System.out.println(-1);
           return;
       }
        if(endNum <=2){
            System.out.println(endNum);
            return;
        }
       System.out.println(a);
       System.out.println(b);
        for(int i=0; i<endNum-2; i++){
            int c = a+b;
            a = b;
            b = c;
            System.out.println(c);
        }
        return;

   }
   public static int fiboRecursion(int endNum){
       if(endNum <= 1){
           System.out.println(endNum);
           return endNum;

       }
       return fiboRecursion(endNum-1) + fiboRecursion(endNum-2);

   }
}
