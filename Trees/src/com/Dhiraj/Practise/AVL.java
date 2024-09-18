package com.Dhiraj.Practise;

public class AVL {
    public class Node {
        int val;
        Node left;
        Node right;
        int height;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node root;

    public AVL() {

    }

    public int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public int height() {
        return height(this.root);
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void insert(int val) {
        this.root = insert(val, this.root);
    }

    private Node insert(int val, Node node) {
        if (node == null) {
            Node newNode = new Node(val);
            return newNode;
        }
        if (val < node.val) {
            node.left = insert(val, node.left);
        } else {
            node.right = insert(val, node.right);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;

        return rotate(node);
    }

    private Node rotate(Node node) {
        // 4 cases
        // left heavy
        if (height(node.left) - height(node.right) > 1) {
            // left-left case
            if (height(node.left.left) - height(node.left.right) > 0) {
                return rightRotate(node);
            }
            if (height(node.left.left) - height(node.left.right) < 0) {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }
        // right heavy
        if (height(node.right) - height(node.left) > 1) {
            if (height(node.right.right) - height(node.right.left) > 0) {
                return leftRotate(node);
            }
            if (height(node.right.right) - height(node.right.left) < 0) {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }
        return node;
    }

    private Node rightRotate(Node node) {
        Node c = node.left;
        Node t = c.right;
        c.right = node;
        node.left = t;
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;
        return c;
    }

    private Node leftRotate(Node node) {
        Node c = node.right;
        Node t = c.left;
        c.left = node;
        node.right = t;
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;
        return c;
    }

}
