
// https://www.geeksforgeeks.org/print-binary-tree-vertical-order-set-2/
import java.util.*;

class Solution {
    Node root;

    Solution() {
        root = null;
    }

    // TC: O(nlogn), SC: O(n)
    ArrayList<Integer> verticalTraversal(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        Queue<Pair> q = new LinkedList<>();
        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair p = q.remove();
            Node curr = p.node;
            int hd = p.hd;
            if (map.containsKey(hd))
                map.get(hd).add(curr.data);
            else {
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(curr.data);
                map.put(hd, arr);
            }

            if (curr.left != null)
                q.add(new Pair(curr.left, hd - 1));
            if (curr.right != null)
                q.add(new Pair(curr.right, hd + 1));
        }

        for (Map.Entry<Integer, ArrayList<Integer>> e : map.entrySet()) {
            ArrayList<Integer> arr = e.getValue();
            for (Integer i : arr)
                res.add(i);
        }
        return res;
    }

    void vertTraversal() {
        ArrayList<Integer> res = verticalTraversal(root);
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
        tree.vertSum();
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
