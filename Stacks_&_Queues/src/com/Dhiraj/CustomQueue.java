package com.Dhiraj;

public class CustomQueue {
    private int data [] ;
    private static final int DEFAULT_SIZE = 10;

    // Custom queue with only single pointer
    int end  = 0;

    public CustomQueue() {
        this(DEFAULT_SIZE);
    }

    public CustomQueue(int size) {
        this.data = new int[size];
    }

    public boolean isFull(){
        return end == data.length;      // we will first add the item then increase the end hence
    }

    public boolean isEmpty(){
        return end == 0;
    }

    public boolean insert(int item){
        if(isFull()){
            return false;
        }
        data[end++] = item;
        return true;
    }

    // will take O(N) time complexity as we will be shifting the element to the left after every removal method get called
    public int remove() throws Exception {
        if(isEmpty()){
            throw new Exception("Queue is Empty");
        }
        int removed = data[0];

        // shift element to the left
        for (int i = 1; i < end ; i++) {
            data[i-1] = data[i];
        }
        end --;

        return removed;
    }

    public int front () throws Exception {
        if(isEmpty()){
            throw new Exception("Queue is Empty");
        }
        return data[0];
    }

    public void display(){
        for (int i = 0; i < end; i++) {
            System.out.print(data[i] + " <- ");
        }
        System.out.println("END");
    }
}
