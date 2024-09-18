package com.Dhiraj;
import java.util.Scanner;

import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        // array list let size of array be handle by java and let no of inputs be any numbers
        // vectors in c++ ==> array list in java

        // syntax
        ArrayList<Integer> list = new ArrayList<>(5);
        // generic --> full integer and not int
        // for now take list is ref_variable and new object ArrayList is pointed by ref_variable

//        list.add(23);                // adds at the last index
//        list.add(34);
//        list.add(2332);
//        list.add(2314);
//        list.add(87);
//        list.add(89);
//        list.add(2);
//        list.add(373);
//        list.add(57);
//        list.add(75);
//        list.add(754);
//        list.add(36);
//        System.out.println(list);
//        System.out.println(list.contains(373));     // boolean

        // set method
        list.set(0, -99);          // 0th index pr -99 update ho jayega

        // contains method
        System.out.println(list.contains(3));   // returns boolean

        // indexOf method
        list.indexOf(34);           // returns integer
        System.out.println("what if element is not in array list "+ list.indexOf(8934));      // it will give -1


        // we have .size() method for ArrayList length
        System.out.println(list.size());

        // add element to a specific position in an arraylist
        list.add(2, -89);

        // add all emements of list1 to list2
//        list2.addAll(list1);

        Scanner in = new Scanner(System.in);
//
//        // input
//        for (int i=0; i<5; i++){
//            list.add(in.nextInt());
//        }
//        // get item at any index
//        for (int i=0; i<5; i++){
//            System.out.println(list.get(i));       // pass index here, list[index] will not work here
//        }
//        System.out.println(list);

        ArrayList <ArrayList<Integer>> list2 = new ArrayList<>();
        // initialisation
        for (int i=0; i<3; i++){
            list2.add(new ArrayList<>());
        }
        System.out.println(list2);                              // [[], [], []]

        // add elements
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                list2.get(i).add(in.nextInt());              // list[rowi].add[input]     // list[rowi][coli] = in.nextInt()3
            }
        }

    }
}

/*
internal working:
1) size of array list is fixed internally actually by default size is fixed to 10
2) say arraylist fills by some amount let say half
3) then it will create a new array list of double the intial size and copy the initial elements of list and old one is deleted
 */






















