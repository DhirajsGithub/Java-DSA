package com.Dhiraj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        // subseq("", "abc");
        // subseqAscii("", "abc");
        // System.out.println(subseqList("", "abc"));

        // System.out.println(subsetIter(new int[] {1,2,3}));

        System.out.println(susetIterRepeat(new int[] { 1, 2, 2 }));
        System.out.println(helperSubsets(new int[] { 1, 2, 2 }));

        // ArrayList<Integer> li = new ArrayList<>();
        // System.out.println(helperSubsets(new int[] { 1, 2, 2 }));

    }

    // process unporcess method
    // O(2^n) time and O(1) space
    static void subseq(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        // take it
        subseq(p + ch, up.substring(1));
        // or ignore it
        subseq(p, up.substring(1));
    }

    // O(3^n) time and O(1) space
    static void subseqAscii(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);

        subseqAscii(p + ch, up.substring(1));
        subseqAscii(p, up.substring(1));
        subseqAscii(p + (ch + 0), up.substring(1));
    }

    // O(2^n) time ans O(N) space
    static ArrayList<String> subseqList(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        char ch = up.charAt(0);

        ArrayList<String> left = subseqList(p + ch, up.substring(1));
        ArrayList<String> right = subseqList(p, up.substring(1));
        left.addAll(right);

        return left;
    }

    static ArrayList<ArrayList<Integer>> subseqArray(ArrayList<Integer> p, int up[]) {
        if (up.length == 0) {
            ArrayList<ArrayList<Integer>> li = new ArrayList<>();
            li.add(p);
            return li;
        }
        int ele = up[0];
        ArrayList<Integer> pp = new ArrayList<>(p);
        pp.add(ele);
        ArrayList<ArrayList<Integer>> left = subseqArray(pp, Arrays.copyOfRange(up, 1, up.length));
        ArrayList<ArrayList<Integer>> right = subseqArray(p, Arrays.copyOfRange(up, 1, up.length));
        left.addAll(right);
        return left;
    }

    // iterative programme to print subsequence

    // time complexity = (2^n * n)
    // space complexity = (2^n * n) 2^n total subsets and O(N) space taken by each
    // subset
    static ArrayList<ArrayList<Integer>> subsetIter(int[] arr) {
        ArrayList<ArrayList<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>()); // outer = [[]]

        for (int num : arr) {
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                ArrayList<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);
            }
        }
        return outer;
    }

    // when you find a duplicate element only add it in newly created subset of
    // previous step
    // duplciates have to be together, hence sort array
    static ArrayList<ArrayList<Integer>> susetIterRepeat(int[] arr) {
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        int start = 0;
        int end = 0;

        for (int i = 0; i < arr.length; i++) {
            start = 0;
            // if current and previous element is same the start = end + 1
            if (i > 0 && arr[i] == arr[i - 1]) {
                start = end + 1;
            }
            end = outer.size() - 1; // end will be at newly created subset
            int n = outer.size();
            for (int j = start; j < n; j++) {
                ArrayList<Integer> internal = new ArrayList<>(outer.get(j));
                internal.add(arr[i]);
                outer.add(internal);
            }
        }
        return outer;
    }

    // https://leetcode.com/problems/subsets/submissions/
    // nums must contain distinct elements
    public static List<List<Integer>> helperSubsets(List<Integer> p, int[] nums) {
        if (nums.length == 0) {
            List<List<Integer>> temp = new ArrayList<>();
            temp.add(p);
            return temp;
        }
        List<Integer> p2 = new ArrayList<>(p);
        int curEle = nums[0];
        p2.add(curEle);
        List<List<Integer>> left = helperSubsets(p2, Arrays.copyOfRange(nums, 1, nums.length));
        List<List<Integer>> right = helperSubsets(p, Arrays.copyOfRange(nums, 1, nums.length));
        left.addAll(right);

        return left;
    }

    public static List<List<Integer>> helperSubsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        int start = 0;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                start = end + 1;
            }
            end = outer.size() - 1;
            int n = outer.size();
            for (int j = start; j < n; j++) {
                List<Integer> inner = new ArrayList<>(outer.get(j));
                inner.add(nums[i]);
                outer.add(inner);
            }
        }

        return outer;
    }

}

/*
 * subset pattern --> taking some elements and removing some
 * subsets:
 * permutation and combinations
 * subsets --> non adjacent collection
 * total number of subsets possible for array of length n of string of length n
 * is 2^n
 * subset pattern --> taking some elements and removing some
 * 
 */