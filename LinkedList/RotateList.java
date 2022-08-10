// https://leetcode.com/problems/rotate-list/
class Solution {
    // TC: O(n), SC: O(1)
    public static Node rotateRight(Node head, int k) {
        if (head == null)
            return head;

        // head is not null, mean there is atleast 1 node. So, n = 1
        int n = 1;
        Node lastNodePtr = head;
        Node curr = head;
        while (lastNodePtr != null && lastNodePtr.next != null) {
            lastNodePtr = lastNodePtr.next;
            ++n;
        }

        k = k % n;
        if (n == 1 || k == 0)
            return head;

        k = n - k;
        Node right = head;
        while (right != null && --k > 0)
            right = right.next;

        Node newHead = right.next;
        right.next = null;
        lastNodePtr.next = head;

        return newHead;
    }

    public static void printLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node head = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        int k = 2;

        printLinkedList(head);
        head = rotateRight(head, k);
        printLinkedList(head);
    }
}

class Node {
    int data;
    Node next, random;

    Node(int mData) {
        data = mData;
        next = null;
        random = null;
    }
}