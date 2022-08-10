// https://www.geeksforgeeks.org/circular-linked-list/

class CircularLinkedList {
    // TC: O(n), SC: O(1)
    public static void printCLL(Node head) {
        if (head == null)
            return;
        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    // TC: O(n), SC: O(1)
    public static Node insertAtBeginNaive(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            newNode.next = newNode;
        } else {
            Node curr = head;
            while (curr.next != head)
                curr = curr.next;
            curr.next = newNode;
            newNode.next = head;
        }
        return newNode;
    }

    // TC: O(1), SC: O(1)
    public static Node insertAtBeginEfficient(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }
        newNode.next = head.next;
        head.next = newNode;
        int temp = head.data;
        head.data = newNode.data;
        newNode.data = temp;
        return head;
    }

    // TC: O(n), SC: O(1)
    public static Node insertAtEndNaive(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }
        Node temp = head;
        while (temp.next != head)
            temp = temp.next;
        temp.next = newNode;
        newNode.next = head;
        return head;
    }

    // TC: O(1), SC: O(1)
    public static Node insertAtEndEfficient(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null)
            newNode.next = newNode;
        else {
            newNode.next = head.next;
            head.next = newNode;
            int temp = head.data;
            head.data = newNode.data;
            newNode.data = temp;
        }
        return newNode;
    }

    // TC: O(n), SC: O(1)
    public static Node deleteAtBeginNaive(Node head) {
        if (head == null || head.next == head)
            return null;
        Node curr = head;
        while (curr.next != head)
            curr = curr.next;
        curr.next = head.next;
        return curr.next;
    }

    // TC: O(1), SC: O(1)
    public static Node deleteAtBeginEfficient(Node head) {
        if (head == null || head.next == head)
            return null;
        head.data = head.next.data;
        head.next = head.next.next;
        return head;
    }

    // TC: O(k), SC:O(1)
    public static Node deleteKthNode(Node head, int k) {
        if (head == null)
            return null;

        if (k == 1)
            return deleteAtBeginEfficient(head);
        Node curr = head;
        for (int i = 0; i < k - 2; ++i)
            curr = curr.next;
        curr.next = curr.next.next;
        return head;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node head = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node1;
        printCLL(head);
        head = insertAtBeginNaive(head, 0);
        printCLL(head);
        head = insertAtBeginEfficient(head, -1);
        printCLL(head);
        head = insertAtEndNaive(head, 5);
        printCLL(head);
        head = insertAtEndEfficient(head, 6);
        printCLL(head);
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
