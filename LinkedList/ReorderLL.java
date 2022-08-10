// 
class Solution {
    // TC: O(n), SC: O(1)
    public static void reorder(Node head) {
        if (head == null || head.next == null)
            return;

        // step 1: finding previous node of middle node
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // step 2: reversing the later half of linked list
        Node prev = null;
        Node curr = slow.next;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        slow.next = null;

        // Now we have two disconnected linked lists of original linked lists.
        // One starts from head and second starts from prev

        // step 3: merging both the linked lists
        Node dummy = new Node(-1);
        Node newHead = dummy;
        curr = dummy;
        while (head != null || prev != null) {
            if (head != null) {
                curr.next = head;
                head = head.next;
                curr = curr.next;
            }

            if (prev != null) {
                curr.next = prev;
                prev = prev.next;
                curr = curr.next;
            }
        }

        head = dummy.next;
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
        reorder(head);
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