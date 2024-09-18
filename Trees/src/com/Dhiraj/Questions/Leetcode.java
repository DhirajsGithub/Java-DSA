package com.Dhiraj.Questions;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public static void main(String[] args) {

    }


//    https://leetcode.com/problems/deepest-leaves-sum/
    public int deepestLeavesSum(TreeNode root) {
        int deepestLevel = heightOfTree(root);
        // we will be taking that level which is height of tree +1;
        System.out.println(deepestLevel);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int curLevel = -1;
        int sum =0;
        while(!queue.isEmpty()){
            curLevel ++;
            System.out.println(curLevel);
            int size = queue.size();

            for(int i=0; i<size; i++){
                TreeNode currentNode = queue.poll();
                if(currentNode.left != null){
                    queue.add(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.add(currentNode.right);
                }
                if(curLevel == deepestLevel){
                    sum+= currentNode.val;
                }

            }
        }
        return sum;
    }

    public int heightOfTree(TreeNode root){
        if(root == null){
            return -1;
        }
        int left = heightOfTree(root.left);
        int right = heightOfTree(root.right);
        return Math.max(left, right)+ 1;
    }


//    https://leetcode.com/problems/range-sum-of-bst/
    public int rangeSumBST(TreeNode root, int low, int high) {
        int ans = 0;
        if(root == null){
            return 0;
        }
        if(root.val >= low && root.val <= high){
            ans +=  root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high) ;
        }
        if(root.val < low){
            ans += rangeSumBST(root.right, low, high);
        }
        if(root.val > high){
            ans += rangeSumBST(root.left, low, high);
        }

        return ans;
    }

//    https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/description/
    int pubAns =0;
    public int averageOfSubtree(TreeNode root) {
        int arr[] = new int[1];
        averageOfSubTreeHelper(root);
        return pubAns;
    }

    public int averageOfSubTreeHelper(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = averageOfSubTreeHelper(root.left) ;
        int right =  averageOfSubTreeHelper(root.right);
        int leftAndRight = left + right + root.val;

        System.out.println(root.val + " "+leftAndRight);
        if(leftAndRight/numberOfNodes(root) == root.val){
            pubAns ++;
        }
        return leftAndRight;

    }

    public int numberOfNodes(TreeNode node){
        int sum = 0;
        if(node == null){
            return 0;
        }
        sum += numberOfNodes(node.left) + numberOfNodes(node.right) +1; // 1 for current node;

        return sum;
    }


}
