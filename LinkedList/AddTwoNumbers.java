// https://leetcode.com/problems/add-two-numbers/
class Solution {
    // TC: O(m+n), SC: O(1)
    public static Node addTwoNumbers(Node l1, Node l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        Node dummyHead = new Node(0);
        Node p = l1, q = l2, curr = dummyHead;
        int carry = 0;

        while (p != null || q != null) {
            int x = (p != null) ? p.data : 0;
            int y = (q != null) ? q.data : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new Node(sum % 10);
            curr = curr.next;
            if (p != null)
                p = p.next;
            if (q != null)
                q = q.next;
        }

        if (carry > 0)
            curr.next = new Node(carry);

        return dummyHead.next;
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
        Node node1 = new Node(9);
        Node node2 = new Node(9);
        Node node3 = new Node(9);
        Node node4 = new Node(9);
        Node head1 = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        Node node5 = new Node(9);
        Node node6 = new Node(9);
        Node node7 = new Node(9);
        Node head2 = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = null;
        printLinkedList(head1);
        printLinkedList(head2);
        Node head3 = addTwoNumbers(head1, head2);
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