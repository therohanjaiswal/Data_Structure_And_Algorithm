
// https://www.geeksforgeeks.org/print-left-view-binary-tree/
import java.util.*;

class Solution {
    Node root;

    Solution() {
        root = null;
    }

    // TC: O(n), SC:O(width of the tree)
    void leftViewIterative(Node node) {
        if (node == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while (q.size() != 0) {
            int count = q.size();
            for (int i = 0; i < count; i++) {
                Node curr = q.peek();
                if (i == 0) {
                    System.out.print(curr.key + " ");
                }
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
                q.remove();
            }
        }
    }

    // TC: O(n), SC: O(height of the tree)
    int maxLevel = 0;

    void leftViewRecursive(Node node, int level) {
        if (node == null)
            return;
        if (maxLevel < level) {
            System.out.print(node.key + " ");
            maxLevel = level;
        }
        leftViewRecursive(node.left, level + 1);
        leftViewRecursive(node.right, level + 1);
    }

    void printLeftView() {
        leftViewIterative(root);
        System.out.println();
        leftViewRecursive(root, 1);
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
        tree.printLeftView();
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
