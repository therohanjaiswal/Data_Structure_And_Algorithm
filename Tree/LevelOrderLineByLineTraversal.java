import java.util.*;
// TC: O(n)
// SC: O(width of binary tree)

class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

class Solution {

    // Root of Binary Tree
    Node root;

    Solution() {
        root = null;
    }

    void lineByLineLevelOrderTraversal(Node node) {
        if (node == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while (q.size() != 0) {
            int count = q.size();
            for (int i = 0; i < count; i++) {
                Node curr = q.peek();
                System.out.print(curr.key + " ");
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
                q.remove();
            }
            System.out.println();
        }
    }

    // using null pointer in the end of each level
    void lineByLineLevelOrderTraversal2(Node node) {
        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(node);
        q.add(null);

        while (q.size() > 1) { // > 1 is used instead of >= 1 as we pushed null also along with node
            Node curr = q.poll();
            if (curr == null) {
                System.out.println();
                q.add(null);
                continue;
            }
            System.out.println(node.key);
            if (curr.left != null)
                q.add(curr.left);
            if (curr.right != null)
                q.add(curr.right);
        }
    }

    void printLineByLineLevelOrderTraversal() {
        lineByLineLevelOrderTraversal(root);
        // lineByLineLevelOrderTraversal2(root);
    }

    // 10
    // / \
    // 20 30
    // / \ / \
    // 40 50 60 70

    // O/P :
    // 10
    // 20 30
    // 40 50 60 70

    public static void main(String[] args) {
        Solution tree = new Solution();
        tree.root = new Node(10);
        tree.root.left = new Node(20);
        tree.root.right = new Node(30);
        tree.root.left.left = new Node(40);
        tree.root.left.right = new Node(50);
        tree.root.right.left = new Node(60);
        tree.root.right.right = new Node(70);
        tree.printLineByLineLevelOrderTraversal();
    }
}
