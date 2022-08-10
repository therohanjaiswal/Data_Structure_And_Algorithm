import java.util.Stack;

// https://leetcode.com/problems/binary-tree-postorder-traversal/discuss/45648/three-ways-of-iterative-postorder-traversing-easy-explanation
class Solution {
    Node root;

    Solution() {
        root = null;
    }

    void postorderRecursive(Node node) {
        if (node == null)
            return;
        postorderRecursive(node.left);
        postorderRecursive(node.right);
        System.out.print(node.key + " ");
    }

    // TC: O(n), SC: O(2*n)
    void postorderIterative1(Node root) {
        if (root == null)
            return;

        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        st1.push(root);
        while (!st1.isEmpty()) {
            Node curr = st1.pop();
            st2.push(curr);
            if (curr.left != null)
                st1.push(curr.left);
            if (curr.right != null)
                st1.push(curr.right);
        }

        while (!st2.isEmpty())
            System.out.print(st2.pop().key + " ");
    }

    // TC: O(n), SC: O(n)
    public static void postorderIterative2(Node root) {
        if (root == null)
            return;
        Node curr = root, prev = null;
        Stack<Node> st = new Stack<>();
        // keep iterating untill both the condn are met
        // 1. stack is empty 2. curr is null
        while (curr != null || !st.isEmpty()) {
            if (curr != null) {
                st.push(curr);
                curr = curr.left;
            } else {
                curr = st.peek();
                if (curr.right == null || curr.right == prev) {
                    System.out.print(curr.key + " ");
                    st.pop();
                    prev = curr;
                    // making curr null, so that it doesn't fall into the
                    // if(curr != null) case again and don't push curr.left elements
                    curr = null;
                } else
                    curr = curr.right;
            }
        }

    }

    void printPostorder() {
        postorderRecursive(root);
        System.out.println();
        postorderIterative1(root);
        System.out.println();
        postorderIterative2(root);
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
        tree.printPostorder();
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
