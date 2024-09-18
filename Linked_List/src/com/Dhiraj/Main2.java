package com.Dhiraj;

public class Main2 {
    public static void main(String[] args) {
        DoublyLL list = new DoublyLL();
        list.insertFirst(2);
        list.insertFirst(3);
        list.insertFirst(4);
        list.insertFirst(5);

        list.insertLast(99);

        list.insert(4, 69);

        list.display();


    }
}
