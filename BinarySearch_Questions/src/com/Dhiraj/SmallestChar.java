package com.Dhiraj;

public class SmallestChar {
    public static void main(String[] args) {
        // sorted array of char in non-descending order return the smallest char that is larger than target char, if target char is largest among the array then return char at index 0
        char [] arr = {'a', 'c', 'e', 'f'};
        char target = 'a';
        int ans = smallestChar(arr, target);
        System.out.println(ans);

    }
    static int smallestChar(char [] array, char target){
        int start = 0;
        int end = array.length -1 ;
        boolean asci = array[start] <= array[end];

        while (start <= end ){
            int mid = start + (end-start)/2 ;
            if (target == array[mid] && mid < array.length-1){
                return mid + 1;
            }

            if (target > mid) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }

        return start;
    }
}

//
//// https://leetcode.com/problems/find-smallest-letter-greater-than-target/
//public class SmallestLetter {
//
//    public static void main(String[] args) {
//
//    }
//
//    public char nextGreatestLetter(char[] letters, char target) {
//
//        int start = 0;
//        int end = letters.length - 1;
//
//        while(start <= end) {
//            // find the middle element
////            int mid = (start + end) / 2; // might be possible that (start + end) exceeds the range of int in java
//            int mid = start + (end - start) / 2;
//
//            if (target < letters[mid]) {
//                end = mid - 1;
//            } else {
//                start = mid + 1;
//            }
//        }
//        return letters[start % letters.length];
//    }
//}