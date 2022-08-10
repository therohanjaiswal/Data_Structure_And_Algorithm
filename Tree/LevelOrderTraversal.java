
// https://www.geeksforgeeks.org/level-order-tree-traversal/
import java.util.*;

class Solution {
    Node root;

    Solution() {
        root = null;
    }

    void levelorder(Node node) {
        if (node == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while (q.size() != 0) {
            Node n = q.peek();
            System.out.println(n.key);
            if (n.left != null)
                q.add(n.left);
            if (n.right != null)
                q.add(n.right);
            q.remove();
        }
    }

    void printLevelOrder() {
        levelorder(root);
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
        tree.printLevelOrder();
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