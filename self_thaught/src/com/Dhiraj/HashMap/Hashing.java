package com.Dhiraj.HashMap;

import java.util.HashMap;

public class Hashing {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(2, 2);
        map.put(3, 3);
        map.put(4, 5);
        System.out.println(map);
        System.out.println(map.get(4));
        map.containsKey(2);
        map.containsValue(5);
        
        map.remove(2);
        map.replace(4, 68);

    }
}
/*
Java HashMap contains values based on the key.
Java HashMap contains only unique keys.
Java HashMap may have one null key and multiple null values.
Java HashMap is non synchronized.
Java HashMap maintains no order.
The initial default capacity of Java HashMap class is 16 with a load factor of 0.75.

 */
