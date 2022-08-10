// https://www.geeksforgeeks.org/quicksort-on-singly-linked-list/
class Solution {
    // TC: O(nlogn), SC: O(1)
    public static Node quickSort(Node node) {
        sort(node, null);
        return node;
    }

    public static void sort(Node start, Node end) {
        if (start == end)
            return;

        Node pivot = partition(start, end);
        sort(start, pivot);
        sort(pivot.next, end);

    }

    public static Node partition(Node start, Node end) {
        int pivot = start.data;
        Node i = start;
        Node j = start.next;

        while (j != end) {
            if (j.data < pivot) {
                i = i.next;
                int temp = i.data;
                i.data = j.data;
                j.data = temp;
            }
            j = j.next;
        }

        int temp = i.data;
        i.data = start.data;
        start.data = temp;

        return i;
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
        Node node2 = new Node(10);
        Node node3 = new Node(1);
        Node node4 = new Node(40);
        Node head = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        printLinkedList(head);
        head = quickSort(head);
        printLinkedList(head);
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