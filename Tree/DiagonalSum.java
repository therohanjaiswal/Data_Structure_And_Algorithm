// https://www.geeksforgeeks.org/diagonal-sum-binary-tree/ 
class Solution {
    Node root;

    Solution() {
        root = null;
    }

    // TC: O(n), SC: O(n)
    ArrayList<Integer> diagonalSumIterative(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null)
            return null;
        Queue<Node> q = new LinkedList<>();

        int sum = 0;

        Node curr = root;
        while (curr != null) {
            sum += curr.data;
            q.add(curr);
            curr = curr.right;
        }
        res.add(sum);

        while (!q.isEmpty()) {
            int size = q.size();
            sum = 0;
            for (int i = 0; i < size; ++i) {
                curr = q.remove();
                curr = curr.left;
                while (curr != null) {
                    sum += curr.data;
                    q.add(curr);
                    curr = curr.right;
                }
            }
            if (sum != 0)
                res.add(sum);
        }
        return res;
    }

    // TC: O(n), SC: O(n)
    ArrayList<Integer> digonalSumRecursive(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null)
            return null;
        Queue<Node> q = new LinkedList<>();

        int sum = 0;

        Node curr = root;
        while (curr != null) {
            sum += curr.data;
            q.add(curr);
            curr = curr.right;
        }
        res.add(sum);
        diagonalSumUtil(res, q);
    }

    void diagonalSumUtil(ArrayList<Integer> res, Queue<Node> q) {
        if (q.isEmpty())
            return;
        int sum = 0;
        int size = q.size();
        for (int i = 0; i < size; ++i) {
            Node curr = q.remove();
            curr = curr.left;
            while (curr != null) {
                sum += curr.data;
                q.add(curr);
                curr = curr.right;
            }
        }
        if (sum != 0)
            res.add(sum);
        diagonalSumUtil(res, q);
    }

    void diagonalSum() {
        ArrayList<Integer> res = diagonalSumIterative(root);
        System.out.println(res);
        res = digonalSumRecursive(root);
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
        tree.diagonalSum();
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