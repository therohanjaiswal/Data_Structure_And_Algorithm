// https://www.geeksforgeeks.org/find-sum-left-leaves-given-binary-tree/
class Solution {
    // Root of Binary Tree
    Node root;

    Solution() {
        root = null;
    }

    int sum = 0;

    // TC: O(n), SC: O(1)
    public int sumOfLeftLeaves(Node root) {
        if (root == null)
            return 0;
        utils(root, false);
        return sum;

    }

    public void utils(Node root, boolean isLeft) {
        if (root == null)
            return;

        if (isLeft && root.left == null && root.right == null) {
            sum += root.data;
            return;
        }

        utils(root.left, true);
        utils(root.right, false);
    }

    void leftSum() {
        int res = sumOfLeftLeaves(root);
        System.out.println(res);
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
        tree.leftSum();
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