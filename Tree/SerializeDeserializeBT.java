
// https://www.geeksforgeeks.org/serialize-deserialize-binary-tree/
class Solution {
    Node root;

    Solution() {
        root = null;
    }

    Node prev = null;

    Node convert(Node root) {
        if (root == null) {
            return root;
        }

        Node head = convert(root.left);
        if (prev == null) {
            head = root;
        } else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        convert(root.right);
        return head;
    }

    void checkBalancedTree() {
        convert(root);
    }

    public static void main(String[] args) {
        Solution tree = new Solution();
        tree.root = new Node(10);
        tree.root.left = new Node(20);
        tree.root.right = new Node(30);
        tree.root.left.left = new Node(40);
        tree.root.left.left.right = new Node(100);
        tree.root.left.right = new Node(50);
        tree.root.right.left = new Node(60);
        tree.root.right.right = new Node(70);
        tree.checkBalancedTree();
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
