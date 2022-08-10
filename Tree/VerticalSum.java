
// https://www.geeksforgeeks.org/vertical-sum-in-a-given-binary-tree/
import java.util.*;

class Solution {
    Node root;

    Solution() {
        root = null;
    }

    // TC: O(nlog(hd) + hd) = O(nlog(hd)), SC: O(hd)
    public ArrayList<Integer> verticalSum(Node root) {
        // TreeMap stores the keys in sorted order
        TreeMap<Integer, Integer> map = new TreeMap<>();
        // map has hd keys, means map has hd insertions and as
        // tree map is self balanced, for hd nodes it takes log(hd)
        verticalSumUtil(root, 0, map);
        ArrayList<Integer> res = new ArrayList<>();
        // traversal takes O(hd)
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            System.out.println(e.getKey() + ": " + e.getValue());
            res.add(e.getValue());
        }

        return res;
    }

    public void verticalSumUtil(Node root, int hd, TreeMap<Integer, Integer> map) {
        if (root == null)
            return;
        verticalSumUtil(root.left, hd - 1, map);
        map.put(hd, map.getOrDefault(hd, 0) + root.data);
        verticalSumUtil(root.right, hd + 1, map);
    }

    void vertSum() {
        ArrayList<Integer> res = verticalSum(root);
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

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}
