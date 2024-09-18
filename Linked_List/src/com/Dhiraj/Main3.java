package com.Dhiraj;

public class Main3 {
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        list.insert(2);
        list.insert(4);
        list.insert(6);
        list.insert(8);
        list.insert(10);

        list.display();
        list.delete(8);

        list.display();
    }
}
