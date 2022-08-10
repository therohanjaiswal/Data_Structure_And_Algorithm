// https://www.geeksforgeeks.org/root-to-leaf-path-sum-equal-to-a-given-number/
class Solution {
    // Root of Binary Tree
    Node root;

    Solution() {
        root = null;
    }

    // TC: O(n), SC: O(1)
    public boolean hasPathSum(Node root, int targetSum) {
        if (root == null)
            return false;

        return utils(root, 0, targetSum);
    }

    public boolean util(Node root, int currSum, int targetSum) {
        if (root == null)
            return false;

        currSum += root.data;
        if (root.left == null && root.right == null) {
            if (currSum == targetSum)
                return true;
            return false;
        }

        return utils(root.left, currSum, targetSum) || utils(root.right, currSum, targetSum);
    }

    void pathSum() {
        int targetSum = 30;
        boolean res = hasPathSum(root, targetSum);
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
        tree.pathSum();
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