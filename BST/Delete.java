// https://www.geeksforgeeks.org/binary-search-tree-set-2-delete/
class Solution {
    Node root;

    Solution() {
        root = null;
    }

    // TC: O(h), SC: O(h)
    Node deleteFromBST(Node root, int key) {
        if (root == null)
            return null;
        if (key < root.key)
            root.left = deleteNode(root.left, key);
        else if (key > root.key)
            root.right = deleteNode(root.right, key);
        else { // root.key == key
            if (root.left != null && root.right != null) { // delete node with both children
                Node succ = getSucc(root);
                root.key = succ.key;
                root.right = deleteNode(root.right, succ.key);
            } else if (root.left != null) { // delete node with only left child
                return root.left;
            } else if (root.right != null) { // delte node with only right child
                return root.right;
            } else { // delte leaf node
                return null;
            }
        }
        return root;
    }

    // This function works only for nodes with right child
    // For a tree like
    // 10
    // / \
    // 5 12
    // the inorder of successor of 5 is 10, but this func can't find
    // but, delete() calls this func only for nodes with both children
    Node getSucc(Node root) {
        Node curr = root.right;
        while (curr != null && curr.left != null)
            curr = curr.left;
        return curr;
    }

    void delete() {
        root = deleteFromBST(root, 120);
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
        tree.insert();
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