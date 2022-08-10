
// https://www.youtube.com/watch?v=FsxTX7-yhOw
import java.util.*;

class Solution {
    Node root;
    Node head;

    Solution() {
        root = null;
        head = null;
    }

    Node prev = null;

    // TC: O(n) as inorder traversal, SC: O(h)
    void bToDLL(Node root) {
        if (root == null)
            return;

        bToDLL(root.left);
        if (prev == null)
            head = root;
        else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        bToDLL(root.right);
    }

    void convertBTIntoDLL() {
        bToDLL(root);
        printDLL(head);
    }

    void printDLL(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.key + " ");
            curr = curr.right;
        }
    }

    public static void main(String[] args) {
        Solution tree = new Solution();
        tree.root = new Node(10);
        tree.root.left = new Node(20);
        tree.root.right = new Node(30);
        tree.root.left.left = new Node(40);
        tree.root.left.left.right = new Node(100);
        tree.root.left.right = new Node(50);
        tree.root.right.left = new Node(60);
        tree.root.right.right = new Node(70);
        tree.convertBTIntoDLL();
    }
}

class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}
