// https://www.geeksforgeeks.org/find-k-th-smallest-element-in-bst-order-statistics-in-bst/
class Solution {
    Node root;
    Node augmented;

    Solution() {
        root = null;
        augmentedRoot = null;
    }

    int res = -1, counter = 0;

    // TC: O(h + k), SC: O(h)
    public void kthSmallestNaive(Node root, int k) {
        if (root == null)
            return;
        kthSmallestNaive(root.left, k);
        counter++;
        if (counter == k) {
            res = root.data;
            return;
        }
        kthSmallestNaive(root.right, k);
    }

    // TC: O(h), SC: O(h)
    public AugmentedNode kthSmallestEfficient(AugmentedNode root, int k) {
        if (root == null)
            return null;
        int count = root.leftCount;
        if (count == k)
            return root;
        else if (k < count)
            return kthSmallestEfficient(root.left, k);
        return kthSmallestEfficient(root.right, k - count);
    }

    public void kthSmallest() {
        int k = 4;
        kthSmallestNaive(root, k);
        System.out.println(res);

        AugmentedNode res = kthSmallestEfficient(root, k);
        System.out.print(res.data);
    }

    public AugmentedNode insert(AugmentedNode root, int x) {
        if (root == null)
            return new AugmentedNode(x);

        if (x < root.data) {
            root.left = insert(root.left, x);
            root.leftCount++;
        }

        else if (x > root.data)
            root.right = insert(root.right, x);
        return root;
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
        tree.kthSmallest();

        tree.augmentedRoot = null;
        int keys[] = { 20, 8, 22, 4, 12, 10, 14 };

        for (int x : keys)
            tree.augmentedRoot = insert(augmentedRoot, x);

        tree.kthSmallest();
    }
}

class AugmentedNode {
    int data;
    int leftCount; // no of nodes in left subtree
    AugmentedNode left, right;

    AugmentedNode(int item) {
        data = item;
        leftCount = 0;
        left = right = null;
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