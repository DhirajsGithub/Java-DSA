package com.Dhiraj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetcodeMedium {
    public static void main(String[] args) {
        // 2.2 * 10^-308
        double p = 0.00001;
        System.out.println(p);
        System.out.println(Math.pow(0.00001,2147483647));
        System.out.println(myPow(3, 3));
//        System.out.println((char) ('a' + 21));
//        List<Integer> li = new ArrayList<>();
//        System.out.println(letterCombinationsHelper("", "73"));
//        int [] arr = new int[]{3, 2, 1};
//
//        System.out.println(permutations(li, arr));
//        System.out.println(kthGrammarNthSysm(5, 11));
        int [] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        System.out.println(combinationSumHelper(candidates, target, ans, 0, 0, temp));
    }


//    https://leetcode.com/problems/powx-n/
    public static double myPow(double x, int n) {

        if(n==0){
            return 1;
        }

        long N = n;
        if(N<0){
            N = -N;
            x = 1/x;
        }

        if((N%2) == 0){ // n is even
            return myPow(x*x, (int)(N/2));
        }else{
            return x*myPow(x, (int)((N-1)));
        }

        // divide and conquer approach
//        if (n==0){
//            return 1;
//        }
//        if(n==1){
//            return x;
//        }
//        if(n > 0){
//            int half = n/2;
//            return myPow(x, half)*myPow(x, n-half);
//
//        }else{
//            n = -n;
//            int half = n/2;
//            return  (1/myPow(x, half))* (1/myPow(x, n - half));
//        }
    }
    public static List<List<Integer>> combinationSumHelper(int[] candidates, int target, List<List<Integer>> ans, int i, int j, List<Integer> temp) {
        // temp ---> [] initially
        // candidates = [2,3,6,7]
        System.out.println(temp);
        if(i == candidates.length){
            return ans;
        }
        int tempSum = tempSumFunc(temp);
        if(j == candidates.length){
            i++;
            j = i;
        }
        if(tempSum < target && j<candidates.length){
            temp.add(candidates[j]);
            combinationSumHelper(candidates, target, ans,i, j, temp);
        }else if(tempSum > target && !temp.isEmpty() && j<candidates.length){
            temp.remove(j);
            if(j>0){
                temp.remove(j-1);
            }
            j ++;
            if(j<candidates.length-1){
                temp.add(candidates[j]);
                combinationSumHelper(candidates, target, ans, i,j, temp);
            }

        }
        if(tempSum ==target){
            ans.add(temp);
            List<Integer> newTemp = new ArrayList<>();
            temp = newTemp;
            i++;
            j = i;
            combinationSumHelper(candidates, target, ans, i,j, temp);
        }

        return ans;
    }
    public static int tempSumFunc(List<Integer> li){
        int sum = 0;
        int i=0;
        while (i < li.size()){
            sum+= li.get(i);
            i++;
        }
        return sum;
    }


    public static List<List<Integer>> permutations(List<Integer> p, int [] up){
        if(up.length == 0){
            List<List<Integer>> temp = new ArrayList<>();
            temp.add(p);
            return temp;
        }
        int curEle = up[0];
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i <=p.size(); i++) {
            p.add(i, curEle);
            ans.addAll(permutations(new ArrayList<>(p), Arrays.copyOfRange(up, 1, up.length)));
            p.remove(i);
        }
        return ans;
    }

//    https://leetcode.com/problems/letter-combinations-of-a-phone-number/
    // "23" -->  2/d, 2/e, 2/f --> ad/"", ae/"", af/"", ...
    public static List<String> letterCombinationsHelper(String p, String up ){
        if(up.isEmpty()){
            List<String> li = new ArrayList<>();
            li.add(p);
            return li;
        }

        int digit = up.charAt(0) - '0';     // '2' --> 2
        List<String> ans = new ArrayList<>();
        if(digit < 7){
            for (int i = (digit-2)*3; i < (digit-1)*3; i++) {
                char ch = (char)('a' + i);
                ans.addAll(letterCombinationsHelper(p+ch, up.substring(1)));
            }
        }else if(digit == 8){
            for (int i = (digit-2)*3+1; i< (digit-1)*3 +1; i++) {
                char ch = (char)('a' + i);
                ans.addAll(letterCombinationsHelper(p+ch, up.substring(1)));
            }
        }else if (digit == 7){
            for (int i = (digit-2)*3; i < (digit-1)*3+1; i++) {
                char ch = (char)('a' + i);
                ans.addAll(letterCombinationsHelper(p+ch, up.substring(1)));
            }
        }else{
            for (int i = (digit-2)*3+1; i < (digit-1)*3+2; i++) {
                char ch = (char)('a' + i);
                ans.addAll(letterCombinationsHelper(p+ch, up.substring(1)));
            }
        }


        return ans;
    }

//    https://leetcode.com/problems/k-th-symbol-in-grammar/
    public static int kthGrammarNthSysm(int n, int k) {
        if(n==1 && k==1){
            return 0;
        }
        int mid = (int)(Math.pow(2, n-1)/2);
        if(k <= mid){
            return kthGrammarNthSysm(n-1, k);
        }else{
            int ans = kthGrammarNthSysm(n-1, k-mid);
           return ans== 0 ? 1: 0;
        }

    }

    private static String reverseEachChar(String p) {
        StringBuilder builder = new StringBuilder(p);
        for (int i = 0; i < builder.length(); i++) {
            char c = builder.charAt(i) == '0' ? '1' : '0';
            builder.setCharAt(i, c);
        }
        return builder.toString();
    }


//    https://leetcode.com/problems/combinations/description/
    public static List<List<Integer>> combine(int n, int k) {
        List<Integer> p = new ArrayList<>();
        return helper(n, p, k, 1);
    }

    public static List<List<Integer>> helper(int n, List<Integer> li, int k, int i){

        //By creating copies of the list using new ArrayList<>(li), you ensure that modifications to one list do not affect others, and you should get the correct combinations in the result.
        if(li.size() == k || i>n){
            List<List<Integer>> temp = new ArrayList<>();
            if(li.size() == k) {
                // need to have a new li, coz we are modyfing li so it will affect the li which are in temp and in turn in ans
                temp.add(new ArrayList<>(li));
            }
            return temp;
        }

        List<List<Integer>> ans = new ArrayList<>();
        li.add(i);
        ans.addAll(helper(n, li, k, i+1));
        li.remove(li.size()-1);
        ans.addAll(helper(n, li, k, i+1));
        return ans;
    }
}
