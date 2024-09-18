package com.Dhiraj.OOP6.CustomArrayList;

import java.util.ArrayList;
import java.util.Arrays;

public class CustomArrayList {

    private int [] data;
    private static int DEFAULT_SIZE = 10;
    private int size = 0;      // size will also acts as an index

    public CustomArrayList() {
        this.data = new int[DEFAULT_SIZE];

    }

    public void add(int num){
        if(isFull()){
            resize();
        }
        data[size++] = num;
    }

    private void resize() {
        int [] temp = new int[data.length*2];
        
        // copy the current items in new array temp
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    private boolean isFull() {
        return size == data.length;
    }

    public int remove(){
        int removed = data[--size];     // last index will be removed
        return removed;
    }
    public int size(){
        return size;
    }
    public int get (int index){
        return data[index];
    }
    public void set (int index, int value){

        data[index] = value;
    }

    // overriding to string method as it is a int array


    @Override
    public String toString() {
        return "CustomArrayList{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        ArrayList<Integer> li = new ArrayList<>();
        CustomArrayList list = new CustomArrayList();
        list.add(2);
        list.add(3);
        list.add(4);

        int num1 = 4;
        int num2 = 4;
        System.out.println(num1++);
        System.out.println(++num2);
        System.out.println(num1);
        System.out.println(num2);

        // far now our custom array list only stores integer data types but we can customize it with the help of generics
    }
}
