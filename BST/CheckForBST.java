// https://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
class Solution {
    Node root;

    Solution() {
        root = null;
    }

    // TC: O(n), SC: O(1)
    public boolean checkForBSTBasic(Node root, int min, int max) {
        if (root == null)
            return true;

        if (root.data <= min || root.data >= max)
            return false;

        // return root.data > min && root.data < max && isBSTUtil(root.left, min,
        // root.data) && isBSTUtil(root.right, root.data, max); and remove 2nd if
        return checkForBSTBasic(root.left, min, root.data) && checkForBSTBasic(root.right, root.data, max);
    }

    Node prev = null;

    // TC: O(n), SC: O(1)
    public boolean checkForBSTEfficient(Node root) {
        if (root == null)
            return true;

        if (root.left == null && root.right == null) {
            if (prev != null && root.data <= prev.data)
                return false;
            prev = root;
            return true;
        }

        boolean left = checkForBSTEfficient(root.left);
        if (prev != null && root.data <= prev.data)
            return false;
        prev = root;
        boolean right = checkForBSTEfficient(root.right);
        return left && right;
    }

    void checkForBST() {
        System.out.println(checkForBSTBasic(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        System.out.println(checkForBSTEfficient(root));
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
        tree.checkForBST();
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