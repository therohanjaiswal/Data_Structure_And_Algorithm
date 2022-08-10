class MyHash {
    int[] arr;
    int cap, size;

    MyHash(int c) {
        cap = c;
        size = 0;
        for (int i = 0; i < c; ++i)
            arr[i] = -1;
    }

    int hash(int key) {
        return key % cap;
    }

    boolean search(int key) {
        int h = hash(key);
        int i = h;
        while (arr[i] != -1) {
            if (arr[i] == key)
                return true;

            i = (i + 1) % cap;
            if (i == h)
                return false;
        }
        return false;
    }

    boolean insert(int key) {
        if (size == cap)
            return false;

        int i = hash(key);
        // arr[i] = -1: empty slot
        // arr[i] = -2: empty slot but earlier there was one element which has been
        // deleted
        // arr[i] == key: key is already present in the hash table
        while (arr[i] != -1 && arr[i] != -2 && arr[i] != key)
            i = (i + 1) % cap;
        if (arr[i] == key)
            return false;
        arr[i] = key;
        ++size;
        return true;
    }

    boolean erase(int key) {
        int h = hash(key);
        int i = h;
        while (arr[i] != -1) {
            if (arr[i] == key) {
                arr[i] = -2;
                --size;
                return true;
            }
            i = (i + 1) % cap;
            if (i == h)
                return false;
        }
        return false;
    }
}
