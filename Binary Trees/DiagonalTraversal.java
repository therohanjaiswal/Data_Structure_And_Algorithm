// https://www.geeksforgeeks.org/diagonal-traversal-of-binary-tree/
class Solution {
    Node root;

    Solution() {
        root = null;
    }

    // TC: O(n), SC: O(n)
    public ArrayList<Integer> diagonal(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        Queue<Node> q = new LinkedList<>();
        Node curr = root;
        while (curr != null) {
            q.add(curr);
            curr = curr.right;
        }

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                curr = q.remove();
                res.add(curr.data);
                curr = curr.left;
                while (curr != null) {
                    q.add(curr);
                    curr = curr.right;
                }
            }
        }
        return res;
    }

    public void diagonalTraversal() {
        ArrayList<Integer> res = diagonal(root);
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
        tree.diagonalTraversal();
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