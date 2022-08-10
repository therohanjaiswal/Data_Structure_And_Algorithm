
// https://www.geeksforgeeks.org/find-pair-given-sum-bst/
import java.util.*;

class Solution {
    Node root;

    Solution() {
        root = null;
    }

    void inorderNaive(ArrayList<Integer> arr, Node root) {
        if (root == null)
            return;
        inorderNaive(arr, root.left);
        arr.add(root.data);
        inorderNaive(arr, root.right);
    }

    // TC: O(n), SC: O(n)
    boolean isPairPresentNaive(Node root, int sum) {
        if (root == null)
            return false;
        ArrayList<Integer> arr = new ArrayList<>();
        inorderNaive(arr, root);

        // finding two sum just like in array
        int low = 0, high = arr.size() - 1;
        while (low < high) {
            if (arr.get(low) + arr.get(high) == sum)
                return true;
            else if (arr.get(low) + arr.get(high) > sum)
                --high;
            else
                ++low;
        }
        return false;
    }

    boolean inorderBetter(Node root, HashSet<Integer> set, int sum) {
        if (root == null)
            return false;

        if (inorderBetter(root.left, set, sum))
            return true;

        int diff = sum - root.data;
        if (set.contains(diff))
            return true;
        else
            set.add(root.data);

        return inorderBetter(root.right, set, sum);
    }

    // TC: O(n), SC: O(n)
    boolean isPairPresentBetter(Node root, int sum) {
        if (root == null)
            return false;
        HashSet<Integer> set = new HashSet<>();
        return inorderBetter(root, set, sum);
    }

    void isPairPresent() {
        int sum = 90;
        System.out.println(isPairPresentNaive(root, sum));
        System.out.println(isPairPresentBetter(root, sum));
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
        tree.checkForBST();
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