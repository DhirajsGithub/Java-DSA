package com.Dhiraj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Practise {
    public static void main(String[] args) {
        permu("abc", "");
        String[] words = { "bar", "foo", "the" };
        List<String> li = new ArrayList<>();
        permuArray(words, li);
    }

    private static void permu(String up, String p) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char c = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String first = p.substring(0, i);
            String second = p.substring(i, p.length());
            permu(up.substring(1), first + c + second);
        }
    }

    private static void permuArray(String[] words, List<String> li) {
        if (words.length == 0) {
            System.out.println(li);
            return;
        }
        String word = words[0];
        for (int i = 0; i <= li.size(); i++) {
            li.add(i, word);
            permuArray(Arrays.copyOfRange(words, 1, words.length), li);
            li.remove(i);
        }
    }

}
