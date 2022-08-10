
// https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/
import java.util.*;

class Solution {
    Node root;

    Solution() {
        root = null;
    }

    // TC: O(n), SC: O(1)
    public ArrayList<Integer> morrisPreorder(Node root) {
        ArrayList<Integer> preorder = new ArrayList<>();
        Node curr = root;
        while (curr != null) {
            if (curr.left == null) {
                preorder.add(curr.key);
                curr = curr.right;
            } else {
                Node prev = curr.left;
                while (prev.right != null && prev.right != curr)
                    prev = prev.right;

                if (prev.right == null) {
                    prev.right = curr; // make thread from prev to curr using right pointer
                    preorder.add(curr.key);
                    curr = curr.left;
                } else { // prev.right == curr i.e., thread already present from prev to curr
                    prev.right = null;
                    curr = curr.right;
                }
            }
        }

        return preorder;
    }

    // TC: O(n), SC: O(1)
    public ArrayList<Integer> morrisInorder(Node root) {
        ArrayList<Integer> inorder = new ArrayList<>();
        Node curr = root;
        while (curr != null) {
            if (curr.left == null) {
                inorder.add(curr.key);
                curr = curr.right;
            } else {
                Node prev = curr.left;
                while (prev.right != null && prev.right != curr)
                    prev = prev.right;

                if (prev.right == null) {
                    prev.right = curr; // make thread from prev to curr using right pointer
                    curr = curr.left;
                } else { // prev.right == curr i.e., thread already present from prev to curr
                    prev.right = null;
                    inorder.add(curr.key);
                    curr = curr.right;
                }
            }
        }

        return inorder;
    }

    void morrisTraversal() {
        ArrayList<Integer> res = morrisInorder(root);
        System.out.println(res);
        res = morrisPreorder(root);
        System.out.println(res);
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
        tree.morrisTraversal();
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
