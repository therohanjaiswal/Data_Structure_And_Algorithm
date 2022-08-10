
// https://www.geeksforgeeks.org/print-right-view-binary-tree-2/
import java.util.*;

class Solution {
    Node root;

    Solution() {
        root = null;
    }

    // TC: O(n), SC:O(width of the tree)
    ArrayList<Integer> rightViewIterative(Node node) {
        ArrayList<Integer> res = new ArrayList<>();
        if (node == null)
            return res;

        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            int count = q.size();
            for (int i = 0; i < count; i++) {
                Node curr = q.remove();
                if (i == 0)
                    res.add(curr.key);

                if (curr.right != null)
                    q.add(curr.right);
                if (curr.left != null)
                    q.add(curr.left);
            }
        }

        return res;
    }

    int maxLevel = 0;

    // TC: O(n), SC: O(height of the tree)
    void rightViewRecursive(Node node, int level, ArrayList<Integer> res) {
        if (node == null)
            return;

        if (maxLevel <= level) {
            res.add(node.key);
            ++maxLevel;
        }

        rightViewRecursive(node.right, level + 1, res);
        rightViewRecursive(node.left, level + 1, res);
    }

    void printRightView() {
        ArrayList<Integer> res = rightViewIterative(root);
        System.out.println(res);
        res = new ArrayList<>();
        rightViewRecursive(root, 0, res);
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
        tree.printRightView();
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
