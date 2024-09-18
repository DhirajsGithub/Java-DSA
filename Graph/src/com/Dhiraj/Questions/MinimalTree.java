package com.Dhiraj.Questions;

/*
Given a sorted (increasing order) array with unique integer elements, write an algorithm to create a binary search tree with minimal height.
 */

public class MinimalTree {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6};
        MinimalTree tree = new MinimalTree();
        tree.createMinimalBST(arr);
        tree.displayTree();
    }
    public class TreeNode {
        public int data;
        public TreeNode left;
        public TreeNode right;
        public TreeNode parent;
        public int size = 0;

        public TreeNode(int d) {
            data = d;
            size = 1;
        }

        @Override
        public String toString(){
            return this.data+"";
        }

    }
    TreeNode root;
    public TreeNode createMinimalBST(int[] array) {
        TreeNode node;
        root = createMinimalBSTHelper(array, 0, array.length, null);
        return root;

    }

    private TreeNode createMinimalBSTHelper(int[] array, int i, int end, TreeNode parent) {
        if(end <= i){
            return null;
        }

        int mid = i + (end-i)/2;
        TreeNode newNode = new TreeNode(array[mid]);
        newNode.parent = parent;
        newNode.data = array[mid];
        newNode.left = createMinimalBSTHelper(array, i, mid, newNode);
        newNode.right = createMinimalBSTHelper(array, mid+1, end, newNode);
       return newNode;
    }
    public void displayTree(){
        displayTree(this.root);
    }

    private void displayTree(TreeNode root) {
        if(root == null){
            return;
        }
        System.out.println("node is "+root + " parent is " +root.parent + " left node is "+root.left + " right node is "+root.right);
        displayTree(root.left);
        displayTree(root.right);
    }
}
