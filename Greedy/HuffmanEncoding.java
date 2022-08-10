
// https://www.geeksforgeeks.org/huffman-coding-greedy-algo-3/
import java.util.*;

class Solution {
    // TC: O(nlogn), SC: O(n)
    public static ArrayList<String> huffmanEncoding(String S, int f[], int N) {
        ArrayList<String> res = new ArrayList<>();
        // We can use this also
        // PriorityQueue<Node> minHeap = new PriorityQueue<>(new Comparator<Node>() {
        // public int compare(Node n1, Node n2) {
        // if(n1.freq == n2.freq)
        // return 1;
        // return n1.freq - n2.freq;
        // }
        // });

        PriorityQueue<Node> minHeap = new PriorityQueue<>();
        Node root = null;
        for (int i = 0; i < N; ++i) {
            minHeap.add(new Node(S.charAt(i), f[i], null, null));
        }

        while (minHeap.size() > 1) {
            Node l = minHeap.remove();
            Node r = minHeap.remove();
            minHeap.add(new Node('$', l.freq + r.freq, l, r));
        }
        root = minHeap.remove();
        getCode(root, "", res);

        return res;
    }

    public static void getCode(Node root, String s, ArrayList<String> res) {
        if (root == null)
            return;

        if (root.ch != '$') {
            res.add(s);
            return;
        }

        getCode(root.left, s + "0", res);
        getCode(root.right, s + "1", res);
    }

    public static void main(String[] args) {
        String s = "abcdef";
        int[] freq = { 5, 9, 12, 13, 16, 45 };
        int n = freq.length;
        ArrayList<String> res = huffmanEncoding(s, freq, n);
        for (String str : res)
            System.out.println(str);
    }
}

class Node implements Comparable<Node> {
    char ch;
    int freq;
    Node left, right;

    Node(char c, int f, Node l, Node r) {
        ch = c;
        freq = f;
        left = l;
        right = r;
    }

    public int compareTo(Node o) {
        // here we are returning 1 instead of 0 when freq is equal
        // coz we are giving priority to this object
        if (this.freq == o.freq)
            return 1;
        return this.freq - o.freq;
    }
}