package com.Dhiraj;

import java.util.*;

public class Permutation {
    public static void main(String[] args) {
        String s = "abc";
        // find all it's permutations i.e. s.length()!
        permuation("", s);
        // System.out.println(permuationsCount("", s));
        // System.out.println(permutationList("", s));

        // https://leetcode.com/problems/letter-combinations-of-a-phone-number/
        // combinatioPhoneNo("", "12");
        // System.out.println(combinatioPhoneNoList("", "12"));

        // dice("", 4);
        // System.out.println(diceList("", 4));
        List<Integer> p = new ArrayList<>();
        // System.out.println(permutationArrayLi(p, new int[]{3, 2, 1}));

    }

    static void permuation(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        // with every function call i number of recursion were happening
        for (int i = 0; i <= p.length(); i++) {
            // since last element is not included while taking substring
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            permuation(f + ch + s, up.substring(1));
        }
        System.out.println("end");
    }

    static int permuationsCount(String p, String up) {
        if (up.isEmpty()) {
            return 1;
        }
        int count = 0;
        char ch = up.charAt(0);
        // with every function call i number of recursion were happening
        for (int i = 0; i <= p.length(); i++) {
            // since last element is not included while taking substring
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            count = count + permuationsCount(f + ch + s, up.substring(1));
        }
        return count;
    }

    static ArrayList<String> permutationList(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            ans.addAll(permutationList(f + ch + s, up.substring(1)));
        }
        return ans;
    }

    // https://leetcode.com/problems/letter-combinations-of-a-phone-number/
    static void combinatioPhoneNo(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        int digit = up.charAt(0) - '0'; // this will convert '1' to 1
        // for 1 char are a b c for 2 char are d e f and so one
        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char) ('a' + i);
            combinatioPhoneNo(p + ch, up.substring(1));
        }
    }

    // return the combinations in an aray list
    static ArrayList<String> combinatioPhoneNoList(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            // System.out.println(p);
            list.add(p);
            // System.out.println(list); list with every return be like [ad] [ae] [af] ,...
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        int digit = up.charAt(0) - '0';
        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char) ('a' + i);
            ans.addAll(combinatioPhoneNoList(p + ch, up.substring(1)));
        }
        return ans;
    }

    // ways to form number on a dice
    // ""/4 --> 1/3, 2/2, 3/1, 4/0
    static void dice(String p, int target) {
        if (target == 0) {
            System.out.println(p);
            return;
        }
        for (int i = 1; i <= 6 && i <= target; i++) {
            dice(i + p, target - i);
        }
    }

    static ArrayList<String> diceList(String p, int target) {
        if (target == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 1; i <= 6 && i <= target; i++) {
            ans.addAll(diceList(i + p, target - i));
        }
        return ans;
    }

    // dice with dynamic face
    static ArrayList<String> diceListFace(String p, int target, int face) {
        if (target == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 1; i <= face && i <= target; i++) {
            ans.addAll(diceListFace(i + p, target - i, face));
        }
        return ans;
    }

    public static List<List<Integer>> permutationArrayLi(List<Integer> p, int[] nums) {
        // sort nums in discending order first
        if (nums.length == 0) {
            List<List<Integer>> temp = new ArrayList<>();
            temp.add(p);
            return temp;
        }
        int curEle = nums[0];
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i <= p.size(); i++) {
            p.add(i, curEle);
            ans.addAll(permutationArrayLi(new ArrayList<>(p), Arrays.copyOfRange(nums, 1, nums.length)));
            p.remove(i); // Remove the added element for the next iteration
        }
        return ans;
    }
}
