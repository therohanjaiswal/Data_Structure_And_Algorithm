import java.util.HashMap;

public class Solution {
    // TC: O(n), SC:O(n)
    public static Node cloneLLNaive(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node curr = head;
        while (curr != null) {
            map.put(curr, new Node(curr.data));
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            Node currClone = map.get(curr);
            currClone.next = map.get(curr.next);
            currClone.random = map.get(curr.random);
        }

        Node head2 = map.get(head);
        return head2;
    }

    // TC: O(n), SC:O(1)
    public static Node cloneLLEfficient(Node head) {
        if (head == null)
            return null;

        // Step 1: Insert new nodes with same values between nodes of original linked
        // list
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = new Node(curr.data);
            curr.next.next = next;
            curr = curr.next.next;
        }

        // Step 2: Assign random pointers of the newly created clone nodes
        curr = head;
        while (curr != null) {
            if (curr.next != null)
                curr.next.random = (curr.random != null) ? curr.random.next : null;
            curr = curr.next.next;
        }

        // Step 3: Separate the cloned list from origianl list
        Node original = head, cloned = head.next;
        Node clonedHead = cloned;
        while (original != null) {
            original.next = original.next.next;
            // cloned.next.next != null is used to handle last cloned node case where
            // cloned.next becomes null
            cloned.next = cloned.next != null ? cloned.next.next : cloned.next;
            original = original.next;
            cloned = cloned.next;
        }

        return clonedHead;
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
        // Node node6 = new Node(6);
        // Node node7 = new Node(7);
        Node head = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        node1.random = node3;
        node3.random = node5;
        node2.random = node1;
        node4.random = node3;
        node5.random = node2;
        // node6.next = node7;
        // node7.next = null;
        printLinkedList(head);
        Node head2 = cloneLLEfficient(head);
        printLinkedList(head2);
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