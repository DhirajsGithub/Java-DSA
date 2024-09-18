package com.Dhiraj;

public class DoublyLL {
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

    private Node head;

    public void insertFirst(int val){
        Node node = new Node(val);       // for first node of the list head and tail will point to same node
        node.next = head;
        node.prev  = null ;         // since it's a first node
        if(head != null){
            head.prev = node;        // since it's a doubly LL
        }
        head = node;
    }

    public void display(){
        Node tempNode = head;
        Node last = null;
        while(tempNode != null){
            System.out.print(tempNode.val + " --> ");
            last = tempNode;
            tempNode = tempNode.next;
        }
        System.out.println("END");
        System.out.println("Print in reverse");
        while(last != null){
            System.out.print(last.val + " --> ");
            last = last.prev;
        }
        System.out.print("START");
    }

    public void insertLast(int val){
        Node node = new Node(val);
        Node last = head;     // temporary node

        node.next = null;       // property of a tail since node will be inserted at last

        // if list is empty
        if(head == null){
            node.prev = null;
            head = node;
            return;
        }

        while(last.next != null){
            last = last.next;
        }
        last.next = node;
        node.prev = last;

    }

    public Node find(int val){
        Node node = head;       // temp node
        while(node != null){
            if(node.val == val){
                return node;
            }
            node = node.next;
        }
        return null;
    }
    public void insert(int after, int val){
        Node p = find(after);
        if(p == null){
            System.out.println("Node value doen not exist");
            return;
        }
        Node node = new Node(val);
        node.next = p.next;
        p.next = node;
        node.prev = p;
        // avoiding null pointer error
        if(node.next != null){
            node.next.prev = node;
        }

    }


}
