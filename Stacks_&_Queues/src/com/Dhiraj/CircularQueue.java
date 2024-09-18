package com.Dhiraj;

public class CircularQueue {
    public int [] data;
    public static final int DEFAULT_SIZE = 10;

    public int end = 0;
    public int front = 0;
    public int size = 0;

    public CircularQueue() {
        this(DEFAULT_SIZE);
    }

    public CircularQueue(int size) {
        this.data = new int[size];
    }

    public boolean isFull(){
        return size == data.length;     // first we're assigning value then increase the size
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean insert(int item){
        if (isFull()){
            return false;
        }
        data[end++] = item;
        end = end % data.length;        // end will always be circulating through 0 to data.length
        size ++;                        // since we are reducing the size whenever we remove an item hence if end == data.length then end % data.length hence item will be added at first
        return true;                    // front won't be pointing to that first front will be pointing to always that item which was added first
    }

    public int remove() throws Exception {
        if(isEmpty()){
            throw new Exception("Queue is Empty");
        }
        int removed = data[front++];
        front = front%data.length;
        size -- ;
        return removed;
    }

    public int front () throws Exception {
        if(isEmpty()){
            throw new Exception("Queue is Empty");
        }
        return data[front];
    }

    public void display(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return;
        }
        int i = front;
        do{
            System.out.print(data[i] + " -> ");
            i++;
            i %= data.length;
        }while(i != end);

        System.out.println("END");
    }
}
