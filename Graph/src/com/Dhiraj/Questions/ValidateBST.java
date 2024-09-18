package com.Dhiraj.Questions;

/*
Implement a function to check if a binary tree is a Binary Search Tree.
 */

public class ValidateBST {
    public class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private TreeNode root;

    public boolean isBST(){
        return isBST(this.root, null, null);
    }

    private boolean isBST(TreeNode root, TreeNode low, TreeNode high) {
        if(root == null){
            return true;
        }
        if(low != null && root.data <= low.data){
            return false;
        }
        if(high !=null && root.data >= high.data){
            return false;
        }

        boolean left = isBST(root.left, low, root);
        boolean right = isBST(root.right, root, high);
        return left && right;
    }

    // this will fail if root value is MIN_VALUE or MAX_VALUE
//    private boolean isBST(TreeNode root, int minValue, int maxValue) {
//        if(root == null){
//            return true;
//        }
//        if(root.data < minValue || root.data > maxValue){
//            return false;
//        }
//        boolean left = isBST(root.left, minValue, root.data);
//        boolean right = isBST(root.right, root.data, maxValue);
//
//        return left && right;
//    }

}
