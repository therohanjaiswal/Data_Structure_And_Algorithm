
// https://www.geeksforgeeks.org/full-and-complete-binary-tree-from-given-preorder-and-postorder-traversals/
class Solution {
    Node root;

    Solution() {
        root = null;
    }

    // TC: O(n^2), SC: O(1)
    public Node buildTree(int[] preorder, int presi, int preei, int[] postorder, int postsi, int postei) {
        if (presi > preei)
            return null;
        Node newNode = new Node(preorder[presi]);
        if (presi == preei)
            return newNode;

        int idx = postsi;
        while (postorder[idx] != preorder[presi + 1])
            idx++;

        int nodeCount = idx - postsi + 1;

        newNode.left = buildTree(preorder, presi + 1, presi + nodeCount, postorder, postsi, idx);
        newNode.right = buildTree(preorder, presi + nodeCount + 1, preei, postorder, idx + 1, postei - 1);
        return newNode;
    }

    void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.key + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        Solution tree = new Solution();
        int[] preorder = { 1, 2, 4, 5, 3, 6, 7 };
        int[] postorder = { 4, 5, 2, 6, 7, 3, 1 };
        int n = preorder.length;
        Node root = tree.buildTree(preorder, 0, n - 1, postorder, 0, n - 1);
        tree.inorder(root);
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
