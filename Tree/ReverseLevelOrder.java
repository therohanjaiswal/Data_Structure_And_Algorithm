
// https://www.geeksforgeeks.org/reverse-level-order-traversal/
import java.util.*;

class Solution {
    // Root of Binary Tree
    Node root;

    Solution() {
        root = null;
    }

    // TC: O(n), SC: O(n)
    public ArrayList<Integer> reverseLevelOrder(Node node) {
        ArrayList<Integer> res = new ArrayList<>();
        if (node == null)
            return res;

        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            Node curr = q.remove();
            res.add(curr.data);
            if (curr.right != null)
                q.add(curr.right);
            if (curr.left != null)
                q.add(curr.left);
        }

        Collections.reverse(res);
        return res;
    }

    void reverseLevelOrder() {
        ArrayList<Integer> res = reverseLevelOrder(root);
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
        tree.reverseLevelOrder();
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