package com.Dhiraj.Questions;

public class DeleteNodeInBST {
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

     public TreeNode findMinNode(TreeNode node){
         if(node == null){
             return node;
         }else{
             while (node.left != null){
                 node = node.left;
             }
         }
         return node;
     }

     // given tree is BST
     public TreeNode deleteNodeInBST(TreeNode root, int key){
         if(root == null){
             return null;
         }
         if(root.val < key){
             root.right = deleteNodeInBST(root.right, key);
         }
         else if(root.val > key){
             root.left = deleteNodeInBST(root.left, key);
         }else{
             // value found
             if(root.left != null && root.right != null){
                 TreeNode minNode = findMinNode(root.right);
                 root.val = minNode.val;
                 root.right = deleteNodeInBST(root.right, minNode.val);
             }else if(root.left != null){
                 root = root.left;
             }else if(root.right != null){
                 root = root.right;
             }else{
                 root =  null;
             }

         }

         return root;


     }
}
