package com.Dhiraj.BinaryTree;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // --------------- BT --------------
//        Scanner scanner = new Scanner(System.in);
//        BinaryTree tree = new BinaryTree();
//        tree.populate(scanner);
//        tree.display();

        // -------------- BST -------------
        BST bt = new BST();
        int nums[] = {5, 2, 7, 1, 4, 6, 9, 8, 3, 10};
        bt.populate(nums);
        bt.display();
        bt.BFS();
        
      


        AVL avlTree = new AVL();
        for (int i = 0; i < 10000; i++) {
            avlTree.insert(i);
        }
        System.out.println("AVL tree height "+ avlTree.height());


        int arr2[] = {3, 8, 6, 7, -2, -8, 4, 9};
        SegmentTree segmentTree = new SegmentTree(arr2);
        segmentTree.display();
    }
}
