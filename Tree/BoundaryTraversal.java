
// https://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/
import java.util.*;

class Solution {
    Node root;

    Solution() {
        root = null;
    }

    // TC: O(n), SC: O(1)
    ArrayList<Integer> boundaryTraversal(Node node) {
        ArrayList<Integer> res = new ArrayList<>();
        if (node == null)
            return res;

        res.add(node.data);
        printLeft(node.left, res);
        printLeaf(node.left, res);
        printLeaf(node.right, res);
        printRight(node.right, res);
        return res;
    }

    void printLeft(Node node, ArrayList<Integer> res) {
        if (node == null)
            return;

        // to avoid duplicate printing of left bottom most leaf node
        if (node.left == null && node.right == null)
            return;

        res.add(node.data);
        if (node.left != null) {
            printLeft(node.left, res);
        } else if (node.right != null)
            printLeft(node.right, res);

    }

    void printLeaf(Node node, ArrayList<Integer> res) {
        if (node == null)
            return;

        printLeaf(node.left, res);
        if (node.left == null && node.right == null)
            res.add(node.data);
        printLeaf(node.right, res);
    }

    void printRight(Node node, ArrayList<Integer> res) {
        if (node == null)
            return;

        // to avoid duplicate printing of right bottom most leaf node
        if (node.left == null && node.right == null)
            return;

        if (node.right != null)
            printRight(node.right, res);
        else if (node.left != null)
            printRight(node.left, res);
        res.add(node.data);
    }

    void boundTraversal() {
        ArrayList<Integer> res = boundaryTraversal(root);
        System.out.print(res);
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
        tree.boundTraversal();
    }
}

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}