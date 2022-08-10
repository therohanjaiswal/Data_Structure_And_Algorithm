// https://www.geeksforgeeks.org/floor-in-binary-search-tree-bst/
class Solution {
    Node root;

    Solution() {
        root = null;
    }

    // TC: O(h), SC: O(1)
    int floorRecursive(Node root, int key) {
        if (root == null)
            return Integer.MIN_VALUE;
        if (key == root.key) {
            return key;
        } else if (key < root.key) {
            return floorRecursive(root.left, key);
        }
        // key > curr.key
        int floor = floorRecursive(root.right, key);
        return root.key >= floor ? root.key : floor;
    }

    // TC: O(h), SC: O(h)
    int floorIterative(Node root, int key) {
        if (root == null)
            return Integer.MIN_VALUE;
        int floor = Integer.MIN_VALUE;
        Node curr = root;
        while (curr != null) {
            if (curr.key == key) {
                floor = curr.key;
                return floor;
            } else if (curr.key < key) {
                floor = curr.key;
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        return floor;
    }

    void floor() {
        System.out.println(floorRecursive(root, 70));
        System.out.println(floorIterative(root, 70));
    }

    public static void main(String[] args) {
        Solution tree = new Solution();
        tree.root = new Node(100);
        tree.root.left = new Node(50);
        tree.root.right = new Node(150);
        tree.root.left.left = new Node(40);
        tree.root.left.left.right = new Node(45);
        tree.root.left.right = new Node(60);
        tree.root.right.left = new Node(120);
        tree.root.right.right = new Node(180);
        tree.floor();
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