// https://www.geeksforgeeks.org/check-if-a-binary-tree-is-subtree-of-another-binary-tree/
class Solution {
    // Root of Binary Tree
    Node root;
    Node subroot;

    Solution() {
        root = null;
        subroot = null;
    }

    // TC: O(n), SC: O(1)
    public boolean isSubtree(Node root, Node subRoot) {
        if (root == null)
            return false;
        if (isSame(root, subRoot))
            return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean isSame(Node p, Node q) {
        if (p == null && q == null)
            return true;

        if (p == null && q != null)
            return false;
        else if (p != null && q == null)
            return false;

        if (p.data != q.data)
            return false;

        return isSame(p.left, q.left) && isSame(p.right, q.right);
    }

    public void checkForSubtree() {
        boolean res = isSubtree(root, subroot);
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

        tree.subroot = new Node(30);
        tree.subroot.left = new Node(60);
        tree.subroot.right = new Node(70);
        tree.checkForSubtree();
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