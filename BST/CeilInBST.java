// https://www.geeksforgeeks.org/floor-and-ceil-from-a-bst/
class Solution {
    Node root;

    Solution() {
        root = null;
    }

    // TC: O(h), SC: O(1)
    public int ceilEfficient(Node root, int key) {
        if (root == null)
            return Integer.MAX_VALUE;
        if (root.data == key)
            return root.data;
        else if (root.data < key)
            return ceilEfficient(root.right, key);
        int ceil = ceilEfficient(root.left, key);
        return Math.min(ceil, root.data);
    }

    public void ceil() {
        System.out.println(ceilEfficient(root, 30));
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
        tree.ceil();
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