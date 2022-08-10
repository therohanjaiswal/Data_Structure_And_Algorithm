// https://www.geeksforgeeks.org/reverse-level-order-traversal/
class Solution {
    Node root;

    Solution() {
        root = null;
    }

    // TC: O(n), SC: O(n)
    ArrayList<Integer> reverseLevelOrder(Node node) {
        ArrayList<Integer> res = new ArrayList<>();
        if (node == null)
            return res;
        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()) {
            Node curr = q.remove();
            res.add(curr.data);
            if (curr.right != null)
                q.add(curr.right);
            if (curr.left != null)
                q.add(curr.left);
        }
        Collections.reverse(res);
        return res;
    }

    void reverseLO() {
        ArrayList<Integer> res = reverseLevelOrder(root);
        System.out.println(res);
    }

    public static void main(String[] args) {
        Solution tree = new Solution();
        tree.root = new Node(10);
        tree.root.left = new Node(20);
        tree.root.right = new Node(30);
        tree.root.left.left = new Node(40);
        tree.root.left.left.right = new Node(100);
        tree.root.left.right = new Node(50);
        tree.root.right.left = new Node(60);
        tree.root.right.right = new Node(70);
        tree.reverseLO();
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
