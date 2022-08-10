
// https://www.geeksforgeeks.org/print-nodes-top-view-binary-tree/
import java.util.*;

class Solution {
    Node root;

    Solution() {
        root = null;
    }

    // TC: O(nlogn), SC: O(n)
    ArrayList<Integer> topViewOfBTree(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair p = q.remove();
            Node curr = p.node;
            int hd = p.hd;
            if (!map.containsKey(hd))
                map.put(hd, curr.data);
            if (curr.left != null)
                q.add(new Pair(curr.left, hd - 1));
            if (curr.right != null)
                q.add(new Pair(curr.right, hd + 1));
        }

        for (Map.Entry<Integer, Integer> e : map.entrySet())
            res.add(e.getValue());
        return res;
    }

    void topView() {
        ArrayList<Integer> res = topViewOfBTree(root);
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
        tree.topView();
    }
}

class Pair {
    Node node;
    int hd;

    Pair(Node n, int h) {
        node = n;
        hd = h;
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
