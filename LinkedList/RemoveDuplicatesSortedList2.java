// https://www.geeksforgeeks.org/remove-occurrences-duplicates-sorted-linked-list/
class Solution {
    // TC: O(n), SC: O(1)
    public static Node removeAllDuplicates(Node head) {
        if (head == null)
            return null;
        Node dummy = new Node(-1);
        dummy.next = head;
        Node prev = dummy;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;
            if (next != null && curr.data == next.data) {
                while (next != null && curr.data == next.data)
                    next = next.next;
                prev.next = next;
            } else {
                prev = curr;
            }
            curr = next;
        }

        return dummy.next;
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
        Node node3 = new Node(2);
        Node node4 = new Node(4);
        Node node5 = new Node(4);
        Node node6 = new Node(5);
        Node head = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = null;
        printLinkedList(head);
        head = removeAllDuplicates(head);
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