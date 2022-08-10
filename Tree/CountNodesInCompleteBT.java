// https://www.geeksforgeeks.org/count-number-of-nodes-in-a-complete-binary-tree/
class Solution {
    Node root;

    Solution() {
        root = null;
    }

    int leftHeight(Node node) {
        int height = 0;
        while (node != null) {
            ++height;
            node = node.left;
        }
        return height;
    }

    int rightHeight(Node node) {
        int height = 0;
        while (node != null) {
            ++height;
            node = node.right;
        }
        return height;
    }

    // TC: O(logn ^ 2), SC: O(1)
    int countNodes(Node node) {
        if (node == null)
            return 0;
        int lHeight = leftHeight(node.left);
        int rHeight = rightHeight(node.right);
        if (lHeight == rHeight)
            return 1 << lHeight - 1;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    void checkBalancedTree() {
        countNodes(root);
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
