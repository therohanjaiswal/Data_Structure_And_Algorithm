
// https://www.geeksforgeeks.org/minimum-time-to-burn-a-tree-starting-from-a-leaf-node/
import java.util.*;

class Solution {
    Node root;

    Solution() {
        root = null;
    }

    // TC: O(n), Sc: O(n)
    public int minTime(Node root, int target) {
        if (root == null)
            return -1;
        HashMap<Node, Node> parents = new HashMap<>();
        storeParents(root, parents);
        Node targetNode = searchTargetNode(root, target);
        return minTimeUtil(root, targetNode, parents);
    }

    public static int minTimeUtil(Node root, Node targetNode, HashMap<Node, Node> map) {
        // start timer from -1 as the target node burns at time = 0
        int time = -1;
        HashSet<Node> set = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        q.add(targetNode);
        while (!q.isEmpty()) {
            int size = q.size();
            ++time;
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
        }
        return time;
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

    public void minTimeToBurn() {
        int target = 20;
        int res = minTime(root, target);
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
        tree.minTimeToBurn();
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
