package com.Dhiraj.Questions;
import java.util.*;

/*
Implement a function to check if a binary tree is balanced. For the purposes of this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any node never differ by more than one.
 */

public class CheckedBalance {

    public class TreeNode {
        public int data;
        public TreeNode left;
        public TreeNode right;
        public TreeNode parent;
        private int size = 0;

        public TreeNode(int d) {
            data = d;
            size = 1;
        }

        public int height() {
            int leftHeight = left != null ? left.height() : 0;
            int rightHeight = right != null ? right.height() : 0;
            return 1 + Math.max(leftHeight, rightHeight);
        }
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        boolean balanced = Math.abs(height(root.left)- height(root.right)) <=1;

        return balanced && isBalanced(root.left) && isBalanced(root.right);
    }

    public int height(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = height(node.left);
        int right = height(node.right);
        return Math.max(left, right)+1;
    }

}
