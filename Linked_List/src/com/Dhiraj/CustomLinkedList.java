package com.Dhiraj;

import java.util.HashSet;

public class CustomLinkedList {

    // a box where we can store our element
    private class Node {
        
        // value of it's own
        private int value;
        
        // reference to another node to join a linked list
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public Node head;
    private Node tail;

    private int size;

    public CustomLinkedList() {
        this.size = 0;
    }

    // inserting node at first i.e. head
    public void insertFirst (int val){
        Node node = new Node(val);
        node.next = head;
        head = node;

        // if there is only one node then head and tail will be at same node
        if(tail == null){
            tail = head;
        }
        size += 1;
    }

    // inserting at the last
    public void insertLast (int val){
        // list is empty
        if(tail == null){
            insertFirst(val);
        }

        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size ++;
    }

    public void insert(int val, int index){
        if(index == 0){
            insertFirst(val);
            return;
        }
        if(index == size){
            insertLast(val);
        }else if(index > size){
            System.out.println("Index out of bound for size "+size);
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node node = new Node(val, temp.next);
        temp.next = node;
        size ++;
    }



    public Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    // find the node that has this value   // with complexity O(N)
    public Node find(int val) {
        Node node = head;
        while (node != null){
            if(node.value == val){
                return node;
            }
            node = node.next;
        }
        return null;
    }

    // delete first node
    public int deleteFirst(){
        int val = head.value;
        head = head.next;
        if(head == null){
            tail = null;
        }
        size --;
        return val;
    }

    // delete last node
    public int deleteLast(){
        if(size <=1){
            return deleteFirst();
        }

        Node secondLast = get(size-2);
        int val = tail.value;
        tail = secondLast;
        tail.next = null;
        return val;
    }

    // delete node of particular index
    public int delete (int index){
        if(index == 0){
            return deleteFirst();
        }
        if(index == size-1){
            return deleteLast();
        }else{
            System.out.println("Index out of bound for size "+size);
        }
        Node prev = get(index-1);
        int val = prev.next.value;
        prev.next = prev.next.next;
        return val;
    }

    // display singly linked list
    public void display (){
        // creating a new ref variable temp to move it as we don't want to change the original head of linked list
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value +" -> " );
            temp = temp.next;

        }
        System.out.println("END");
    }



    // QUESTIONS

    // void return type and make change in LL
    public void insertRec2(int val, int index, Node currentNode){
        if(index == 0){
            Node node = new Node(val, currentNode.next);
            node.next = head;
            head = node;
            return;
        }
        if(index-1 == 0){
            Node node = new Node(val, currentNode.next);
            currentNode.next = node;
            return;
        }
        insertRec2(val, index-1, currentNode.next);
    }

    // node return type that returns the LL node to change the structure
    // insert using recursion concept
    public void insertRec(int val, int index){
        head = insertRec(val, index, head);  // head pointing to head
    }
    // 1->2->3->4->5     // we are inserting at index 3 then if index==0 temp will have node 3 and it will return a new Node of value val
    private Node insertRec(int val, int index, Node node){
        if(index == 0){
            Node temp = new Node(val, node);
            // temp.value = val  and temp.next = node  by constructor of Node class
            size ++;
            return temp;
        }
        // making a ref link with node.next
        node.next = insertRec(val, index-1, node.next);     // it will always be a head as first in last out stack
        return node;
    }

//    https://leetcode.com/problems/remove-duplicates-from-sorted-list/
    // remove duplicates from sorted LL and return the head Node
    public Node remDuplicate(){
        Node node = head;
        while (node.next != null){
            if(node.value == node.next.value){
                node.next = node.next.next;
                size --;
            }else{
                node = node.next;
            }
        }
        tail = node;
        tail.next = null;
        return head;
    }

    // merge two linked list according to their values sorted
//    https://leetcode.com/problems/merge-two-sorted-lists/submissions/1127221709/
    public static CustomLinkedList mergeTwoLL(CustomLinkedList first, CustomLinkedList second){
        Node f = first.head;
        Node s = second.head;

        CustomLinkedList ans = new CustomLinkedList();

        while (f != null && s != null) {
            if (f.value < s.value) {
                ans.insertLast(f.value);
                f = f.next;
            } else {
                ans.insertLast(s.value);
                s = s.next;
            }
        }

        while (f != null) {
            ans.insertLast(f.value);
            f = f.next;
        }

        while (s != null) {
            ans.insertLast(s.value);
            s = s.next;
        }

        return ans;
    }

    // with O(N) time complexity
    public boolean hasCycle(Node head) {
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }

    // find length of the cycle
    public int lengthOfCycle(Node head) {
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                int length = 0;
                Node temp = slow;
                do{
                    temp = temp.next;
                    length ++;
                }while(temp != slow);

                return length;
            }
        }
        return 0;
    }

//    https://leetcode.com/problems/linked-list-cycle-ii/
    public Node detectCycle(Node head) {
        int length = lengthOfCycle(head);
        if(length == 0){
            return null;
        }
        // cycle present
        Node p1 = head;
        Node p2 = head;
        // the concept is that we have to make p1 and p2 to meet at certain node such that from that node cycle is getting started
        // so we will move p2 to length first the we will move p2 and p1 one by one until they meet, and they will meet at point where cycle si getting started
        for (int i = 0; i < length; i++) {
            p2 = p2.next;
        }
        while (p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

//    https://leetcode.com/problems/happy-number/description/
    public boolean isHappy(int n) {
        // fast and slow pointers
        // the numbers will convergence to 1 or a number which was alreasy being appeared
        // hence used a LL cycle detection method
        int slow = n;
        int fast = n;
        do{
            slow = sumDigitsSqr(slow);
            fast = sumDigitsSqr(sumDigitsSqr(fast));
        }while(slow != fast);

        if(slow == 1){
            return true;
        }
        return false;

    }
    static int sumDigitsSqr(int n){
        int sum =0;
        while(n>0){
            sum += (n%10)*(n%10);
            n = n/10;
        }
        return sum;
    }

    // using hastset
//    public boolean isHappy(int n) {
//        HashSet<Integer> hs = new HashSet<>();
//        int num = n;
//        while (true){
//            int sum = 0;
//            while (num>0){
//                int last = num%10;
//                sum += last*last;
//                num = num/10;
//            }
//            System.out.println(sum);
//            num = sum;
//            if(hs.contains(sum)){
//                return false;
//            }else{
//                hs.add(sum);
//            }
//            if(sum == 1){
//                return true;
//            }
//        }
//    }


//    https://leetcode.com/problems/middle-of-the-linked-list/
    public Node middleNode(Node head) {
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


//    https://leetcode.com/problems/sort-list/description/
    // bubble sort
    public void bubbleSort(){
        bubbleSort(size-1, 0);
    }
    private void bubbleSort(int row, int col){
        if(row == 0){
            return;
        }
        if(col < row){
            Node first = get(col);
            Node second = get(col + 1);

            if(first.value > second.value){
                // swap
                // three conditions
                if(first == head){
                    head = second;
                    first.next = second.next;
                    second.next = first;
                }else if(second == tail){
                    Node prev = get(col - 1);
                    prev.next = second;
                    tail = first;
                    first.next = null;
                    second.next = first;
                }else{
                    Node prev = get(col - 1);
                    prev.next = second;
                    first.next = second.next;
                    second.next = first;
                }

            }
            bubbleSort(row, col + 1);
        }else{
            bubbleSort(row-1, 0);
        }

    }

//    private void bubbleSort(int row, int col){
////       start   row = arr.length-1   col = 0
//        if(row == 0){
//            return;
//        }
//        if(row < col){
//            Node first = get(col);
//            Node second = get(col+1);
//            if(first.value > second.value){
//                // swap
//                if(second.next != null){
//                    first.next = second.next;
//                }
//                second.next = first;
//                if(head == first){
//                    head = second;
//                }else if(second == tail){
//                    Node prev = get(col-1);
//                    prev.next = second;
//                    second.next = first;
//                    tail = first;
//                    tail.next = null;
//                }
//
//
//            }
//        }
//
//
//    }

    // Reverse a linked List using recursion
    public void reverseLL(Node node){
        if(node == tail){
            head = tail;
            return;
        }
        reverseLL(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;

    }

    // Reverse a linked list using loop, two pointers
    public void reverseLLRec(Node node){
        // node is head
        // only one node is presenet or list is empty
        if(node == null){
            return;
        }
        // Node preve node
        Node prev = null;
        Node present = node;
        // Node next to node
        Node next = present.next;

        tail = node;

        while(present != null){
            present.next = prev;
            prev = present;
            present = next;
            if(next != null){
                next = next.next;
            }
        }

        head = prev;
    }


//    https://leetcode.com/problems/reverse-linked-list-ii/
    public Node reverseBetween(Node head, int left, int right) {
        if(left == right){
            return head;
        }
        // atleast 2 nodes
        Node prv = null;
        Node cur = head;
        for (int i = 0; cur !=null && i < left-1; i++) {
            prv = cur;
            cur = cur.next;
        }

        Node newEnd = cur;
        Node last = prv;
        Node next = cur.next;
        for (int i = 0; i < right-left+1; i++) {
            cur.next = prv;
            prv = cur;
            cur = next;
            if(next != null){
                next = next.next;
            }
        }
        if(last != null){
            last.next = prv;
        }else{
            head = prv;
        }
        newEnd.next = cur;
        return head;
    }

//    https://leetcode.com/problems/reorder-list/description/
    public void reorderList(Node head) {
        Node middle = getMiddleNode(head);
        reverseLLRec(middle);
        Node hs = getMiddleNode(head);
        Node hf = head;
        while (hf != null && hs != null){
            Node temp = hf.next;
            hf.next = hs;
            hf = temp;

            temp = hs.next;
            hs.next = hf;
            hs = temp;
        }

        if(hf != null){
            hf.next = null;
        }
    }

    private Node getMiddleNode(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public int getDecimalValue(Node head, int ans) {
        Node tempNode = head;
        int n = size(head);
        for(int i = n-1; i>=0; i--){
            int mul = (int)Math.pow(2, i);
            ans = ans + tempNode.value*mul;
//            System.out.println(ans);
            System.out.println(tempNode.value);
            
        }

        return ans;
    }

    public int size(Node head){
        Node tempNode = head;
        int size = 0;
        while(tempNode != null){
            size ++;
            tempNode = tempNode.next;
        }
        return size;
    }


}
/*
Forget about the solution draw the LL, how it will look like in the end

https://leetcode.com/problems/linked-list-cycle/submissions/
The fast and slow pointer technique (also known as the tortoise and hare algorithm) uses two pointers to determine traits about directional data structures.
 This can be an array, singly-linked list, or a graph. It is often applied to determine if there are any cycles in the data structure and is therefore
  also known as Floyd’s Cycle Detection Algorithm.
Slow pointer and fast pointer are simply the names given to two pointer variables. The only difference is that,
slow pointer travels the linked list one node at a time where as a fast pointer travels the linked list two nodes at a time.
USE : Cycle detection, finding a node, etc

// with O(N) time complexity
   public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }

    // find length of the cycle
   public int lengthOfCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                int length = 0;
                Node temp = slow;

                do{
                    temp = temp.next;
                    length ++;
                }while(temp != slow);

                return length;
            }
        }
        return length;
    }

 https://leetcode.com/problems/linked-list-cycle-ii/

 https://leetcode.com/problems/happy-number/

 https://leetcode.com/problems/sort-list/

 */
