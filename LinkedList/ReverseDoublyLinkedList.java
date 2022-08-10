// https://www.geeksforgeeks.org/reverse-a-doubly-linked-list/
class Solution {
    // TC: O(n), SC: O(1)
    public static DoublyNode reverseDLL(DoublyNode head) {
        if (head == null || head.next == null)
            return head;

        DoublyNode prev = null;
        DoublyNode curr = head;
        while (curr != null) {
            prev = curr;
            DoublyNode temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            curr = curr.prev;
        }
        head = prev;
        return head;
    }

    public static void printDLL(DoublyNode head) {
        DoublyNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyNode node1 = new DoublyNode(1);
        DoublyNode node2 = new DoublyNode(2);
        DoublyNode node3 = new DoublyNode(3);
        DoublyNode node4 = new DoublyNode(4);
        DoublyNode head = node1;
        node1.prev = null;
        node1.next = node2;
        node2.prev = node1;
        node2.next = node3;
        node3.prev = node2;
        node3.next = node4;
        node4.prev = node3;
        node4.next = null;
        printDLL(head);
        head = reverseDLL(head);
        printDLL(head);
    }
}

class DoublyNode {
    int data;
    DoublyNode prev, next;

    DoublyNode(int mData) {
        data = mData;
        prev = null;
        next = null;
    }
}