package com.Dhiraj.Practise;

import com.Dhiraj.CustomLinkedList;

import java.util.Arrays;

public class LinkedList {
    public Node head;
    public Node tail;
    public int size;


    public LinkedList() {
        this.size = 0;
    }

    public void insertFirst(int [] array){
        Node node = new Node(array);
        node.next = head;
        head = node;
        if(tail == null){
            tail = head;
        }
        size += 1;
    }

    public void insertLast(int [] array){
        if(tail == null){
            insertFirst(array);
        }
        Node node = new Node(array);
        tail.next = node;
        tail = node;
        size ++;
    }

    public void insertInLL(int [] array, int location){
        Node node = new Node(array);
        if(location ==0){
            insertFirst(array);
            return;
        }else if(location == size){
            insertLast(array);
        }else{
            Node tempNode = head;
            for (int i = 0; i < location-1; i++) {
                tempNode = tempNode.next;
            }
            tempNode.next = node;
            node.next = tempNode.next.next;
        }

        size++;
    }

    public Node getNode (int location){
       Node node = head;
        for (int i = 0; i < location; i++) {
            node = node.next;
        }
        return node;
    }

    public int [] deleteFirst(){
        int [] arr = head.arr;
        head = head.next;
        if (head == null){
            tail = null;
        }
        size--;
        return arr;
    }

    public int [] deleteLast(){

        if(size <=1){
            return deleteFirst();
        }
       Node secondLast = getNode(size-2);
        int [] val = tail.arr;
        tail = secondLast;
        tail.next = null;
        return val;
    }

    public int [] delete(int index){
        if(index == 0){
            return deleteFirst();
        }
        if(index == size-1){
            return deleteLast();
        }else{
            System.out.println("Index out of bound for size "+size);
        }
        Node prev = getNode(index-1);
        int [] val = prev.next.arr;
        prev.next = prev.next.next;
        return val;
    }

    public void display(){
        Node tempNode = head;
        while(tempNode!=null){
            System.out.print(Arrays.toString(tempNode.arr)+" -> ");
            tempNode = tempNode.next;
        }
        System.out.println("END");
    }

}
