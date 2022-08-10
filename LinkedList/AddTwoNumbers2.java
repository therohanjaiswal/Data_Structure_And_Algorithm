
// https://leetcode.com/problems/add-two-numbers-ii/
import java.util.*;

class Solution {
    // TC: O(m + n), SC: O(m+n)
    public static Node addTwoNumbers2(Node l1, Node l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        Node head = null;
        Stack<Node> st1 = listToStack(l1);
        Stack<Node> st2 = listToStack(l2);
        int carry = 0;

        while (!st1.isEmpty() || !st2.isEmpty() || carry != 0) {
            int num = carry;
            num += !st1.isEmpty() ? st1.pop().data : 0;
            num += !st2.isEmpty() ? st2.pop().data : 0;
            Node newNode = new Node(num % 10);
            carry = num / 10;
            newNode.next = head;
            head = newNode;
        }

        return head;
    }

    public static Stack<Node> listToStack(Node head) {
        Stack<Node> st = new Stack<>();
        while (head != null) {
            st.add(head);
            head = head.next;
        }
        return st;
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
        Node head3 = addTwoNumbers2(head1, head2);
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