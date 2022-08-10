// https://www.geeksforgeeks.org/merge-sort-for-linked-list/
class Solution {
    // TC: O(nlogn), SC: O(1)
    public static Node sortList(Node head) {
        if (head == null || head.next == null)
            return head;

        Node left = head;
        // get previous node of mid
        Node prevMid = getPrevOfMid(head);

        // right list starts from mid
        Node right = prevMid.next;

        // terminating left list
        prevMid.next = null;

        // now we have two lists left and right
        left = sortList(left);
        right = sortList(right);

        return merge(left, right);
    }

    public static Node merge(Node list1, Node list2) {
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

    public static Node getPrevOfMid(Node head) {
        if (head == null || head.next == null)
            return head;

        Node slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
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
        Node node3 = new Node(1);
        Node node4 = new Node(40);
        Node head = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        printLinkedList(head);
        head = sortList(head);
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