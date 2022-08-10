
// https://www.geeksforgeeks.org/flatten-a-binary-tree-into-linked-list/
import java.util.*;

class Solution {
    Node root;

    Solution() {
        root = null;
    }

    Node prev = null;

    // TC: O(n), SC: O(n - recursion call stack)
    void flattenBTreeNaive(Node root) {
        if (root == null)
            return;
        flattenBTreeNaive(root.right);
        flattenBTreeNaive(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    // TC: O(n), SC: O(1)
    void flattenBTreeEfficient(Node root) {
        Node curr = root;
        while (curr != null) {
            if (curr.left != null) {
                Node prev = curr.left;
                while (prev.right != null)
                    prev = prev.right;
                prev.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }

    void flattenBTree() {
        flattenBTreeNaive(root);
        flattenBTreeEfficient(root);
    }

    public static void main(String[] args) {
        Solution tree = new Solution();
        tree.root = new Node(10);
        tree.root.left = new Node(20);
        tree.root.right = new Node(30);
        tree.root.left.left = new Node(40);
        tree.root.left.right = new Node(50);
        tree.root.right.left = new Node(60);
        tree.root.right.right = new Node(70);
        tree.flattenBTree();
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
