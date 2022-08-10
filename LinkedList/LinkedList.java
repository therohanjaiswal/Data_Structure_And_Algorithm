// https://www.geeksforgeeks.org/data-structures/linked-list/

class Solution {
    // TC: O(n), SC: O(1)
    public static void printLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // TC: O(n), SC: O(n)
    public static void printLinkedListRecursively(Node temp) {
        if (temp == null)
            return;
        System.out.print(temp.data + " ");
        printLinkedListRecursively(temp.next);
    }

    // TC: O(n), SC: O(1)
    public static Node sortedInsert(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null)
            return newNode;

        if (data < head.data) {
            newNode.next = head;
            return newNode;
        }

        Node curr = head;
        while (curr.next != null && curr.next.data < data)
            curr = curr.next;
        newNode.next = curr.next;
        curr.next = newNode;
        return head;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(5);
        Node head = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        printLinkedList(head);
        // printLinkedListRecursively(head);
        sortedInsert(head, 4);
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