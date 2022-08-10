import java.util.*;

class Solution {
    Node root;

    Solution() {
        root = null;
    }

    void preorderRecursive(Node node) {
        if (node == null)
            return;
        System.out.print(node.key + " ");
        preorderRecursive(node.left);
        preorderRecursive(node.right);
    }

    // TC: O(n), SC: O(n), as it pushes every node once into the stack
    void preorderIterativeSimple(Node root) {
        if (root == null)
            return;
        Stack<Node> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            Node curr = st.pop();
            System.out.print(curr.key + " ");
            if (curr.right != null)
                st.push(curr.right);
            if (curr.left != null)
                st.push(curr.left);
        }
    }

    // TC: O(n), SC: O(h)
    void preOrderIterativeEfficient(Node root) {
        Stack<Node> st = new Stack<>();
        Node curr = root;
        while (true) {
            while (curr != null) {
                System.out.print(curr.key + " ");
                st.push(curr);
                curr = curr.left;
            }
            if (st.isEmpty())
                break;
            curr = st.pop().right;
        }
    }

    void printPreorder() {
        preorderRecursive(root);
        System.out.println();
        preorderIterativeSimple(root);
        System.out.println();
        preOrderIterativeEfficient(root);
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
        tree.printPreorder();
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
