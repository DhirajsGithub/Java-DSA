package com.Dhiraj.BinaryTree;

import com.sun.source.tree.Tree;

public class BT_to_DLL {
    DLLNode head;
    DLLNode tail;

    public DLLNode convertToDLL(TreeNode root){
        if(root == null){
           return null;
        }
        convertToDLLHelper(root);
        return head;
    }

    private void convertToDLLHelper(TreeNode node){
        if(node == null){
            return; 
        }
        convertToDLLHelper(node.left);
        DLLNode newNode = new DLLNode(node.val);
        if(head == null){
            newNode.next = null;
            newNode.prv = null;
            head = tail = newNode;

        }else{
            tail.next = newNode;
            newNode.prv = tail;
            tail = newNode;
            tail.next = null;
        }
    }
}

class DLLNode{
    int val;
    DLLNode prv;
    DLLNode next;

    public DLLNode(int val) {
        this.val = val;
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}