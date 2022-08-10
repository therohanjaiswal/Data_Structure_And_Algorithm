import java.util.*;

// https://www.geeksforgeeks.org/write-a-c-program-to-calculate-size-of-a-tree/
class Solution {
    // Root of Binary Tree
    Node root;

    Solution() {
        root = null;
    }

    // TC: O(n), SC: O(1)
    int sizeOfBTRecursive(Node node) {
        if (node == null)
            return 0;
        return 1 + sizeOfBTRecursive(node.left) + sizeOfBTRecursive(node.right);
    }

    // TC: O(n), SC: O(n)
    int sizeOfBTIterative(Node root) {
        if (root == null)
            return 0;

        int result = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node curr = q.remove();
            ++result;
            if (curr.left != null)
                q.add(curr.left);
            if (curr.right != null)
                q.add(curr.right);
        }
        return result;
    }

    void printSizeOfBT() {
        System.out.println(sizeOfBTRecursive(root));
        System.out.println(sizeOfBTIterative(root));
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
        tree.printSizeOfBT();
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
