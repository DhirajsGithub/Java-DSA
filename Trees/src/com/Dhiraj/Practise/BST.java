package com.Dhiraj.Practise;

import java.util.LinkedList;
import java.util.Queue;

public class BST {
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

    public boolean isEmpty() {
        return this.root == null;
    }

    public int heightOfTree() {
        return heightOfTree(this.root);
    }

    private int heightOfTree(Node root) {
        if (root == null) {
            return -1;
        }
        int left = heightOfTree(root.left);
        int right = heightOfTree(root.right);
        return Math.max(left, right) + 1;
    }

    private int getHeight(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public void insert(int val) {
        root = insert(this.root, val);
    }

    private Node insert(Node root, int val) {

        if (root == null) {
            Node newNode = new Node(val);
            return newNode;
        }
        if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        return root;
    }

    public boolean balanced() {
        return balanced(this.root);
    }

    private boolean balanced(Node node) {
        if (node == null) {
            return true;
        }
        return Math.abs(getHeight(node.left) - getHeight(node.right)) <= 1 && balanced(node.left)
                && balanced(node.right);
    }

    public void display() {
        display(this.root, 0);
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

    public void populate(int[] sortedArray) {
        populate(sortedArray, 0, sortedArray.length);

    }

    private void populate(int[] sortedArray, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        this.insert(sortedArray[mid]);
        populate(sortedArray, start, mid);
        populate(sortedArray, mid + 1, end);
    }

    public void preorder() {
        preorder(this.root);
    }

    private void preorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        preorder(node.left);
        preorder(node.right);
    }

    public void bfs() {
        bfs(this.root);
    }

    private void bfs(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.print(cur.val + " ");
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }

    // search in BST
    public Node searchInBST(int val) {
        return searchInBST(this.root, val);
    }

    private Node searchInBST(Node node, int val) {
        if (node == null) {
            return null;
        }
        if (node.val == val) {
            return node;
        }
        if (val > node.val) {
            return searchInBST(node.right, val);
        } else {
            return searchInBST(node.left, val);
        }
    }

    public Node minNodeInBST() {
        return minNodeInBST(this.root);
    }

    private Node minNodeInBST(Node node) {
        while (node != null && node.left != null) {
            node = node.left;
        }
        return node;

    }

    public Node maxNodeInBST() {
        return maxNodeInBST(this.root);
    }

    private Node maxNodeInBST(Node root) {
        if (root == null) {
            return null;
        }
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    public Node deleteInBST(int val) {
        return deleteInBST(this.root, val);
    }

    private Node deleteInBST(Node node, int val) {
        if (node == null) {
            return null;
        }
        if (node.val < val) {
            node.right = deleteInBST(node.right, val);
        } else if (node.val > val) {
            node.left = deleteInBST(node.left, val);
        } else {
            if (node.left != null && node.right != null) {
                Node max = maxNodeInBST(node.left);

                node.val = max.val;
                node.left = deleteInBST(node.left, val);
            } else if (node.left != null) {
                node = node.left;
            } else if (node.right != null) {
                node = node.right;
            } else {
                node = null;
            }
        }
        return node;

    }

}
