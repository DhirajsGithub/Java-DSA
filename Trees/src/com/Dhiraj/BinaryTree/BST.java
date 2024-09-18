package com.Dhiraj.BinaryTree;

import java.util.*;

public class BST {
    private class Node {
        private int value;
        private Node left;
        private Node right;
        private int height;

        private Node next; // for Populating Next Right Pointers in Each Node question only

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    private Node root;

    public BST() {
    }

    public int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void insert(int value) {
        // this is important, as we are assigning value to root after every insertion
        // with log(N)
        root = insert(value, this.root);
    }

    private Node insert(int value, Node node) {
        if (node == null) {
            Node newNode = new Node(value);
            return newNode;
        }
        if (value < node.value) {
            node.left = insert(value, node.left);
        } else {
            node.right = insert(value, node.right);
        }

        // for new node left and right height will be -1 and hence the height of node
        // will be -1 + 1 = 0
        node.height = Math.max(height(node.left), height(node.right)) + 1;

        return node;
    }

    public boolean balanced() {
        return balanced(root);
    }

    private boolean balanced(Node node) {
        if (node == null) {
            return true;
        }
        // note null node will have height of -1
        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }

    public void display() {
        System.out.println("sihi");
        display(this.root, "Root Node : ");
    }

    private void display(Node node, String detail) {
        if (node == null) {
            return;
        }
        System.out.println(detail + node.value);
        display(node.left, "Left child of " + node.value + " : ");
        display(node.right, "Right child of " + node.value + " : ");
    }

    public void populate(int[] nums) {
        for (int num : nums) {
            this.insert(num);
        }
    }

    // if array is sorted then tree will be one sided like linked list
    // hence we are taking mid element and inserting it to the tree, doing it for
    // all the left and right subparts
    // time complexity for insertion will be N*logn(N) as we are inserting N
    // elements in a BT(each will take log(N)) time
    public void populateSorted(int[] nums) {
        populateSorted(nums, 0, nums.length);
    }

    private void populateSorted(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        this.insert(nums[mid]);
        populateSorted(nums, start, mid);
        populateSorted(nums, mid + 1, end);
    }

    // bfs
    // time complexity O(N), space complexity O(N)
    public void BFS() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(this.root);
        System.out.print(this.root.value + " -> ");
        while (!queue.isEmpty()) {
            Node present = queue.remove();

            if (present.left != null) {
                queue.add(present.left);
                System.out.print(present.left.value + " -> ");
            }
            if (present.right != null) {
                queue.add(present.right);
                System.out.print(present.right.value + " -> ");
            }

        }
        System.out.println();
    }

    // search in BST
    public Node searchInBST(int val) {
        return searchInBST(this.root, val);
    }

    private Node searchInBST(Node root, int val) {
        if (root == null) {
            return null;
        }
        if (root.value == val) {
            return root;
        }
        if (root.value < val) {
            return searchInBST(root.right, val);
        } else {
            return searchInBST(root.left, val);
        }
    }

    public Node minNodeInBST() {
        return minNodeInBST(this.root);
    }

    private Node minNodeInBST(Node root) {
        if (root == null) {
            return null;
        }
        while (root.left != null) {
            root = root.left;
        }
        return root;
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

    private Node deleteInBST(Node root, int val) {

        if (root == null) {
            return null;
        }
        if (root.value < val) {
            root.right = deleteInBST(root.right, val);
        } else if (root.value > val) {
            root.left = deleteInBST(root.left, val);
        } else {
            // three conditions
            if (root.left != null && root.right != null) {
                // take max of left or min from right and swap the node
                Node max = maxNodeInBST(root.left);
                root.value = max.value;
                root.left = deleteInBST(root.left, max.value);
            } else if (root.left != null) {
                // only one child node
                root = root.left;
            } else if (root.right != null) {
                root = root.right;
            } else {
                root = null;
            }
        }
        return root;
    }

    /*
     * Successor of a given node
     * In Binary Search Tree, Inorder Successor of an input node can also be defined
     * as the node with the smallest key greater
     * than the key of the input node. So, it is sometimes important to find next
     * node in sorted order.
     * 
     * To find the inorder successor of a node in a Binary Search Tree (BST), we
     * need to consider two scenarios:
     * 
     * Node has a right child: In this case, the inorder successor is the leftmost
     * node in the right subtree.
     * Node doesn't have a right child: We need to find the closest ancestor for
     * which the current node is in its left subtree.
     */
    public Node inorderSuccessor(Node node) {
        if (node == null) {
            return node;
        }
        // Case 1: Node has a right child
        if (node.right != null) {
            return minNodeInBST(node.right);
        } else {
            // Case 2: Node doesn't have a right child
            Node ancestor = this.root;
            Node successor = null;
            while (ancestor != node) {
                if (node.value < ancestor.value) {
                    successor = ancestor; // Move towards the closest ancestor
                    ancestor = ancestor.left;
                } else {
                    ancestor = ancestor.right;
                }
            }
            return successor;
        }
    }

    /*
     * Predecessor of a node
     * In the context of a Binary Search Tree (BST), the "predecessor" of a node
     * refers to the node that comes
     * immediately before it in an inorder traversal. An inorder traversal of a BST
     * visits nodes in ascending order
     * of their values, which means for a given node, the predecessor is the node
     * with the largest value that is smaller than the given node.
     */

    public Node inorderPredecessor(Node node) {
        if (node == null) {
            return node;
        }
        if (node.left != null) {
            return maxNodeInBST(node.left);
        }
        // Case 2: If node doesn't have a left child
        Node predecessor = null;
        Node ancestor = root;
        while (ancestor != node) {
            if (node.value > ancestor.value) {
                predecessor = ancestor;
                ancestor = ancestor.right;
            } else {
                ancestor = ancestor.left;
            }
        }

        return predecessor;
    }

    // questions
    // https://leetcode.com/problems/binary-tree-level-order-traversal/
    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<Node> qu = new LinkedList<>();
        qu.offer(root);
        while (!qu.isEmpty()) {
            int presentSize = qu.size();

            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i < presentSize; i++) {
                Node presentNode = qu.poll();
                temp.add(presentNode.value);
                if (presentNode.left != null) {
                    qu.add(presentNode.left);
                }
                if (presentNode.right != null) {
                    qu.add(presentNode.right);
                }
            }
            ans.add(temp);
        }

        return ans;
    }

    // https://leetcode.com/problems/average-of-levels-in-binary-tree/description/

    public List<Double> averageOfLevels(Node root) {
        List<Double> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<Node> qu = new LinkedList<>();
        qu.offer(root);
        while (!qu.isEmpty()) {
            int presentSize = qu.size();
            double sum = 0;
            for (int i = 0; i < presentSize; i++) {
                Node presentNode = qu.poll();
                sum += presentNode.value;
                if (presentNode.left != null) {
                    qu.add(presentNode.left);
                }
                if (presentNode.right != null) {
                    qu.add(presentNode.right);
                }
            }
            ans.add(sum / presentSize);
        }
        return ans;
    }

    // https://www.geeksforgeeks.org/level-order-successor-of-a-node-in-binary-tree/
    public int levelOrderSuccessor(Node root, int target) {
        if (root == null) {
            return -1;
        }
        Queue<Node> qu = new LinkedList<>();
        qu.add(root);
        int ans = -1;
        while (!qu.isEmpty()) {
            Node presentNode = qu.poll();
            if (presentNode.left != null) {
                qu.add(presentNode.left);
            }
            if (presentNode.right != null) {
                qu.add(presentNode.right);
            }
            // this should be here after adding left and right node, coz it might be the
            // case where qu is empty
            if (presentNode.value == target && !qu.isEmpty()) {
                ans = qu.poll().value;
            }
        }
        return ans;
    }

    // https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
    public List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        boolean reverse = false;
        Deque<Node> dq = new LinkedList<>();
        dq.offer(root);
        while (!dq.isEmpty()) {
            int levelSize = dq.size();
            List<Integer> li = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                if (!reverse) {
                    Node presentNode = dq.pollFirst(); // will remove first item
                    li.add(presentNode.value);
                    if (presentNode.left != null) {
                        dq.addLast(presentNode.left);
                    }
                    if (presentNode.right != null) {
                        dq.addLast(presentNode.right);
                    }
                } else {
                    Node presentNode = dq.pollLast(); // will remove last item
                    li.add(presentNode.value);
                    if (presentNode.right != null) {
                        dq.addFirst(presentNode.right);
                    }
                    if (presentNode.left != null) {
                        dq.addFirst(presentNode.left);
                    }
                }
            }
            ans.add(li);
            reverse = !reverse;
        }

        return ans;
    }

    // https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
    public List<List<Integer>> levelOrderBottom(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<Node> qu = new LinkedList<>();
        qu.offer(root);
        while (!qu.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int presentSize = qu.size();
            for (int i = 0; i < presentSize; i++) {
                Node presentNode = qu.poll();
                temp.add(presentNode.value);
                if (presentNode.left != null) {
                    qu.add(presentNode.left);
                }
                if (presentNode.right != null) {
                    qu.add(presentNode.right);
                }
            }
            ans.add(0, temp);
        }
        return ans;
    }

    // https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
    // public Node connect(Node root) {
    // if(root == null){
    // return root;
    // }
    // Queue<Node> qu = new LinkedList<>();
    // qu.offer(root);
    // while (!qu.isEmpty()){
    // int presentSize = qu.size();
    //
    // for(int i=0; i<presentSize; i++){
    // Node presentNode = qu.poll();
    // if(i <presentSize-1 && !qu.isEmpty()){
    // presentNode.next = qu.peek();
    // }else{
    // presentNode.next = null;
    // }
    //
    // // we are adding the nodes in for loop but the loop will be executed as the
    // the number of nodes in a level
    // if(presentNode.left != null){
    // qu.add(presentNode.left);
    // }
    // if(presentNode.right != null){
    // qu.add(presentNode.right);
    // }
    // }
    // }
    // return root;
    // }

    // optimal solution with O(log(N)) time and O(1) space
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node leftMost = root;

        while (leftMost.left != null) {
            Node current = leftMost;
            while (current != null) {
                current.left.next = current.right;
                if (current.next != null) {
                    current.right.next = current.next.left;
                }
                current = current.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }

    // https://leetcode.com/problems/binary-tree-right-side-view/description/
    public List<Integer> rightSideView(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Queue<Node> qu = new LinkedList<>();
        qu.offer(root);
        while (!qu.isEmpty()) {
            int presentSize = qu.size();
            for (int i = 0; i < presentSize; i++) {
                Node presentNode = qu.poll();
                if (i == presentSize - 1) {
                    ans.add(presentNode.value);
                }
                if (presentNode.left != null) {
                    qu.add(presentNode.left);
                }
                if (presentNode.right != null) {
                    qu.add(presentNode.right);
                }
            }
        }
        return ans;
    }

    // https://leetcode.com/problems/cousins-in-binary-tree/description/
    public boolean isCousins(Node root, int x, int y) {
        Node xx = findNode(root, x);
        Node yy = findNode(root, y);

        return ((level(root, xx, 0) == level(root, yy, 0)) && (!isSibling(root, xx, yy)));
    }

    Node findNode(Node node, int x) {
        if (node == null) {
            return null;
        }
        if (node.value == x) {
            return node;
        }
        Node n = findNode(node.left, x);
        if (n != null) {
            return n;
        }
        return findNode(node.right, x);
    }

    boolean isSibling(Node node, Node x, Node y) {
        if (node == null) {
            return false;
        }

        return ((node.left == x && node.right == y) || (node.left == y && node.right == x)
                || isSibling(node.left, x, y) || isSibling(node.right, x, y));
    }

    int level(Node node, Node x, int lev) {
        if (node == null) {
            return 0;
        }

        if (node == x) {
            return lev;
        }

        int l = level(node.left, x, lev + 1);
        if (l != 0) {
            return l;
        }
        return level(node.right, x, lev + 1);
    }

    // https://leetcode.com/problems/symmetric-tree/description/
    public boolean isSymmetric(Node root) {
        if (root == null) {
            return true;
        }
        Queue<Node> qu = new LinkedList<>();
        qu.add(root.left);
        qu.add(root.right);
        while (!qu.isEmpty()) {
            Node left = qu.poll();
            Node right = qu.poll();

            if (left == null && right == null) {
                continue;
            }
            // note this should be below both are null condition
            if (left == null || right == null) {
                return false;
            }

            // also this should be below left and right null, to avoid null pointer error
            if (left.value != right.value) {
                return false;
            }

            qu.add(left.left);
            qu.add(right.right);
            qu.add(left.right);
            qu.add(right.left);

        }
        return true;
    }

    int diameter = 0;

    // https://leetcode.com/problems/diameter-of-binary-tree/
    public int diameterOfBinaryTree(Node root) {
        // so the intention will be calculate the max of left + right height

        heightNode(root);
        // only diameter will give the number of nodes but diameter-1 will be length of
        // longest parth
        return diameter - 1;
    }

    private int heightNode(Node node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = heightNode(node.left);
        int rightHeight = heightNode(node.right);

        int dia = leftHeight + rightHeight + 1;
        diameter = Math.max(dia, diameter);
        return Math.max(leftHeight, rightHeight) + 1;

    }

    // https://leetcode.com/problems/invert-binary-tree/description/
    public Node invertTree(Node root) {
        if (root == null) {
            return root;
        }
        // swap
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    // https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    // https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
    public Node sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length);
    }

    private Node sortedArrayToBST(int[] nums, int start, int end) {
        if (start >= end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        Node root = new Node(nums[mid]);
        root.left = sortedArrayToBST(nums, start, mid);
        root.right = sortedArrayToBST(nums, mid + 1, end);

        return root;

    }

    // https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
    // O(N) space and time
    // can we do it with O(1) space
    // public void flatten(Node root) {
    // // preorder --> root -> left -> right
    // if(root == null){
    // return;
    // }
    // Queue<Node> qu = new LinkedList();
    // flattenTemp(root, qu);
    // // now qu has all the nodes;
    // root = qu.remove();
    // while (!qu.isEmpty()){
    // root.right = qu.remove();
    // }
    //
    // }
    //
    // private void flattenTemp(Node root, Queue<Node> qu) {
    // if(root != null){
    // qu.add(root);
    // }else{
    // return;
    // }
    // flattenTemp(root.left, qu);
    // flattenTemp(root.right, qu);
    // }

    public void flatten(Node root) {

        Node current = root;
        while (current != null) {
            if (current.left != null) {
                Node temp = current.left;
                while (temp.right != null) {
                    temp = temp.right;
                }
                temp.right = current.right;
                current.right = current.left;
                current.left = null;
            }
            current = current.right;
        }
    }

    // https://leetcode.com/problems/validate-binary-search-tree/description/
    public boolean isValidBST(Node root) {
        // dfs preorder
        return isValidBSTHelper(root, null, null);

    }

    private boolean isValidBSTHelper(Node node, Integer low, Integer high) {
        if (node == null) {
            return true;
        }
        if (low != null && node.value <= low) {
            return false;
        }
        if (high != null && node.value >= high) {
            return false;
        }

        boolean leftTree = isValidBSTHelper(node.left, low, node.value);
        boolean rightTree = isValidBSTHelper(node.right, node.value, high);

        return leftTree && rightTree;
    }

    // https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
    public Node lowestCommonAncestor(Node root, Node p, Node q) {
        if (root == null) {
            return null;
        }

        // no need to go down
        if (root == p || root == q) {
            return root;
        }
        Node left = lowestCommonAncestor(root.left, p, q);
        Node right = lowestCommonAncestor(root.right, p, q);

        // both p and q lies to left and right side of node
        if (left != null && right != null) {
            return root;
        }

        // if p and q lies to same side of node
        if (left == null) {
            return right;
        } else {
            return left;
        }

    }

    // https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
    // public int kthSmallest(Node root, int k) {
    // ArrayList<Integer> nums = new ArrayList<>();
    // int p = k;
    // kthSmallestHelper(root, nums, k);
    // System.out.println(nums);
    // return nums.get(p);
    //
    // }
    //
    // private void kthSmallestHelper(Node node, ArrayList<Integer> nums, int k) {
    // if(node == null){
    // return;
    // }
    // kthSmallestHelper(node.left, nums, k);
    // nums.add(node.value);
    // kthSmallestHelper(node.right, nums, k-1);
    // }

    public int kthSmallest(Node root, int k) {
        ArrayList<Integer> nums = new ArrayList<>();
        int p = k;
        Node temp = kthSmallestHelper(root, k, 0);
        return temp.value;

    }

    private Node kthSmallestHelper(Node node, int k, int count) {
        if (node == null) {
            return null;
        }
        Node left = kthSmallestHelper(node.left, k, count);
        if (left != null) {
            return left; // ans is found somewhere below like when count is k then return left
        }
        count++;
        if (count == k) {
            return node;
        }
        return kthSmallestHelper(node.right, k, count);

    }

    // to be solved !!!
    // https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/

    // https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        StringBuilder s = new StringBuilder();
        serializHelper(root, s);
        return s.toString();
    }

    private void serializHelper(Node root, StringBuilder s) {
        if (root == null) {
            s.append("n,");
            return;
        }
        // preorder
        s.append(String.valueOf(root.value) + ",");
        serializHelper(root.left, s);
        serializHelper(root.right, s);
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {

        String[] myArray = data.split(",");
        List<String> li = Arrays.asList(myArray);
        List<String> myList = new ArrayList<>(li);
        Collections.reverse(myList);
        return deserializeHelper(myList);
    }

    private Node deserializeHelper(List<String> data) {

        if (data.size() == 0) {
            return null;
        }

        String last = data.get(data.size() - 1);
        data.remove(data.size() - 1);

        if (last.equals(",") || last.equals("n")) {
            return null;
        }

        Node node = new Node(Integer.parseInt(last));
        node.left = deserializeHelper(data);
        node.right = deserializeHelper(data);
        return node;
    }

    // https://leetcode.com/problems/path-sum/description/
    public boolean hasPathSum(Node root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.value == targetSum && root.left == null && root.right == null) {
            return true;
        }
        return hasPathSum(root.left, targetSum - root.value) || hasPathSum(root.right, targetSum - root.value);
    }

    // https://leetcode.com/problems/sum-root-to-leaf-numbers
    public int sumNumbers(Node root) {
        int ans = sumNumbersHelper(root, 0);
        return ans;
    }

    private int sumNumbersHelper(Node root, int i) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return i + root.value;

        }
        int left = sumNumbersHelper(root.left, i * 10 + root.value);
        int right = sumNumbersHelper(root.right, i * 10 + root.value);
        return left + right;

    }

    // https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
    int maxPathSumIs = Integer.MIN_VALUE;

    public int maxPathSum(Node root) {
        maxPathSumHelper(root);
        return maxPathSumIs;
    }

    private int maxPathSumHelper(Node root) {
        if (root == null) {
            return 0;
        }
        int left = maxPathSumHelper(root.left);
        int right = maxPathSumHelper(root.right);

        // ignore -ve
        left = Math.max(0, left);
        right = Math.max(0, right);

        int pathSum = left + right + root.value;

        maxPathSumIs = Math.max(pathSum, maxPathSumIs);

        return Math.max(left, right) + root.value;
    }

    // given array [3, 9, 12, 8] find if it exist at any path of the tree
    boolean findPath(Node node, int[] arr) {
        if (node == null) {
            return arr.length == 0;
        }
        return findPathHelper(node, arr, 0);
    }

    private boolean findPathHelper(Node node, int[] arr, int i) {
        if (node == null) {
            return false;
        }
        if (i >= arr.length || arr[i] != node.value) {
            return false;
        }

        // we reach at the leaf of the tree
        if (node.left == null && node.right == null && i == arr.length - 1) {
            return true;
        }

        return findPathHelper(node.left, arr, i + 1) || findPathHelper(node.right, arr, i + 1);
    }
    // https://www.geeksforgeeks.org/print-path-between-any-two-nodes-in-a-binary-tree/

    int countPaths(Node node, int sum) {
        List<Integer> path = new ArrayList<>();
        return helper(node, sum, path);
    }

    int helper(Node node, int sum, List<Integer> path) {
        if (node == null) {
            return 0;
        }

        path.add(node.value);
        int count = 0;
        int s = 0;
        // how many paths I can make
        ListIterator<Integer> itr = path.listIterator(path.size());
        while (itr.hasPrevious()) {
            s += itr.previous();

            if (s == sum) {
                count++;
            }
        }

        count += helper(node.left, s, path) + helper(node.right, sum, path);

        // backtrack
        path.remove(path.size() - 1);
        return count;

    }

    // put in a list
    List<List<Integer>> findPaths(Node node, int sum) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(node, sum, path);
        return paths;
    }

    void helper(Node node, int sum, List<Integer> path, List<List<Integer>> paths) {
        if (node == null) {
            return;
        }

        path.add(node.value);

        if (node.value == sum && node.left == null && node.right == null) {
            paths.add(new ArrayList<>(path));
        } else {
            helper(node.left, sum - node.value, path, paths);
            helper(node.right, sum - node.value, path, paths);
        }

        // backtrack
        path.remove(path.size() - 1);
    }

    // TODO
    // https://www.geeksforgeeks.org/top-50-tree-coding-problems-for-interviews/

    // https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
    public Node buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        // we can retirve the indice of inorder with O(1) time

        int[] buildTreeIndex = { 0 };
        return buildTreeHelper(preorder, inorder, 0, preorder.length - 1, map, buildTreeIndex);

    }

    public Node buildTreeHelper(int[] preorder, int[] inorder, int left, int right, HashMap<Integer, Integer> map,
            int[] buildTreeIndex) {
        if (left > right) {
            return null;
        }

        int current = preorder[buildTreeIndex[0]];
        buildTreeIndex[0]++;
        Node node = new Node(current);

        if (left == right) {
            return node;
        }

        int inorderIndex = map.get(current);

        node.left = buildTreeHelper(preorder, inorder, left, inorderIndex - 1, map, buildTreeIndex);
        node.right = buildTreeHelper(preorder, inorder, inorderIndex + 1, right, map, buildTreeIndex);

        return node;
    }

    // https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
    public List<List<Integer>> verticalTraversal(Node root) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }
        int col = 0;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        // that's how we pass the map to the helper function
        Queue<Map.Entry<Node, Integer>> queue = new ArrayDeque<>();
        queue.offer(new AbstractMap.SimpleEntry<>(root, col));

        int min = 0;
        int max = 0;
        while (!queue.isEmpty()) {
            Map.Entry<Node, Integer> remove = queue.poll();
            root = remove.getKey();
            col = remove.getValue();

            if (root != null) {
                if (!map.containsKey(col)) {
                    map.put(col, new ArrayList<>());
                }
                map.get(col).add(root.value);

                min = Math.min(min, col);
                max = Math.max(max, col);

                queue.offer(new AbstractMap.SimpleEntry<>(root.left, col - 1));
                queue.offer(new AbstractMap.SimpleEntry<>(root.right, col + 1));
            }
        }

        for (int i = min; i <= max; i++) {
            ans.add(map.get(i));
        }

        return ans;
    }

    // https://leetcode.com/problems/word-ladder/description/
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        Set<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.offer(beginWord);
        int length = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            length++;

            for (int i = 0; i < size; i++) {
                String current = queue.poll();

                for (int j = 0; j < current.length(); j++) {
                    char[] temp = current.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        temp[j] = c;
                        String newWord = new String(temp);
                        if (newWord.equals(endWord)) {
                            return length + 1;
                        }

                        if (wordList.contains(newWord) && !set.contains(newWord)) {
                            set.add(newWord);
                            queue.offer(newWord);
                        }
                    }
                }
            }
        }

        return 0;
    }

    // https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
    public boolean findTarget(Node root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return findTargetHelper(root, set, k);

    }

    public boolean findTargetHelper(Node root, HashSet<Integer> set, int k) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.value)) {
            return true;
        }
        set.add(root.value);
        return findTargetHelper(root.left, set, k) || findTargetHelper(root.right, set, k);
    }

    // https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
    private int kthSmallestK;
    private int getKthSmallestAns;

    public int kthSmallestSecondMethod(Node root, int k) {
        // we know that inorder traversal in BST will give the values in non-decreasing
        // order
        this.kthSmallestK = k;
        kthSmallestSecondMethodHelper(root);
        return getKthSmallestAns;

    }

    private void kthSmallestSecondMethodHelper(Node node) {
        if (node == null) {
            return;
        }
        kthSmallestSecondMethodHelper(node.left);
        kthSmallestK--;
        if (kthSmallestK == 0) {
            getKthSmallestAns = node.value;
            return;
        }
        kthSmallestSecondMethodHelper(node.right);
    }

}
