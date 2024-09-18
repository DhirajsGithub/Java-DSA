public class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public static void main(String[] args) {
        Node newNode = new Node(0);
        System.out.println(newNode.val);
    }
}