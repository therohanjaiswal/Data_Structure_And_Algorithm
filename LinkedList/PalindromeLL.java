
// https://www.geeksforgeeks.org/function-to-check-if-a-singly-linked-list-is-palindrome/
import java.util.*;

class Solution {
    // TC: O(n), SC: O(n)
    public static boolean checkPalindromeNaive(Node head) {
        Node slow = head;
        Stack<Integer> stack = new Stack<Integer>();

        while (slow != null) {
            stack.push(slow.data);
            slow = slow.next;
        }

        while (head != null) {
            int i = stack.pop();
            if (head.data != i)
                return false;

            head = head.next;
        }
        return true;
    }

    // TC: O(n), SC: O(1)
    public static boolean checkPalindromeEfficient(Node head) {
        if (head == null || head.next == null)
            return true;

        Node slow = head, fast = head;
        Node prevSlow = null;
        while (fast != null && fast.next != null) {
            prevSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // when linkedlist has odd length
        if (fast != null) {
            prevSlow = prevSlow.next;
            slow = slow.next;
        }

        Node head2 = reverseList(slow);
        Node temp1 = head, temp2 = head2;
        while (temp2 != null) {
            if (temp1.data != temp2.data)
                return false;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return true;
    }

    public static Node reverseList(Node head) {
        if (head == null || head.next == null)
            return head;
        Node prev = null, curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
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
        Node node4 = new Node(3);
        Node node5 = new Node(2);
        Node node6 = new Node(1);
        // Node node7 = new Node(7);
        Node head = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = null;
        // node7.next = null;
        printLinkedList(head);
        boolean isPalindrome = checkPalindromeEfficient(head);
        if (isPalindrome)
            System.out.println("LL is palindrome");
        else
            System.out.println("LL is not a palindrome");
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