package com.Dhiraj;

public class QueueMain {
    public static void main(String[] args) throws Exception {
//        CustomQueue queue = new CustomQueue(5);
//        queue.insert(4);
//        queue.insert(5);
//        queue.insert(6);
//        queue.insert(7);
//        queue.insert(8);
//
//        queue.display();
//        System.out.println(queue.remove());
//        queue.display();

        CircularQueue queue2 = new CircularQueue(5);
        queue2.insert(4);
        queue2.insert(5);
        queue2.insert(6);
        queue2.insert(7);
        queue2.insert(8);
        queue2.display();
        System.out.println(queue2.remove());
        queue2.insert(89);
        queue2.display();


    }
}
