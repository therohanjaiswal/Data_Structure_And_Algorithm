// https://www.geeksforgeeks.org/recursively-reversing-a-linked-list-a-simple-implementation/

public class Solution {
    // TC: O(n), SC: O(n)
    public static Node reverseListRecursive(Node prev, Node curr) {
        if (curr == null)
            return prev;
        Node next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
        return reverseListRecursive(prev, curr);
        // return reverseListRecursive(curr, next); we can write this directly
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
        head = reverseListRecursive(null, head);
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