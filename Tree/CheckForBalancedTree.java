// https://www.geeksforgeeks.org/how-to-determine-if-a-binary-tree-is-balanced/
class Solution {
    Node root;

    Solution() {
        root = null;
    }

    int height(Node node) {
        if (node == null || (node.left == null && node.right == null))
            return 0;
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        return 1 + (leftHeight > rightHeight ? leftHeight : rightHeight);
    }

    // TC: O(n^2), SC: O(h)
    boolean isbalancedTreeNaive(Node node) {
        if (node == null || (node.left == null && node.right == null))
            return true;
        int leftHeight = 0;
        int rightHeight = 0;
        if (node.left != null)
            leftHeight = 1 + height(node.left);
        if (node.right != null)
            rightHeight = 1 + height(node.right);
        return Math.abs(leftHeight - rightHeight) <= 1 && isbalancedTreeNaive(node.left)
                && isbalancedTreeNaive(node.right);
    }

    // TC: O(n), Sc: O(h)
    int isBalancedTreeEfficient(Node node) {
        if (node == null)
            return 0;
        int leftHeight = isBalancedTreeEfficient(node.left);
        if (leftHeight == -1)
            return -1;
        int rightHeight = isBalancedTreeEfficient(node.right);
        if (rightHeight == -1)
            return -1;
        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }

    void checkBalancedTree() {
        System.out.println(isbalancedTreeNaive(root));
        System.out.println(isBalancedTreeEfficient(root));
    }

    public static void main(String[] args) {
        Solution tree = new Solution();
        tree.root = new Node(10);
        tree.root.left = new Node(20);
        tree.root.right = new Node(30);
        tree.root.left.left = new Node(40);
        tree.root.left.left.right = new Node(100);
        tree.root.left.right = new Node(50);
        tree.root.right.left = new Node(60);
        tree.root.right.right = new Node(70);
        tree.checkBalancedTree();
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
