package com.Dhiraj.OOP6.CustomArrayList;

import com.Dhiraj.OOP3.Polymorphism.Numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WildCardExample<T extends Numbers> {
    // Numbers classes contains float, integer, etc hence this customArray list will only accept Numbers supporting objects
    // heret T should either be Number or it's subclass, more type checking now

//    // wildcard example
//    public void getList(List <Numbers> list){
//        // only Numbers data type will be accepeted
//    }

    // to pass Number type only in a method
//    public void getList(List <Number> list){
//        // do something
//    }


    // to pass Number type and it's subclasses
    public void getList(List < ? extends Numbers> list){
        // here we can pass Numbers, as well integer float, etc
    }

    private Object [] data;
    // since Object class is inheritated by all the classes, it make sence to have Object data Type later we can cast it to any T data type

    private static int DEFAULT_SIZE = 10;
    private int size = 0;      // size will also acts as an index

    public WildCardExample() {
        this.data = new Object[DEFAULT_SIZE];

    }

    public void add(T num){
        if(isFull()){
            resize();
        }
        data[size++] = num;
    }

    private void resize() {
        Object [] temp = new Object[data.length*2];

        // copy the current items in new array temp
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    private boolean isFull() {
        return size == data.length;
    }

    public T remove(){
        T removed = (T)data[--size];     // type cast
        return removed;
    }
    public int size(){
        return size;
    }
    public T get (int index){
        return (T)data[index];    // return type is T hence return must be of type T
    }
    public void set (int index, int value){

        data[index] = value;
    }

    // overriding to string method as it is a int array
    @Override
    public String toString() {
        return "CustomGenArrayList{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        ArrayList<Integer> li = new ArrayList<>();
//        CustomArrayList list = new CustomArrayList();
//        list.add(2);
//        list.add(3);
//        list.add(4);

        CustomGenArrayList<Integer> list2 = new CustomGenArrayList<>();
        list2.add(2);
        list2.add(3);
        list2.add(4);

        CustomGenArrayList<String> list3 = new CustomGenArrayList<>();
        list3.add("Str1");
        list3.add("Str2");

        System.out.println(list3);        // not set value will be null as we set data Object
    }
}
