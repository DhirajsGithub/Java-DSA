package com.Dhiraj;

public class CustomStack {
    protected int [] data;
    private static final int DEFAULT_SIZE = 10;

    int ptr = -1;

    public CustomStack() {
        this(DEFAULT_SIZE);
        // this can be used as a constructor 2nd use of this
    }

    public CustomStack(int size) {
        this.data = new int[size];
    }

    public boolean push (int val) throws StackException {
        if(isFull()){
            throw new StackException("Can't push in full stack of arrays");     // custom exception class
//            return false;    // since exception is thrwon hence this will be unreachable statement
        }
        ptr ++;
        data[ptr] = val;
        return true;
    }
    public int pop() throws Exception {
        if(isEmpty()){
            throw new Exception("Cannot pop from an empty array");   // inbuilt exception class
        }
//        int removed = data[ptr];
//        ptr --;
//        return removed;

        return data[ptr--];     // ptr --  will first do the task then it will reduce itself by one
    }

    public int peek() throws Exception {
        if(isEmpty()){
            throw new Exception("Empty array don't have peek element");
        }
        return data[ptr];
    }

    public boolean isFull(){
        return ptr == data.length -1;       // pts is at last index, since we are pushing elements after doing ptr++ hence
    }

    public boolean isEmpty(){
        return ptr == -1;
    }
}
