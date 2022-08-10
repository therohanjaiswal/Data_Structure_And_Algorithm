
// https://www.geeksforgeeks.org/construct-a-binary-tree-from-postorder-and-inorder/
class Solution {
    Node root;

    Solution() {
        root = null;
    }

    int postIndex;

    // TC: O(n^2), SC: O(h)
    Node buildTreeUtil(char[] inorder, char[] postorder, int instart, int inend) {
        if (postIndex < 0 || instart > inend)
            return null;

        Node newNode = new Node(postorder[postIndex--]);
        if (instart == inend)
            return newNode;

        int inIndex = 0;
        for (int i = instart; i <= inend; ++i) {
            if (inorder[i] == newNode.key) {
                inIndex = i;
                break;
            }
        }
        newNode.right = buildTreeUtil(inorder, postorder, inIndex + 1, inend);
        newNode.left = buildTreeUtil(inorder, postorder, instart, inIndex - 1);
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

    void constructBTree(char[] inorder, char[] postorder, int n) {
        postIndex = n - 1;
        root = buildTreeUtil(inorder, postorder, 0, n - 1);
        inorder(root);
    }

    public static void main(String[] args) {
        Solution tree = new Solution();
        char[] inorder = { 'D', 'B', 'E', 'A', 'F', 'C' };
        char[] postorder = { 'D', 'E', 'B', 'F', 'C', 'A' };
        tree.constructBTree(inorder, postorder, inorder.length);
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
