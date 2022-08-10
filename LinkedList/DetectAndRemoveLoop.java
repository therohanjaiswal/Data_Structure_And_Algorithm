// https://www.geeksforgeeks.org/detect-and-remove-loop-in-a-linked-list/

class Solution {
    // TC: O(n), SC: O(1)
    public static Node detectAndRemoveLoop(Node head) {
        Node slow = head, fast = head;
        boolean loopExists = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                loopExists = true;
                break;
            }
        }
        if (loopExists) {
            slow = head;
            // Now if we move slow and fast at same pace, then the claim is that
            // both slow and fast will meet at the point of junction.
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }

            // Now first we reiterate fast pointer until fast.next points to junction
            // node(where slow is already pointing). Then we set fast.next = null
            while (fast.next != slow)
                fast = fast.next;
            fast.next = null;
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
        node7.next = node2;
        head = detectAndRemoveLoop(head);
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