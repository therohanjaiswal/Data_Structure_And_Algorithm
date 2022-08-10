
// https://www.geeksforgeeks.org/detect-loop-in-a-linked-list/
import java.util.HashSet;

class Solution {
    // TC: O(n), SC: O(n)
    public static boolean detectLoopNaive(Node head) {
        HashSet<Node> set = new HashSet<>();
        Node curr = head;
        while(curr != null) {
            if(set.contains(curr))
                return true;
            set.add(curr);
            curr = curr.next
        }

        return false;
    }

    // TC: O(n), SC: O(1)
    public static boolean detectLoop(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int k = 3;
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
        if (detectLoop(head))
            System.out.print("Loop exist.");
        else
            System.out.print("Loop does not exist.");
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