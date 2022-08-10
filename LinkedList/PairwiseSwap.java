// https://www.geeksforgeeks.org/pairwise-swap-elements-of-a-given-linked-list/
// We can also solve this using reverse linked list in groups of 2.
class Solution {
    // TC: O(n), SC: O(1)
    public static Node pairWiseSwap(Node head) {
        if (head == null || head.next == null)
            return head;
        // to set new head
        Node curr = head.next.next;
        Node prev = head;
        head = head.next;
        head.next = prev;
        // starting from 3rd node
        while (curr != null && curr.next != null) {
            prev.next = curr.next;
            prev = curr;
            Node next = curr.next.next;
            curr.next.next = curr;
            curr = next;
        }

        prev.next = curr;
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
        Node node7 = new Node(7);
        Node head = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = null;
        printLinkedList(head);
        head = pairWiseSwap(head);
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
