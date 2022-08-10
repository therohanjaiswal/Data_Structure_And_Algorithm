// https://www.geeksforgeeks.org/check-for-children-sum-property-in-a-binary-tree/
class Solution {
    Node root;

    Solution() {
        root = null;
    }

    boolean childrenSum(Node node) {
        if (node == null || (node.left == null && node.right == null))
            return true;

        int sum = 0;
        if (node.left != null)
            sum += node.left.key;
        if (node.right != null)
            sum += node.right.key;
        return sum == node.key && childrenSum(node.left) && childrenSum(node.right);
    }

    boolean checkChildrenSum() {
        return childrenSum(root);
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
        System.out.println(tree.checkChildrenSum());
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