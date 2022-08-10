// https://www.geeksforgeeks.org/inorder-successor-in-binary-search-tree/
class Solution {
    Node root;

    Solution() {
        root = null;
    }

    Node res = null;
    Node prev = null;

    // TC: O(n), SC: O(1)
    public Node inorderSuccessorNaive(Node root, Node x) {
        if (root == null)
            return null;
        utils(root, x);
        return res;
    }

    public void utils(Node root, Node x) {
        if (root == null)
            return;

        utils(root.left, x);
        if (prev != null && prev == x)
            res = root;
        prev = root;
        utils(root.right, x);
    }

    // TC: O(h), SC: O(1)
    public Node inorderSuccessorEfficient(Node root, Node target) {
        if (target.right != null)
            return minValue(target.right);

        Node succ = null;

        // Start from root and search for successor down the tree
        while (root != null) {
            if (target.data < root.data) {
                succ = root;
                root = root.left;
            } else if (target.data > root.data)
                root = root.right;
            else
                break;
        }

        return succ;
    }

    public Node minValue(Node node) {
        Node current = node;

        while (current.left != null)
            current = current.left;

        return current;
    }

    void inorderSuccessor() {
        Node res = inorderSuccessorNaive(root, root.right);
        System.out.println(res.data);
        res = inorderSuccessorEfficient(root, root.right);
        System.out.println(res.data);
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
        tree.inorderSuccessor();
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