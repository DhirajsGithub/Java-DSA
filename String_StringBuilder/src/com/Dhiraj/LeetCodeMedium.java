package com.Dhiraj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class LeetCodeMedium {
    public static void main(String[] args) {

        String s = "bs";
//        System.out.println(checkPalindromeFormation("abc", "def"));
        System.out.println(6%3);

        String str = "aaaaaaaaaaaaaaaabbbbbbbbbbbbaaaaaaabbbbbbbbbbbbcccccccccccdddddddddddddddddddeeeeeeeeeeeeeeefffffffffffffffgggggggggggggggggggghhhhhhhhhhhhhhhhiiiiiiiiiiiiiiiiiiiiiijjjjjjjjjjjjjjjjjjjjjjjjkkkkkkkkkkkkkkkkkkkk";
        System.out.println("longest substring "+longestSubstring(str, 20, 0, str.length()-1));

//        System.out.println(longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
//        System.out.println(Arrays.toString(medianSlidingWindow(new int[]{1,2}, 1)));



    }
    public static boolean isStringPalindrom (String s){
        int i=0;
        int j = s.length()-1;
        while (i<j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

//    https://leetcode.com/problems/split-two-strings-to-make-palindrome/description/
    public static boolean checkPalindromeFormation (String s1, String s2){
        // s1 and s2 are of same length given
        // s1 and s2 must be split at same index
        // s1Prefix + s2Suffix or s2Prefix + s1Suffix
//        int i=0;
//        while (i<s1.length()){
//            StringBuilder str = new StringBuilder();
//            str.append(s1.substring(0, i));
//            str.append(s2.substring(i));
//            if(isStringPalindrom(str.toString())){
//                return true;
//            }
//            StringBuilder str2 = new StringBuilder();
//            str2.append(s2.substring(0, i));
//            str2.append(s1.substring(i));
//            if(isStringPalindrom(str2.toString())){
//                return true;
//            }
//            System.out.println(str + " "+ str2);
//            i++;
//        }
//
//        return false;

        int i=0;
        int j = s1.length()-1;
        while (i<j){

        }
        return true;
    }

//    https://leetcode.com/problems/number-of-ways-to-split-a-string/description/
    public static int numOfways(String s){
        int size = s.length();
        int loop = 1 + (size-3)*2;
//        for (int i = 0; i < loop; i++) {
//
//        }
        int i=1;
        int j=1;
        while (i<size-2){
            System.out.println(s.substring(0, i));
            while (j<size-2){
                System.out.println(s.substring(i, j+1));
                System.out.println(s.substring(j+1));
                j++;
            }
        }


        return -1;
    }


//    https://leetcode.com/problems/max-consecutive-ones-iii/
    public static int longestOnes(int[] nums, int k) {

        int i=0;
        int j=0;
        while(j<nums.length){
            if(nums[j] == 0){
                k--;
            }
            if(k<0){
                if(nums[i] == 0){
                    // since j and i decide the distance, if k<0 we are incrementing i hence decrementing distance due to 0 at position of j
                    // but now that position is taken by i hence we need to incerement k
                    k++;
                }
                i++;
            }
            j++;
        }
        return j-i;

//        int maxAns = 0;
//        for (int i = 0; i < nums.length; i++) {
//            int curSum = 0;
//            int m = k;
//            for (int j = i; j < nums.length; j++) {
//                if(nums[j] == 1){
//                    curSum++;
//                    maxAns = Math.max(curSum, maxAns);
//                }else if(m >0){
//                    curSum ++;
//                    maxAns = Math.max(curSum, maxAns);
//                    m--;
//                }else{
//
//                    curSum = 0;
//                    break;
//                }
//            }
//        }
//        return maxAns;
    }

//   https://leetcode.com/problems/sliding-window-median/description/
    public static double[] medianSlidingWindow(int[] nums, int k) {
        int size = nums.length-k +1;
        double [] ans = new double[size];
        int i=0;
        int j=k;
        int m =0;
        int tempArr [] = Arrays.copyOfRange(nums, i, j);
        Arrays.sort(tempArr);
        ArrayList<Integer> li = new ArrayList<>();
        for (int l = i; l < j; l++) {
            li.add(tempArr[l]);
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(li);
        while (j<=nums.length){
            System.out.println(" j is "+j);
            double median = findMedian(li);
            ans[m] = median;
            m++;
            int removeInd = li.indexOf(nums[i]);
            li.remove(removeInd);
            i++;
            j++;
            if(j<=nums.length){
                int newEle = nums[j-1];
                System.out.println("new ele "+ newEle);
                if (li.size()>0  && newEle>= li.get(li.size()-1)){
                    li.add(li.size(), newEle);
                }else if(li.size()>0 && newEle <= li.get(0)){
                    li.add(0, newEle);
                }else if(li.size() == 0){
                    li.add(newEle);
                }
                else{
                    for (int l = 0; l < li.size(); l++) {
                        if (l > 0 && newEle >= li.get(l-1) && newEle <= li.get(l)){
                            li.add(l, newEle);
                            break;
                        }
                    }
                }
                System.out.println(li);
            }




        }
        return ans;
    }
    public static double findMedian(ArrayList<Integer> nums){
        if (nums.size() == 1){
            double ans = nums.get(0);
            return ans;
        }
        double median;
        if(nums.size()%2 == 0){
            median = ((double)(nums.get((nums.size()/2) -1)) + (double)(nums.get(nums.size()/2)) )/2;

        }else{
            median = nums.get(nums.size()/2);
        }
        return median;
    }

//    https://leetcode.com/problems/next-permutation/description/
public static int longestSubstring(String s, int k, int i, int j) {
    if (j - i + 1 < k) {
        return 0;
    }

    HashMap<Character, Integer> hm = new HashMap<>();
    for (int n = i; n <= j; n++) {
        hm.put(s.charAt(n), hm.getOrDefault(s.charAt(n), 0) + 1);
    }

    boolean isCorrect = true;
    int start = i;
    for (int n = i; n <= j; n++) {
        if (hm.get(s.charAt(n)) < k) {
            isCorrect = false;
            return Math.max(longestSubstring(s, k, start, n - 1), longestSubstring(s, k, n + 1, j));
        }
    }

    if (isCorrect) {
        return j - i + 1;
    }

    return 0;
}

    public static int occurrenceOfCharInString(String str, char cc, int s, int e) {
        int ans = 0;
        while (s <= e) {
            if (str.charAt(s) == cc) {
                ans++;
            }
            s++;
        }
        return ans;
    }

}
