
// https://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/
import java.util.*;

class Solution {
    Node root;

    Solution() {
        root = null;
    }

    int preIndex = 0;

    // TC: O(n^2), SC: O(h)
    Node buildTree(char[] inorder, char[] preorder, int instart, int inend) {
        if (instart > inend)
            return null;
        char root = preorder[preIndex++];
        Node newNode = new Node(root);
        int inIndex;
        for (inIndex = instart; inIndex <= inend; ++inIndex) {
            if (inorder[inIndex] == root) {
                break;
            }
        }
        newNode.left = buildTree(inorder, preorder, instart, inIndex - 1);
        newNode.right = buildTree(inorder, preorder, inIndex + 1, inend);
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

    void constructBTree(char[] inorder, char[] preorder, int instart, int inend) {
        root = buildTree(inorder, preorder, instart, inend);
        inorder(root);
    }

    public static void main(String[] args) {
        Solution tree = new Solution();
        char[] inorder = { 'D', 'B', 'E', 'A', 'F', 'C' };
        char[] preorder = { 'A', 'B', 'D', 'E', 'C', 'F' };
        tree.constructBTree(inorder, preorder, 0, inorder.length - 1);
    }
}

class Node {
    char key;
    Node left, right;

    public Node(char item) {
        key = item;
        left = right = null;
    }
}
