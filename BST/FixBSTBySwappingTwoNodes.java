// https://www.geeksforgeeks.org/fix-two-swapped-nodes-of-bst/

class Solution {
    Node root;

    Solution() {
        root = null;
    }

    // first stores the first voilated node
    // second stores the second violated node
    // prev store the previous node of current node which
    // comes in inorder traversal sequence of the tree
    Node prev = null, first = null, second = null;

    // TC: O(n), SC: O(1)
    public Node fixBST(Node root) {
        if (root == null)
            return null;
        fixBSTUtils(root);
        // swapping data
        int temp = first.data;
        first.data = second.data;
        second.data = temp;
        return root;
    }

    public void fixBSTUtils(Node root) {
        if (root == null)
            return;
        fixBSTUtils(root.left);

        // we know that the inorder traversal of the bst is always sorted in increasing
        // order. So the previous node will have value less than the current node value.
        // But while doing the inorder traversal if we find that the previous node value
        // is greater than current node (root) value then it's a violation and we got
        // our first node to swap. After that if again the violation occur, it means
        // that we got our second node.
        if (prev != null && root.data < prev.data) {
            if (first == null)
                first = prev;
            second = root;
        }

        prev = root;
        fixBSTUtils(root.right);
    }

    void checkForBST() {
        root = fixBST(root);
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