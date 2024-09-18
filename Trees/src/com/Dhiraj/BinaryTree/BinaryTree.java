package com.Dhiraj.BinaryTree;

import java.util.Scanner;
import java.util.Stack;

public class BinaryTree {

    public BinaryTree() {

    }

    private static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    // insert elements
    public void populate(Scanner scanner){
        System.out.println("enter root node ");
        int value = scanner.nextInt();
        root = new Node(value);
        populate(scanner, root);
    }

    private void populate(Scanner scanner, Node node) {
        System.out.println("Do you want to enter left of "+ node.value);
        boolean left = scanner.nextBoolean();
        if(left){
            System.out.println("Enter the value of the left of " + node.value);
            int value = scanner.nextInt();
            Node newNode = new Node(value);
            node.left = newNode;
            populate(scanner, node.left);
        }

        System.out.println("Do you want to enter Right of "+ node.value);
        boolean right = scanner.nextBoolean();
        if(right){
            System.out.println("Enter the value to right of " + node.value);
            int value = scanner.nextInt();
            Node newNode = new Node(value);
            node.right = newNode;
            populate(scanner, node.right);
        }
    }

    public void display(){
        display(root, 0);
    }

    private void display(Node node, int level) {
        if(node == null){
            return;
        }
        display(node.right, level+1);
        if(level != 0){
            // horizontal space
            for (int i = 0; i < level-1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|---->"+node.value);
        }else{
            System.out.println(node.value);     // root node
        }
        display(node.left, level+1);        // when this line hits, then that node will be pop from stack
    }


    public void preOrderTraversal(){
        preOrderTraversal(root);
    }

    private void preOrderTraversal(Node node) {
        if(node == null){
            return;
        }
        System.out.println(node.value + " -> ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);      // when this line hits, then that node will be pop from stack
        // note where that node is being called and when it finishes all it's stack data then it will come to bottom
    }

    public void inOrderTraversal(){
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node node) {
        if(node == null){
            return;
        }
        inOrderTraversal(node.left);
        System.out.println(node.value + " -> ");
        inOrderTraversal(node.right);
    }

    public void postOrderTraversal(){
        postOrderTraversal(root);
    }

    private void postOrderTraversal(Node node) {
        if(node == null){
            return;
        }
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.println(node.value + " -> ");
    }


}
