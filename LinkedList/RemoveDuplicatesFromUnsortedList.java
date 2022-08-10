
// https://www.geeksforgeeks.org/remove-duplicates-from-an-unsorted-linked-list/
import java.util.*;

class Solution {
    // TC: O(n), SC: O(n)
    public static Node removeDuplicates(Node head) {
        if (head == null)
            return null;

        HashSet<Integer> set = new HashSet<>();
        Node prev = null;
        Node dummy = new Node(-1);
        Node curr = dummy;

        while (head != null) {
            if (!set.contains(head.data)) {
                set.add(head.data);
                curr.next = head;
                curr = curr.next;
            }
            head = head.next;
        }
        curr.next = null;

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
        Node node1 = new Node(5);
        Node node2 = new Node(2);
        Node node3 = new Node(2);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(4);
        Node head = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = null;
        printLinkedList(head);
        head = removeDuplicates(head);
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