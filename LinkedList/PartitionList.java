// https://leetcode.com/problems/partition-list/
class Solution {
    // TC: O(n), SC: O(1)
    public static Node partition(Node head, int x) {
        if (head == null)
            return null;

        Node dummy1 = new Node(-1);
        Node dummy2 = new Node(-2);
        Node curr1 = dummy1;
        Node curr2 = dummy2;

        while (head != null) {
            if (head.data < x) {
                curr1.next = head;
                curr1 = curr1.next;
            } else {
                curr2.next = head;
                curr2 = curr2.next;
            }
            head = head.next;
        }

        curr1.next = dummy2.next;
        curr2.next = null;

        return dummy1.next;
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
        Node node2 = new Node(4);
        Node node3 = new Node(3);
        Node node4 = new Node(2);
        Node node5 = new Node(5);
        Node node6 = new Node(2);
        Node node7 = new Node(7);
        Node head = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = null;
        int x = 3;
        printLinkedList(head);
        head = partition(head, x);
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