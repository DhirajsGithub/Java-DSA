package com.Dhiraj.Questions;

import java.util.Arrays;

public class Questions {
    public static void main(String[] args) {
        /*
        Input : A = {1, 2, 3, 4, 5}
Output : [48]
         [20, 28]
         [8, 12, 16]
         [3, 5, 7, 9]
         [1, 2, 3, 4, 5]

Explanation :
Here,   [48]
        [20, 28] -->(20 + 28 = 48)
        [8, 12, 16] -->(8 + 12 = 20, 12 + 16 = 28)
        [3, 5, 7, 9] -->(3 + 5 = 8, 5 + 7 = 12, 7 + 9 = 16)
        [1, 2, 3, 4, 5] -->(1 + 2 = 3, 2 + 3 = 5, 3 + 4 = 7, 4 + 5 = 9)
         */
        int [] A = {1, 2, 3, 4, 5};
//        Sumtrianglefromarray(A, A.length);


//        System.out.println(maxMinInArray(A, 0, A[2]));

//        System.out.println(firstUpperCase("geeksforgees", 0));

        int arr[] = {3, -9, 2, 90, 9, 1, -33};
//        System.out.println(Arrays.toString(arr));
//        recursiveInsertion(arr, 0, 1);
        bubbleSort(arr, 0, 1);
        System.out.println(Arrays.toString(arr));

        // product of two numbers
//        System.out.println(productOfTwoNums(0, 5));

        // sieve of erathonesis
//        boolean [] primes = new boolean[21];
//        seiveOfErathonesis(primes, 20, 2, 2);
//        System.out.println(Arrays.toString(primes));
//        for(int i=0; i< primes.length; i++){
//            if(!primes[i]){
//                System.out.print(i+ " ");
//            }
//        }

        String exp = "[()](({}" ;
        System.out.println(balanceParanthesis(exp, 0, 0, 0));

//        powerSet("", "aba");


//        possiblePalindromicPartitio("","nitin");

//        System.out.println(removeConsecDuplicat("", "aaaaabbbbbb"));

    }

    private static void bubbleSort(int[] arr, int i, int j) {
        if(i==arr.length){
            return;
        }

        if(j< arr.length-i){
            if(arr[j] < arr[j-1]){
                swap(arr, j-1, j);
            }
            bubbleSort(arr, i, j+1);
        }else{
            bubbleSort(arr, i+1, 1);
        }




    }
    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    private static int maxMinInArray(int[] a, int l, int max) {
        if(l == a.length){
            return max;
        }
        if(a[l] > max){
            max = a[l];
        }
        return maxMinInArray(a, l+1, max);

    }

    static void Sumtrianglefromarray(int arr[], int i){

        int arr2 [] = new int[i-1];
        for(int j=0; j<i-1; j++){
            arr2[j] = arr[j]+arr[j+1];
        }
        if(i==1){
            return;
        }

        Sumtrianglefromarray(arr2, i-1);
        System.out.println(Arrays.toString(arr2));
    }

    static char firstUpperCase(String s, int i){
        if(i == s.length()){
            return 0;
        }
        if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
            return s.charAt(i);
        }
        return firstUpperCase(s, i+1);
    }

    static int productOfTwoNums(int x, int y){
        // assuming x and y are positive
        // 3*4 ==> 4+4+4
        if(x==1){
            return y;
        }
        if(x ==0){
            return 0;
        }

        int ans =  y + productOfTwoNums(x-1, y) ;
        return ans;
    }

    static void seiveOfErathonesis(boolean prime [], int n, int i, int j){
        // i = 2 initially,  j = 0
        if(i*i>n){
            return;
        }
        if(i*j <= n){
            prime[i*j] = true;
            seiveOfErathonesis(prime, n, i, j+1);
        }else{
            seiveOfErathonesis(prime, n, i+1, 0);
        }
    }

    static void recursiveInsertion(int [] arr, int i, int j){
        if(i == arr.length){
            return;
        }
        if(j>0){
            if (arr[j-1] > arr[j]) {          // same as if (arr[i] > arr[j])
                swap(arr, j, j - 1);
            }
            recursiveInsertion(arr, i, j-1);
        }
        recursiveInsertion(arr, i+1, 1+i);
    }

    static boolean balanceParanthesis(String s, int i, int j, int count){
        if(i == s.length()){
            return count*2 == s.length();
        }
        // if at any j i char found recurse again with j=0 and i= i+1
        if(j<s.length()){
            if(findClosing(s.charAt(i)) == s.charAt(j)){
                return balanceParanthesis(s, i+1, i+2, count+1);
            }
            return balanceParanthesis(s, i, j+1, count);
        }
        return balanceParanthesis(s, i+1, i+2, count);

    }
    static char findClosing(char c)
    {
        if (c == '(')
            return ')';
        if (c == '{')
            return '}';
        if (c == '[')
            return ']';
        return Character.MIN_VALUE;
    }

    // proper subset
    static void powerSet(String p, String s){
        if(s.length() == 0){
            if(p.length() >=1){
                System.out.println(p+" ");
            }

            return;
        }

        char ch = s.charAt(0);
        // take it
        powerSet(p+ch, s.substring(1));
        // ignroe it
        powerSet(p, s.substring(1));
    }

    static void possiblePalindromicPartitio (String p, String s){
        // ideas is to make possible set of s and check if that sets are palindromic or not

        if(s.isEmpty()){
            if(isPalindromic(p)){
                System.out.println(p);
            }
            return;
        }
        char ch = s.charAt(0);

        // take it
        possiblePalindromicPartitio(p+ch, s.substring(1));
        // ignore it
        possiblePalindromicPartitio(p, s.substring(1));
    }

    static boolean isPalindromic (String s){
        for(int i=0; i< s.length()/2; i++){
            if(s.charAt(i) != s.charAt(s.length()-i-1)){
                return false;
            }
        }
        return true;
    }

    static String removeConsecDuplicat(String p, String s){
        if(s.isEmpty()){
            return p;
        }
        char ch = s.charAt(0);
        if(!p.contains(ch+"")){
            // accenpt
            p = p+ch;
        }
       return removeConsecDuplicat(p, s.substring(1));

    }


}
