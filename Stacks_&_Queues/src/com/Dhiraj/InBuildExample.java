package com.Dhiraj;

import java.util.*;

public class InBuildExample {
    public static void main(String[] args) {
        // Stack : First in Last Out
        // internal stack
        Stack <Integer> stack = new Stack<>();    // it's a class
        stack.add(34);
        stack.add(3);
        stack.add(-23);
        stack.add(67);


        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());


        // Queues : First in First Out
        // internal queues
        Queue<Integer> queue = new LinkedList<>();      // queue is an interface
        queue.add(3);
        queue.add(45);
        queue.add(90);
        queue.add(-34);
        System.out.println(queue.peek());
        System.out.println(queue.remove());

        // Deque : Since Deque supports both stack and queue operations, it can be used as both.
        Deque<Integer> deque = new ArrayDeque<>();

        deque.add(45);
        deque.addFirst(1);
        deque.addLast(-34);
        deque.add(3434);
        System.out.println(deque.remove());     // first elmetn will be removed
        System.out.println(deque.removeFirst());
        System.out.println(deque.removeLast());


    }
}


/*
When to use stack and queues :
binary tree traversal and stuff
when we convert recursion to iteration
stack : triggered to implement the undo functionality.
stack : “Back” buttons for navigation
stack : Chronological news feeds behave in a LIFO manner to ensure the latest item is at the top of the feed, hence a stack can be used for this.
queue : Backend task management where operations are handled in a queue-like manner — such as API calls, database writes and pub/sub messaging systems.
queue : Alert and notification systems tend to have a FIFO behaviour, hence a queue can be used to build this.

// Deque :
we can add or remove the element from top and bottom i.e. both the sides
null elements are not allowed in this
no thread safe
no capacity restrictions
it is faster than linkedlist and stacks
use : in trees bfs and tfs
 */









