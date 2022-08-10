import java.util.*;

class Solution {
    public static void main(String[] args) {
        // doubly ended queue
        Deque<Integer> d = new LinkedList<>();
        d.addFirst(1);
        d.addLast(40);
        d.addFirst(20);
        d.addLast(100);
        d.addFirst(30);
        d.addLast(200);
        d.removeFirst();
        d.removeLast();
        System.out.println(d.getFirst());
        System.out.println(d.getLast());

        Iterator<Integer> i = d.iterator();
        while (i.hasNext())
            System.out.print(i.next() + " ");

        System.out.println();
        Iterator<Integer> j = d.descendingIterator();
        while (j.hasNext())
            System.out.print(j.next() + " ");
    }
}
