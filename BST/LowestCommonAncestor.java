// https://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/
class Solution {
    Node root;

    Solution() {
        root = null;
    }

    // TC: O(n), SC: O(1)
    Node lcaBST(Node root, int n1, int n2) {
        if (root == null)
            return null;

        if (root.data < n1 && root.data < n2)
            return lcaBST(root.right, n1, n2);
        else if (root.data > n1 && root.data > n2)
            return lcaBST(root.left, n1, n2);

        return root;
    }

    void lcaBST() {
        Node res = lcaBST(root, 45, 180);
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
        tree.lcaBST();
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