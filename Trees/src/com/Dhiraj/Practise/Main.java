package com.Dhiraj.Practise;

import java.util.Scanner;

import com.Dhiraj.Practise.BST.Node;

public class Main {
    public static void main(String[] args) {
        BST bt = new BST();
        int nums[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        // bt.populate(nums);
        // bt.display();
        // bt.deleteInBST(5);
        // bt.deleteInBST(9);
        // bt.deleteInBST(2);
        // System.out.println("----");
        // bt.display();
        // bt.preorder();
        // System.out.println();
        // bt.bfs();
        // Node serch = bt.searchInBST(8);
        // System.out.println(serch.val);
        // Node min = bt.minNodeInBST();
        // Node max = bt.maxNodeInBST();
        // System.out.println("min : " + min.val + " max: " + max.val);

        // AVL avlTree = new AVL();
        // for (int i = 0; i < 10000000; i++) {
        // avlTree.insert(i);
        // }
        // System.out.println("AVL tree height " + avlTree.height());

        int arr2[] = { 3, 8, 6, 7, -2, -8, 4, 9 };
        Segment segmentTree = new Segment(arr2);
        segmentTree.display();
        System.out.println(segmentTree.query(2, 6));
        segmentTree.update(5, 100);
        System.out.println(segmentTree.query(2, 6));

    }
}
