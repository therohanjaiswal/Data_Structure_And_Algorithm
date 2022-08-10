class Solution {
    public static void main(String[] args) {
        DoublyNode node1 = new DoublyNode(1);
        DoublyNode node2 = new DoublyNode(2);
        DoublyNode node3 = new DoublyNode(3);
        DoublyNode head = node1;
        node1.prev = null;
        node1.next = node2;
        node2.prev = node1;
        node2.next = node3;
        node3.prev = node2;
        node3.next = null;
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