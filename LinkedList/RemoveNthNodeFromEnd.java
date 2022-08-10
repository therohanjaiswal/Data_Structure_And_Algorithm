// https://www.geeksforgeeks.org/nth-node-from-the-end-of-a-linked-list/

class Solution {
    // TC: O(n), SC: O(1)
    public static Node removeNFromEnd(Node head, int n) {
        Node slow = head;
        Node fast = head;

        while (fast != null && --n >= 0)
            fast = fast.next;

        // when n is equal to length of the linked list
        if (fast == null)
            return slow.next;

        Node prev = null;
        while (fast != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = slow.next;

        return head;
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
        Node node6 = new Node(6);
        Node head = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = null;
        printLinkedList(head);

        int n = 2;
        head = removeNFromEnd(head, n);
        printLinkedList(head);
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