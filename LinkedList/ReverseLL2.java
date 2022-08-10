// https://www.geeksforgeeks.org/reverse-sublist-linked-list/
class Solution {
    // TC: O(n), SC: O(1)
    public static Node reverseBetween(Node head, int left, int right) {
        Node leftPrev = null;
        Node leftNode = head;
        Node rightNode = head;

        Node curr = head;
        while (curr != null) {
            if (--left > 0) {
                leftPrev = leftNode;
                leftNode = leftNode.next;
            }
            if (--right > 0)
                rightNode = rightNode.next;
            if (right == 0)
                break;
            curr = curr.next;
        }

        // storing it rightNode.next as rightNode.next will be changed after reverse()
        Node temp = rightNode.next;
        Node h3 = reverse(leftNode, rightNode.next);
        leftNode.next = temp;
        if (leftPrev == null)
            return h3;

        leftPrev.next = h3;
        return head;
    }

    public static Node reverse(Node left, Node right) {
        Node prev = null;
        Node curr = left;

        while (curr != null && curr != right) {
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
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node head1 = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        int left = 2, right = 4;
        printLinkedList(head1);
        Node newHead = reverseBetween(head1, left, right);
        printLinkedList(newHead);

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