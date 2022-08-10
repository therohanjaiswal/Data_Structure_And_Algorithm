
// https://www.geeksforgeeks.org/print-all-nodes-at-distance-k-from-given-node-iterative-approach/
// https://www.geeksforgeeks.org/print-nodes-distance-k-given-node-binary-tree/
import java.util.*;

class Solution {
    Node root;

    Solution() {
        root = null;
    }

    // TC: O(nlogn), Sc: O(h)
    ArrayList<Integer> nodesKAwayIterative(Node root, int target, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        HashMap<Node, Node> parent = new HashMap<>();
        storeParents(root, parent);
        Node t = searchTargetNode(root, target);
        nodesAtDistanceK(root, t, k, parent, res);
        Collections.sort(res);
        return res;
    }

    void storeParents(Node root, HashMap<Node, Node> map) {
        if (root == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        map.put(root, null);
        while (!q.isEmpty()) {
            Node curr = q.remove();
            if (curr.left != null) {
                q.add(curr.left);
                map.put(curr.left, curr);
            }

            if (curr.right != null) {
                q.add(curr.right);
                map.put(curr.right, curr);
            }
        }
    }

    Node searchTargetNode(Node root, int target) {
        if (root == null)
            return null;
        if (root.data == target)
            return root;
        Node inLeft = searchTargetNode(root.left, target);
        if (inLeft != null)
            return inLeft;
        return searchTargetNode(root.right, target);
    }

    public static void nodesAtDistanceK(Node root, Node target, int k, HashMap<Node, Node> map,
            ArrayList<Integer> res) {
        HashSet<Node> set = new HashSet<>();
        int dist = 0;

        Queue<Node> q = new LinkedList<>();
        q.add(target);
        set.add(target);

        while (!q.isEmpty()) {
            if (dist == k) {
                while (!q.isEmpty())
                    res.add(q.remove().data);
            }

            int size = q.size();
            for (int i = 0; i < size; ++i) {
                Node curr = q.remove();
                if (curr.left != null && !set.contains(curr.left)) {
                    q.add(curr.left);
                    set.add(curr.left);
                }

                if (curr.right != null && !set.contains(curr.right)) {
                    q.add(curr.right);
                    set.add(curr.right);
                }

                if (map.get(curr) != null && !set.contains(map.get(curr))) {
                    q.add(map.get(curr));
                    set.add(map.get(curr));
                }
            }
            ++dist;
        }
    }

    // TC: O(n), SC: O(n)
    public ArrayList<Integer> nodesKAwayRecursive(Node root, int target, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Node targetNode = searchTargetNode(root, target);

        nodesAtDistanceKRecursive(root, targetNode, k, res);
        return res;
    }

    public int nodesAtDistanceKRecursive(Node node, Node target, int k, ArrayList<Integer> result) {
        if (node == null)
            return -1;

        if (node == target) {
            kdistanceNodeDown(node, k, result);
            return 0;
        }

        int dl = nodesAtDistanceKRecursive(node.left, target, k, result);

        if (dl != -1) {
            if (dl + 1 == k)
                result.add(node.data);
            else
                kdistanceNodeDown(node.right, k - dl - 2, result);
            return 1 + dl;
        }

        // MIRROR OF ABOVE CODE FOR RIGHT SUBTREE
        int dr = nodesAtDistanceKRecursive(node.right, target, k, result);
        if (dr != -1) {
            if (dr + 1 == k)
                result.add(node.data);
            else
                kdistanceNodeDown(node.left, k - dr - 2, result);
            return 1 + dr;
        }
        return -1;
    }

    public void kdistanceNodeDown(Node node, int k, ArrayList<Integer> result) {
        if (node == null)
            return;
        if (k == 0) {
            result.add(node.data);
            return;
        }
        kdistanceNodeDown(node.left, k - 1, result);
        kdistanceNodeDown(node.right, k - 1, result);
    }

    public void nodesKAway() {
        int k = 1;
        int target = 20;
        ArrayList<Integer> res = nodesKAwayIterative(root, target, k);
        System.out.println(res);
        res = nodesKAwayRecursive(root, target, k);
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
        tree.nodesKAway();
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
