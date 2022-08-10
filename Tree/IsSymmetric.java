// https://www.geeksforgeeks.org/symmetric-tree-tree-which-is-mirror-image-of-itself/
class Solution {
    Node root;

    Solution() {
        root = null;
    }

    // TC: O(n), SC: O(h)
    boolean isSymmUtils(Node node1, Node node2) {
        if (node1 == null && node2 == null)
            return true;
        if (node1 == null || node2 == null)
            return false;
        if (node1.key != node2.key)
            return false;
        return isSymmUtils(node1.left, node2.right) && isSymmUtils(node1.right, node2.left);
    }

    boolean isSymmetric() {
        return isSymmUtils(root, root);
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
        tree.isSymmetric();
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