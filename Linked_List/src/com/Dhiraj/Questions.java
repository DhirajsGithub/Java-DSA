package com.Dhiraj;

public class Questions {

    // https://leetcode.com/problems/linked-list-cycle
    // Amazon and Microsoft
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    // find length of the cycle
    public int lengthCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                // calculate the length
                ListNode temp = slow;
                int length = 0;
                do {
                    temp = temp.next;
                    length++;
                } while (temp != slow);
                return length;
            }
        }
        return 0;
    }

    // https://leetcode.com/problems/linked-list-cycle-ii/
    public ListNode detectCycle(ListNode head) {
        int length = 0;

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                length = lengthCycle(slow);
                break;
            }
        }

        if (length == 0) {
            return null;
        }

        // find the start node
        ListNode f = head;
        ListNode s = head;

        while (length > 0) {
            s = s.next;
            length--;
        }

        // keep moving both forward and they will meet at cycle start
        while (f != s) {
            f = f.next;
            s = s.next;
        }
        return s;
    }

    // Google: https://leetcode.com/problems/happy-number/
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        } while (slow != fast);

        if (slow == 1) {
            return true;
        }
        return false;
    }
    private int findSquare(int number) {
        int ans = 0;
        while (number > 0) {
            int rem = number % 10 ;
            ans += rem * rem;
            number /= 10;
        }
        return ans;
    }


    // https://leetcode.com/problems/middle-of-the-linked-list/submissions/
    public ListNode middleNode(ListNode head) {
        ListNode s = head;
        ListNode f = head;

        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }
        return s;
    }


    // https://leetcode.com/problems/reverse-linked-list/submissions/
    // google, apple, amazon, microsoft
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode prev = null;
        ListNode present = head;
        ListNode next = present.next;

        while (present != null) {
            present.next = prev;
            prev = present;
            present = next;
            if (next != null) {
                next = next.next;
            }
        }
        return prev;
    }


//    https://leetcode.com/problems/reverse-linked-list-ii/

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right){
            return head;
        }
        ListNode current = head;
        ListNode prev = null;
        for (int i = 0; current!=null && i < left-1; i++) {
            prev = current;
            current = current.next;
        }
        ListNode last = prev;
        ListNode newEnd = current;

        // use pen and paper asshole
        // from left to right just doing normal reverse linked list then with help of last and newEnd we are connection left and right part alternatively
        // swapping
        ListNode next = current.next;     // next will be left now
        for (int i = 0; current!=null && i < right-left+1; i++) {
            current.next = prev;
            prev = current;
            current = next;
            if(next != null){
                next = next.next;
            }
        }

        if(last != null){
            last.next = prev;
        }else{
            head = prev;
        }
        newEnd.next = current;
        return head;
    }


//    https://leetcode.com/problems/palindrome-linked-list/
    public boolean isPalindrome(ListNode head) {
        // reverse the second half of the linked list and compare with first half
        ListNode mid = middleNode(head);
        ListNode headSecond = reverseList(mid);
        ListNode reverseHead = headSecond;

        // compare both halves
        while(head != null || headSecond!= null){
            if(head.val != headSecond.val){
                break;
            }
            head = head.next;
            headSecond = headSecond.next;

        }
        reverseList(reverseHead);

        return head == null || headSecond == null;

//        return false;
    }


//    https://leetcode.com/problems/reorder-list/
    // since we cannot move backwards in singlyLL the concept is that reverse a linkedList by half and the move start and mid ++ with swapping
    public void reorderList(ListNode head) {
        ListNode midNode = middleNode(head);
        ListNode startSec = reverseList(midNode);
        ListNode start = head;

        while(start != null && startSec != null){

            ListNode tempNode = start.next;
            start.next = startSec;
            start = tempNode;

            tempNode = startSec.next;
            startSec.next = start;
            startSec = tempNode;
        }

        // next of tail to null
        if(start != null){
            start.next = null;
        }

    }

//    https://leetcode.com/problems/reverse-nodes-in-k-group/
    public ListNode reverseKGroup(ListNode head, int k) {
        // same problem as reverse between
        if(k<=1 || head == null){
            return head;
        }


        ListNode current = head;
        ListNode prev = null;

        while(true){
            ListNode last = prev;
            ListNode newEnd = current;

            // use pen and paper asshole
            // from left to right just doing normal reverse linked list then with help of last and newEnd we are connection left and right part alternatively
            // swapping
            ListNode next = current.next;     // next will be left now
            // first k half will get reverse
            for (int i = 0; current!=null && i < k; i++) {
                current.next = prev;
                prev = current;
                current = next;
                if(next != null){
                    next = next.next;
                }
            }

            if(last != null){
                last.next = prev;
            }else{
                head = prev;
            }
            newEnd.next = current;
            if(current == null){
                break;
            }



        }
        return head;

    }
//    https://leetcode.com/problems/rotate-list/
    public ListNode rotateRight(ListNode head, int k) {

        // just connect proper newlast
        if (k <= 0 || head == null || head.next == null) {
            return head;
        }

        ListNode last = head;
        int length = 1;
        while (last.next != null) {
            last = last.next;
            length++;
        }

        last.next = head;
        int rotations = k % length;
        int skip = length - rotations;
        ListNode newLast = head;
        for (int i = 0; i < skip - 1; i++) {
            newLast = newLast.next;
        }
        head = newLast.next;
        newLast.next = null;

        return head;


//        if(head == null || head.next==null || k==0){
//            return head;
//        }
//
//        ListNode tempNode = head;
//        int m = 0;
//        while (tempNode.next != null){
//            m++;
//            tempNode =tempNode.next;
//        }
//        m ++;  // size
//    //        tempNode now is tail
//
//        int r = k<=m ? k : k%m;
//
//        for (int i = 0; i < r; i++) {
//            ListNode lastSec = null;
//            ListNode last = head;
//            while (last.next != null){
//                lastSec = last;
//                last = last.next;
//            }
//
//            last.next = head;
//            if(lastSec != null){
//                lastSec.next = null;
//            }
//
//            head = last;
//        }
//        return head;

    }

    public ListNode getNode(int index, ListNode head) {
        ListNode node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

}


class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    ListNode(int x) {
        val = x;
        next = null;
    }
}

/*
most important
- In place reversal of linked list questions
- cycle detectation
- recursio in linked list
- fast and slow pointers

other questions are in CustomLinkedList class
 */