package com.Dhiraj;

public class CircularDoublyLL {
    private class Node{
        int val;       // this is 0 by default
        Node prev;     // by default this are null
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node prev, Node next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }

    public Node head;
    public Node tail;
    public int size;

    public Node CreateCDLL(int val){
        Node newNode = new Node(val);
        head = newNode;
        newNode.next = newNode;
        newNode.prev = newNode;
        tail = newNode;
        size = 1;
        return head;
    }

    public void insertInCDLL(int location, int val){
        Node newNode = new Node(val);
        if(head == null){
            CreateCDLL(val);
            return;
        }else if(location ==0){
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
            head = newNode;
            tail.next = head;
        }else if(location >= size){
            tail.next = newNode;
            newNode.prev = tail;
            newNode.next = head;
            head.prev = newNode;
            tail = newNode;
        }else{
            Node tempNode = head;
            for (int i = 0; i < location-1; i++) {
                tempNode = tempNode.next;
            }
            newNode.next = tempNode.next;
            newNode.prev = tempNode;
            tempNode.next = newNode;
            newNode.next.prev = newNode;
        }
        size ++;
    }

    public void display(){
        if(head == null){
            System.out.println("List is Empty");
            return;
        }
        System.out.print("HEAD --> ");
        Node tempNode = head;
        for (int i = 0; i < size; i++) {
            System.out.print(tempNode.val+" --> ");
            tempNode = tempNode.next;
        }
        System.out.println("TAIL");

        System.out.print("TAIL --> ");
        Node last =  tail;
        for (int i = 0; i < size; i++) {
            System.out.print(last.val + " --> ");
            last = last.prev;
        }
        System.out.println("HEAD");
    }

    public void deleteInCDLL(int location){
        if(head == null){
            System.out.println("List is Empty");
        }
        else if(location == 0){
            if(size == 1){
                head.next = null;
                head.prev = null;
                head = null;
                tail = null;
                size --;
                return;
            }
            head = head.next;
            head.prev = tail;
            tail.next = head;
            size --;
        }else if(location >= size){
            if(size == 1){
                head.next = null;
                head.prev = null;
                head = null;
                tail = null;
                size --;
                return;
            }
            tail = tail.prev;
            tail.next = head;
            head.prev = tail;
            size --;
        }else {
            Node tempNode = head;
            for (int i = 0; i < location-1; i++) {
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            tempNode.next.prev = tempNode;
            size--;
        }
    }

    public void deleteCDLL(){
        Node tempNode = head;
        for (int i = 0; i < size; i++) {
            tempNode.prev = null;
            tempNode =tempNode.next;
        }
        head = null;
        tail = null;
    }
}















