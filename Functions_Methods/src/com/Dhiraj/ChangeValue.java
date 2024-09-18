package com.Dhiraj;

import java.util.Arrays;

public class ChangeValue {
    public static void main(String[] args) {
        // create an array
        int [] arr = {1,4,6,8,3,4};
        change(arr);
        System.out.println(Arrays.toString(arr));           // [99, 4, 6, 8, 3, 4]
        System.out.println(arr);

        String name = "Kunal Kushwaha";   // Prob.2   name ---> "Kunal Kushwaha" sout(name) will be Kunal Kushwaha. name/naam ----> "Rahul Rana"(valid to functional scope only)
        changeName(name);
        System.out.println(name);      // won't print Rahul Rana it's still Kunal Kushwaha // java main pass by reference hota hain for arrays and object in case of functions
    }

    static void change(int[] nums) {
        nums[0] = 99;        // if you make a change via this reference variable via this reference variable same object will be changes
        return;     // void return
    }


    static void changeName(String name){
        name = "Rahul Rana";         // not changing but creating a new object
    }
}
