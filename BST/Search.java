// https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
class Solution {
    Node root;

    Solution() {
        root = null;
    }

    // TC: O(h), SC: O(1)
    boolean searchIterative(Node root, int key) {
        if (root == null)
            return false;
        Node curr = root;
        while (curr != null) {
            if (curr.key == key)
                return true;
            else if (key < curr.key)
                curr = curr.left;
            else
                curr = curr.right;
        }
        return false;
    }

    // TC: O(h), SC: O(h)
    // h = n in worst case, h = logn in avg case
    boolean searchRecursive(Node root, int key) {
        if (root == null)
            return false;
        if (root.key == key)
            return true;
        else if (key < root.key)
            return searchRecursive(root.left, key);
        return searchRecursive(root.right, key);
    }

    void search() {
        System.out.println(searchRecursive(root, 60));
        System.out.println(searchIterative(root, 60));
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
        tree.search();
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