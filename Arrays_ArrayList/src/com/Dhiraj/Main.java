package com.Dhiraj;

import java.util.Arrays;

class Student {
    public int roll_no;
    public String name;

    Student(int roll_no, String name) {
        this.roll_no = roll_no;
        this.name = name;
    }
}

public class Main {

    public static void main(String[] args) {
        // Arrays are basically collection of data types
        // syntax
        // datatype[] ref_variable = new data_type[size]
        // or datatype[] ref_variable_name = {items}
        // datatype[] ref_variable_name ---->//1. happens at compile time new
        // data_type[size]------> happens at runtime
        // 2.new ---> used to create an object in heap memory of size 5

        // data_type[] ---> non-primitive data type called array

        int[] rollNos = new int[5];
        int[] rollNos2 = { 23, 32, 1, 42, 1 };

        // 1. int[] means rollNos is pointing towards an array which have collection of
        // integers
        // 2. same data type must be present

        int[] ros; // -----> decleration of an array, ros is getting define in the stack
        ros = new int[4]; // initialisation: actually here object is being created in the heap

        // make an array which has collection of sum of conseuctive values of array gain
        int[] gain = { 44, 32, -9, 52, 23, -50, 50, 33, -84, 47, -14, 84, 36, -62, 37, 81, -36, -85, -39, 67, -63, 64,
                -47, 95, 91, -40, 65, 67, 92, -28, 97, 100, 81 };
        int max = 0;
        int[] arr = new int[gain.length + 1];
        arr[0] = 0;
        for (int i = 1; i < gain.length + 1; i++) {
            arr[i] = gain[i - 1] + arr[i - 1];

        }

        // System.out.println(Arrays.toString(arr));

        Student[] arrr;

        // allocating memory for 5 objects of type Student.
        arrr = new Student[5];
        System.out.println(arrr.length);

    }
}

/*
 * 
 * An array is a data structure that holds a fixed-size sequential collection of
 * elements of the same type.
 * Memory Address=Base Address+(3×Size of int)
 * Keep in mind that Java abstracts away direct memory access, and the actual
 * memory management is handled by the Java Virtual Machine (JVM).
 * The formula above is a conceptual representation, and the JVM takes care of
 * the low-level details.
 * 
 * 
 * 
 * in c++ array are store continuosly in the memory like cell after cell with
 * specific address to each element.
 * cells means one by one allocation. Due to pointers
 * in java it depends on JVM
 * 1) array object are store in heap memory
 * 2) Heap object are not continuous
 * 3) Dynamic memory allocation
 * 4) hence array object in java are not continuous
 */
