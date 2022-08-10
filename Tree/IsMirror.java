// https://www.youtube.com/watch?v=9jH2L2Ysxko
class Solution {
    Node root;

    Solution() {
        root = null;
    }

    boolean isMirror(Node node1, Node node2) {
        if (node1 == null && node2 == null)
            return true;

        if (node1 != null && node2 != null && node1.key == node2.key)
            return isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);

        return false;
    }

    boolean isMirror2(Node node1, Node node2) {
        if (node1 == null && node2 == null)
            return true;
        // if any of them is null
        if (node1 == null || node2 == null)
            return false;
        // if both are not null and keys are not equal
        if (node1.key != node2.key)
            return false;
        // if both are not null and keys are also equal,
        // check for left and right subtrees
        return isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
    }

    boolean isMirrorUtil() {
        return isMirror(root, root);
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
        System.out.println(tree.isMirrorUtil());
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
