// https://www.geeksforgeeks.org/diameter-of-a-binary-tree/
class Solution {
    Node root;

    Solution() {
        root = null;
    }

    int height1(Node node) {
        if (node == null || (node.left == null && node.right == null))
            return 0;
        int leftHeight = height1(node.left);
        int rightHeight = height1(node.right);
        return 1 + (leftHeight > rightHeight ? leftHeight : rightHeight);
    }

    // TC: O(n^2), SC: O(1)
    int diameterNaive(Node node) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return 1;
        int leftHeigt = 0;
        // if left is null, leftHeight will remain 0
        // calc left height only when left is non-null
        if (node.left != null)
            leftHeigt = 1 + height(node.left);
        int rightHeight = 0;
        // if right is null, leftHeight will remain 0
        // calc right height only when right is non-null
        if (node.right != null)
            rightHeight = 1 + height(node.right);
        int d = leftHeigt + rightHeight + 1;
        return Math.max(d, Math.max(diameterNaive(node.left), diameterNaive(node.right)));
    }

    int res = 0;

    // TC: O(n), SC: O(1)
    int diameterEfficient(Node root) {
        height(root);
        return res;
    }

    int height(Node node) {
        if (node == null)
            return 0;
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        res = Math.max(res, leftHeight + rightHeight + 1);
        return 1 + (leftHeight > rightHeight ? leftHeight : rightHeight);
    }

    void diameter() {
        System.out.println(diameterNaive(root));
        System.out.println(diameterEfficient(root));
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
        tree.diameter();
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