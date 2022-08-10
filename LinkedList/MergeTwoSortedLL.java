// https://www.geeksforgeeks.org/merge-two-sorted-linked-lists/
class Solution {
    // TC: O(m + n), SC: O(1)
    public static Node mergeSortedLLIterative(Node list1, Node list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        Node dummy = new Node(-1);
        Node curr = dummy;
        Node curr1 = list1;
        Node curr2 = list2;

        while (curr1 != null && curr2 != null) {
            if (curr1.data < curr2.data) {
                curr.next = curr1;
                curr1 = curr1.next;
            } else {
                curr.next = curr2;
                curr2 = curr2.next;
            }
            curr = curr.next;
        }

        if (curr1 != null)
            curr.next = curr1;

        if (curr2 != null)
            curr.next = curr2;

        return dummy.next;
    }

    // TC: O(m + n), SC: O(m + n)
    public static Node mergeSortedLLRecursive(Node head1, Node head2) {
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;

        if (head1.data < head2.data) {
            head1.next = mergeSortedLLRecursive(head1.next, head2);
            return head1;
        } else {
            head2.next = mergeSortedLLRecursive(head1, head2.next);
            return head2;
        }
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
        Node node2 = new Node(10);
        Node node3 = new Node(15);
        Node node4 = new Node(40);
        Node head1 = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        Node node5 = new Node(2);
        Node node6 = new Node(3);
        Node node7 = new Node(20);
        Node head2 = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = null;
        printLinkedList(head1);
        printLinkedList(head2);
        Node head3 = mergeSortedLLRecursive(head1, head2);
        printLinkedList(head3);
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