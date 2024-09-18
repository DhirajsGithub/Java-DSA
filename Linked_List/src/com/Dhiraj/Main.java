package com.Dhiraj;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
	// in built linked list
        LinkedList<Integer> list = new LinkedList<>();
        list.add(46);
        list.add(33);

       list.push(78);
       int p = list.pop();
        list.pop();
        System.out.println(p);
        System.out.println("=");
        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }



        CustomLinkedList li = new CustomLinkedList();
        li.insertFirst(2);
        li.insertFirst(1);
        li.insertFirst(-9);
        li.insertFirst(0);
        li.insertFirst(3);


        li.insertLast(99);
        li.insert(89, 2);

//        li.deleteFirst();
//        li.deleteLast();
//
//        li.delete(1);

        li.display();
        System.out.println("li after sorting");
        li.bubbleSort();
        li.display();

     System.out.println("Q.1 insert in LL using recursion");
        li.insertRec2(-5, 6f, li.head);
        li.display();

        // merge two lists
        CustomLinkedList liA = new CustomLinkedList();
        liA.insertLast(1);
        liA.insertLast(2);
        liA.insertLast(5);

        CustomLinkedList liB = new CustomLinkedList();
        liB.insertLast(1);
        liB.insertLast(2);
        liB.insertLast(9);
        liB.insertLast(14);

        CustomLinkedList result = CustomLinkedList.mergeTwoLL(liA, liB);
        result.display();

        // reverse LL
        li.display();
        System.out.println("After reversing LL");
        li.reverseLL(li.head);
        li.display();

        System.out.println("=============");
        CustomLinkedList lic = new CustomLinkedList();
        lic.insertLast(1);
        lic.insertLast(0);
        lic.insertLast(1);
        System.out.println(lic.getDecimalValue(lic.head, 0));


    }
}


/*


|3| --> |4| --> |5| --> |6| --> null/None

first node i.e. 3 is known as the head of the linked list
each node points to the next node
last node is the tail of  linked list it points towards null of none
last node may be given is not then we can find it with node = null

Class Node {
    int val;
    Node next;
}
Node is an object which have a key called val and another key callled next which of type Node itself and it is like a reference varaible
with Node next we are connection all the Nodes as int a = 10, a being next,  int being Node, 10 being another node
node = node.next ==> changing the ref
node.somethng = somethng  ==> changing the original node

 */