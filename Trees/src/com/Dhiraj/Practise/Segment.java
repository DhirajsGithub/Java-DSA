package com.Dhiraj.Practise;

public class Segment {
    public class Node {
        int startIndex;
        int endIndex;
        int data;
        Node left;
        Node right;

        public Node(int val) {
            this.data = val;
        }

        public Node(int startIndex, int endIndex) {
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }

    }

    private Node root;

    public Segment(int[] arr) {
        this.root = segment(arr, 0, arr.length - 1);
    }

    private Node segment(int[] arr, int start, int end) {
        if (start == end) {
            Node newNode = new Node(start, end);
            newNode.data = arr[start];
            return newNode;
        }
        int mid = (start + end) / 2;
        Node node = new Node(start, end);
        node.left = segment(arr, start, mid);
        node.right = segment(arr, mid + 1, end);
        node.data = node.left.data + node.right.data;
        return node;
    }

    public void display() {
        display(this.root);
    }

    private void display(Node node) {
        String str = "";
        if (node.left != null) {
            str = str + "Interval=[" + node.left.startIndex + "--" + node.left.endIndex + "] and data: "
                    + node.left.data + "+ ->";
        } else {
            str = str + "No left child";
        }

        // for current node
        str = str + "Interval=[" + node.startIndex + "--" + node.endIndex + "] and data: " + node.data + "+ ->";

        if (node.right != null) {
            str = str + "Interval=[" + node.right.startIndex + "--" + node.right.endIndex + "] and data: "
                    + node.right.data + "+ ->";
        } else {
            str = str + "No left child";
        }

        System.out.println(str);

        if (node.left != null) {
            display(node.left);
        }
        if (node.right != null) {
            display(node.right);
        }

    }

    public int query(int qsi, int qei) {
        return this.query(this.root, qsi, qei);
    }

    private int query(Node node, int qsi, int qei) {
        // node is completely inside query index
        if (node.startIndex >= qsi && node.endIndex <= qei) {
            return node.data;
        }

        // node is completely outside query index
        else if (node.endIndex < qsi || node.startIndex > qei) {
            return 0;
        } else {
            // over lapping
            // go to bottom find above two cases
            return this.query(node.left, qsi, qei) + this.query(node.right, qsi, qei);
        }

    }

    public void update(int index, int value) {
        this.root.data = update(this.root, index, value);
    }

    private int update(Node node, int index, int val) {
        if (index >= node.startIndex && index <= node.endIndex) {

            // reach leaf
            if (index == node.startIndex && index == node.endIndex) {
                node.data = val;
                return node.data;
            } else {
                int left = update(node.left, index, val);
                int right = update(node.right, index, val);
                node.data = left + right;
                return node.data;
            }

        }
        return node.data;
    }

}
