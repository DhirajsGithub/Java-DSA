package com.Dhiraj.BinaryTree;

public class AVL {
    private class Node{
        private int value;
        private Node left;
        private Node right;
        private int height;

        public Node(int value) {
            this.value = value;
        }

        public int getValue(){
            return this.value;
        }
    }

    private Node root;

    public AVL() {
    }

    public int height(Node node){
        if(node == null){
            return -1;
        }
        return node.height;
    }

    // height of tree
    public int height(){
        return height(root);
    }

    public boolean isEmpty(){
        return this.root == null;
    }

    public void insert(int value){
        // this is important, as we are assigning value to root after every insertion with log(N)
        root = insert(value, this.root);
    }

    private Node insert(int value, Node node){
        if(node == null){
            Node newNode = new Node(value);
            return newNode;
        }
        if(value < node.value){
            node.left = insert(value, node.left);
        }else{
            node.right = insert(value, node.right);
        }

        // for new node left and right height will be -1 and hence the height of node will be -1 + 1 = 0
        node.height = Math.max(height(node.left), height(node.right)) + 1;

        // inserted element normally, now we will see if the tree is balance or not, from bottom up approach
        // node will get rotated if the tree is unbalanced, if tree is balanced it won't rotate
        return rotate(node);
    }

    private Node rotate(Node node) {
        // 4 rules
        // left heavy 2 cases
        if(height(node.left) - height(node.right) > 1){

            // left - left case
            if(height(node.left.left) - height(node.left.right) > 0){
                return rightRotate(node);
            }

            // left - right case
            if(height(node.left.left) - height(node.left.right) < 0){
                 node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }


        // right heavy 2 cases
        if(height(node.left) - height(node.right) < -1){
            // right - right case
            if(height(node.right.right) - height(node.right.left) > 0){
                return leftRotate(node);
            }

            // right - left case
            if(height(node.right.right) - height(node.right.left) < 0){
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        // for everthing else
        return node;
    }

    private Node leftRotate(Node c) {
        // g is grand child
        // c is child
        // see notes
        Node g = c.right;
        Node t = g.left;
        g.left = c;
        c.right = t;

        g.height = Math.max(height(g.left), height(g.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;
        return g;
    }

    private Node rightRotate(Node p) {
        Node c = p.left;
        Node t = c.right;
        c.right = p;
        p.left = t;

        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;

        return c;       // new node NOTE see drawings
    }

    public boolean balanced(){
        return balanced(root);
    }

    private boolean balanced(Node node) {
        if(node == null){
            return true;
        }
        // note null node will have height of -1
        return Math.abs(height(node.left) - height(node.right)) <=1 && balanced(node.left) && balanced(node.right);
    }

    public void display(){
        System.out.println("sihi");
        display(this.root, "Root Node : ");
    }

    private void display(Node node, String detail) {
        if(node == null){
            return;
        }
        System.out.println(detail + node.value);
        display(node.left, "Left child of " + node.value + " : ");
        display(node.right, "Right child of " + node.value + " : ");
    }

    public void populate(int [] nums){
        for(int num : nums) {
            this.insert(num);
        }
    }

    // if array is sorted then tree will be one sided like linked list
    // hence we are taking mid element and inserting it to the tree, doing it for all the left and right subparts
    // time complexity for insertion will be N*logn(N) as we are inserting N elements in a BT(each will take log(N)) time
    public void populateSorted(int [] nums){
        populateSorted(nums, 0, nums.length);
    }

    private void populateSorted(int[] nums, int start, int end) {
        if(start >= end){
            return;
        }
        int mid = (start+end)/2;
        this.insert(nums[mid]);
        populateSorted(nums, start, mid);
        populateSorted(nums, mid+1, end);
    }
}
