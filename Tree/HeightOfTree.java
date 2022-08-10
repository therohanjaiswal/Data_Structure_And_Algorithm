class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

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

    int printHeight() {
        return height(root);
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
        System.out.println(tree.printHeight());
    }
}
