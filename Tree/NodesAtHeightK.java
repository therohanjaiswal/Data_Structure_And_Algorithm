// https://www.geeksforgeeks.org/print-nodes-at-k-distance-from-root/
class Solution {
    Node root;

    Solution() {
        root = null;
    }

    void nodesAtHeightKFromRoot(Node node, int k) {
        if (node == null)
            return;
        if (k == 0) {
            System.out.println(node.key);
            return;
        }
        nodesAtHeightKFromRoot(node.left, k - 1);
        nodesAtHeightKFromRoot(node.right, k - 1);
    }

    void printNodesAtHeightK(int k) {
        nodesAtHeightKFromRoot(root, k);
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
        tree.printNodesAtHeightK(1);
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
