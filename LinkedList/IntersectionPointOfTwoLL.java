// https://www.geeksforgeeks.org/write-a-function-to-get-the-intersection-point-of-two-linked-lists/

class Solution {
    // TC: O(n), SC: O(1)
    public static int intersectPointNaive(Node headA, Node headB) {
        int countA = 0;
        Node currA = headA;
        while (currA != null) {
            currA = currA.next;
            ++countA;
        }

        int countB = 0;
        Node currB = headB;
        while (currB != null) {
            currB = currB.next;
            ++countB;
        }

        int diff = (int) Math.abs(countA - countB);
        currA = headA;
        currB = headB;
        if (countA > countB) {
            while (diff-- > 0)
                currA = currA.next;
        } else {
            while (diff-- > 0)
                currB = currB.next;
        }

        while (currA != currB) {
            currA = currA.next;
            currB = currB.next;
        }

        return currA;
    }

    // TC: O(n), SC: O(1)
    public static Node intersectionPointEfficient(Node headA, Node headB) {
        Node ptr1 = headA;
        Node ptr2 = headB;

        // If any one of head is null i.e no Intersection Point
        if (ptr1 == null || ptr2 == null)
            return null;

        // Traverse through the lists until they
        // reach Intersection node
        while (ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;

            // If at any node ptr1 meets ptr2, then it is
            // intersection node.Return intersection node.
            if (ptr1 == ptr2)
                return ptr1;

            // Once both of them go through reassigning,
            // they will be equidistant from the collision point.

            // When ptr1 reaches the end of a list, then
            // reassign it to the head2.
            if (ptr1 == null)
                ptr1 = headB;

            // When ptr2 reaches the end of a list, then
            // redirect it to the head1.
            if (ptr2 == null)
                ptr2 = headA;
        }

        return ptr1;
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
        Node node2 = new Node(8);
        Node node3 = new Node(7);
        Node node4 = new Node(10);
        Node node5 = new Node(12);
        Node node6 = new Node(15);
        Node node7 = new Node(9);
        Node head1 = node1;
        Node head2 = node7;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = null;
        node7.next = node4;
        int intersectingPoint = intersectPoint(head1, head2);
        System.out.println(intersectingPoint);
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