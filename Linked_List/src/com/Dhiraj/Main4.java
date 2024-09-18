package com.Dhiraj;

public class Main4 {
    public static void main(String[] args) {
        CircularDoublyLL li = new CircularDoublyLL();
        li.insertInCDLL(0, 1);
        li.insertInCDLL(2, 2);
        li.insertInCDLL(1, 3);
        li.insertInCDLL(3, 4);

        li.display();
        li.deleteInCDLL(34);
        li.deleteCDLL();
        li.display();


    }
}
