
// https://www.geeksforgeeks.org/zigzag-tree-traversal/
import java.util.*;

class Solution {
    // Root of Binary Tree
    Node root;

    Solution() {
        root = null;
    }

    // TC: O(n), SC: O(n)
    List<List<Integer>> zigZagTraversal(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        boolean leftToRight = true;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            Integer[] arr = new Integer[size];
            for (int i = 0; i < size; ++i) {
                Node curr = q.remove();
                int index = leftToRight ? i : size - 1 - i;
                arr[index] = curr.data;
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }

            res.add(Arrays.asList(arr));
            leftToRight = !leftToRight;
        }

        return res;
    }

    void printZigZag() {
        List<List<Integer>> list = zigZagTraversal(root);
        for (List<Integer> l : list) {
            System.out.println(l);
        }
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
        tree.printZigZag();
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
