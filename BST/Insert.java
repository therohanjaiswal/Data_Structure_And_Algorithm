// https://www.geeksforgeeks.org/insert-a-node-in-binary-search-tree-iteratively/
class Solution {
    Node root;

    Solution() {
        root = null;
    }

    // TC: O(h), SC: O(h)
    // h = n - worst case, logn - avg case
    Node insertIntoBST(Node root, int val) {
        Node node = new Node(val);
        if (root == null) {
            root = node;
            return root;
        }
        Node parent = findParent(root, val);
        if (parent == null)
            return null;
        if (val > parent.key)
            parent.right = node;
        else
            parent.left = node;
        return root;
    }

    Node findParent(Node root, int val) {
        if (root == null)
            return null;
        Node prev = null, curr = root;
        while (curr != null) {
            prev = curr;
            if (val == curr.key)
                return null;
            else if (val > curr.key)
                curr = curr.right;
            else
                curr = curr.left;
        }
        return prev;
    }

    void insert() {
        root = insertIntoBST(root, 200);
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
        tree.insert();
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