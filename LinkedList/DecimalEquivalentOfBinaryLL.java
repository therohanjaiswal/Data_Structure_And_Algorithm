// https://www.geeksforgeeks.org/decimal-equivalent-of-binary-linked-list/
class Solution {
    // Only one traversal. Simulates binary operations
    // TC: O(n), SC: O(1)
    public static int decimalValueEfficient(Node head) {
        int ans = 0;
        Node curr = head;
        while (curr != null) {
            ans = (ans << 1) | curr.data;
            curr = curr.next;
        }

        return ans;
    }

    // Two traversals
    // TC: O(n), SC: O(1)
    public static int decimalValueNaive(Node head) {
        if (head == null)
            return 0;

        Node curr = head;
        int len = 0;
        while (curr != null) {
            ++len;
            curr = curr.next;
        }

        int num = 0;
        curr = head;
        while (curr != null) {
            num += curr.data * (int) Math.pow(2, len - 1);
            --len;
            curr = curr.next;
        }

        return num;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(0);
        Node node3 = new Node(1);
        Node node4 = new Node(1);
        Node head = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
        int res = decimalValueEfficient(head);
        System.out.println(res);
    }
}

class Node {
    int data;
    Node next;

    Node(int mData) {
        data = mData;
        next = null;
    }
}