package com.Dhiraj;
import java.util.Arrays;
import java.util.Scanner;

public class IndexArray {
    public static void main(String[] args) {
        int[] arr = new int[5];
//        same as int[] arr = {0, 0, 0, 0, 0};
        System.out.println(arr[0]);           // 0 by default
        String[] str = new String[4];
        System.out.println(str[0]);           // null by default


        Scanner in = new Scanner(System.in);
        // array of the primitives
        int [] arr2 = new int[5];
        arr[0] = 23;
        arr[1] = 223;
        arr[2] = 1;
        arr[3] = 42;
        arr[4] = 50;
        // [23, 223, 1, 42, 50]
        System.out.println(arr2[3]);    // 42
//        System.out.println(arr2[5]);      // error index out of bound
        System.out.println(Arrays.toString(arr2));        // we have Arrays class and it have toString method

        // input using for loop
        for(int i=0; i<arr2.length; i++){
            arr2[i]  = in.nextInt();            // input will be taken as 23, 442, 23, 424, 89  but due to nexInt() mehtod it will always take int after the other seperated by space
        }
        for(int i=0; i<arr2.length; i++){
            System.out.println(arr2[i]);
        }

        // for each method
        for (int num : arr2){         // for every element in the array print the element
            System.out.print(num +" ");     // here num represent element of the array
        }
//        note int num is an array of integers

        // array of the objects
        String[] str2 = new String[4];
        for (int i=0; i<str2.length; i++) {         // no problem with str2.length though
            str2[i] = in.next();
        }
        System.out.println(Arrays.toString(str2));
        // modify
        str2[1] = "kunal";
        System.out.println(Arrays.toString(str2));

        for (String element: str2){
            System.out.println(element);
        }
        // NOTE: String is an array of string

        // Array passing in function
        int[] nums = {2,1,4,5,5};
        System.out.println(nums);
        change(nums);
        System.out.println(nums);    // [2,99,4,5,5]     ----> mutable behaviour

    }
    static void change(int [] arr){
        arr[1] = 99;
    }

}

/*
null:
1. null is Case sensitive
2. Reference Variable value: Any reference variable in Java has a default value null.
3. Type of null: Unlike the common misconception, null is not Object or neither a type. It’s just a special value, which can be assigned to any reference type and you can type cast null to any type Examples:
null is a literal not a datatype
Literal: Any constant value which can be assigned to the variable is called literal/constant. In simple words, Literals in Java is a synthetic representation of boolean, numeric, character, or string data.
but we can define it as object for 'non-primitive' like arrays and string
any reference variable you have by default it's value is set to null
primitives are store in stack and non primitives are store in heap
int[] arr = new int[5];     so we have arr ref_varaible which is define in stack and it's pointing towards array which is store in heap memory each elements having own memeory allocated
 */