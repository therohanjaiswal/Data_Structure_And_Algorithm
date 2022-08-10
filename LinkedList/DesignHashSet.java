// https://leetcode.com/problems/design-hashset/
class MyHashSet {
    List<Integer>[] container = null;
    int cap = 1000;
    double loadFactor = 0.75;
    int count = 0;

    public MyHashSet() {
        container = new LinkedList[cap];
        for (int i = 0; i < cap; ++i)
            container[i] = new LinkedList<>();
    }

    public void add(int key) {
        if (contains(key))
            return;

        // rehash when loadFactor * cap == count
        // if(loadFactor * cap == count) {
        // count = 0;
        // cap *= 2;
        // List<Integer>[] oldC = container;
        // container = new LinkedList[cap];

        // for(int i = 0; i < cap; ++i) {
        // if(i < oldC.length) {
        // List<Integer> list = oldC[i];
        // if(!list.isEmpty()) {
        // for(int entry : list)
        // container[i].add(entry);
        // }
        // } else {
        // container[i] = new LinkedList<>();
        // }
        // }
        // }

        int hash = key % cap;
        container[hash].add(key);
        ++count;
    }

    public void remove(int key) {
        int hash = key % cap;
        List<Integer> list = container[hash];
        if (!list.isEmpty()) {
            Iterator<Integer> itr = list.iterator();
            while (itr.hasNext()) {
                if (itr.next() == key) {
                    itr.remove();
                    --count;
                    return;
                }
            }
        }
    }

    public boolean contains(int key) {
        int hash = key % cap;
        List<Integer> list = container[hash];
        if (!list.isEmpty()) {
            Iterator<Integer> itr = list.iterator();
            while (itr.hasNext()) {
                if (itr.next() == key)
                    return true;
            }
        }

        return false;
    }
}