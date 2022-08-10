//https://www.geeksforgeeks.org/delete-occurrences-given-key-linked-list/
class Solution {
    // Edge Case: 1->1->1->1, this should return empty linked list
    // TC: O(n), SC: O(1)
    public static Node deleteAllOccurances(Node head, int x) {
        if (head == null)
            return null;

        Node dummyNode = new Node(-1);
        dummyNode.next = head;
        Node prev = dummyNode;
        Node curr = head;

        while (curr != null) {
            if (curr.data == x)
                prev.next = curr.next;
            else
                prev = curr;
            curr = curr.next;
        }

        return dummyNode.next;
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
        Node node2 = new Node(1);
        Node node3 = new Node(1);
        Node node4 = new Node(1);
        Node head = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
        head = deleteAllOccurances(head, 1);
        printLinkedList(head);
    }
}