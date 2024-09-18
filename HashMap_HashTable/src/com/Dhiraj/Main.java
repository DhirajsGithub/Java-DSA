package com.Dhiraj;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        // write your code here
        // String name = "Rahul";

        // Integer a = 4235678;

        // int code = a.hashCode();

        // System.out.println(code);

        // <TreeMap<String, Integer> map = new TreeMap<>();
        HashMap<String, Integer> map = new HashMap<>();

        map.put("Kunal", 89);
        map.put("Karan", 99);
        map.put("Rahul", 94);

        // System.out.println(map.get("Karan"));
        // System.out.println(map.getOrDefault("Apoorv", 78));
        System.out.println(map.containsKey("Karan"));

        HashSet<Integer> set = new HashSet<>();
        set.add(56);
        set.add(9);
        set.add(12);
        set.add(43);
        set.add(56);
        set.add(2);

        System.out.println(set);

        HashMapFinal<String, String> hs = new HashMapFinal<>();

        hs.put("Mango", "King of fruits");
        hs.put("Apple", "A sweet red fruit");
        hs.put("Litchi", "Kunal's fav fruit");

        System.out.println(hs);
    }
}
