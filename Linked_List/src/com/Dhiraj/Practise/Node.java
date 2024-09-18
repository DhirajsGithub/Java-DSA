package com.Dhiraj.Practise;

public class Node {
    Node next;
    int [] arr;

    public Node(int[] arr) {
        this.arr = arr;
    }

    public Node(Node next, int[] arr) {
        this.next = next;
        this.arr = arr;
    }
}
