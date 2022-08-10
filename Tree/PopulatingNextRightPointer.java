
// // https://www.geeksforgeeks.org/connect-nodes-at-same-level-with-o1-extra-space/
import java.util.*;

class Solution {
    Node root;

    Solution() {
        root = null;
    }

    // TC: O(n), SC: O(n)
    public Node connectNaive(Node root) {
        if (root == null)
            return null;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                Node curr = q.remove();
                if (i < size - 1)
                    curr.next = q.peek();
                else
                    curr.next = null;
                if (curr.left != null)
                    q.add(curr.left);

                if (curr.right != null)
                    q.add(curr.right);
            }
        }

        return root;
    }

    // TC: O(n), SC: O(1)
    public Node connectEfficient(Node root) {
        if (root == null)
            return null;
        utils(root, null);
        return root;
    }

    public void utils(Node curr, Node next) {
        if (curr == null)
            return;
        curr.next = next;
        utils(curr.left, curr.right);
        utils(curr.right, curr.next == null ? null : curr.next.left);
    }

    void connect() {
        Node res = connectNaive(root);
        inorder(res);
        res = connectEfficient(root);
        inorder(root);
    }

    void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        Solution tree = new Solution();
        tree.root = new Node(100);
        tree.root.left = new Node(50);
        tree.root.right = new Node(150);
        tree.root.left.left = new Node(40);
        tree.root.left.left.right = new Node(45);
        tree.root.left.right = new Node(60);
        tree.root.right.left = new Node(120);
        tree.root.right.right = new Node(180);
        tree.connect();
    }
}

class Node {
    int data;
    Node left, right, next;

    public Node(int item) {
        data = item;
        left = right = next = null;
    }
}