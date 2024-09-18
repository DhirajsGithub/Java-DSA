package com.Dhiraj.BinaryTree;

public class SegmentTree {

    private static class Node {
        // initially it is zero
        int data;
        int startInterval;
        int endInterval;
        Node left;
        Node right;

        public Node(int startInterval, int endInterval) {
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }

    Node root;

    public SegmentTree(int arr[]) {
        // create a segment tree using provided array
        // it will take O(N) time as we need to create every single node
        this.root = constructTree(arr, 0, arr.length - 1);
    }

    private Node constructTree(int arr[], int start, int end) {
        if (start == end) {
            // leaf node, we reach at the leaf node of tree
            Node leaf = new Node(start, end);
            leaf.data = arr[start];
            return leaf;
        }

        // create new node with index you are at
        Node node = new Node(start, end);
        int mid = (start + end) / 2;
        node.left = constructTree(arr, start, mid);
        node.right = constructTree(arr, mid + 1, end);
        node.data = node.left.data + node.right.data;
        return node;
    }

    public void display() {
        display(this.root);
    }

    private void display(Node node) {
        String str = "";
        if (node.left != null) {
            str = str + "Interval=[" + node.left.startInterval + "--" + node.left.endInterval + "] and data: "
                    + node.left.data + "+ ->";
        } else {
            str = str + "No left child";
        }

        // for current node
        str = str + "Interval=[" + node.startInterval + "--" + node.endInterval + "] and data: " + node.data + "+ ->";

        if (node.right != null) {
            str = str + "Interval=[" + node.right.startInterval + "--" + node.right.endInterval + "] and data: "
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

    // query
    // for finding sum in given range
    public int query(int qsi, int qei) {
        return this.query(this.root, qsi, qei);
    }

    private int query(Node node, int qsi, int qei) {
        // case 1:
        // Node is completely lying inside query interval
        if (node.startInterval >= qsi && node.endInterval <= qei) {
            return node.data;
        }
        // case 2:
        // Node interval is completely outside query interval
        else if (node.startInterval > qei || node.endInterval < qsi) {
            return 0;
        } else {
            // case 3:
            // Overlapping
            // go to bottom bottom- find above two cases
            return this.query(node.left, qsi, qei) + this.query(node.right, qsi, qei);
        }
    }

    // update
    public void update(int index, int value) {
        this.root.data = update(this.root, index, value);
    }

    private int update(Node node, int index, int value) {
        if (index >= node.startInterval && index <= node.endInterval) {
            // reached the reaf node
            if (index == node.startInterval && index == node.endInterval) {
                node.data = value;
                return node.data;
            }
            // we haven't arrived at the leaf, dig dipper
            else {
                int leftAns = update(node.left, index, value); // image as going left left it will find index ==
                                                               // node.startInterval && index == node.endInterval
                                                               // condition and will return the new value of node
                int rightAns = update(node.right, index, value);

                node.data = leftAns + rightAns;
                return node.data;
            }
        }

        return node.data;
    }

}
