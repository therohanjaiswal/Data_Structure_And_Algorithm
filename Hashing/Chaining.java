
// chaining, oe of the way of handling collisions
// https://www.geeksforgeeks.org/hashing-set-2-separate-chaining/
import java.util.*;

public class MyHash {
    ArrayList<LinkedList<Integer>> table;
    int bucketSize;

    MyHash(int b) {
        bucketSize = b;
        table = new ArrayList<LinkedList<Integer>>();
        for (int i = 0; i < b; ++i) {
            bucket.add(new LinkedList<Integer>());
        }
    }

    void insert(int key) {
        int i = key % bucketSize;
        table.get(i).add(key);
    }

    void remove(int key) {
        int i = key % bucketSize;
        // remove(key) takes either object or index, so
        // remove(key) will consider key as as index and may malfunction
        // hence typecasting key into Integer object
        table.get(i).remove((Integer) key);
    }

    boolean search(int key) {
        int i = key % bucketSize;
        return table.get(i).contains(key);
    }
}
