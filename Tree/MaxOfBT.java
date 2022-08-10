
// https://www.geeksforgeeks.org/find-maximum-or-minimum-in-binary-tree/
import java.util.*;

class Solution {
    Node root;

    Solution() {
        root = null;
    }

    // TC: O(n), SC: O(h)
    int maxOfBTRecursive(Node node) {
        if (node == null)
            return Integer.MIN_VALUE;
        int leftMax = maxOfBTRecursive(node.left);
        int rightMax = maxOfBTRecursive(node.right);
        return Math.max(Math.max(leftMax, rightMax), node.key);
    }

    // TC: O(n), SC: O(width of the tree)
    int maxOfBTIterative(Node root) {
        if (root == null)
            return -1;
        int max = Integer.MIN_VALUE;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (q.size() != 0) {
            Node n = q.peek();
            max = Math.max(max, n.data);
            if (n.left != null)
                q.add(n.left);
            if (n.right != null)
                q.add(n.right);
            q.remove();
        }
        return max;
    }

    int printMaxOfBT() {
        System.out.println(maxOfBTIterative(root));
        System.out.println();
        System.out.println(maxOfBTRecursive(root));
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
        tree.printMaxOfBT();
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
