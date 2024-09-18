package com.Dhiraj;

import java.util.ArrayList;

class Heap<T extends Comparable<T>> {
    // extends comparable to compare between generics

    // MinHeap --> we will always get smallest item with O(1) time
    private ArrayList<T> list;

    public Heap() {
        list = new ArrayList<>();
    }

    private void swap(int first, int second) {
        T temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
    }

    private int parent(int index) {
        // to start the index from 0;
        // note we won't be passing 0 as index while inserting see upheap method
        return (index - 1) / 2;
    }

    private int left(int index) {
        return index * 2 + 1;
    }

    private int right(int index) {
        return index * 2 + 2;
    }

    public void insert(T value) {
        // inserting the value at last of array then with upheap we will take to specific condition
        list.add(value);
        upheap(list.size() - 1);
    }
    private void upheap(int index) {
        // index will be list.size() - 1
        if(index == 0) {
            return;
        }
        int p = parent(index);      // getting the parent index
        // comparing index to it's parent, then swaping the index with parent if index < parent
        // note compareTo method for HuffmanCoder is overrider, it means when this Heap is being used there then it will compare according to the cost
        if(list.get(index).compareTo(list.get(p)) < 0) {
            swap(index, p);
            upheap(p);      // recursively calling it from down
        }
    }

    public T remove() throws Exception {
        if (list.isEmpty()) {
            throw new Exception("Removing from an empty heap!");
        }

        T temp = list.get(0);       // getting the first element to return

        T last = list.remove(list.size() - 1);      // removing the last element
        if (!list.isEmpty()) {
            list.set(0, last);              // setting the last element at first index then down heaping it to satisfy the condition
            downheap(0);
        }

        return temp;
    }
    private void downheap(int index) {
        int min = index;        // let the 0th index be minimum which is replace by the last element from remove method
        int left = left(index);
        int right = right(index);

        // comparing the left and right child of index for swaping
        if(left < list.size() && list.get(min).compareTo(list.get(left)) > 0) {
            min = left;
        }

        if(right < list.size() && list.get(min).compareTo(list.get(right)) > 0) {
            min = right;
        }

        // found the min from left and right child
        if(min != index) {
            swap(min, index);       // swaping the index with child (min child)
            downheap(min);
        }
    }

    public ArrayList<T> heapSort() throws Exception {
        ArrayList<T> data = new ArrayList<>();
        while(!list.isEmpty()) {
            data.add(this.remove());
        }
        return data;
    }

    public int size() {
        return this.list.size();
    }
}