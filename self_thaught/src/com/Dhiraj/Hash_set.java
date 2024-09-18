package com.Dhiraj;

import java.util.HashSet;
import java.util.Iterator;

public class Hash_set {
    public static void main(String[] args) {
        HashSet <String> set = new HashSet<>();
        set.add("One");
        set.add("Two");
        set.add("Three");
        set.add("Four");
        set.add("Five");
        set.add("Five");

        System.out.println(set);

        System.out.println(set.contains("Six"));

        Iterator<String> i=set.iterator();
        while(i.hasNext())
        {
            System.out.println(i.next());
        }
        set.remove("One");
        HashSet <String> set1 = new HashSet<>();
        set1.add("Three");
        set1.add("Four");
        set1.add("Five");
        set1.add("Five");

        set.removeAll(set1);        // any collection

        set.clear();        // removing all elements of the set



    }
}

/*
HashSet stores the elements by using a mechanism called hashing.
HashSet contains unique elements only.
HashSet allows null value.
HashSet class is non synchronized.
HashSet doesn't maintain the insertion order. Here, elements are inserted on the basis of their hashcode.
HashSet is the best approach for search operations.
The initial default capacity of HashSet is 16, and the load factor is 0.75
 */