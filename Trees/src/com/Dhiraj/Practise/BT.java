package com.Dhiraj.Practise;

import java.util.Scanner;

public class BT {
    private class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node root;

    public void populate(Scanner scanner) {
        System.out.println("insert root node ");
        int val = scanner.nextInt();
        root = new Node(val);
        populate(scanner, root);
    }

    private void populate(Scanner scanner, Node node) {
        System.out.println("Do you want to enter Left of " + node.val);
        boolean left = scanner.nextBoolean();
        if (left) {
            System.out.println("Enter the value to left of " + node.val);
            int val = scanner.nextInt();
            Node newNode = new Node(val);
            node.left = newNode;
            populate(scanner, node.left);
        }
        System.out.println("Do you want to enter Right of " + node.val);
        boolean right = scanner.nextBoolean();
        if (right) {
            System.out.println("Enter the value to right of " + node.val);
            int value = scanner.nextInt();
            Node newNode = new Node(value);
            node.right = newNode;
            populate(scanner, node.right);
        }
    }

    public void display() {
        display(root, 0);

    }

    private void display(Node node, int level) {
        if (node == null) {
            return;
        }
        display(node.right, level + 1);
        if (level != 0) {
            for (int index = 0; index < level - 1; index++) {
                System.out.print("|\t\t");
            }
            System.out.println("|---->" + node.val);
        } else {
            System.out.println(node.val);
        }
        display(node.left, level + 1);
    }

}
