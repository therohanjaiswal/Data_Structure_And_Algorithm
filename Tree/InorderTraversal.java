
// https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/
import java.util.*;

class Solution {
    Node root;

    Solution() {
        root = null;
    }

    void inorderRecursive(Node node) {
        if (node == null)
            return;
        inorderRecursive(node.left);
        System.out.print(node.key + " ");
        inorderRecursive(node.right);
    }

    void inorderIterative(Node node) {
        if (node == null)
            return;

        Stack<Node> st = new Stack<>();
        Node curr = node;
        while (true) {
            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }
            if (st.isEmpty())
                break;
            curr = st.pop();
            System.out.print(curr.key + " ");
            curr = curr.right;
        }
    }

    void printInorder() {
        inorderRecursive(root);
        System.out.println();
        inorderIterative(root);
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
        tree.printInorder();
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
