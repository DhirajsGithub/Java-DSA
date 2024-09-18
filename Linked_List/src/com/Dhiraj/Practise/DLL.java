package com.Dhiraj.Practise;

public class DLL {
    private class Node{
        private int val;
        private Node next;
        private Node prv;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next, Node prv) {
            this.val = val;
            this.next = next;
            this.prv = prv;
        }
    }

    private Node head;
    public int size;

    public DLL() {
        this.size = 0;
    }

    public void insertFirst(int val){
        Node node = new Node(val);
        size++;
        if(head == null){
            head = node;
            return;
        }
        node.next = head;
        head.prv = node;
        head = node;

        return;

    }

    public void insertLast(int val){
        Node node = new Node(val);
        size++;
        if(head == null){
            head = node;
            return;
        }
        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
//        temp --> last node or tail node
        temp.next = node;
        node.prv = temp;
       return;

    }

    public void display(){
        Node temp = head;
        Node temp2 = temp;
        while (temp != null){
            System.out.print(temp.val + " -> ");
            temp2 = temp;
            temp = temp.next;
        }
//        temp2 --> is last node which is not null
        System.out.print("end");
        System.out.println();
        System.out.print("end <- ");
        do {
            System.out.print(temp2.val + " <- ");
            temp2 = temp2.prv;
        }while (temp2 != null);


    }

}
