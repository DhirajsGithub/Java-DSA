package com.Dhiraj;

import java.util.HashMap;

public class Temp {
    public static void main(String[] args) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(1, 11);
        hm.put(2, 22);
        hm.put(3, 33);

        hm.forEach((k, v) -> System.out.println(k + v));
    }
}
