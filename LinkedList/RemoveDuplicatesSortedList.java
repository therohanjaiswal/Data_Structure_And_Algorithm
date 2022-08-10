// https://www.geeksforgeeks.org/remove-duplicates-from-a-sorted-linked-list/
class Solution {
    // TC: O(n), SC: O(1)
    public static Node removeDuplicates(Node head) {
        if (head == null || head.next == null)
            return head;
        Node prev = head;
        Node curr = head.next;
        while (curr != null) {
            if (curr.data == prev.data)
                prev.next = curr.next;
            else
                prev = prev.next;
            curr = curr.next;
        }
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