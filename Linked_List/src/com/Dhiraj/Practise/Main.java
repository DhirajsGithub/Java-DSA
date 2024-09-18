package com.Dhiraj.Practise;

public class Main {
    public static void main(String[] args) {
        LinkedList li = new LinkedList();
        int arr [] = {1, 2, 9};
        int arr2 [] = {3, 4, 3};
        int arr3 [] = {6, 7, 7998};
        int arr4 [] = {3, 4, 899};
        li.insertInLL(arr, 0);
        li.insertInLL(arr2, 0);
        li.insertInLL(arr3, 0);
        li.insertInLL(arr4, 0);
        li.display();
        sortAcc2ndIndex(li);
//        li.display();
        System.out.println(li.size);
        li.display();

        DLL dll = new DLL();
        dll.insertFirst(3);
        dll.insertFirst(6);
        dll.insertFirst(0);
        dll.insertFirst(2);
        dll.insertLast(99);
        dll.display();
    }

    public static void sortAcc2ndIndex(LinkedList li){
        boolean swapped;
        for (int i = 0; i < li.size; i++) {
            swapped = false;
            for (int j = 0; j < li.size-i; j++) {

                System.out.println("shit");
                Node f = li.getNode(j);
                Node s = li.getNode(j+1);

                    if( s!=null && f.arr[2] > s.arr[2]){
                        //swap

                        if(f == li.head){
                            li.head = s;
                            f.next = s.next;
                            s.next = f;
                        }else if(s == li.tail){
                            Node prev = li.getNode(j-1);
                            prev.next = s;
                            li.tail = f;
                            f.next = null;
                            s.next = f;

                        }else{
                            Node prev = li.getNode(j-1);
                            prev.next = s;
                            f.next = s.next;
                            s.next = f;

                        }
                        swapped = true;
                    }



            }
            if(!swapped){
                break;
            }
        }
    }
}
