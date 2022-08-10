
// https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
import java.util.*;

import javax.xml.transform.Source;

class Solution {
    Node root;

    Solution() {
        root = null;
    }

    // TC: O(n), SC: O(1) and require 3 traversals
    Node lcaNaive(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        if (findPath(root, path1, n1) == false || findPath(root, path2, n2) == false)
            return null;

        for (int i = 0; i < path1.size() - 1 && i < path2.size() - 1; ++i) {
            if (path1.get(i + 1) != path2.get(i + 1))
                return path1.get(i);
        }
        return null;
    }

    boolean findPath(Node root, ArrayList<Node> arr, int n1) {
        if (root == null)
            return false;
        arr.add(root);
        if (root.key == n1)
            return true;
        if (findPath(root.left, arr, n1) || findPath(root.right, arr, n1))
            return true;
        arr.remove(arr.size() - 1);
        return false;
    }

    // // TC: O(n), SC: O(1) and require 1 traversal
    Node lcaEfficient(Node root, int n1, int n2) {
        if (root == null)
            return null;

        // if root key is equal to any of the number then it means
        // we have found one of the node, so return node.
        if (root.key == n1 || root.key == n2)
            return root;

        Node left = lcaEfficient(root.left, n1, n2);
        Node right = lcaEfficient(root.right, n1, n2);
        // both left and right are non null when we we have got both
        // the values from each side and this is the lca of n1 and n2.
        if (left != null && right != null)
            return root;

        // left is not null and right is null
        // means we have found either of the values in the left subtree
        // so return the node address
        else if (left != null)
            return left;

        // left is null and right is not null
        // means we have found either of the values in the right subtree,
        // so return the node address
        else if (right != null)
            return right;

        // left and rght both are null
        // means we have not found in each of the subtree, so return null
        return right;
    }

    void lca() {
        System.out.println(lcaNaive(root, 7, 8));
        System.out.println(lcaEfficient(root, 7, 8).key);
    }

    public static void main(String[] args) {
        Solution tree = new Solution();
        tree.root = new Node(4);
        tree.root.left = new Node(5);
        tree.root.right = new Node(6);
        tree.root.left.left = new Node(3);
        tree.root.left.left.right = new Node(100);
        tree.root.left.right = new Node(50);
        tree.root.right.left = new Node(60);
        tree.root.right.right = new Node(7);
        tree.root.right.right.right = new Node(8);
        tree.lca();
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
